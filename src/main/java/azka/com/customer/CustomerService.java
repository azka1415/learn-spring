package azka.com.customer;

import azka.com.exception.DuplicateResourceException;
import azka.com.exception.ResourceNotFound;
import azka.com.request.CustomerRegistrationRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

    public CustomerService(@Qualifier("jpa") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers() {
        return customerDao.selectAllCustomers();
    }

    public Customer getCustomerById(Integer id) {
        return customerDao.selectCustomerById(id)
                .orElseThrow(() -> new ResourceNotFound("Customer with id [%s] does not exist".formatted(id)));
    }

    public void addCustomer(CustomerRegistrationRequest request) {
        if (customerDao.existsPersonWithEmail(request.email())) {
            throw new DuplicateResourceException("email already taken");
        }
        customerDao.insertCustomer(
                new Customer(request.name(), request.email(), request.age())
        );
    }
}
