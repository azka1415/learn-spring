package azka.com.customer;

import java.util.List;
import java.util.Optional;

public class CustomerJPADataAccessService implements CustomerDao {
    @Override
    public List<Customer> selectAllCustomers() {
        return null;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return Optional.empty();
    }
}
