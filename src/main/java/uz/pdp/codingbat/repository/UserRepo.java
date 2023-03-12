package uz.pdp.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.codingbat.entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {


}
