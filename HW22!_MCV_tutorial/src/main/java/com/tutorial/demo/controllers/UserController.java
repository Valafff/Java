package com.tutorial.demo.controllers;

import com.tutorial.demo.entities.User;
import com.tutorial.demo.exceptions.UserAlreadyExist;
import com.tutorial.demo.exceptions.UserNotFoundException;
import com.tutorial.demo.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller("users")
//@RequestMapping("/users")
public class UserController
{
    private final UserService userService;

    public UserController(UserService service)
    {
        userService = service;
    }

    @GetMapping("/users")
    public String showUserList(Model model)
    {
        List<User> listUsers = userService.listAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @GetMapping("/users/new")
    public  String showNewForm(Model model)
    {
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Добавить нового юзера");
        return "user_form";
    }

    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes re) throws UserAlreadyExist
    {
        try
        {
            userService.save(user);
            re.addFlashAttribute("message", "Юзер успешно сохранен!");
            return "redirect:/users";
        }
        catch (UserAlreadyExist e)
        {
            re.addFlashAttribute("messageAlert", e.getMessage());
            return "redirect:/users";
        }
    }
//    @PostMapping("/users/save")
//    public String saveUser(User user, RedirectAttributes re)
//    {
//            userService.save(user);
//            re.addFlashAttribute("message", "Юзер успешно сохранен!");
//            return "redirect:/users";
//    }

    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra)
    {
        try
        {
          User user =  userService.get(id);
          model.addAttribute("user", user);
          model.addAttribute("pageTitle", "Редактирование пользователя (ID " + id + ")");

          return "user_form";
        }
        catch (UserNotFoundException e)
        {
            ra.addFlashAttribute("message", "Юзер успешно сохранен!");
            return "redirect:/users";
        }
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes ra)
    {
        try
        {
            userService.delete(id);
            ra.addFlashAttribute("message", "Юзер c ID "+ id +" успешно удален");
        }
        catch (UserNotFoundException e)
        {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/users";
    }
}
