package com.mono_car_rent.modules.customer.use_case;

import com.mono_car_rent.common.Page;
import com.mono_car_rent.common.Pageable;
import com.mono_car_rent.modules.customer.Customer;
import com.mono_car_rent.modules.customer.dto.CustomerSaveDTO;
import com.mono_car_rent.modules.customer.dto.CustomerUpdateDTO;
import java.util.Optional;


public interface CustomerCRUDUseCase {
    /**
     * Create a customer.
     * @param customerSaveDTO the data of the customer to create
     * @return the created customer
     */
    public Customer create(CustomerSaveDTO customerSaveDTO) throws Throwable;

    /**
     * Get a customer by its identity card.
     * @param identityCard the identity card of the customer
     * @return the customer
     */
    public Customer get(String identityCard) throws Throwable;

    /**
     * Paginate customers.
     * @param pageable the pagination data
     * @param filter the filter to apply
     * @return the paginated customers
     */
    public Page<Customer> paginate(Pageable pageable, Optional<String> filter) throws Throwable;

    /**
     * Update a customer by its identity card.
     * @param identityCard the identity card of the customer
     * @param customerUpdateDTO the new data of the customer
     * @return the updated customer
     */
    public Customer update(String identityCard, CustomerUpdateDTO customerUpdateDTO) throws Throwable;

    /**
     * Delete a customer by its identity card.
     * @param identityCard the identity card of the customer
     * @return the identity card of the deleted customer
     */
    public String delete(String identityCard) throws Throwable;
}
