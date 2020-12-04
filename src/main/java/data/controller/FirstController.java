package data.controller;

import com.sun.media.jfxmediaimpl.HostUtils;
import data.entity.Role;
import data.entity.User;
import data.service.RoleService;
import data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
public class FirstController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/")
    public String firstPage(Model model) {
        return "firstView";
    }

    @GetMapping(value = "/allUsers")
    public String showAllUsers(Model model) {
        model.addAttribute("usersAll", userService.getAll());
        return "allUsers";
    }

    @GetMapping(value = "/{id}")
    public String showOneUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("userByid", userService.getById(id));
        return "getUserById";
    }

    @GetMapping(value = "/addUser")
    public String giveNewUser(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("allRoles", roleService.getAll());
        return "newuser";
    }

    @PostMapping()
    public String saveNewUser(@ModelAttribute("user") User user,  @RequestParam(value = "allRoles") String[] roles) {
        user.setRoles(userService.newRoles(roles));
        userService.save(user);
        return "redirect:/allUsers";
    }

    @GetMapping("/{id}/admin")
    public String editUser(@PathVariable("id") long id, Model model) {
        User user1 = userService.getById(id);
        model.addAttribute("user", user1);
        model.addAttribute("allRoles", roleService.getAll());
        return "edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("user") User user,
                         @PathVariable("id") long id, @RequestParam(value = "allRoles") String[] roles) {
        user.setRoles(userService.newRoles(roles));
        System.out.println("User _++++" + user);
        System.out.println("User new roles???????" + userService.newRoles(roles));
        userService.update(id, user);
        return "redirect:/allUsers";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        System.out.println("in Delete method");
        userService.remove(id);
        return "redirect:/allUsers";
    }

    @GetMapping("page/user")
    public String showOverview(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        model.addAttribute("userGotIn", user);
        return "user";
    }
}
