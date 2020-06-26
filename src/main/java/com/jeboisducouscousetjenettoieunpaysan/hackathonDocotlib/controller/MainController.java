package com.jeboisducouscousetjenettoieunpaysan.hackathonDocotlib.controller;

import com.jeboisducouscousetjenettoieunpaysan.hackathonDocotlib.entity.Drug;
import com.jeboisducouscousetjenettoieunpaysan.hackathonDocotlib.repository.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private DrugRepository drugRepository;

    @GetMapping("/")
    public String getIndex() { return "index"; }

    @GetMapping("/pill-box-instructions")
    public String getPillboxInstructions(Model model, @RequestParam (defaultValue = "0") String count) {

        List<Drug> drugList = drugRepository.findAll();
        if (Integer.parseInt(count) > drugList.size() - 1) {
            return "pill-box-instructions-finish";
        }
        model.addAttribute("drug", drugList.get(Integer.parseInt(count)));
        model.addAttribute("count", count);
        model.addAttribute("number", Integer.parseInt(count) + 1);
        return "pill-box-instructions";
    }

    @PostMapping("/pill-box-instructions/increment")
    public String incrementPillboxInstructions(Model model, @RequestParam String count) {

        int newCount = Integer.parseInt(count) + 1;
        model.addAttribute("count", String.valueOf(newCount));
        return "redirect:/pill-box-instructions?count=" + newCount;
    }

    @PostMapping("/pill-box-instructions/decrement")
    public String decrementPillboxInstructions(Model model, @RequestParam String count) {

        int newCount = Integer.parseInt(count);
        if (Integer.parseInt(count) > 0) {
            newCount -= 1;
        }
        model.addAttribute("count", String.valueOf(newCount));
        return "redirect:/pill-box-instructions?count=" + newCount;
    }

    @GetMapping("/pill-box")
    public String getPillBox() { return "pill-box"; }


    @GetMapping("/pill-box-details")
    public String getDrugs(Model out) {

        out.addAttribute("drugs", drugRepository.findAllMorningDrugs());
        out.addAttribute("drugsMidday", drugRepository.findAllMiddayDrugs());
        out.addAttribute("drugsNight", drugRepository.findAllNightDrugs());
        out.addAttribute("drugsIfNecessary", drugRepository.findAllIfNecessaryDrugs());

        return "pill-box-details";
    }
}
