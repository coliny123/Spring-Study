package hello.hello_spring.controller;

import hello.hello_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
/*
    이렇게 new로 하면 다른 controller들이 UserService를 가져다 쓰는데 인스턴스가 계속 생김,
    그래서 하나만 생성해두고 공용으로 씀(싱글톤!!)
    public final UserService userService = new UserService();
    So, 생성자에 넣어서 DI
    Lombok 사용시
        @Controller
        @RequiredArgsConstructor
        public class UserController{

            private final UserService userService;
        }
 */
    public final UserService userService;

    @Autowired  // Dependency Injection
    public UserController(UserService userService) {    //
        this.userService = userService;
    }
}
