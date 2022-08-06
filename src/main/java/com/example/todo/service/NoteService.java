package com.example.todo.service;

import java.util.List;

import com.example.todo.model.Note;

public interface NoteService {

	Note save(Note note);

	List<Note> findAll();

	void delete(long id);
	
	Note findById(long id);
}
