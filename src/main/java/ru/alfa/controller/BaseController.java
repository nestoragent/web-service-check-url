package ru.alfa.controller;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.alfa.model.Link;

/**
 * Created by velichko-aa on 16.03.17.
 */
@Slf4j
@Controller
public class BaseController {

    private static final String VIEW_INDEX = "index";
    private static int counter = 0;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView welcome() {
        ModelAndView model = new ModelAndView();
        model.addObject("linkForCheck", new Link());
        log.debug("[welcome] counter : {}", counter);
        model.setViewName(VIEW_INDEX);
        return model;
    }

    @RequestMapping(value = "/{check}", method = RequestMethod.GET)
    public ModelAndView welcomeName(@ModelAttribute("linkForCheck") Link link) {
        ModelAndView model = new ModelAndView();

        System.out.println("get");
        System.out.println("link: " + link.getLink());
        model.addObject("status", checkLink(link.getLink()));
        log.debug("[welcomeName] counter : {}", counter);
        model.setViewName(VIEW_INDEX);
        return model;

    }

    private String checkLink(String link) {
        String result = "";
        try {
            Document mainPage = Jsoup.connect(link).timeout(120000)
                    .userAgent("Mozilla")
                    .get();
            if (mainPage.html().contains("html"))
                result = "correct";
            else
                result = "incorrect";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
