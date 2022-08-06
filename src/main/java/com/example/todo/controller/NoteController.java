package com.example.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.model.Note;
import com.example.todo.service.NoteService;

@RestController
@RequestMapping("/notes")
public class NoteController {

	  @Autowired
	    private NoteService noteService;

	    @RequestMapping(value = "/list", method = RequestMethod.GET)
	    public List<Note> listUser() {
	        return noteService.findAll();
	    }

	    @RequestMapping(value = "/create", method = RequestMethod.POST)
	    public Note create(@RequestBody Note note) {
	        return noteService.save(note);
	    }

	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	    public String delete(@PathVariable(value = "id") Long id) {
	    	noteService.delete(id);
	        return "delete success";
	    }
	    
	    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	    public Note update(@PathVariable(value = "id") Long id, @RequestBody Note note) {
	    	Note data = noteService.findById(id);
	    	data.setNote(note.getNote());
	    	return noteService.save(data);
	    }
}
