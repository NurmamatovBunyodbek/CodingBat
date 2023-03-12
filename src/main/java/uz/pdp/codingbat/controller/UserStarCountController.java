package uz.pdp.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.entity.UserStarCount;
import uz.pdp.codingbat.payload.Result;
import uz.pdp.codingbat.service.UserStartCountService;

import java.util.List;

@RestController
@RequestMapping("/usercount")
public class UserStarCountController {

    @Autowired
    UserStartCountService userStartCountService;

    @GetMapping
    public List<UserStarCount> all() {
        List<UserStarCount> userStarCounts = userStartCountService.allUserStarCount();
        return userStarCounts;
    }

    @GetMapping("/{id}")
    public UserStarCount getId(@PathVariable Integer id) {
        UserStarCount userCountId = userStartCountService.getUserCountId(id);
        return userCountId;
    }

    @PostMapping
    public Result add(@RequestBody UserStarCount userStarCount) {
        Result result = userStartCountService.addUserCount(userStarCount);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody UserStarCount userStarCount) {
        Result result = userStartCountService.editingUserStarCount(id, userStarCount);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleted(@PathVariable Integer id) {
        Result result = userStartCountService.deletedId(id);
        return result;
    }

}
