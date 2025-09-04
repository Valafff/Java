package com.tutorial.demo;

import com.tutorial.demo.entities.User;
import com.tutorial.demo.repositories.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests
{
    @Autowired
    private  UserRepository repository;
    //Так нифига не работает для тестового класса
//    private final UserRepository repository;
//
//    public  UserRepositoryTests(UserRepository repository)
//    {
//        this.repository = repository;
//    }

    @Test
    public void testAddNew()
    {
        User user = new User("123", "123@ggg.com", "vas", "pupkin", false);
//        User user = new User();
//        user.setEmail("123@ggg.com");
//        user.setPassword("123");
//        user.setFirstName("vas");
//        user.setLastName("pupkin");

        User savedUser = repository.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll()
    {
        Iterable<User> users = repository.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for (User user: users)
        {
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate()
    {
        Integer userId = 1;
        Optional<User> optionalUser = repository.findById(userId);
        if (optionalUser.isPresent())
        {
            User user = optionalUser.get();
            user.setPassword("8888");
            repository.save(user);
        }
        Optional<User> updatedUser= repository.findById(userId);
        if (updatedUser.isPresent())
        {
            User uptUser = updatedUser.get();
            Assertions.assertThat(uptUser.getPassword()).isEqualTo("8888");
        }
    }

    @Test
    public void testGet()
    {
        Integer userId = 3;
        Optional<User> optionalUser = repository.findById(userId);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());
    }

    @Test
    public  void  testDelete()
    {
        Integer userid = 2;
        repository.deleteById(userid);

        Optional<User> optionalUser = repository.findById(userid);
        Assertions.assertThat(optionalUser).isNotPresent();
    }

}
