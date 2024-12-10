package com.mono_car_rent.modules.customer;

import com.mono_car_rent.common.Page;
import com.mono_car_rent.common.Pageable;
import com.mono_car_rent.modules.customer.dto.CustomerSaveDTO;
import com.mono_car_rent.modules.customer.dto.CustomerUpdateDTO;

public class CustomerController {
    private final CustomerService customerService = new CustomerService();

    public Customer create(CustomerSaveDTO customerSaveDTO) throws Throwable {
        return customerService.create(customerSaveDTO);
    }

    public Customer get(String identityCard) throws Throwable {
        return customerService.get(identityCard);
    }

    public Page<Customer> paginate(Pageable pageable) throws Throwable {
        return customerService.paginate(pageable);
    }

    public Customer update(String identityCard, CustomerUpdateDTO customerUpdateDTO) throws Throwable {
        return customerService.update(identityCard, customerUpdateDTO);
    }

    public String delete(String identityCard) throws Throwable {
        return customerService.delete(identityCard);
    }
}
