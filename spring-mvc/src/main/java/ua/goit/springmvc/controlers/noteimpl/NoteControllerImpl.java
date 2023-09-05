package ua.goit.springmvc.controlers.noteimpl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.springmvc.controlers.NoteController;
import ua.goit.springmvc.entities.Note;

import java.util.HashMap;
import java.util.Map;

@Controller
public class NoteControllerImpl implements NoteController {
    private Map<Long, Note> notes = new HashMap<>();

    @Override
    public ModelAndView getNotes() {
        ModelAndView result = new ModelAndView("note/list-notes");

        result.addObject("notes", notes);

        return result;
    }

    @Override
    public ModelAndView addNewNote(@RequestParam(name = "note") String newNote, @RequestParam(name = "title") String newTitle) {
        ModelAndView result = new ModelAndView("note/list-notes");
        Note note = new Note(newTitle, newNote);
        Long nextId = (long) notes.size();

        note.setId(nextId);
        notes.put(nextId, note);
        result.addObject("notes", notes);

        return result;
    }

    @Override
    public ModelAndView deleteNoteById(@PathVariable(name = "id") Long id) {
        notes.remove(id);

        return new ModelAndView("redirect:/note/list");
    }

    @Override
    public ModelAndView editingNote(@PathVariable() Long id) {
        ModelAndView result = new ModelAndView("note/edit-page");
        result.addObject(notes.get(id));

        return result;
    }

    @Override
    public ModelAndView editNote(@PathVariable() Long id
            , @RequestParam(name = "note") String editedNote
            , @RequestParam(name = "title") String editedTitle) {

        Note updatedNote = new Note(editedTitle, editedNote);
        updatedNote.setId(id);
        notes.remove(id);
        notes.put(id, updatedNote);

        return new ModelAndView("redirect:/note/list");
    }
}
