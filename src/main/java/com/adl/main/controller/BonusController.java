package com.adl.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adl.main.model.BonusModel;
import com.adl.main.model.JoiningModelWorker;
import com.adl.main.repository.BonusRepository;

@RestController
@RequestMapping("/bonus")
public class BonusController {

	@Autowired
	BonusRepository bonusRepo;

	@GetMapping("/")
	public List<BonusModel> getAll(){
		return bonusRepo.findAll();
	}
	
	@GetMapping("/top")
	public List<JoiningModelWorker> getTopSalary(){
		return bonusRepo.getTopSalary();
	}
	
	@PostMapping("/save")
	public String saveData(@RequestBody BonusModel data) {
		bonusRepo.save(data);
		return "Save Berhasil";
	}
	
	@PutMapping("/update")
	public String updateData(@RequestBody BonusModel data) {
		bonusRepo.save(data);
		return "Update Berhasil";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteData(@PathVariable("id") int id) {
		bonusRepo.deleteById(id);
		return "Delete Berhasil";
	}
}
