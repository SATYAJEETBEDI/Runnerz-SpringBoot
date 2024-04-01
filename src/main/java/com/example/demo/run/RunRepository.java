package com.example.demo.run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();
    
    List<Run> findAll() {
        return runs;
    }

    Optional<Run> findById(Integer id) {
        return runs.stream()
            .filter(run -> run.id() == (id))
            .findFirst();
    }

    void create(Run run){
        runs.add(run);
    }

    void update(Run run,Integer id){
        Optional<Run> runToUpdate = findById(id);
        if(runToUpdate.isPresent()){
            runs.remove(runToUpdate.get());
            runs.add(run);
        }
    }

    void delete(Integer id){
        Optional<Run> runToDelete = findById(id);
        if(runToDelete.isPresent()){
            runs.remove(runToDelete.get());
        }
    }

    @PostConstruct
    private void init() {
        runs.add(new Run(1, "My first run", LocalDateTime.now(), LocalDateTime.now().plus(1,ChronoUnit.HOURS) ,5, Location.OUTDOOR));
        runs.add(new Run(2, "My second run", LocalDateTime.now(), LocalDateTime.now().plus(1,ChronoUnit.HOURS) ,5, Location.OUTDOOR));
        runs.add(new Run(3, "My third run", LocalDateTime.now(), LocalDateTime.now().plus(1,ChronoUnit.HOURS) ,5, Location.OUTDOOR));
    }

}
