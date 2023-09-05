package ua.goit.springmvc.controlers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "/note")
public interface NoteController {
    @PostMapping(value = "/list")
    ModelAndView addNewNote(@RequestParam() String newNote, @RequestParam() String newTitle);

    @GetMapping(value = "/list")
    ModelAndView getNotes();

    @PostMapping(value = "/delete/{id}")
    ModelAndView deleteNoteById(@PathVariable() Long id);

    @GetMapping(value = "/edit/{id}")
    ModelAndView editingNote(@PathVariable() Long id);

    @PostMapping(value = "/edit/{id}")
    ModelAndView editNote(@PathVariable() Long id
            , @RequestParam() String editedNote
            , @RequestParam() String editedTitle);
}
