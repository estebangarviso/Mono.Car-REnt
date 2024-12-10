package com.mono_car_rent.common;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.*;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Function;


public abstract class AbstractRepository<T> {
    protected ArrayList<T> items;
    private static final String DATA_DIR = "data";
    private static final String TRANSACTION_SUFFIX = "_transactions.log";
    private final Gson gson;
    private final String fileName;
    private final Type typeToken;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    protected AbstractRepository(String fileName, TypeToken<ArrayList<T>> token) {
        this.fileName = DATA_DIR + "/" + fileName;
        this.typeToken = token.getType();
        this.gson = new Gson().newBuilder()
            .registerTypeAdapter(Transaction.class, new TransactionAdapter<>(token))
            .create();
        new File(DATA_DIR).mkdirs();
        this.items = loadItemsWithTransactions();
    }

    private ArrayList<T> loadItemsWithTransactions() {
        lock.readLock().lock();
        try {
            ArrayList<T> loadedItems = loadBaseItems();
            
            Path transactionFile = Paths.get(fileName + TRANSACTION_SUFFIX);
            if (Files.exists(transactionFile)) {
                try (BufferedReader reader = Files.newBufferedReader(transactionFile)) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        Type transactionType = TypeToken.getParameterized(Transaction.class, 
                            ((ParameterizedType) typeToken).getActualTypeArguments()[0]).getType();
                        Transaction<T> transaction = gson.fromJson(line, transactionType);
                        applyTransaction(loadedItems, transaction);
                    }
                }
            }
            return loadedItems;
        } catch (IOException e) {
            throw new RuntimeException("Error loading data", e);
        } finally {
            lock.readLock().unlock();
        }
    }

    private ArrayList<T> loadBaseItems() {
        File file = new File(fileName);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (Reader reader = new FileReader(file)) {
            return gson.fromJson(reader, typeToken);
        } catch (IOException e) {
            throw new RuntimeException("Error loading data from " + fileName, e);
        }
    }

    private void applyTransaction(ArrayList<T> items, Transaction<T> transaction) {
        switch (transaction.type) {
            case ADD -> items.add(transaction.item);
            case DELETE -> items.remove(transaction.index);
            case UPDATE -> items.set(transaction.index, transaction.item);
        }
    }

    private void appendTransaction(Transaction<T> transaction) {
        lock.writeLock().lock();
        try {
            Files.writeString(
                Paths.get(fileName + TRANSACTION_SUFFIX),
                gson.toJson(transaction) + System.lineSeparator(),
                StandardOpenOption.CREATE, 
                StandardOpenOption.APPEND
            );
            
        } catch (IOException e) {
            throw new RuntimeException("Error writing transaction", e);
        } finally {
            lock.writeLock().unlock();
        }
    }

    //#region Create
    /**
     * Save a new item in the repository
     * @param item the item to save
     */
    protected RepositoryResponse<T> save(T item) {
        Transaction<T> transaction = new Transaction<>(TransactionType.ADD, items.size(), item);
        items.add(item);
        appendTransaction(transaction);
        return RepositoryResponse.<T>builder().success(true).value(item).build();
    }
    //#endregion
    //#region Read
    /**
     * Get all items in the repository
     * @return the items in the repository
     */
    public List<T> getAll() {
        return items;
    }

    /**
     * Get a page of items in the repository
     * @param page the page number
     * @param size the number of items per page
     * @return the items in the specified page
     */
    protected List<T> getPage(int page, int size) {
        // calculate the start index
        int start = (page - 1) * size;
        // calculate the end index
        int end = Math.min(start + size, this.count());
        // return the items in the specified page
        return new ArrayList<>(items.subList(start, end));
    }

    /**
     * Get an item by its index
     * @param index
     * @return
     */
    protected T get(int index) {
        return items.get(index);
    }

    /**
     * Get the number of items in the repository
     * @return
     */
    protected int count() {
        return items.size();
    }

    protected <R> RepositoryResponse<T> getByProperty(Function<T, R> propertyGetter, R value) {
        try {
            lock.readLock().lock();
            for (int i = 0; i < items.size(); i++) {
                T item = items.get(i);
                if (propertyGetter.apply(item).equals(value)) {
                    return RepositoryResponse.<T>builder()
                    .success(true)
                    .value(item)
                    .index(i)
                    .build();
                }
            }
            return RepositoryResponse.<T>builder()
                .success(false)
                .error(new Exception("Item not found"))
                .build();
        } catch (Exception e) {
            return RepositoryResponse.<T>builder()
                .success(false)
                .error(e)
                .build();
        } finally {
            lock.readLock().unlock();
        }
    }
    //#endregion
    //#region Delete
    /**
     * Remove an item by its index
     * @param index
     */
    protected void delete(int index) {
        Transaction<T> transaction = new Transaction<>(TransactionType.DELETE, index, null);
        items.remove(index);
        appendTransaction(transaction);
    }

    /**
     * Remove all items in the repository
     */
    protected void clear() {
        items.clear();
    }
    //#endregion
    //#region Update
    /**
     * Update an item by its index
     * @param index
     * @param item
     */
    protected RepositoryResponse<T> update(int index, T item) {
        Transaction<T> transaction = new Transaction<>(TransactionType.UPDATE, index, item);
        items.set(index, item);
        appendTransaction(transaction);
        return RepositoryResponse.<T>builder()
            .index(index)
            .success(true)
            .value(item)
            .build();
    }
    //#endregion

    private enum TransactionType {
        ADD, DELETE, UPDATE
    }

    private static class Transaction<T> {
        TransactionType type;
        int index;
        T item;

        Transaction(TransactionType type, int index, T item) {
            this.type = type;
            this.index = index;
            this.item = item;
        }
    }

    private class TransactionAdapter<E> extends TypeAdapter<Transaction<E>> {
        private final Type elementType;

        TransactionAdapter(TypeToken<ArrayList<E>> typeToken) {
            this.elementType = ((ParameterizedType) typeToken.getType()).getActualTypeArguments()[0];
        }

        @Override
        public void write(JsonWriter out, Transaction<E> transaction) throws IOException {
            out.beginObject();
            out.name("type").value(transaction.type.name());
            out.name("index").value(transaction.index);
            out.name("item");
            if (transaction.item != null) {
                gson.toJson(transaction.item, elementType, out);
            } else {
                out.nullValue();
            }
            out.endObject();
        }

        @Override
        public Transaction<E> read(JsonReader in) throws IOException {
            in.beginObject();
            TransactionType type = null;
            int index = -1;
            E item = null;

            while (in.hasNext()) {
                String name = in.nextName();
                switch (name) {
                    case "type" -> type = TransactionType.valueOf(in.nextString());
                    case "index" -> index = in.nextInt();
                    case "item" -> {
                        if (in.peek() != JsonToken.NULL) {
                            item = gson.fromJson(in, elementType);
                        } else {
                            in.nextNull();
                        }
                    }
                    default -> in.skipValue();
                }
            }
            in.endObject();

            return new Transaction<>(type, index, item);
        }
    }
}