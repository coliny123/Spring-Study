package hello.hello_spring;

import hello.hello_spring.repository.*;
import hello.hello_spring.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    private final EntityManager em;
    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public UserService userService(){
        return new UserService(userRepository());
    }

    @Bean
    public UserRepository userRepository(){
//        return new MemoryUserRepository();
//        return new JdbcUserRepository(dataSource);
//        return new JdbcTemplateUserRepository(dataSource);
        return new JpaUserRepository(em);
        /*
        개방-폐쇄 원칙(OCP, Open-Closed Principle)
        확장에는 열려있고, 수정, 변경에는 닫혀있다.
        스프링의 DI (Dependencies Injection)을 사용하면 기존 코드를 전혀 손대지 않고, 설정만으로 구현
        클래스를 변경할 수 있다.
        회원을 등록하고 DB에 결과가 잘 입력되는지 확인하자.
        데이터를 DB에 저장하므로 스프링 서버를 다시 실행해도 데이터가 안전하게 저장된다.
         */
    }

    // 컨트롤러는 어쩔 수 없음 Autowired 사용 하는 수밖에
}
