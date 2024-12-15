package com.mono_car_rent.common;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


@Getter
@Builder
@ToString
public class RepositoryResponse<T> {
    private boolean success;
    private T value;
    private int index;
    private Throwable error;

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
