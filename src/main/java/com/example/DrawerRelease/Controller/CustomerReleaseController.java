package com.example.DrawerRelease.Controller;

import com.example.DrawerRelease.DTO.CustomerReleaseDto;
import com.example.DrawerRelease.Service.CustomerReleaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.spi.CurrencyNameProvider;

@RestController
@RequestMapping("/api")
public class CustomerReleaseController {

    private CustomerReleaseService customerReleaseService;

    public CustomerReleaseController(CustomerReleaseService customerReleaseService) {
        this.customerReleaseService = customerReleaseService;
    }

    @GetMapping("/get")
    public String getPost(){
        return "Connect Successfully";
    }


    @GetMapping("/getAll")
    public List<CustomerReleaseDto> GetAllRelease(){
        return customerReleaseService.GetAllRelease();
    }


    @GetMapping("/{lckrid}")
    public ResponseEntity<CustomerReleaseDto> getCustomerById(@PathVariable(name = "lckrid") long lckrid){
        return ResponseEntity.ok(customerReleaseService.getBySomeColumn(lckrid));
    }

}
