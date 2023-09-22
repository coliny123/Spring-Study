package hello.hello_spring.repository;

import hello.hello_spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataUserRepository extends JpaRepository<User, Long>, UserRepository {

    // select m from User m where m.name = ?
    @Override
    Optional<User> findByName(String name);
}
