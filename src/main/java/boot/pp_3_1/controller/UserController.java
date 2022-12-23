package boot.pp_3_1.controller;

import boot.pp_3_1.model.User;
import boot.pp_3_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class UserController {
    @Autowired
    UserService a;

    public UserController() {
    }

    @GetMapping ("/users/")
    public String getUsers(Model model){
        model.addAttribute("users", a.listUsers());
        return "users";
    }

    @GetMapping ("/users/{id}")
    public String getUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", a.getUser(id));
        return "user";
    }

    @GetMapping ("/users/new")
    public String getNew(Model model){
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/users")
    public String create(@ModelAttribute User user){
        a.add(user);
        return "redirect:/users/";
    }

    @GetMapping ("/users/{id}/edit")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", a.getUser(id));
        return "edit";
    }

    @PatchMapping("/users/{id}")
    public String edit(@ModelAttribute("user") User user) {
        a.update(user);
        return "redirect:/users/";
    }

    @GetMapping ("/users/{id}/delete")
    public String deleteUser(@PathVariable("id") int id, Model model){
        a.delete(id);
        return "redirect:/users/";
    }
}

