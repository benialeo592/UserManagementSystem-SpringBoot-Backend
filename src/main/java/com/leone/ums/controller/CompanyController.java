package com.leone.ums.controller;

import com.leone.ums.entity.Company;
import com.leone.ums.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/companies")
public class CompanyController {

    private CompanyService companyService;


    @GetMapping()
    public ResponseEntity<List<Company>> all(){
        return ResponseEntity.ok().body(this.companyService.getAllCompanies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(this.companyService.getCompanyById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Company> create(@RequestBody Company company){
        return ResponseEntity.ok().body(this.companyService.saveCompany(company));
    }


}
