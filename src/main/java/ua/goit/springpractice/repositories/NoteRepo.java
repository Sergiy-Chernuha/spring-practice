package ua.goit.springpractice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.goit.springpractice.entities.Note;

@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {
}
