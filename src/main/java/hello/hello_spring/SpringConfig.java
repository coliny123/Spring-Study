package hello.hello_spring;

import hello.hello_spring.repository.MemoryUserRepository;
import hello.hello_spring.repository.UserRepository;
import hello.hello_spring.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    /*
    직접 스프링 빈 등록 시 장단점

     */

    @Bean
    public UserService userService(){
        return new UserService(userRepository());
    }

    @Bean
    public UserRepository userRepository(){
        return new MemoryUserRepository();
    }

    // 컨트롤러는 어쩔 수 없음 Autowired 사용 하는 수밖에
}
