package uz.pdp.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.entity.Language;
import uz.pdp.codingbat.payload.LanguageDto;
import uz.pdp.codingbat.payload.Result;
import uz.pdp.codingbat.service.LanguageService;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    LanguageService languageService;

    @GetMapping
    public List<Language> getAll() {
        List<Language> languageList = languageService.allLanguage();
        return languageList;
    }

    @GetMapping("/{id}")
    public Language getId(@PathVariable Integer id) {
        Language languageId = languageService.getLanguageId(id);
        return languageId;
    }

    @PostMapping
    public Result add(@RequestBody LanguageDto languageDto) {
        Result result = languageService.addLanguage(languageDto);
        return result;
    }

    @PutMapping("{id}")
    public Result edit(@PathVariable Integer id, @RequestBody LanguageDto languageDto) {
        Result result = languageService.editingLanguage(id, languageDto);
        return result;
    }

    @DeleteMapping("{id}")
    public Result deleted(@PathVariable Integer id) {
        Result result = languageService.deletedLanguage(id);
        return result;
    }


}
