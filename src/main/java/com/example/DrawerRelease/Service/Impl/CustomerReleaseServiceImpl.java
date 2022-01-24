package com.example.DrawerRelease.Service.Impl;

import com.example.DrawerRelease.DTO.CustomerReleaseDto;
import com.example.DrawerRelease.Entity.CustomerReleaseEntity;
import com.example.DrawerRelease.Exception.ResourceNotFoundException;
import com.example.DrawerRelease.Repository.CustomerReleaseRepository;
import com.example.DrawerRelease.Service.CustomerReleaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerReleaseServiceImpl implements CustomerReleaseService {

    private CustomerReleaseRepository customerReleaseRepository;

    public CustomerReleaseServiceImpl(CustomerReleaseRepository customerReleaseRepository) {
        this.customerReleaseRepository = customerReleaseRepository;
    }

    @Override
    public List<CustomerReleaseDto> GetAllRelease() {
        List<CustomerReleaseEntity> customerReleaseEntities = customerReleaseRepository.findAll();
        return customerReleaseEntities.stream().map(customerReleases1Entity -> mapToDTO(customerReleases1Entity)).collect(Collectors.toList());
    }

    @Override
    public CustomerReleaseDto getBySomeColumn(long lckrid) {

        CustomerReleaseEntity customerReleaseEntity= customerReleaseRepository.findById(lckrid).orElseThrow(()->new ResourceNotFoundException("CustomerReleaseEntity","lckrid",lckrid));

        return mapToDTO(customerReleaseEntity);
    }



    //Convert Entity into DTO
    private CustomerReleaseDto mapToDTO(CustomerReleaseEntity customerReleaseEntity){
        CustomerReleaseDto customerReleaseDto= new CustomerReleaseDto();

        customerReleaseDto.setLckrid(customerReleaseEntity.getLckrid());
        customerReleaseDto.setDrwerid(customerReleaseEntity.getDrwerid());
        customerReleaseDto.setAcnumber(customerReleaseEntity.getAcnumber());
        customerReleaseDto.setActitle(customerReleaseEntity.getActitle());
        customerReleaseDto.setDeproduct(customerReleaseEntity.getDeproduct());
        customerReleaseDto.setFcvalue(customerReleaseEntity.getFcvalue());
        customerReleaseDto.setMvalue(customerReleaseEntity.getMvalue());
        customerReleaseDto.setCvalue(customerReleaseEntity.getCvalue());
        customerReleaseDto.setCtype(customerReleaseEntity.getCtype());
        customerReleaseDto.setCtypedes(customerReleaseEntity.getCtypedes());
        customerReleaseDto.setCustomername(customerReleaseEntity.getCustomername());
        customerReleaseDto.setAddress1(customerReleaseEntity.getAddress1());
        customerReleaseDto.setAddress2(customerReleaseEntity.getAddress2());
        customerReleaseDto.setHouse(customerReleaseEntity.getHouse());
        customerReleaseDto.setCityno(customerReleaseEntity.getCityno());
        customerReleaseDto.setPhoneno(customerReleaseEntity.getPhoneno());
        customerReleaseDto.setAllotime(customerReleaseEntity.getAllotime());
        customerReleaseDto.setExpiretime(customerReleaseEntity.getExpiretime());
        customerReleaseDto.setStatus(customerReleaseEntity.getStatus());

        return customerReleaseDto;
    }

    //Converted DTO to Entity
//    private CustomerRelease mapToEntity(CustomerReleaseDto customerReleaseDto){
//        CustomerRelease customerRelease=new CustomerRelease();
//
//        customerRelease.setDrwerid(customerReleaseDto.getDrwerid());
//        customerRelease.setAcnumber(customerReleaseDto.getAcnumber());
//        customerRelease.setActitle(customerReleaseDto.getActitle());
//        customerRelease.setDeproduct(customerReleaseDto.getDeproduct());
//        customerRelease.setFcvalue(customerReleaseDto.getFcvalue());
//        customerRelease.setMvalue(customerReleaseDto.getMvalue());
//        customerRelease.setCvalue(customerReleaseDto.getCvalue());
//        customerRelease.setCtype(customerReleaseDto.getCtype());
//        customerRelease.setCtypedes(customerReleaseDto.getCtypedes());
//        customerRelease.setCustomername(customerReleaseDto.getCustomername());
//        customerRelease.setAddress1(customerReleaseDto.getAddress1());
//        customerRelease.setAddress2(customerReleaseDto.getAddress2());
//        customerRelease.setHouse(customerReleaseDto.getHouse());
//        customerRelease.setCityno(customerReleaseDto.getCityno());
//        customerRelease.setPhoneno(customerReleaseDto.getPhoneno());
//        customerRelease.setAllotime(customerReleaseDto.getAllotime());
//        customerRelease.setExpiretime(customerReleaseDto.getExpiretime());
//        customerRelease.setStatus(customerReleaseDto.getStatus());
//
//        return customerRelease;
//    }

}
