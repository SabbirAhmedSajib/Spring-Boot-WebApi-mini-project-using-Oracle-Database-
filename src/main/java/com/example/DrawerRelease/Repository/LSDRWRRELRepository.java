package com.example.DrawerRelease.Repository;

import com.example.DrawerRelease.Entity.LSDRWRRELEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface LSDRWRRELRepository extends JpaRepository<LSDRWRRELEntity,Long> {

    @Query("select distinct(LCKRID) from LSDRWRRELEntity ")
    List<LSDRWRRELEntity> getLocker();



}
