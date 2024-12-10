package com.mono_car_rent.modules.customer;

import com.mono_car_rent.common.Page;
import com.mono_car_rent.common.Pageable;
import com.mono_car_rent.common.RepositoryResponse;
import com.mono_car_rent.common.exception.general.BadRequestException;
import com.mono_car_rent.modules.customer.dto.CustomerSaveDTO;
import com.mono_car_rent.modules.customer.dto.CustomerUpdateDTO;
import com.mono_car_rent.modules.customer.use_case.CustomerCRUDUseCase;
import com.mono_car_rent.modules.rental.RentalRepository;

import java.util.List;

public class CustomerService implements CustomerCRUDUseCase {
    private final CustomerRepository customerRepository = CustomerRepository.getInstance();
    private final RentalRepository rentalRepository = RentalRepository.getInstance();
    @Override
    public Customer create(CustomerSaveDTO customerSaveDTO) throws Throwable {
        RepositoryResponse<Customer> saved = customerRepository.save(customerSaveDTO);

        if (!saved.isSuccess()) {
            throw saved.getError();
        }

        return saved.getValue();
    }

    @Override
    public Customer get(String identityCard) throws Throwable {
        RepositoryResponse<Customer> found = customerRepository.findByIdentityCard(identityCard);

        if (!found.isSuccess()) {
            throw found.getError();
        }

        return found.getValue();
    }

    @Override
    public Page<Customer> paginate(Pageable pageable) throws Throwable {
        RepositoryResponse<Page<Customer>> paginated = customerRepository.paginate(pageable);

        if (!paginated.isSuccess()) {
            throw paginated.getError();
        }

        return paginated.getValue();
    }

    @Override
    public Customer update(String identityCard, CustomerUpdateDTO customerUpdateDTO) throws Throwable {
        RepositoryResponse<Customer> updated = customerRepository.update(identityCard, customerUpdateDTO);

        if (!updated.isSuccess()) {
            throw updated.getError();
        }

        return updated.getValue();
    }

    @Override
    public String delete(String identityCard) throws Throwable {
        if (rentalRepository.existsByCustomerIdentityCard(identityCard)) {
            throw BadRequestException.customerHasRentals();
        }
        RepositoryResponse<String> deleted = customerRepository.delete(identityCard);

        if (!deleted.isSuccess()) {
            throw deleted.getError();
        }

        return deleted.getValue();
    }
}
