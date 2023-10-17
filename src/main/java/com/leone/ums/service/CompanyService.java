package com.leone.ums.service;

import com.leone.ums.entity.Company;
import com.leone.ums.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompanyService {

    private CompanyRepository companyRepo;

    public List<Company> getAllCompanies(){
        return this.companyRepo.findAll();
    }

    public Company getCompanyById(Long id){
        Optional<Company> foundCompany = this.companyRepo.findById(id);
        if(foundCompany.isEmpty()){
            throw new NoSuchElementException("Compagnia non trovata");
        }
        return foundCompany.get();
    }

}
