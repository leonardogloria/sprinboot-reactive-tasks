package br.com.infnet.tasks.service;

import br.com.infnet.tasks.model.Task;
import br.com.infnet.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public void save(Task task){
        taskRepository.save(task).subscribe();
    }
    public Flux<Task> getAll(){
        return this.taskRepository.findAll();
    }
    public Mono<Task> getById(Long id){
        return this.taskRepository.findById(id);
    }
    public Mono<Void> deleteById(Long id){
        return this.taskRepository.deleteById(id);
    }



}
