package com.tutorial.demo.services;

import com.tutorial.demo.entities.User;
import com.tutorial.demo.exceptions.UserAlreadyExist;
import com.tutorial.demo.exceptions.UserNotFoundException;
import com.tutorial.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    private final UserRepository repository;

    public UserService(UserRepository userRepository)
    {
        this.repository = userRepository;
    }

    public List<User> listAll ()
    {
        return (List<User>) repository.findAll();
    }

    public void save(User user) throws UserAlreadyExist
    {
        var pass = repository.existsByPasswordOrEmailOrFirstNameOrLastName(
                user.getPassword(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName());
        if (!pass || (user.getId() != null && user.getId() != 0))
        {
            repository.save(user);
        }
        else
        {
            throw  new UserAlreadyExist("Нельзя создать такого пользователя");
        }
    }

//    public void save(User user)
//    {
//        repository.save(user);
//    }

    public User get(Integer id) throws UserNotFoundException {
        Optional<User> user = repository.findById(id);
        if (user.isPresent())
        {
            return  user.get();
        }
        throw new UserNotFoundException("Не найден ни один пользователь с ID "+ id);
    }

    public void delete(Integer id) throws UserNotFoundException {
        Long count = repository.countById(id);
        if (count == null || count == 0)
        {
            throw new UserNotFoundException("Не найден ни один пользователь с ID "+ id);
        }
        repository.deleteById(id);
    }
}
