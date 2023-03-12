package uz.pdp.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.codingbat.entity.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer> {


}
