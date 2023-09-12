package ua.goit.springpractice.services.NoteServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ua.goit.springpractice.entities.Note;
import ua.goit.springpractice.repositories.NoteRepo;
import ua.goit.springpractice.services.NoteService;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class NoteServiceImpl implements NoteService {
    private final Logger logger;

    private final NoteRepo noteRepo;

    public NoteServiceImpl(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
        logger = LoggerFactory.getLogger(NoteServiceImpl.class);
    }

    @Override
    public List<Note> listAll() {

        return noteRepo.findAll();
    }

    @Override
    public Note add(Note note) {
        if (!Objects.isNull(note)) {
            return noteRepo.save(note);
        }

        return null;
    }

    @Override
    public void deleteById(Long id) {
        try {
            noteRepo.deleteById(id);
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    public void update(Note note) {
        try {
            noteRepo.save(note);
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    public Note getById(Long id) {
        try {
            return noteRepo.findById(id).orElseThrow();
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }
}
