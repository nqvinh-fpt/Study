package Group3.ProjectOJT.Repository;

import Group3.ProjectOJT.Entities.Account;
import Group3.ProjectOJT.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUserName(String userName);
}
