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


import com.gestion.springjwt.models.CommandClass;
import com.gestion.springjwt.payload.models.StrucModel;
import com.gestion.springjwt.payload.response.MessageResponse;
import com.gestion.springjwt.repository.StructInter;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/structure-appui")
public class StrucController {
	

	  private final StructInter repository;

	  
	  StrucController(StructInter repository) {
	    this.repository = repository;

	  }

	  @GetMapping("/all")
	  @PreAuthorize("hasRole('ADMIN')")
	  public ResponseEntity<?> all() {
			
			  List<CommandClass> allStruct = repository.findAll();
			  return ResponseEntity.ok(allStruct);
		  
//		  return ResponseEntity.ok(new LVClassModel());	 
		 
	  }

	  @PostMapping("/save")
	  @PreAuthorize("hasRole('ADMIN')")
	  public ResponseEntity<?> create(@Valid @RequestBody StrucModel lv) {
		CommandClass newStruct = new CommandClass();
		System.out.println(lv.toString());
		newStruct.setAddresse(lv.getAddresse());
		newStruct.setDescription(lv.getDescription());
		newStruct.setNom(lv.getNom());

		newStruct.setNumTel(lv.getNumTel());
	    
	    repository.save(newStruct);
	    return ResponseEntity.ok(new MessageResponse("Structure d'appui registered successfully!"));
	    
	  }

	  // Single item

	 /* @GetMapping("/one")
	  @PreAuthorize("hasRole('ADMIN')")
	  public ResponseEntity<?> one(@Valid @RequestBody Long id) {

	    LVClass lv = (LVClass) repository.findById(id)                                      
	                                        .orElseThrow(() -> new IllegalArgumentException("not found"));
	    return ResponseEntity.ok(lv);
													 
	  }*/

		/*
		 * @PutMapping("/update/{id}")
		 * 
		 * @PreAuthorize("hasRole('ADMIN')") public ResponseEntity<?>
		 * update(@RequestBody LVClassModel newLV , @PathVariable Long id) {
		 * 
		 * LVClass RD = (LVClass) repository.findById(id) .orElseThrow(() -> new
		 * IllegalArgumentException("not found")); System.out.println(newLV);
		 * System.out.println(new LVClassModel()); RDClass rd =
		 * repo.findById(newLV.getRdId()) .orElseThrow(() -> new
		 * IllegalArgumentException("not found"));
		 * 
		 * RD.setLVLibelle(newLV.getlVLibelle());
		 * RD.setLVRequeteSql(newLV.getlVRequeteSql());
		 * RD.setLVColonneValeur(newLV.getLVColonneValeur());
		 * RD.setLVColonneId(newLV.getLVColonneId()); RD.setRD(rd);
		 * 
		 * 
		 * 
		 * repository.save(RD);
		 * 
		 * return ResponseEntity.ok(new
		 * MessageResponse("Liste de Valeurs updated successfully!"));
		 * 
		 * }
		 */

	  @DeleteMapping("/delete/{id}")
	  @PreAuthorize("hasRole('ADMIN')")
	  public ResponseEntity<?> delete(@Valid @PathVariable Long id) {
	    repository.deleteById(id);
	    return ResponseEntity.ok(new MessageResponse("Liste de Valeurs deleted successfully!"));
	  }


	

}
