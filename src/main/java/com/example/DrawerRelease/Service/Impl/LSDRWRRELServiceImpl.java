package com.example.DrawerRelease.Service.Impl;

import com.example.DrawerRelease.DTO.LSDRWRRELDto;
import com.example.DrawerRelease.Entity.CustomerReleaseEntity;
import com.example.DrawerRelease.Entity.LSDRWRRELEntity;
import com.example.DrawerRelease.Exception.ResourceNotFoundException;
import com.example.DrawerRelease.Repository.LSDRWRRELRepository;
import com.example.DrawerRelease.Service.LSDRWRRELService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LSDRWRRELServiceImpl implements LSDRWRRELService {


    private LSDRWRRELRepository lsdrwrrelRepository;

    public LSDRWRRELServiceImpl(LSDRWRRELRepository lsdrwrrelRepository) {
        this.lsdrwrrelRepository = lsdrwrrelRepository;
    }

    @Override
    public List<LSDRWRRELDto> GetAllLSDRWRREL() {
        List<LSDRWRRELEntity> lsdrwrrelEntities= lsdrwrrelRepository.findAll();
        return lsdrwrrelEntities.stream().map
                (lsdrwrrelEntity -> mapToDTO(lsdrwrrelEntity)).collect(Collectors.toList());
    }

    @Override
    public LSDRWRRELDto getByRelId(long RELID) {
        LSDRWRRELEntity lsdrwrrelEntity= lsdrwrrelRepository.findById(RELID).orElseThrow(()->new ResourceNotFoundException("LSDRWRRELEntity","RELID",RELID));
        return mapToDTO(lsdrwrrelEntity);
    }

    @Override
    public List<LSDRWRRELDto> getLckr() {

        List<LSDRWRRELEntity> lsdrwrrelEntities= lsdrwrrelRepository.getLocker();
        return lsdrwrrelEntities.stream().map
                (lsdrwrrelEntity -> allLocker(lsdrwrrelEntity)).collect(Collectors.toList());
    }



    @Override
    public LSDRWRRELDto UpdateRelease(LSDRWRRELDto lsdrwrrelDto, long RELID) {
        LSDRWRRELEntity lsdrwrrelEntity = lsdrwrrelRepository.findById(RELID).orElseThrow(()-> new ResourceNotFoundException("LSDRWRRELEntity","RELID",RELID));
        lsdrwrrelEntity.setOPRBRANCD(lsdrwrrelDto.getOPRBRANCD());
        lsdrwrrelEntity.setCUSCOD(lsdrwrrelDto.getCUSCOD());
        lsdrwrrelEntity.setBRANCD(lsdrwrrelDto.getBRANCD());
        lsdrwrrelEntity.setACTYPE(lsdrwrrelDto.getACTYPE());
        lsdrwrrelEntity.setACTNUM(lsdrwrrelDto.getACTNUM());
        lsdrwrrelEntity.setLCKRID(lsdrwrrelDto.getLCKRID());
        lsdrwrrelEntity.setDRWRID(lsdrwrrelDto.getDRWRID());
        lsdrwrrelEntity.setRELDATE(lsdrwrrelDto.getRELDATE());
        lsdrwrrelEntity.setPAYSTAT(lsdrwrrelDto.getPAYSTAT());
        lsdrwrrelEntity.setREMARKS(lsdrwrrelDto.getREMARKS());
        lsdrwrrelEntity.setOPRSTAMP(lsdrwrrelDto.getOPRSTAMP());
        lsdrwrrelEntity.setOPRTIMSTAMP(lsdrwrrelDto.getOPRTIMSTAMP());
        lsdrwrrelEntity.setUPDATE_BY(lsdrwrrelDto.getUPDATE_BY());
        lsdrwrrelEntity.setUPDATE_DATE(lsdrwrrelDto.getUPDATE_DATE());
        lsdrwrrelEntity.setAPPFLG(lsdrwrrelDto.getAPPFLG());
        lsdrwrrelEntity.setAPPSTAMP(lsdrwrrelDto.getAPPSTAMP());
        lsdrwrrelEntity.setAPPTIMSTAMP(lsdrwrrelDto.getAPPTIMSTAMP());


        LSDRWRRELEntity updateRelease= lsdrwrrelRepository.save(lsdrwrrelEntity);
        return mapToDTO(updateRelease);
    }


    @Override
    public LSDRWRRELDto createLSDRWRREL(LSDRWRRELDto lsdrwrrelDto) {
        LSDRWRRELEntity lsdrwrrelEntity= mapToEntity(lsdrwrrelDto);
        LSDRWRRELEntity newlsdrwrrel=lsdrwrrelRepository.save(lsdrwrrelEntity);

        LSDRWRRELDto lsdrwrrelResponse = mapToDTO(newlsdrwrrel);
        return lsdrwrrelResponse;

    }

    @Override
    public List<LSDRWRRELDto> GetAllL() {
        List<LSDRWRRELEntity> lsdrwrrelEntities= lsdrwrrelRepository.findAll();
        return lsdrwrrelEntities.stream().map
                (lsdrwrrelEntity -> allLocker(lsdrwrrelEntity)).collect(Collectors.toList());
    }

    //convert Entity into Dto
    private LSDRWRRELDto mapToDTO(LSDRWRRELEntity lsdrwrrelEntity){
        LSDRWRRELDto lsdrwrrelDto=new LSDRWRRELDto();

        lsdrwrrelDto.setRELID(lsdrwrrelEntity.getRELID());
        lsdrwrrelDto.setOPRBRANCD(lsdrwrrelEntity.getOPRBRANCD());
        lsdrwrrelDto.setCUSCOD(lsdrwrrelEntity.getCUSCOD());
        lsdrwrrelDto.setBRANCD(lsdrwrrelEntity.getBRANCD());
        lsdrwrrelDto.setACTYPE(lsdrwrrelEntity.getACTYPE());
        lsdrwrrelDto.setACTNUM(lsdrwrrelEntity.getACTNUM());
        lsdrwrrelDto.setLCKRID(lsdrwrrelEntity.getLCKRID());
        lsdrwrrelDto.setDRWRID(lsdrwrrelEntity.getDRWRID());
        lsdrwrrelDto.setRELDATE(lsdrwrrelEntity.getRELDATE());
        lsdrwrrelDto.setPAYSTAT(lsdrwrrelEntity.getPAYSTAT());
        lsdrwrrelDto.setREMARKS(lsdrwrrelEntity.getREMARKS());
        lsdrwrrelDto.setOPRSTAMP(lsdrwrrelEntity.getOPRSTAMP());
        lsdrwrrelDto.setOPRTIMSTAMP(lsdrwrrelEntity.getOPRTIMSTAMP());
        lsdrwrrelDto.setUPDATE_BY(lsdrwrrelEntity.getUPDATE_BY());
        lsdrwrrelDto.setUPDATE_DATE(lsdrwrrelEntity.getUPDATE_DATE());
        lsdrwrrelDto.setAPPFLG(lsdrwrrelEntity.getAPPFLG());
        lsdrwrrelDto.setAPPSTAMP(lsdrwrrelEntity.getAPPSTAMP());
        lsdrwrrelDto.setAPPTIMSTAMP(lsdrwrrelEntity.getAPPTIMSTAMP());

        return lsdrwrrelDto;
    }

    //convert DTO into Entity
    private LSDRWRRELEntity mapToEntity(LSDRWRRELDto lsdrwrrelDto){

        LSDRWRRELEntity lsdrwrrelEntity=new LSDRWRRELEntity();

        lsdrwrrelEntity.setOPRBRANCD(lsdrwrrelDto.getOPRBRANCD());
        lsdrwrrelEntity.setCUSCOD(lsdrwrrelDto.getCUSCOD());
        lsdrwrrelEntity.setBRANCD(lsdrwrrelDto.getBRANCD());
        lsdrwrrelEntity.setACTYPE(lsdrwrrelDto.getACTYPE());
        lsdrwrrelEntity.setACTNUM(lsdrwrrelDto.getACTNUM());
        lsdrwrrelEntity.setLCKRID(lsdrwrrelDto.getLCKRID());
        lsdrwrrelEntity.setDRWRID(lsdrwrrelDto.getDRWRID());
        lsdrwrrelEntity.setRELDATE(lsdrwrrelDto.getRELDATE());
        lsdrwrrelEntity.setPAYSTAT(lsdrwrrelDto.getPAYSTAT());
        lsdrwrrelEntity.setREMARKS(lsdrwrrelDto.getREMARKS());
        lsdrwrrelEntity.setOPRSTAMP(lsdrwrrelDto.getOPRSTAMP());
        lsdrwrrelEntity.setOPRTIMSTAMP(lsdrwrrelDto.getOPRTIMSTAMP());
        lsdrwrrelEntity.setUPDATE_BY(lsdrwrrelDto.getUPDATE_BY());
        lsdrwrrelEntity.setUPDATE_DATE(lsdrwrrelDto.getUPDATE_DATE());
        lsdrwrrelEntity.setAPPFLG(lsdrwrrelDto.getAPPFLG());
        lsdrwrrelEntity.setAPPSTAMP(lsdrwrrelDto.getAPPSTAMP());
        lsdrwrrelEntity.setAPPTIMSTAMP(lsdrwrrelDto.getAPPTIMSTAMP());

        return lsdrwrrelEntity;
    }


    private LSDRWRRELDto allLocker(LSDRWRRELEntity lsdrwrrelEntity){
        LSDRWRRELDto lsdrwrrelDto=new LSDRWRRELDto();

        lsdrwrrelDto.setLCKRID(lsdrwrrelEntity.getLCKRID());
        lsdrwrrelDto.setDRWRID(lsdrwrrelEntity.getDRWRID());
        lsdrwrrelDto.setRELDATE(lsdrwrrelEntity.getRELDATE());
        lsdrwrrelDto.setPAYSTAT(lsdrwrrelEntity.getPAYSTAT());
        lsdrwrrelDto.setREMARKS(lsdrwrrelEntity.getREMARKS());
        lsdrwrrelDto.setOPRSTAMP(lsdrwrrelEntity.getOPRSTAMP());
        lsdrwrrelDto.setOPRTIMSTAMP(lsdrwrrelEntity.getOPRTIMSTAMP());
        lsdrwrrelDto.setUPDATE_BY(lsdrwrrelEntity.getUPDATE_BY());
        lsdrwrrelDto.setUPDATE_DATE(lsdrwrrelEntity.getUPDATE_DATE());
        lsdrwrrelDto.setAPPFLG(lsdrwrrelEntity.getAPPFLG());
        lsdrwrrelDto.setAPPSTAMP(lsdrwrrelEntity.getAPPSTAMP());
        lsdrwrrelDto.setAPPTIMSTAMP(lsdrwrrelEntity.getAPPTIMSTAMP());

        return lsdrwrrelDto;
    }
}
