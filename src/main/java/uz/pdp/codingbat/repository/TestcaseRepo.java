package uz.pdp.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.codingbat.entity.TestCase;

public interface TestcaseRepo extends JpaRepository<TestCase,Integer> {


}
