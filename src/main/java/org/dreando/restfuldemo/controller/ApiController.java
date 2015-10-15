package org.dreando.restfuldemo.controller;

import org.dreando.restfuldemo.data.DataProvider;
import org.dreando.restfuldemo.resource.Company;
import org.dreando.restfuldemo.resource.Department;
import org.dreando.restfuldemo.resource.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 * Created by Mateusz Koza on 13.10.15.
 * <p>
 * A controller that exposes REST API. @RestController in comparison to normal @Controller adds on the class level an
 * additional annotation @ResponseBody which tells that this controller does not return view template.
 * <p>
 * Example calls: localhost:8080/api/company/workers?companyName=Google
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private DataProvider dataProvider;

    @RequestMapping("company/workers")
    public List<Worker> getCompanyWorkers(@RequestParam String companyName) {
        return dataProvider.getCompanyWorkers(companyName);
    }

    @RequestMapping("company/departments")
    public List<Department> getCompanyDepartments(@RequestParam String companyName) {
        return dataProvider.getCompanyDepartments(companyName);
    }

    @RequestMapping("company/cto")
    public Worker getCompanyCto(@RequestParam String companyName) {
        return dataProvider.getCompanyCto(companyName);
    }

    @RequestMapping("company/ceo")
    public Worker getCompanyCeo(@RequestParam String companyName) {
        return dataProvider.getCompanyCeo(companyName);
    }

    @RequestMapping("company")
    public Company getCompanyByName(@RequestParam String companyName) {
        return dataProvider.getCompanyByName(companyName);
    }

    @RequestMapping("companies")
    public Collection<Company> getCompanies() {
        return dataProvider.getCompanies();
    }
}
