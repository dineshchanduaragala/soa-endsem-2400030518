package com.klef.soa.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.exam.entity.LanguageTutor;
import com.klef.soa.exam.repository.LanguageTutorRepository;

@Service
public class LanguageTutorServiceImpl implements LanguageTutorService {

    @Autowired
    private LanguageTutorRepository repo;

    @Override
    public LanguageTutor add(LanguageTutor tutor) {
        return repo.save(tutor);
    }

    @Override
    public List<LanguageTutor> displayAll() {
        return repo.findAll();
    }

    @Override
    public LanguageTutor displayById(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Tutor not found with ID: " + id));
    }

    @Override
    public LanguageTutor update(int id, LanguageTutor tutor) {

        LanguageTutor existingTutor = repo.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Tutor not found with ID: " + id));

        existingTutor.setName(tutor.getName());
        existingTutor.setLanguage(tutor.getLanguage());
        existingTutor.setExperience(tutor.getExperience());
        existingTutor.setGender(tutor.getGender());
        existingTutor.setHourlyfee(tutor.getHourlyfee());

        return repo.save(existingTutor);
    }

    @Override
    public String deleteByid(int id) {

        LanguageTutor tutor = repo.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Tutor not found with ID: " + id));

        repo.delete(tutor);

        return "Tutor deleted successfully";
    }
}