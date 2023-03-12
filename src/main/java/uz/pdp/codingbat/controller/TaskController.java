package uz.pdp.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.entity.Task;
import uz.pdp.codingbat.payload.Result;
import uz.pdp.codingbat.payload.TaskDto;
import uz.pdp.codingbat.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping
    public List<Task> getAll() {
        List<Task> list = taskService.allTaskList();
        return list;
    }

    @GetMapping("/{id}")
    public Task getId(@PathVariable Integer id) {
        Task taskId = taskService.getTaskId(id);
        return taskId;
    }

    @PostMapping
    public Result add(@RequestBody TaskDto taskDto) {
        Result result = taskService.addTask(taskDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody TaskDto taskDto) {
        Result result = taskService.editingTask(id, taskDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleted(@PathVariable Integer id) {
        Result result = taskService.deletedTask(id);
        return result;
    }

}
