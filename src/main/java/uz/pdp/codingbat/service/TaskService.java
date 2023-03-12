package uz.pdp.codingbat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.entity.Task;
import uz.pdp.codingbat.payload.Result;
import uz.pdp.codingbat.payload.TaskDto;
import uz.pdp.codingbat.repository.TaskRepo;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepo taskRepo;

    public List<Task> allTaskList() {
        List<Task> taskList = taskRepo.findAll();
        return taskList;
    }

    public Task getTaskId(Integer id) {
        Optional<Task> optionalTask = taskRepo.findById(id);
        return optionalTask.get();
    }

    public Result addTask(TaskDto taskDto) {
        Task task = new Task();
        task.setName(taskDto.getName());
        task.setCategory(taskDto.getCategory());
        task.setSolution(taskDto.getSolution());
        task.setQuestion(taskDto.getQuestion());
        task.setTemplate(taskDto.getTemplate());
        task.setAnswerText(taskDto.getAnswerText());
        taskRepo.save(task);
        return new Result("Task added", true);
    }

    public Result editingTask(Integer id, TaskDto taskDto) {
        Optional<Task> optionalTask = taskRepo.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setName(taskDto.getName());
            task.setCategory(taskDto.getCategory());
            task.setSolution(taskDto.getSolution());
            task.setQuestion(taskDto.getQuestion());
            task.setTemplate(taskDto.getTemplate());
            task.setAnswerText(taskDto.getAnswerText());
            return new Result("Editing Task", true);
        }
        return new Result("Task not found", false);
    }

    public Result deletedTask(Integer id) {
        taskRepo.deleteById(id);
        return new Result("Task deleted", true);
    }


}
