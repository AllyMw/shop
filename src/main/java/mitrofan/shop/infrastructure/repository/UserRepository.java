package mitrofan.shop.infrastructure.repository;

import mitrofan.shop.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
     User findByLogin(String login);
}
