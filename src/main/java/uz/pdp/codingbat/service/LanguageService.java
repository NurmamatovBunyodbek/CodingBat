package uz.pdp.codingbat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.entity.Language;
import uz.pdp.codingbat.payload.LanguageDto;
import uz.pdp.codingbat.payload.Result;
import uz.pdp.codingbat.repository.LanguageRepo;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {

    @Autowired
    LanguageRepo languageRepo;

    public List<Language> allLanguage() {
        List<Language> languageList = languageRepo.findAll();
        return languageList;
    }

    public Language getLanguageId(Integer id) {
        Optional<Language> languageOptional = languageRepo.findById(id);
        return languageOptional.get();
    }

    public Result addLanguage(LanguageDto languageDto) {
        Language language = new Language();
        language.setName(languageDto.getName());
        languageRepo.save(language);
        return new Result("Language added", true);
    }

    public Result editingLanguage(Integer id, LanguageDto languageDto) {
        Optional<Language> optionalLanguage = languageRepo.findById(id);
        if (optionalLanguage.isPresent()) {
            Language language = optionalLanguage.get();
            language.setName(languageDto.getName());
            languageRepo.save(language);
            return new Result("editing", true);
        }
        return new Result("Language not found", false);
    }

    public Result deletedLanguage(Integer id) {

        languageRepo.deleteById(id);
        return new Result("Deleted language", true);
    }

}
