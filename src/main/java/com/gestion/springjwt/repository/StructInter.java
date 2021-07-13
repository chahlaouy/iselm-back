package com.gestion.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.gestion.springjwt.models.CommandClass;

public interface StructInter extends JpaRepository<CommandClass, Long>{

}
