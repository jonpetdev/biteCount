package com.app.controller;


import com.app.model.BusinessUnit;
import com.app.model.Done;
import com.app.model.GetFromPageBite;
import com.app.repository.BusinessUnitRep;
import com.app.repository.CommunicationPlanRep;
import com.app.repository.DoneRep;
import com.app.service.DoneFileBaseService;
import com.app.service.DoneService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Controller
public class InfoController {



    @Autowired
    DoneFileBaseService doneFileBaseService;

    @Autowired
    DoneService doneService;

    @Autowired
    DoneRep doneRep;

    @Autowired
    BusinessUnitRep businessUnitRep;

    @Autowired
    CommunicationPlanRep communicationPlanRep;

    @RequestMapping(value={"/"}, method= RequestMethod.GET)
    public String first (Model model){

        return "firstpage";
    }

    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
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

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String form(@ModelAttribute("getFromPage") GetFromPageBite bite, RedirectAttributes redirectAttrs, HttpServletRequest request) throws IOException {
        doneFileBaseService.multipartFile(request, bite.getFile());
        redirectAttrs.addFlashAttribute("bite", bite);

        return "redirect:/home";
    }

    @RequestMapping(value = {"/viewnaudotojai"}, method = RequestMethod.GET)
    public String naudotojai(Model model, HttpServletRequest request) throws IOException, InvalidFormatException {
        model.addAttribute("clients", doneService.getinam());
        model.addAttribute("businessList", businessUnitRep.findAll());
        model.addAttribute("communicationList", communicationPlanRep.findAll());

        return "viewcardusers";
    }
//-----add Bite Client-----------
    @RequestMapping(value={"/addbitecarduser"},method = RequestMethod.GET)
    public String addBiteClient(Model model){
        model.addAttribute("addBiteForm", new Done());
        model.addAttribute("businessList", businessUnitRep.findAll());
        model.addAttribute("communicationList", communicationPlanRep.findAll());
        return "addbitecarduser";
    }

    @RequestMapping(value = "/addbitecarduser", method = RequestMethod.POST)
    public  String addBiteClient(@ModelAttribute("addBiteForm") Done done){
        doneRep.save(done);

        return "redirect:/viewnaudotojai";
    }

    //-----delete Bite Client-----
    @RequestMapping(value = "viewcardusers/{id}/delete", method = RequestMethod.GET)
    public String deleteBite(@PathVariable("id") Long id) {
        doneRep.delete(doneRep.getOne(id));
        return "redirect:/viewnaudotojai";
    }

    //-----update Bite Client
    @RequestMapping(value = "viewcardusers/{id}/update", method = RequestMethod.GET)
    public String updateBite(@PathVariable("id") Long id, Model model){
        model.addAttribute("editBiteForm",doneRep.findById(id));
        model.addAttribute("businessList", businessUnitRep.findAll());
        model.addAttribute("communicationList", communicationPlanRep.findAll());

        return "editbitecarduser";
    }

    @RequestMapping(value = "/editbitecarduser", method = RequestMethod.POST)
    public String updateBite(@ModelAttribute("editBiteForm") Done done){
        doneRep.save(done);

        return "redirect:/viewnaudotojai";
    }


}
