package bf.ferdi;

import bf.ferdi.client.CustomerRestClient;
import bf.ferdi.entities.BankAccount;
import bf.ferdi.enums.AccountType;
import bf.ferdi.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AcounteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcounteServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient){

		return  args -> {
			customerRestClient.allCustomers().forEach(c->{
				BankAccount bankAccount1 = BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.balance(Math.random()*8000)
						.createdAt(LocalDate.now())
						.type(AccountType.CURRENT_ACCOUNT)
						.currency("MAD")
						.customerId(c.getId())
						.build();
				BankAccount bankAccount2 = BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.balance(Math.random()*12563)
						.createdAt(LocalDate.now())
						.type(AccountType.SAVING_ACCOUNT)
						.currency("FER")
						.customerId(c.getId())
						.build();

				bankAccountRepository.save(bankAccount1);
				bankAccountRepository.save(bankAccount2);
				bankAccountRepository.findAll().forEach(System.out::println);
			});
		};
	}
}
