package uz.pdp.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.codingbat.entity.Language;

public interface LanguageRepo extends JpaRepository<Language,Integer> {
}
