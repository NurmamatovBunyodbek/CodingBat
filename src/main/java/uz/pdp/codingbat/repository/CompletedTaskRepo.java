package uz.pdp.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.codingbat.entity.CompletedTask;

public interface CompletedTaskRepo extends JpaRepository<CompletedTask,Integer> {


}
