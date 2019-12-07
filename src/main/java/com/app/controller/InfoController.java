package com.app.controller;


import com.app.model.GetFromPageBite;
import com.app.service.DoneFileBaseService;
import com.app.service.DoneService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Controller
public class InfoController {



    @Autowired
    DoneFileBaseService doneFileBaseService;

    @Autowired
    DoneService doneService;



    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String textRe(Model model, HttpServletRequest request) throws IOException, InvalidFormatException {
        GetFromPageBite bite = (GetFromPageBite) model.asMap().get("bite");
        try {
            model.addAttribute("vidurkis", doneFileBaseService.sumaPoNuolaidu(request, bite));
            model.addAttribute("tikrinam",doneFileBaseService.tikrinam(request, bite));
        }catch (NullPointerException e){

        }

        model.addAttribute("getFromPage", new GetFromPageBite());
        return "home";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String form(@ModelAttribute("getFromPage") GetFromPageBite bite, RedirectAttributes redirectAttrs, HttpServletRequest request) throws IOException {

        doneFileBaseService.multipartFile(request, bite.getFile());

        redirectAttrs.addFlashAttribute("bite", bite);

        return "redirect:/";
    }
}
