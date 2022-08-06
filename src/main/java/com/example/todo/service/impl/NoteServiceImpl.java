package com.example.todo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.todo.dao.NoteDao;
import com.example.todo.dao.UserDao;
import com.example.todo.model.Note;
import com.example.todo.model.User;
import com.example.todo.service.NoteService;

@Service(value = "noteService")
public class NoteServiceImpl implements UserDetailsService, NoteService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private NoteDao noteDao;

	@Override
	public Note save(Note note) {

		return noteDao.save(note);
	}

	@Override
	public List<Note> findAll() {
		List<Note> list = new ArrayList<Note>();
		noteDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		noteDao.deleteById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User user = userDao.findByUsername(userId);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(String.valueOf(user.getId()), user.getPassword(),
				getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	@Override
	public Note findById(long id) {
		return noteDao.findById(id).get();
	}

}
