package uz.pdp.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.codingbat.entity.UserStarCount;

public interface UserStartCountRepo extends JpaRepository<UserStarCount,Integer> {


}
