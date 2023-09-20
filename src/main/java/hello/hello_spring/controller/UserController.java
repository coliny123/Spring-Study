package hello.hello_spring.controller;

import hello.hello_spring.domain.User;
import hello.hello_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// 컨트롤러는 어쩔 수 없음 이렇게 하는 수밖에
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

/*
DI의 3가지 방법:
필드 주입, setter 주입, 생성자 주입
의존관계가 실행중에 동적으로 변하는경우는 거의 없으므로 생성자 주입을 권장
@Autowired를 통한 DI는 스프링이 관리하는 객체(스프링 빈 등록)에서만 동작한다. 스프링 빈으로 등록하지 않고 내가 직접 생성한 객체에서는 동작하지 않는다.
정형화 되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록한다.
-> UserRepository interface로 설계하고 구현을 MemoryUserRepository 한 걸 나중에 코드 수정 없이 다른 repository로 바꿔치기 하는 상황!
-> SpringConfig에서 MemoryUserRepository만 DbUserRepository로 바꿔주면 됨!!!
 */


//    1. setter DI
//    -> 단점: 누군가가 UserController를 호출했을 때 setter가 public으로 열려있어야 함(노출)
//    public UserService userService;
//
//    @Autowired
//    public void setUserController(UserService userService) {
//        this.userService = userService;
//    }

//    2. 필드 DI
//    @Autowired public UserService userService;

//    3. 생성자 DI
    public final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/new")
    public String createForm(){
        return "users/createUserForm";
    }

    @PostMapping("/users/new")
    public String create(UserForm form){
        User user = new User();
        user.setName(form.getName());

        userService.join(user);
        return "redirect:/";
    }
}
