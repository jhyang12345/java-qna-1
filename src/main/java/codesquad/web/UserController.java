package codesquad.web;

import codesquad.domain.User;
import codesquad.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private List<User> users = new ArrayList<>();

    @Autowired
    private UserRepository userRepository;

    // {id} named variable
    @GetMapping("/users/{index}")
    public String show(@PathVariable long index, Model model) {

        model.addAttribute("user", userRepository.findById(index).get());
        return "/user/profile";
    }

    @PostMapping("/users")
    public String create(User user, Model model) {
        userRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping("/users/updateForm/{index}")
    public String getUserInfo(@PathVariable long index, Model model) {
        model.addAttribute("user", userRepository.findById(index).get());
        return "/user/updateForm";
    }

    @PostMapping("/users/updateForm/{index}")
    public String updateUserInfo(@PathVariable long index, User user, Model model) {
        User original = userRepository.findById(index).get();
        if(original.getPassword().equals(user.getPassword())) {
            user.setId(original.getId());
            userRepository.save(user);
        }
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String list(User user, Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "/user/list";
    }

}
