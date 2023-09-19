package hello.hello_spring.service;

import hello.hello_spring.domain.User;
import hello.hello_spring.repository.MemoryUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


class UserServiceTest {

    UserService userService;
    MemoryUserRepository userRepository;

    @BeforeEach
    void beforeEach() { // 각 test 시작전에 MemoryUserRepository를 만들고 그걸 UserService에 넣어줌 -> 같은 MemoryUserRepository가 사용이 됨
        userRepository = new MemoryUserRepository();
        userService = new UserService(userRepository);
    }

    @AfterEach
    void afterEach() {
        userRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        User user = new User();
        user.setName("육정현");

        //when
        Long saveId = userService.join(user);

        //then
        User findUser = userService.findOne(saveId).get();
        assertThat(user.getName()).isEqualTo(findUser.getName());
    }

    @Test
    void 중복_회원_예외() {
        //given
        User user1 = new User();
        user1.setName("육정현");

        User user2 = new User();
        user2.setName("육정현");

        //when
        userService.join(user1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> userService.join(user2));// IllegalStateException면 TEST 성공, NullPointerException 같으면 실패
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        try {
//            userService.join(user2);
//            fail("예외가 발생해야 합니다.");
//        } catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.123");
//        }

        //then
    }

    @Test
    void findUsers() {
    }

    @Test
    void findOne() {
    }
}