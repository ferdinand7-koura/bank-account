package bf.ferdi;

import bf.ferdi.entities.Customer;
import bf.ferdi.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			Customer customer1= Customer.builder()
					.firstName("KOURA")
					.lastName("Ferdinand")
					.email("ferdinand7koura@gmail.com")
					.build();
			customerRepository.save(customer1);
			customerRepository.save(new Customer(null,"DOAMBA","Leaticia","leaticia@gmail.com"));
			customerRepository.save(new Customer(null,"PALM","Julien","palmjulien@gmail.com"));
		customerRepository.findAll().forEach(System.out::println);
		};
	}
}
