package uz.pdp.codingbat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.entity.Category;
import uz.pdp.codingbat.entity.Language;
import uz.pdp.codingbat.payload.CategoryDto;
import uz.pdp.codingbat.payload.Result;
import uz.pdp.codingbat.repository.CategoryRepo;
import uz.pdp.codingbat.repository.LanguageRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    LanguageRepo languageRepo;

    public List<Category> getAllList() {
        List<Category> categoryList = categoryRepo.findAll();
        return categoryList;
    }

    public Category getCategory(Integer id) {
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        return optionalCategory.get();
    }

    public Result addCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        Optional<Language> byId = languageRepo.findById(categoryDto.getLanguageId());
        category.setLanguage(byId.get());
        category.setDescription(categoryDto.getDescription());
        category.setStartCount(categoryDto.getStartCount());
        categoryRepo.save(category);

        return new Result("Category added", true);
    }

    public Result editingCategory(Integer id, CategoryDto categoryDto) {
        Optional<Category> categoryOptional = categoryRepo.findById(id);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.setName(categoryDto.getName());
            Optional<Language> byId = languageRepo.findById(categoryDto.getLanguageId());
            category.setLanguage(byId.get());
            category.setDescription(categoryDto.getDescription());
            category.setStartCount(categoryDto.getStartCount());
            categoryRepo.save(category);
            return new Result("Category editing", true);
        }
        return new Result("Category not found", false);
    }

    public Result deletedCategory(Integer id) {
        categoryRepo.deleteById(id);
        return new Result("Category", true);
    }


}
