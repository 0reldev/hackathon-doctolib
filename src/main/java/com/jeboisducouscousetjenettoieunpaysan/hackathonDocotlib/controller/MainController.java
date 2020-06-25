package com.jeboisducouscousetjenettoieunpaysan.hackathonDocotlib.controller;

import com.jeboisducouscousetjenettoieunpaysan.hackathonDocotlib.repository.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private DrugRepository drugRepository;

    @GetMapping("/")
    public String getIndex() { return "index"; }

    @GetMapping("/pill-box-instructions")
    public String getPillBoxInstructions() {

        return "pill-box-instructions";
    }

    @GetMapping("/pill-box")
    public String getPillBox() { return "pill-box"; }


    @GetMapping("/pill-box-details")
    public String getDrugs(Model out) {

        out.addAttribute("names", drugRepository.findAllMorningDrugsNames());
        out.addAttribute("drugs", drugRepository.findAllMorningDrugs());
        out.addAttribute("images", drugRepository.findAllMorningDrugsImages());

        out.addAttribute("namesNight", drugRepository.findAllNightDrugsNames());
        out.addAttribute("drugsNight", drugRepository.findAllNightDrugs());
        out.addAttribute("imagesNight", drugRepository.findAllNightDrugsImages());

        return "pill-box-details";
    }
}
