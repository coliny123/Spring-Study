package hello.hello_spring.repository;

import hello.hello_spring.domain.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;


public class MemoryUserRepository implements UserRepository{
    // 메모리에 저장하니까 Map 사용 key: id, value: User,
    private static Map<Long, User> store = new HashMap<>(); // HashMap은 동시성 문제 존재해서 실무에서 공유 변수는 ConcurrentHashMap 사용!
    private static Long sequence = 0L; // 실무에서는 동시성 문제로인해 AtomicLong 사용함
    @Override
    public User save(User user) {
        user.setId(++sequence);
        store.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(store.get(id));  // null 값이 반환될 경우 존재하므로
    }

    @Override
    public Optional<User> findByName(String name) {
        return store.values().stream()
                .filter(user -> user.getName().equals(name))
                .findAny();
    }

    @Override
    public List<User> findAll() {   // 실무에서 List 많이 사용 됨
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
