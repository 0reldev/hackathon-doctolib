package com.jeboisducouscousetjenettoieunpaysan.hackathonDocotlib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String getIndex() { return "index"; }

    @GetMapping("/pill-box-instructions")
    public String getPillBoxInstructions() {

        return "pill-box-instructions";
    }
}
