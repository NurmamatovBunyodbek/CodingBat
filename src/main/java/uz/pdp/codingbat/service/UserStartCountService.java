package uz.pdp.codingbat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.entity.UserStarCount;
import uz.pdp.codingbat.payload.Result;
import uz.pdp.codingbat.repository.UserStartCountRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserStartCountService {

    @Autowired
    UserStartCountRepo userStartCountRepo;

    public List<UserStarCount> allUserStarCount() {
        List<UserStarCount> countList = userStartCountRepo.findAll();
        return countList;
    }

    public UserStarCount getUserCountId(Integer id) {
        Optional<UserStarCount> countOptional = userStartCountRepo.findById(id);
        return countOptional.get();
    }

    public Result addUserCount(UserStarCount userStarCount) {
        UserStarCount userStarCount1 = new UserStarCount();
        userStarCount1.setStarCount(userStarCount.getStarCount());
        userStarCount1.setUserId(userStarCount.getUserId());
        userStarCount1.setCategoryId(userStarCount.getCategoryId());
        userStartCountRepo.save(userStarCount1);
        return new Result("Added", true);
    }

    public Result editingUserStarCount(Integer id, UserStarCount userStarCount) {
        Optional<UserStarCount> countOptional = userStartCountRepo.findById(id);
        if (countOptional.isPresent()) {
            UserStarCount starCount = countOptional.get();
            starCount.setStarCount(userStarCount.getStarCount());
            starCount.setUserId(userStarCount.getUserId());
            starCount.setCategoryId(userStarCount.getCategoryId());
            userStartCountRepo.save(starCount);
            return new Result("Editing", true);
        }
        return new Result("Not found", false);
    }

    public Result deletedId(Integer id) {
        userStartCountRepo.deleteById(id);
        return new Result("deleted", true);
    }
}
