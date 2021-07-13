package com.gestion.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.gestion.springjwt.models.ProductClass;

public interface LVRepo extends JpaRepository<ProductClass, Long> {

    List<ProductClass> findByLibelleContaining(String libelle);

}
