package com.gestion.springjwt.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.springjwt.models.CATClass;
import com.gestion.springjwt.models.ProductClass;


import com.gestion.springjwt.payload.models.ProductClassModel;


import com.gestion.springjwt.payload.response.MessageResponse;
import com.gestion.springjwt.repository.CATRepo;
import com.gestion.springjwt.repository.LVRepo;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/products")
public class ProductController {
    


  private final LVRepo repository;
  private final CATRepo repositoryCat;

  
  ProductController(LVRepo repository, CATRepo repositoryCat) {
    this.repository = repository;
    this.repositoryCat = repositoryCat;


  }

  @GetMapping("/all")
  public ResponseEntity<?> all() {
		
	List<ProductClass> products = repository.findAll();
	return ResponseEntity.ok(products);
 
  }

  @PostMapping("/save")

  public ResponseEntity<?> create(@Valid @RequestBody ProductClassModel p) {
	 ProductClass newP = new ProductClass();
	System.out.println(p.toString());

	CATClass category = (CATClass) repositoryCat.findById(p.getCategory())
    		.orElseThrow(() -> new IllegalArgumentException("not found"));
	newP.setCategory(category);
    newP.setLibelle(p.getLibelle());
    newP.setPrix(p.getPrix());
    newP.setQuantite(p.getQuantite());
    newP.setSlug(p.getSlug());
    newP.setDescription(p.getDescription());

    
    
    repository.save(newP);
    return ResponseEntity.ok(new MessageResponse("Start up registered successfully!"));
    
  }

  // Single item

  @GetMapping("/one/{id}")
  public ResponseEntity<?> one(@Valid @PathVariable Long id) {

    ProductClass lv = (ProductClass) repository.findById(1L)                                      
                                        .orElseThrow(() -> new IllegalArgumentException("not found"));
    return ResponseEntity.ok(lv);
												 
  }

	/*
	 * @PutMapping("/update/{id}")
	 * 
	 * @PreAuthorize("hasRole('ADMIN')") public ResponseEntity<?>
	 * update(@RequestBody LVClassModel newLV , @PathVariable Long id) {
	
	 * return ResponseEntity.ok(new
	 * MessageResponse("Liste de Valeurs updated successfully!"));
	 * 
	 * }
	 */

  @GetMapping("/search/{keyword}")
  public @Valid ResponseEntity<List<ProductClass>> search(@Valid @PathVariable String keyword) {
    List<ProductClass> products = repository.findByLibelleContaining(keyword);

	return ResponseEntity.ok(products);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> delete(@Valid @PathVariable Long id) {
    repository.deleteById(id);
    return ResponseEntity.ok(new MessageResponse("Liste de Valeurs deleted successfully!"));
  }


}
