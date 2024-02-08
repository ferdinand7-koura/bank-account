package bf.ferdi.repository;

import bf.ferdi.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository <BankAccount,String>   {
}
