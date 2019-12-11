package com.app.controller;

import com.app.model.Done;
import com.app.model.LimitsBite;
import com.app.repository.LimitsRep;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class LimitController {

    @Autowired
    LimitsRep limitsRep;

    //---------limitai
    @RequestMapping(value = "/viewlimitai", method = RequestMethod.GET)
    public String limitaiView(Model model, HttpServletRequest request) throws IOException, InvalidFormatException {
        model.addAttribute("limit", limitsRep.findAll());

        return "limitaiview";
    }

    @RequestMapping(value = "/limitaiview/{id}/update", method = RequestMethod.GET)
    public String limitaiView(@PathVariable("id") Long id, Model model){
        model.addAttribute("limitaiForm",limitsRep.findById(id));

        return "limitai";
    }

    @RequestMapping(value = "/limitai", method = RequestMethod.POST)
    public String limitaiView(@ModelAttribute("limitaiForm") LimitsBite bitelimits){

        limitsRep.save(bitelimits);

        return "redirect:/viewlimitai";
    }

    @RequestMapping(value={"/addlimitai"},method = RequestMethod.GET)
    public String addLimitai(Model model){
        model.addAttribute("addLimitaiForm", new LimitsBite());

        return "addlimitai";
    }

    @RequestMapping(value = "/addlimitai", method = RequestMethod.POST)
    public  String addLimitai(@ModelAttribute("addLimitaiForm") LimitsBite lim){
        limitsRep.save(lim);

        return "redirect:/viewlimitai";
    }

    //-----delete Bite Client-----
    @RequestMapping(value = "limitaiview/{id}/delete", method = RequestMethod.GET)
    public String deleteLimitai(@PathVariable("id") Long id) {
        limitsRep.delete(limitsRep.getOne(id));
        return "redirect:/viewlimitai";
    }
}
