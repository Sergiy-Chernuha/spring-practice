package ua.goit.springpractice.services;

import ua.goit.springpractice.entities.Note;

import java.util.List;
import java.util.NoSuchElementException;

public interface NoteService {
    List<Note> listAll();

    Note add(Note note);

    void deleteById(Long id) throws NoSuchElementException;

    void update(Note note) throws NoSuchElementException;

    Note getById(Long id) throws NoSuchElementException;
}
