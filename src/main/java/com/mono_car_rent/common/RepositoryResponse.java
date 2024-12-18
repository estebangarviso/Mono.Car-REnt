package com.mono_car_rent.common;


public class RepositoryResponse<T> {
    private boolean success;
    private T value;
    private int index;
    private Throwable error;

    RepositoryResponse(boolean success, T value, int index, Throwable error) {
        this.success = success;
        this.value = value;
        this.index = index;
        this.error = error;
    }

    public static <T> RepositoryResponseBuilder<T> builder() {
        return new RepositoryResponseBuilder<T>();
    }

    public boolean isSuccess() {
        return this.success;
    }

    public T getValue() {
        return this.value;
    }

    public int getIndex() {
        return this.index;
    }

    public Throwable getError() {
        return this.error;
    }

    public String toString() {
        return "RepositoryResponse(success=" + this.isSuccess() + ", value=" + this.getValue() + ", index=" + this.getIndex() + ", error=" + this.getError() + ")";
    }

    public static class RepositoryResponseBuilder<T> {
        private boolean success;
        private T value;
        private int index;
        private Throwable error;

        RepositoryResponseBuilder() {
        }

        public RepositoryResponseBuilder<T> success(boolean success) {
            this.success = success;
            return this;
        }

        public RepositoryResponseBuilder<T> value(T value) {
            this.value = value;
            return this;
        }

        public RepositoryResponseBuilder<T> index(int index) {
            this.index = index;
            return this;
        }

        public RepositoryResponseBuilder<T> error(Throwable error) {
            this.error = error;
            return this;
        }

        public RepositoryResponse<T> build() {
            return new RepositoryResponse<T>(this.success, this.value, this.index, this.error);
        }

        public String toString() {
            return "RepositoryResponse.RepositoryResponseBuilder(success=" + this.success + ", value=" + this.value + ", index=" + this.index + ", error=" + this.error + ")";
        }
    }

    public class RepositoryResponseDTOBuilder {

        public RepositoryResponse<T> build() {
            // handle success and failure cases
            if (success) {
                if (value == null) {
                    throw new IllegalStateException("Value must be set for successful response");
                }
                if (index < 0) {
                    throw new IllegalStateException("Index must be set for successful response");
                }
            } else {
                if (value == null) {
                    throw new IllegalStateException("Error must be set for failed response");
                }
            }

            // create and return the response
            return new RepositoryResponse<T>(success, value, index, error);
        }
    }
}
