package com.joseph.beer.Controller;

import com.joseph.beer.domain.BeerEntry;
import com.joseph.beer.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class BeerWebController {

    @Autowired
    private BeerService beerService;

    private static final String BEER_TEMPLATE = "beer";

    private static final String ENTRIES_TEMPLATE_ID = "entries";

    private static final String HOMEPAGE_REDIRECT = "redirect:/";

    private static final String NEW_PAGE_TEMPLATE_ID = "newEntry";

    private static final String BEER_FORM_HEADER_ID = "formHeader";

    @GetMapping("/")
    public String displayBeer (Model model) {

        model.addAttribute(BEER_FORM_HEADER_ID, "Add A New Beer");
        model.addAttribute(ENTRIES_TEMPLATE_ID, this.beerService.findAllEntries());
        model.addAttribute("newEntry", new BeerEntry());

        return BEER_TEMPLATE;
    }

    @GetMapping ("/delete/{id}")
    public String deleteBeer (@PathVariable Integer id) {
        this.beerService.deleteBeerEntryById (id);

        return HOMEPAGE_REDIRECT;
    }

    @PostMapping ("/")
    public String addBeer (Model model, @Valid @ModelAttribute (NEW_PAGE_TEMPLATE_ID) BeerEntry newEntry, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            this.beerService.save(newEntry);
            return HOMEPAGE_REDIRECT;
        } else {
            model.addAttribute(BEER_FORM_HEADER_ID, "Please Correct The Data");
            model.addAttribute (ENTRIES_TEMPLATE_ID, this.beerService.findAllEntries());
            return BEER_TEMPLATE;
        }
    }

    @GetMapping ("update/{id}")
    public String editBeer (Model model, @PathVariable Integer id) {
        model.addAttribute(ENTRIES_TEMPLATE_ID, this.beerService.findAllEntries());
        model.addAttribute(BEER_FORM_HEADER_ID, "Please Change the Data");
        model.addAttribute(NEW_PAGE_TEMPLATE_ID, this.beerService.findOne(id));

        return BEER_TEMPLATE;
    }

    @PostMapping ("update/{id}")
    public String saveBeer (Model model, @PathVariable Integer id, @Valid @ModelAttribute (NEW_PAGE_TEMPLATE_ID) BeerEntry newEntry, BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            BeerEntry current = this.beerService.findOne(id);

            current.setBeer(newEntry.getBeer());
            current.setComment(newEntry.getComment());
            current.setCountry(newEntry.getCountry());
            current.setPercent(newEntry.getPercent());
            current.setTime(newEntry.getTime());

            this.beerService.save(current);

            return HOMEPAGE_REDIRECT;
        } else {
            model.addAttribute(BEER_FORM_HEADER_ID, "Please Correct The Data");
            model.addAttribute(ENTRIES_TEMPLATE_ID, this.beerService.findAllEntries());

            return BEER_TEMPLATE;
        }
    }



}