package com.certidevs.controller;

import com.certidevs.model.Artist;
import com.certidevs.model.RecordCompany;
import com.certidevs.repository.RecordCompanyRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@Slf4j
public class RecordCompanyController {
    private RecordCompanyRepository recordCompanyRepository;

    @GetMapping("recordCompanies")
    public List<RecordCompany> findAll(){
        log.info(this.getClass().getName() + " - findAll");
        return recordCompanyRepository.findAll();
    }
    @GetMapping("/{id}")
    public RecordCompany findById(@PathVariable Long id) {
        log.info(this.getClass().getName() + " - findById " + id);
        return recordCompanyRepository.findById(id).orElseThrow();
    }
    @PostMapping()
    public RecordCompany saveRecordCompany(@RequestBody RecordCompany recordCompany) {
        log.info(this.getClass().getName() + " - saveRecordCompany");
        return recordCompanyRepository.save(recordCompany);
    }
    @PutMapping("/{id}")
    public RecordCompany updateRecordCompany(@RequestBody RecordCompany recordCompany, @PathVariable Long id) {
        log.info(this.getClass().getName() + " - updateRecordCompany " + id);
        if (this.recordCompanyRepository.existsById(id))
            return recordCompanyRepository.save(recordCompany);
        else
            throw new NoSuchElementException();
    }
    @DeleteMapping("/{id}")
    public void deleteRecordCompany(@PathVariable Long id) {
        log.info(this.getClass().getName() + " - deleteRecordCompany "+ id);
        recordCompanyRepository.deleteById(id);
    }
    @DeleteMapping()
    public void deleteAll() {
        log.info(this.getClass().getName() + " - deleteAll");
        recordCompanyRepository.deleteAll();
    }
}
