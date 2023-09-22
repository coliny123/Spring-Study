package hello.hello_spring.repository;

import hello.hello_spring.domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class JpaUserRepository implements UserRepository{

    /*
    -항상 data를 저장, 변경시 service 계층에 @Transactional 를 붙혀줘야 함!(ex: 회원 가입)
    JPA는 기존의 반복 코드는 물론이고, 기본적인 SQL도 JPA가 직접 만들어서 실행해준다.
    JPA를 사용하면, SQL과 데이터 중심의 설계에서 객체 중심의 설계로 패러다임을 전환을 할 수 있다.
    JPA를 사용하면 개발 생산성을 크게 높일 수 있다.
     */
    private final EntityManager em;

    public JpaUserRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public User save(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        User user = em.find(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findByName(String name) {
        List<User> result = em.createQuery("select m from User m where m.name = :name", User.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("select m from User m", User.class)   // Entity(User) 대상으로 쿼리를 날림(조회해!(객체 자체를) -> 이미 mapping이 다 됨)
                .getResultList();
    }
}
