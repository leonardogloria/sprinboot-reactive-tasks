package br.com.infnet.tasks.controller;

import br.com.infnet.tasks.model.Task;
import br.com.infnet.tasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping
    public ResponseEntity<Flux<Task>> getAll(){
        Flux<Task> all = taskService.getAll();
        return ResponseEntity.ok(all);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Mono<Task>> getById(@PathVariable Long id){
        return ResponseEntity.ok(taskService.getById(id));
    }
    @PostMapping
    public ResponseEntity<Map<String, String>> create(@RequestBody Task task) {
        taskService.save(task);
        System.out.println(task);
        return ResponseEntity.ok(Map.of("message", "created"));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id){
        taskService.deleteById(id);
        return ResponseEntity.ok(Map.of("message", "deleted"));
    }


}
