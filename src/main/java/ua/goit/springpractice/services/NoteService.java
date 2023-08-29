package ua.goit.springpractice.services;

import org.springframework.stereotype.Service;
import ua.goit.springpractice.entities.Note;

import java.util.*;

@Service
public class NoteService {
    private Map<Long, Note> notes;

    public NoteService() {
        notes = new HashMap<>();
    }

    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    public Note add(Note note) {
        if (Objects.isNull(note.getId())) {
            Long newId = generateId();

            note.setId(newId);
            notes.put(newId, note);
        } else {
            notes.put(note.getId(), note);
        }

        return note;
    }

    public void deleteById(Long id) throws NoSuchElementException {
        if (notes.containsKey(id)) {
            notes.remove(id);
        } else {
            throw new NoSuchElementException("Id(" + id + ") not found for delete");
        }
    }

    public void update(Note note) throws NoSuchElementException {
        if (notes.containsKey(note.getId())) {
            notes.put(note.getId(), note);
        } else {
            throw new NoSuchElementException("Note(id=" + note.getId() + ") not found for update");
        }
    }

    public Note getById(Long id) throws NoSuchElementException {
        if (!notes.containsKey(id)) {
            throw new NoSuchElementException("Id(" + id + ") not found");
        }

        return notes.get(id);
    }

    private Long generateId() {
        Long newKey = new Random().nextLong();

        if (notes.containsKey(newKey)) {
            newKey = generateId();
        }

        return newKey;
    }
}
