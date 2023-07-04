package azka.com.customer;

import azka.com.request.CustomerRegistrationRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService customerService;
    
    public CustomerController( CustomerService customerService ) {
        this.customerService = customerService;
    }
    
    
    @GetMapping(path = "api/v1/customers")
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "api/v1/customers/{customerId}")
    public Customer getCustomer(@PathVariable(name = "customerId") Integer customerId) {
        return customerService.getCustomerById(customerId);
    }

    @PostMapping(path = "api/v1/customers")
    public void addCustomer(@RequestBody CustomerRegistrationRequest request) {
        customerService.addCustomer(request);
    }
}
