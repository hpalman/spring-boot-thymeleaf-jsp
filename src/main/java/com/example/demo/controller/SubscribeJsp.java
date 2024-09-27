package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.thymeleaf.examples.spring6.thvsjsp.business.entities.Subscription;
//import org.thymeleaf.examples.spring6.thvsjsp.business.entities.SubscriptionType;

import com.example.demo.examples.Subscription;
import com.example.demo.examples.SubscriptionType;


@Controller
public class SubscribeJsp {

    private static final Logger log = LoggerFactory.getLogger(SubscribeJsp.class);


    public SubscribeJsp() {
        super();
    }




    @ModelAttribute("allTypes")
    public SubscriptionType[] populateTypes() {
        return new SubscriptionType[] { SubscriptionType.ALL_EMAILS, SubscriptionType.DAILY_DIGEST };
    }


    @GetMapping({"/subscribejsp"})
    public String showSubscription(final Subscription subscription) {
        return "subscribejsp";
    }



    @GetMapping(value="/subscribejsp", params={"save"})
    public String subscribe(final Subscription subscription, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "subscribejsp";
        }
        log.info("JUST ADDED SUBSCRIPTION: " + subscription);
        model.clear();
        return "redirect:/subscribejsp";
    }
}
