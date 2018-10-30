package com.thymeleaf.course.controller;

import com.thymeleaf.course.domain.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /* TODO You need to implement endpoint here. */
    /* TODO Endpoint should be map by Get method. You need to retrieve data from service, and return it to the 'company.html'. */
    @GetMapping
    public String getCompanies(Model model) {
        model.addAttribute("companies", companyService.getAllCompanies());
        return "company";
    }

}
