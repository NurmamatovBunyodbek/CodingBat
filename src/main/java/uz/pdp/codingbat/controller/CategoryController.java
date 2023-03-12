package uz.pdp.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.entity.Category;
import uz.pdp.codingbat.payload.CategoryDto;
import uz.pdp.codingbat.payload.Result;
import uz.pdp.codingbat.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> categoryList() {
        List<Category> allList = categoryService.getAllList();
        return allList;
    }

    @GetMapping("/{id}")
    public Category getId(@PathVariable Integer id) {
        Category category = categoryService.getCategory(id);
        return category;
    }

    @PostMapping
    public Result addCategory(@RequestBody CategoryDto categoryDto) {
        Result result = categoryService.addCategory(categoryDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody CategoryDto categoryDto) {

        Result result = categoryService.editingCategory(id, categoryDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleted(@PathVariable Integer id) {
        Result result = categoryService.deletedCategory(id);
        return result;
    }

}
