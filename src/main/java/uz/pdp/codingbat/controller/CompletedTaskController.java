package uz.pdp.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.ls.LSInput;
import uz.pdp.codingbat.entity.CompletedTask;
import uz.pdp.codingbat.payload.CompletedTaskDto;
import uz.pdp.codingbat.payload.Result;
import uz.pdp.codingbat.service.CompletedTaskService;

import java.util.List;

@RestController
@RequestMapping("/completedTask")
public class CompletedTaskController {

    @Autowired
    CompletedTaskService completedTaskService;

    @GetMapping
    public List<CompletedTask> getAll(){
        List<CompletedTask> allCompletedTask = completedTaskService.getAllCompletedTask();
        return allCompletedTask;
    }

    @GetMapping("/{id}")
    public  CompletedTask getId(@PathVariable Integer id){
        CompletedTask completedId = completedTaskService.getCompletedId(id);
        return completedId;
    }
    @PostMapping
    public Result add(@RequestBody CompletedTaskDto completedTaskDto){
        Result result = completedTaskService.addCompletedTask(completedTaskDto);
        return result;
    }
    @PutMapping("/{id}")
    public  Result edit(@PathVariable Integer id , @RequestBody CompletedTaskDto completedTaskDto){
        Result result = completedTaskService.editingCompletedTask(id, completedTaskDto);
        return result;
    }
    @DeleteMapping("{id}")
    public  Result deleted(@PathVariable Integer id){
        Result result = completedTaskService.deletedCompletedTask(id);
        return result;
    }

}
