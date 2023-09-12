package ua.goit.springpractice.controlers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.springpractice.entities.Note;
import ua.goit.springpractice.services.NoteServiceImpl.NoteServiceImpl;

@Controller
@RequestMapping(value = "/note", consumes = MediaType.ALL_VALUE)
public class NoteController {
    NoteServiceImpl noteService;

    public NoteController(NoteServiceImpl noteService) {
        this.noteService = noteService;
    }

    @GetMapping(value = "/list")
    public ModelAndView getNotes() {
        ModelAndView result = new ModelAndView("note/list-notes");

        result.addObject("notes", noteService.listAll());

        return result;
    }

    @GetMapping(value = "/new")
    public ModelAndView writeNewNote() {
        return new ModelAndView("note/add-new-note");
    }

    @PostMapping(value = "/add")
    public ModelAndView addNewNote(@RequestParam(name = "note") String newNote, @RequestParam(name = "title") String newTitle) {

        noteService.add(new Note(newTitle, newNote));

        return new ModelAndView("redirect:/note/list");
    }

    @PostMapping(value = "/delete")
    public ModelAndView deleteNoteById(@RequestParam(name = "id") Long id) {

        noteService.deleteById(id);

        return new ModelAndView("redirect:/note/list");
    }

    @GetMapping(value = "/edit")
    public ModelAndView editingNote(@RequestParam(name = "id") Long id) {
        ModelAndView result = new ModelAndView("note/edit-page");

        result.addObject(noteService.getById(id));

        return result;
    }

    @PostMapping(value = "/edit")
    public ModelAndView editNote(@RequestParam(name = "id") Long id
            , @RequestParam(name = "title") String editedTitle
            , @RequestParam(name = "content") String editedNote) {

        noteService.update(new Note(id, editedTitle, editedNote));

        return new ModelAndView("redirect:/note/list");
    }
}
