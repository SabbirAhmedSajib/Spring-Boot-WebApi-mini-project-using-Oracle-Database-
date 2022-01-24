package com.example.DrawerRelease.Controller;


import com.example.DrawerRelease.DTO.LSDRWRRELDto;
import com.example.DrawerRelease.Service.LSDRWRRELService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/posts")
public class LSDRWRRELController {

    private LSDRWRRELService lsdrwrrelService;

    public LSDRWRRELController(LSDRWRRELService lsdrwrrelService) {
        this.lsdrwrrelService = lsdrwrrelService;
    }

    @GetMapping("/getRelease")
    public List<LSDRWRRELDto> GetAllRelease(){
        return lsdrwrrelService.GetAllLSDRWRREL();
    }


    @GetMapping("/{RELID}")
    public ResponseEntity<LSDRWRRELDto> getLSDRWRRELById(@PathVariable(name = "RELID") long RELID){
        return ResponseEntity.ok(lsdrwrrelService.getByRelId(RELID));
    }

    @PostMapping("/post")
    public ResponseEntity<LSDRWRRELDto> createPost(@RequestBody LSDRWRRELDto lsdrwrrelDto){
        return new ResponseEntity<>(lsdrwrrelService.createLSDRWRREL(lsdrwrrelDto), HttpStatus.CREATED);

    }

    @PutMapping("/{RELID}")
    public ResponseEntity<LSDRWRRELDto> updateRelease(@RequestBody LSDRWRRELDto lsdrwrrelDto,@PathVariable(name = "RELID") long RELID){
        LSDRWRRELDto postResponse = lsdrwrrelService.UpdateRelease(lsdrwrrelDto,RELID);
        return new ResponseEntity<>(postResponse,HttpStatus.OK);
    }


    @GetMapping("/getLocker")
    public List<LSDRWRRELDto> GetAllLockerInfo(){
        return lsdrwrrelService.getLckr();
    }


    @GetMapping("/get")
    public List<LSDRWRRELDto> GetLockerInfo(){
        return lsdrwrrelService.GetAllL();
    }



}
