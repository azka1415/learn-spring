package azka.com.customer;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDataAccessService implements CustomerDao {
    public static List<Customer> customers;
    static {
        customers = new ArrayList<>();
        Customer alex = new Customer(1,"alex","alex@gmail.com",40);
        Customer jamila = new Customer(2,"jamila","jamila@gmail.com",21);
        customers.add(alex);
        customers.add(jamila);
    }
    @Override
    public List<Customer> selectAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer customerId) {
        return customers.stream().filter(customer -> customer.getId().equals(customerId)).findFirst();
    }
}
