package ua.goit.springpractice;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ua.goit.springpractice.entities.Note;
import ua.goit.springpractice.services.NoteService;

import java.util.NoSuchElementException;

@Service
public class TestNoteService {
    private final NoteService noteService;

    public TestNoteService(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostConstruct
    public void doMethodsNoteService() {
        Note firstNote = new Note("1st", "123qwerty");
        firstNote.setId(1L);
        noteService.add(firstNote);
        noteService.add(new Note("ser", "qwer"));
        noteService.add(new Note("ser", "qwer"));
        Note adNoted = noteService.add(new Note("ser", "qwer"));
        System.out.println(adNoted);

        System.out.println(noteService.listAll());

        try {
            Note secondNote = new Note("second", "12asd");
            secondNote.setId(1L);
            noteService.update(secondNote);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        try {
            Note thirdNote = new Note("second", "12asd");
            thirdNote.setId(3L);
            noteService.update(thirdNote);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(noteService.listAll());

        try {
            Note noteById = noteService.getById(5L);
            System.out.println(noteById);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        try {
            Note noteById = noteService.getById(1L);
            System.out.println(noteById);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        try {
            noteService.deleteById(2L);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        try {
            noteService.deleteById(1L);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(noteService.listAll());

        try {
            Note noteById = noteService.getById(1L);
            System.out.println(noteById);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}
