package com.joseph.guestbook.Controller;

import com.joseph.guestbook.domain.GuestBookEntry;
import com.joseph.guestbook.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GuestBookController {

    @Autowired
    private GuestBookService guestBookService;

    @GetMapping ("/comment")
    public List <GuestBookEntry> testMapping () {
        return guestBookService.findAllEntries ();
    }

}
