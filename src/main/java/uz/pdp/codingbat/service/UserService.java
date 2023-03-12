package uz.pdp.codingbat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.entity.User;
import uz.pdp.codingbat.payload.Result;
import uz.pdp.codingbat.payload.UserDto;
import uz.pdp.codingbat.repository.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> allUserList() {
        List<User> userList = userRepo.findAll();
        return userList;
    }

    public User getUserId(Integer id) {
        Optional<User> optionalUser = userRepo.findById(id);
        return optionalUser.get();
    }

    public Result addUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        userRepo.save(user);
        return new Result("Added", true);
    }

    public Result editingUser(Integer id, UserDto userDto) {
        Optional<User> byId = userRepo.findById(id);
        if (byId.isPresent()) {
            User user = byId.get();
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            userRepo.save(user);
            return new Result("User editing", true);
        }
        return new Result("User not found", false);
    }

    public Result deletedUser(Integer id) {
        userRepo.deleteById(id);
        return new Result("User deleted", true);
    }


}
