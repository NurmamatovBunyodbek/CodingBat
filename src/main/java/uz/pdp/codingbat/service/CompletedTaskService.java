package uz.pdp.codingbat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.entity.CompletedTask;
import uz.pdp.codingbat.entity.Task;
import uz.pdp.codingbat.entity.TestCase;
import uz.pdp.codingbat.entity.User;
import uz.pdp.codingbat.payload.CompletedTaskDto;
import uz.pdp.codingbat.payload.Result;
import uz.pdp.codingbat.payload.TestCaseDto;
import uz.pdp.codingbat.repository.CompletedTaskRepo;
import uz.pdp.codingbat.repository.TaskRepo;
import uz.pdp.codingbat.repository.TestcaseRepo;
import uz.pdp.codingbat.repository.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CompletedTaskService {

    @Autowired
    CompletedTaskRepo completedTaskRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    TaskRepo taskRepo;
    @Autowired
    TestcaseRepo testcaseRepo;


    public List<CompletedTask> getAllCompletedTask() {
        List<CompletedTask> completedTaskList = completedTaskRepo.findAll();
        return completedTaskList;
    }

    public CompletedTask getCompletedId(Integer id) {
        Optional<CompletedTask> taskOptional = completedTaskRepo.findById(id);
        return taskOptional.get();
    }

    public Result addCompletedTask(CompletedTaskDto completedTaskDto) {
        CompletedTask completedTask = new CompletedTask();
        Optional<Task> optionalTask = taskRepo.findById(completedTaskDto.getTaskId());
        completedTask.setTaskId(optionalTask.get().getId());
        Optional<User> userOptional = userRepo.findById(completedTaskDto.getUserId());
        completedTask.setUserId(userOptional.get().getId());
        completedTask.setAnswerText(completedTaskDto.getAnswerText());
        completedTask.setIsCompleted(completedTaskDto.getIsCompleted());
        Optional<TestCase> optionalTestCase = testcaseRepo.findById(completedTaskDto.getTestCaseCount());
        completedTask.setTestCaseCount(optionalTestCase.get().getId());
        completedTaskRepo.save(completedTask);
        return new Result("Added", true);
    }

    public Result editingCompletedTask(Integer id, CompletedTaskDto completedTaskDto) {
        Optional<CompletedTask> taskOptional = completedTaskRepo.findById(id);
        if (taskOptional.isPresent()) {
            CompletedTask completedTask = taskOptional.get();
            Optional<Task> optionalTask = taskRepo.findById(completedTaskDto.getTaskId());
            completedTask.setTaskId(optionalTask.get().getId());
            Optional<User> userOptional = userRepo.findById(completedTaskDto.getUserId());
            completedTask.setUserId(userOptional.get().getId());
            completedTask.setAnswerText(completedTaskDto.getAnswerText());
            completedTask.setTestCaseCount(completedTaskDto.getTestCaseCount());
            completedTask.setIsCompleted(completedTaskDto.getIsCompleted());
            completedTaskRepo.save(completedTask);
            return new Result("CompletedTask editing", true);
        }
        return new Result("Not found", false);
    }

    public Result deletedCompletedTask(Integer id) {
        completedTaskRepo.deleteById(id);
        return new Result("Deleted", true);
    }

}
