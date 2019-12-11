package com.app.controller;


import com.app.model.Done;
import com.app.model.GetFromPageBite;
import com.app.model.LimitsBite;
import com.app.repository.*;
import com.app.service.DoneFileBaseService;
import com.app.service.DoneService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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

    @Autowired
    InfoClientBiteRep infoClientBiteRep;

    @Autowired
    GetFromPageBiteRep getFromPageBiteRep;

    @Autowired
    LimitsRep limitsRep;


    @RequestMapping(value={"/"}, method= RequestMethod.GET)
    public String first (Model model){

        return "firstpage";
    }

    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public String textRe(Model model, HttpServletRequest request){

        GetFromPageBite bite = (GetFromPageBite) model.asMap().get("bite");
        String noFile= (String) model.asMap().get("nera");
        model.addAttribute("nera", noFile);
        try {

            model.addAttribute("modelis",doneFileBaseService.paskirstymas(bite.getDate()));
            model.addAttribute("data", bite.getDate());
            model.addAttribute("tikrinam",doneFileBaseService.tikrinam(bite.getDate()));
            model.addAttribute("nuolaidos",doneFileBaseService.nuolaidos(bite.getDate()));
            model.addAttribute("ponuolaidos",doneFileBaseService.bendraPoNuolaidu(doneFileBaseService.paskirstymas(bite.getDate())));
        }catch (NullPointerException e){

        }
        model.addAttribute("getFromPage", new GetFromPageBite());
        return "home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String form(@ModelAttribute("getFromPage") GetFromPageBite bite, RedirectAttributes redirectAttrs, HttpServletRequest request) throws IOException, InvalidFormatException {
        if (bite.getFile().isEmpty()) {
            System.out.println("nera failo");
            bite.setFile(null);
            redirectAttrs.addFlashAttribute("nera", "*Pasirinkite failą");
            if (bite.getProcSMS() == null) {
                System.out.println("nera proc3");
            }
            if (bite.getProcSkambuciams() == null) {
                System.out.println("nera proc2");
            }
            if (bite.getProcSaskaita() == null) {
                System.out.println("nera proc1");
            }

        }else{
            if (bite.getProcSMS() == null) {
                System.out.println("nera proc3");
            }else
            if (bite.getProcSkambuciams() == null) {
                System.out.println("nera proc2");
            }else
            if (bite.getProcSaskaita() == null) {
                System.out.println("nera proc1");
            }else{
            getFromPageBiteRep.save(bite);
            doneFileBaseService.mainListas(request, bite);
            }
        }
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


    //----get file unit wide client
    @RequestMapping(value = "/home/{imone}/{data}/view",method = RequestMethod.GET)
    public String viewAllForUnit(@PathVariable("imone") String imone,@PathVariable("data") String data, HttpServletRequest request, Model model) throws IOException, InvalidFormatException {
        model.addAttribute("listas",infoClientBiteRep.findInfoClientBitesByDateAndImone(data, imone));
        model.addAttribute("limitas",limitsRep.findById(3l).get());

        return "viewinfoclient";
    }



}
