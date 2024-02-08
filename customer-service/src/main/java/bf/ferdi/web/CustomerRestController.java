package bf.ferdi.web;

import bf.ferdi.entities.Customer;
import bf.ferdi.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerRestController {

    private CustomerRepository customerRepository;

    public CustomerRestController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    public List<Customer> customersList(){
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public  Customer customerById(@PathVariable Long id){
        return customerRepository.findById(id).get();
    }
}
