package com.klef.soa.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klef.soa.exam.entity.LanguageTutor;
import com.klef.soa.exam.service.LanguageTutorService;

@RestController
@RequestMapping("/languagetutor")
public class LanguageTutorController {

    @Autowired
    private LanguageTutorService service;

    @PostMapping("/add")
    public LanguageTutor addTutor(@RequestBody LanguageTutor tutor) {
        return service.add(tutor);
    }

    @GetMapping("/displayall")
    public List<LanguageTutor> displayAll() {
        return service.displayAll();
    }

    @GetMapping("/displaybyid/{id}")
    public LanguageTutor displayById(@PathVariable int id) {
        return service.displayById(id);
    }

    @PutMapping("/update/{id}")
    public LanguageTutor updateTutor(
            @PathVariable int id,
            @RequestBody LanguageTutor tutor) {
        return service.update(id, tutor);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTutor(@PathVariable int id) {
        return service.deleteByid(id);
    }
}