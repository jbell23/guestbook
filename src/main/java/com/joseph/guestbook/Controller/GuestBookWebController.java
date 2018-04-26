package com.joseph.guestbook.Controller;

import com.joseph.guestbook.domain.GuestBookEntry;
import com.joseph.guestbook.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class GuestBookWebController {

    @Autowired
    private GuestBookService guestBookService;

    private static final String GUESTBOOK_TEMPLATE = "guestbook";

    private static final String ENTRIES_TEMPLATE_ID = "entries";

    private static final String HOMEPAGE_REDIRECT = "redirect:/";

    private static final String NEW_PAGE_TEMPLATE_ID = "newEntry";

    private static final String GUESTBOOK_FORM_HEADER_ID = "formHeader";

    @GetMapping("/")
    public String displayGuestBook (Model model) {

        model.addAttribute(GUESTBOOK_FORM_HEADER_ID, "Add A New Beer");
        model.addAttribute(ENTRIES_TEMPLATE_ID, this.guestBookService.findAllEntries());
        model.addAttribute("newEntry", new GuestBookEntry());

        return GUESTBOOK_TEMPLATE;
    }

    @GetMapping ("/delete/{id}")
    public String deleteComment (@PathVariable Integer id) {
        this.guestBookService.deleteGuestBookEntryById (id);

        return HOMEPAGE_REDIRECT;
    }

    @PostMapping ("/")
    public String addComment (Model model, @Valid @ModelAttribute (NEW_PAGE_TEMPLATE_ID) GuestBookEntry newEntry, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            this.guestBookService.save(newEntry);
            return HOMEPAGE_REDIRECT;
        } else {
            model.addAttribute(GUESTBOOK_FORM_HEADER_ID, "Please Correct The Data");
            model.addAttribute (ENTRIES_TEMPLATE_ID, this.guestBookService.findAllEntries());
            return GUESTBOOK_TEMPLATE;
        }
    }

    @GetMapping ("update/{id}")
    public String editComment (Model model, @PathVariable Integer id) {
        model.addAttribute(ENTRIES_TEMPLATE_ID, this.guestBookService.findAllEntries());
        model.addAttribute(GUESTBOOK_FORM_HEADER_ID, "Please Change the Data");
        model.addAttribute(NEW_PAGE_TEMPLATE_ID, this.guestBookService.findOne(id));

        return GUESTBOOK_TEMPLATE;
    }

    @PostMapping ("update/{id}")
    public String saveComment (Model model, @PathVariable Integer id, @Valid @ModelAttribute (NEW_PAGE_TEMPLATE_ID) GuestBookEntry newEntry, BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            GuestBookEntry current = this.guestBookService.findOne(id);

            current.setUser(newEntry.getUser());
            current.setComment(newEntry.getComment());
            current.setPercent(newEntry.getPercent());
            current.setTime(newEntry.getTime());

            this.guestBookService.save(current);

            return HOMEPAGE_REDIRECT;
        } else {
            model.addAttribute(GUESTBOOK_FORM_HEADER_ID, "Please Correct The Data");
            model.addAttribute(ENTRIES_TEMPLATE_ID, this.guestBookService.findAllEntries());

            return GUESTBOOK_TEMPLATE;
        }
    }
}