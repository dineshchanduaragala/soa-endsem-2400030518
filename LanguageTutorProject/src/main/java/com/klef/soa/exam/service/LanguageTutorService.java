package com.klef.soa.exam.service;

import java.util.List;

import com.klef.soa.exam.entity.LanguageTutor;

public interface LanguageTutorService
{
	public LanguageTutor add(LanguageTutor tutor);

    List<LanguageTutor> displayAll();

    LanguageTutor displayById(int id);

    LanguageTutor update(int id, LanguageTutor tutor);

    String deleteByid(int id);
}
