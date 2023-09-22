package hello.hello_spring.repository;

import hello.hello_spring.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryUserRepositoryTest {
    MemoryUserRepository repository = new MemoryUserRepository();

    // test 코드 실행 순서는 의존 관계 없으므로 test 끝나고 변수 지워줘야 함!!!
    @AfterEach
    void afterEach() {
        repository.clearStore();
    }

    @Test
    void save() {
        User user = new User();
        user.setName("김도환");
        repository.save(user);

        User result = repository.findById(user.getId()).get();  // Optional에서 꺼낼 때 get()사용
        //  System.out.println("result = " + (result == user)); // 글자로 확인 귀찮으니 assert 사용
        //  Assertions.assertEquals(user, "spring");
        assertThat(user).isEqualTo(result);
    }

    @Test
    void findByName() {
        User user1 = new User();
        user1.setName("육정현");
        repository.save(user1);

        User user2 = new User();
        user2.setName("최재현");
        repository.save(user2);

        // == Optional<User> result = repository.findByName("육정현");
        User result = repository.findByName("육정현").get();
        assertThat(result).isEqualTo(user1);
    }

    @Test
    void findAll() {
        User user1 = new User();
        user1.setName("육정현");
        repository.save(user1);

        User user2 = new User();
        user2.setName("최재현");
        repository.save(user2);

        List<User> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
