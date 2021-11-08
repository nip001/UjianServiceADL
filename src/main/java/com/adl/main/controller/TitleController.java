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

import com.adl.main.model.TitleModel;
import com.adl.main.repository.TitleRepository;

@RestController
@RequestMapping("/title")
public class TitleController {

	@Autowired
	TitleRepository titleRepo;
	
	@GetMapping("/")
	public List<TitleModel> getAll(){
		return titleRepo.findAll();
	}
	
	@PostMapping("/save")
	public String saveData(@RequestBody TitleModel data) {
		titleRepo.save(data);
		return "Save Berhasil";
	}
	
	@PutMapping("/update")
	public String updateData(@RequestBody TitleModel data) {
		titleRepo.save(data);
		return "Update Berhasil";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteData(@PathVariable("id") int id) {
		titleRepo.deleteById(id);
		return "Delete Berhasil";
	}
}
