package com.example.DrawerRelease.Service;



import com.example.DrawerRelease.DTO.LSDRWRRELDto;

import java.util.List;

public interface LSDRWRRELService {

    List<LSDRWRRELDto> GetAllLSDRWRREL();

    LSDRWRRELDto getByRelId(long RELID);

    List<LSDRWRRELDto> getLckr();



    LSDRWRRELDto UpdateRelease(LSDRWRRELDto lsdrwrrelDto, long RELID);

    LSDRWRRELDto createLSDRWRREL (LSDRWRRELDto lsdrwrrelDto);


    List<LSDRWRRELDto> GetAllL();

}
