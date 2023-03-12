package uz.pdp.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.entity.User;
import uz.pdp.codingbat.payload.Result;
import uz.pdp.codingbat.payload.UserDto;
import uz.pdp.codingbat.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> all() {
        List<User> users = userService.allUserList();
        return users;
    }

    @GetMapping("/{id}")
    public User getId(@PathVariable Integer id) {
        User userId = userService.getUserId(id);
        return userId;
    }

    @PostMapping
    public Result add(@RequestBody UserDto userDto) {
        Result result = userService.addUser(userDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody UserDto userDto) {
        Result result = userService.editingUser(id, userDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleted(@PathVariable Integer id) {
        Result result = userService.deletedUser(id);
        return result;
    }

}
