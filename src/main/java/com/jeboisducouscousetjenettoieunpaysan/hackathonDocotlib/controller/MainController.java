package com.jeboisducouscousetjenettoieunpaysan.hackathonDocotlib.controller;

import com.jeboisducouscousetjenettoieunpaysan.hackathonDocotlib.entity.Composition;
import com.jeboisducouscousetjenettoieunpaysan.hackathonDocotlib.entity.Drug;
import com.jeboisducouscousetjenettoieunpaysan.hackathonDocotlib.repository.CompositionRepository;
import com.jeboisducouscousetjenettoieunpaysan.hackathonDocotlib.repository.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private DrugRepository drugRepository;

    @Autowired
    private CompositionRepository compositionRepository;

    @GetMapping("/")
    public String getIndex() { return "index"; }

    @GetMapping("/pill-box-instructions")
    public String getPillboxInstructions(Model model, @RequestParam (defaultValue = "1") String count) {

        count = Long.parseLong(count) < 1 ? "1" : count;
        Optional<Composition> optionalComposition = compositionRepository.findById(Long.parseLong(count));
        if (!optionalComposition.isPresent()) {
            return "pill-box-instructions-finish";
        }
        Composition composition = optionalComposition.get();
        model.addAttribute("composition", composition);
        model.addAttribute("count", count);
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
    public String getPillBox(Model model) {

        model.addAttribute("drugName", drugRepository.findAllDrugByIdOne());

        return "pill-box";
    }


    @GetMapping("/pill-box-details")
    public String getDrugs(Model out) {

        out.addAttribute("drugs", drugRepository.findAllMorningDrugs());
        out.addAttribute("drugsMidday", drugRepository.findAllMiddayDrugs());
        out.addAttribute("drugsNight", drugRepository.findAllNightDrugs());
        out.addAttribute("drugsIfNecessary", drugRepository.findAllIfNecessaryDrugs());

        return "pill-box-details";
    }
}
