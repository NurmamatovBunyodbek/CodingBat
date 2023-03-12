package uz.pdp.codingbat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.entity.Task;
import uz.pdp.codingbat.entity.TestCase;
import uz.pdp.codingbat.payload.Result;
import uz.pdp.codingbat.payload.TestCaseDto;
import uz.pdp.codingbat.repository.TaskRepo;
import uz.pdp.codingbat.repository.TestcaseRepo;

import java.util.List;
import java.util.Optional;

@Service
public class TestCaseService {


    @Autowired
    TestcaseRepo testcaseRepo;
    @Autowired
    TaskRepo taskRepo;


    public List<TestCase> allTestCase() {
        List<TestCase> caseList = testcaseRepo.findAll();
        return caseList;
    }

    public TestCase getTestCaseId(Integer id) {
        Optional<TestCase> caseOptional = testcaseRepo.findById(id);
        return caseOptional.get();
    }

    public Result addTestCase(TestCaseDto testCaseDto) {
        TestCase testCase = new TestCase();
        testCase.setCaseText(testCaseDto.getCaseText());
        testCase.setTaskId(testCaseDto.getTaskId());
        testcaseRepo.save(testCase);
        return new Result("Added", true);
    }

    public Result editingTestCase(Integer id, TestCaseDto testCaseDto) {
        Optional<TestCase> byId = testcaseRepo.findById(id);
        if (byId.isPresent()) {
            TestCase testCase = byId.get();
            testCase.setCaseText(testCaseDto.getCaseText());
            testCase.setTaskId(testCaseDto.getTaskId());
            testcaseRepo.save(testCase);
            return new Result("Editing TestCase", true);
        }
        return new Result("Not found", false);
    }

    public Result deletedTestCase(Integer id) {
        testcaseRepo.deleteById(id);
        return new Result("deleted", true);
    }

}
