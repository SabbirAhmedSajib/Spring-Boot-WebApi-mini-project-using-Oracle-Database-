package com.example.DrawerRelease.Service;

import com.example.DrawerRelease.DTO.CustomerReleaseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerReleaseService {

    List<CustomerReleaseDto> GetAllRelease();

    CustomerReleaseDto getBySomeColumn(long lckrid);
}
