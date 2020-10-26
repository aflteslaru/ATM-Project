package com.atm.controllers;

import com.atm.actions.AtmOperations;
import com.atm.dto.BillsDTO;
import com.atm.entities.Atm;
import com.atm.services.AtmRepository;
import com.atm.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MainController {

    @Autowired
    private AtmRepository atmRepository;

    private AtmOperations atmOperations = new AtmOperations();

    @GetMapping("/resetDb")
    public ResponseEntity resetDb() {
        Iterable<Atm> atm = atmRepository.findAll();
        atm.forEach(bill -> bill.setCount(0));
        atmRepository.saveAll(atm);
        return new ResponseEntity<>(new ResponseMessage(ResponseMessage.SUCCESS, "Database values reseted to 0!"),
                HttpStatus.OK);
    }

    @PostMapping("/addBills")
    public ResponseEntity addBills(@RequestBody BillsDTO billsDTO) {
        List<Integer> list = atmOperations.getDTOasList(billsDTO);
        Iterable<Atm> atm = atmRepository.findAll();
        atm.forEach(bill -> bill.setCount(bill.getCount() + (list.get(bill.getId() - 1))));
        if (!atmOperations.validate(atm)) {
            return new ResponseEntity<>(new ResponseMessage(ResponseMessage.ERROR, "Bills limit excedeed"),
                    HttpStatus.OK);
        }
        atmRepository.saveAll(atm);
        return new ResponseEntity<>(new ResponseMessage(ResponseMessage.SUCCESS, "Money added in ATM"),
                HttpStatus.OK);
    }

    //    @RequestMapping(value = "withdraw", method = RequestMethod.GET)
    @GetMapping("/withdraw")
    public ResponseEntity withdrawMoney(@RequestParam Integer sum) {
        BillsDTO result = atmOperations.withdrawAlgorithm(sum, getAtmRepositoryDesc());
        if (result != null) {
            List<Integer> list = atmOperations.getDTOasList(result);
            Iterable<Atm> atm = atmRepository.findAll();
            atm.forEach(bill -> bill.setCount(bill.getCount() - (list.get(bill.getId() - 1))));
            atmRepository.saveAll(atm);
            return new ResponseEntity<>(new ResponseMessage(ResponseMessage.INFO, "The money was taken out! See the following JSON!", result),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ResponseMessage(ResponseMessage.ERROR, "ATM doesn't have enought money"),
                    HttpStatus.OK);
        }
    }

    public Iterable<Atm> getAtmRepositoryDesc() {
        return atmRepository.findAllByOrderByIdDesc();
    }
}
