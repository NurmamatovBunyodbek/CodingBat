package uz.pdp.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.entity.TestCase;
import uz.pdp.codingbat.payload.Result;
import uz.pdp.codingbat.payload.TestCaseDto;
import uz.pdp.codingbat.service.TestCaseService;

import java.util.List;

@RestController
@RequestMapping("/testcase")
public class TestCaseController {

    @Autowired
    TestCaseService testCaseService;

    @GetMapping
    public List<TestCase> all() {
        List<TestCase> list = testCaseService.allTestCase();
        return list;
    }

    @GetMapping("/{id}")
    public TestCase getId(@PathVariable Integer id) {
        TestCase testCaseId = testCaseService.getTestCaseId(id);
        return testCaseId;
    }

    @PostMapping
    public Result add(@RequestBody TestCaseDto testCaseDto) {
        Result result = testCaseService.addTestCase(testCaseDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody TestCaseDto testCaseDto) {
        Result result = testCaseService.editingTestCase(id, testCaseDto);
        return result;
    }

    @DeleteMapping("{id}")
    public Result deleted(@PathVariable Integer id) {
        Result result = testCaseService.deletedTestCase(id);
        return result;
    }


}
