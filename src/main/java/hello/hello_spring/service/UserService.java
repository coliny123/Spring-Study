package hello.hello_spring.service;

import hello.hello_spring.domain.User;
import hello.hello_spring.repository.MemoryUserRepository;
import hello.hello_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class UserService {

    /*
        UserService에서 만든 MemoryUserRepository와 TEST에서 만든 MemoryUserRepository가 서로 다른 인스턴스,(지금은 static이라서 ㄱㅊ지만 아니라면 문제 생김)
        지금도 다른 MemoryUserRepository로 test하고 있음, So, UserService에서 new 대신 생성자로 바꿈(외부에서 넣어주도록!)
    */
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) { // DI(dependency injection)
        this.userRepository = userRepository;
    }

    /**
     *
     * @param user
     * @return
     */
    public Long join(User user) {
        //같은 이름이 있는 중복 회원x
        validateDuplicatedName(user);   // 중복 회원 검증
        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicatedName(User user) {
        userRepository.findByName(user.getName())
                .ifPresent(u ->{  // Optional로 감싸기 때문에 이렇게 가능!
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     * @return
     */
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findOne(Long userId){
        return userRepository.findById(userId);
    }
}
