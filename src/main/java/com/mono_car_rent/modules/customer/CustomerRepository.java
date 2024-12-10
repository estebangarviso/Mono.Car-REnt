package com.mono_car_rent.modules.customer;

import com.google.gson.reflect.TypeToken;
import com.mono_car_rent.common.AbstractRepository;
import com.mono_car_rent.common.Page;
import com.mono_car_rent.common.Pageable;
import com.mono_car_rent.common.RepositoryResponse;
import com.mono_car_rent.common.exception.general.BadRequestException;
import com.mono_car_rent.common.exception.general.NotFoundException;
import com.mono_car_rent.modules.customer.dto.CustomerSaveDTO;
import com.mono_car_rent.modules.customer.dto.CustomerUpdateDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class CustomerRepository extends AbstractRepository<Customer> {
    private CustomerRepository() {
        super("customers.json", new TypeToken<ArrayList<Customer>>() {});
    }

    /**
     * Saves a customer.
     *
     * @param customerSaveDTO the customer to save
     */
    public RepositoryResponse<Customer> save(CustomerSaveDTO customerSaveDTO) {
        Customer newCustomer = Customer.builder()
                .identityCard(customerSaveDTO.identityCard())
                .name(customerSaveDTO.name())
                .build();
        return super.save(newCustomer);
    }

    /**
     * Finds a customer by identity card.
     *
     * @param identityCard the identity card to search
     * @return the customer found or null
     */
    public RepositoryResponse<Customer> findByIdentityCard(String identityCard) {
        for (Customer customer : this.getAll()) {
            if (customer.getIdentityCard().equals(identityCard)) {
                return RepositoryResponse.<Customer>builder()
                        .success(true)
                        .value(customer)
                        .build();
            }
        }
        return RepositoryResponse.<Customer>builder()
                .success(false)
                .error(NotFoundException.customerNotFound(identityCard))
                .build();
    }

    /**
     * Updates a customer.
     *
     * @param customerUpdateDTO the customer to update
     */
    public RepositoryResponse<Customer> update(String identityCard, CustomerUpdateDTO customerUpdateDTO) {
        RepositoryResponse<Customer> customerResponse = findByIdentityCard(identityCard);
        if (!customerResponse.isSuccess()) {
            return customerResponse;
        }
        Customer customer = customerResponse.getValue();
        if (customer == null) {
            return RepositoryResponse.<Customer>builder()
                    .success(false)
                    .error(NotFoundException.customerNotFound(identityCard))
                    .build();
        }
        customer.setName(customerUpdateDTO.name());
        return super.update(customerResponse.getIndex(), customer);
    }

    /**
     * Deletes a customer.
     *
     * @param identityCard the identity card of the customer to delete
     */
    public RepositoryResponse<String> delete(String identityCard) {
        RepositoryResponse<Customer> customerResponse = findByIdentityCard(identityCard);
        if (!customerResponse.isSuccess()) {
            return RepositoryResponse.<String>builder()
                    .success(false)
                    .error(NotFoundException.customerNotFound(identityCard))
                    .build();
        }
        super.delete(customerResponse.getIndex());
        return RepositoryResponse.<String>builder()
                .success(true)
                .value(identityCard)
                .build();
    }

    /**
     * Gets a page of customers.
     *
     * @param pageable the page information
     */
    public RepositoryResponse<Page<Customer>> paginate(Pageable pageable, Optional<String> filter) {
        int page = pageable.page();
        int size = pageable.size();
        List<Customer> allCustomers = this.getAll();
        
        // Apply filter
        List<Customer> activeCustomersList = new ArrayList<>();
        if (filter.isEmpty()) {
            activeCustomersList = allCustomers;
        } else {
            String filterValue = filter.get();
            for (Customer customer : allCustomers) {
                if (customer.getIdentityCard().contains(filterValue) || customer.getName().contains(filterValue)) {
                    activeCustomersList.add(customer);
                }
            }
        }

        int totalItems = activeCustomersList.size();
        int totalPages = (int) Math.ceil((double) totalItems / size);
        if (page < 1 || page > totalPages) {
            return RepositoryResponse.<Page<Customer>>builder()
                    .success(false)
                    .error(BadRequestException.invalidPage(page, totalPages))
                    .build();
        }
        List<Customer> items = activeCustomersList.stream()
                .skip((page - 1) * size)
                .limit(size)
                .toList();

        Page<Customer> customerPage = new Page<Customer>();
        customerPage.setCurrentPage(page);
        customerPage.setPageSize(size);
        customerPage.setItems(items);
        customerPage.setTotalItems(totalItems);
        customerPage.setTotalPages(totalPages);

        return RepositoryResponse.<Page<Customer>>builder()
                .success(true)
                .value(customerPage)
                .build();
    }

    //#region Singleton
    private static final AtomicReference<CustomerRepository> instance = new AtomicReference<>();
    public static CustomerRepository getInstance() {
        if (instance.get() == null) {
            instance.set(new CustomerRepository());
        }
        return instance.get();
    }
    //#endregion
}
