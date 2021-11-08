package com.adl.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adl.main.model.TitleModel;

@Repository
public interface TitleRepository extends JpaRepository<TitleModel, Integer>{

}
