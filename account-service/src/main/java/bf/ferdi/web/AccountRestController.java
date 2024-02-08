package bf.ferdi.web;

import bf.ferdi.client.CustomerRestClient;
import bf.ferdi.entities.BankAccount;
import bf.ferdi.model.Customer;
import bf.ferdi.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {

    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;


    public AccountRestController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")
    public List<BankAccount> bankAccountsList(){
        List<BankAccount> accountList = bankAccountRepository.findAll();
        accountList.forEach(acc ->{
            acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));
        });

        return accountList;
    }

    @GetMapping("/accounts/{id}")
    public  BankAccount bankAccountById(@PathVariable String id){
             BankAccount bankAccount= bankAccountRepository.findById(id).get();
            Customer  customer= customerRestClient.findCustomerById(bankAccount.getCustomerId());
            bankAccount.setCustomer(customer);
            return bankAccount;
    }
}
