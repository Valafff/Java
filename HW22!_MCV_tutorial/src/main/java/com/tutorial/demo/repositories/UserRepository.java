package com.tutorial.demo.repositories;

import com.tutorial.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

//public interface UserRepository extends CrudRepository<User, Integer>
public interface UserRepository extends JpaRepository<User, Integer>
{
    public Long countById(Integer id);

//    public boolean existsByPassword(String password);
    boolean existsByPasswordOrEmailOrFirstNameOrLastName(String password, String email, String firstName, String lastName);

}
