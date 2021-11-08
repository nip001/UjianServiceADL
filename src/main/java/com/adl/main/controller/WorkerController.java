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

import com.adl.main.model.ResponseDerpatmentWorker;
import com.adl.main.model.ResponseTitleWorker;
import com.adl.main.model.WorkerModel;
import com.adl.main.repository.WorkerRepository;

@RestController
@RequestMapping("/worker")
public class WorkerController {

	@Autowired
	WorkerRepository workerRepo;
	
	@GetMapping("/")
	public List<WorkerModel> getAll(){
		return workerRepo.findAll();
	}
	
	@GetMapping("/duplicate")
	public List<WorkerModel> getDuplicateSalary(){
		return workerRepo.getDuplicateSalary();
	}
	
	@GetMapping("/department")
	public List<ResponseDerpatmentWorker> getDepartment(){
		return workerRepo.getDepartment();
	}
	
	@GetMapping("/title")
	public List<ResponseTitleWorker> getTitle(){
		return workerRepo.getTitle();
	}
	
	@PostMapping("/save")
	public String saveData(@RequestBody WorkerModel data) {
		workerRepo.save(data);
		return "Save Berhasil";
	}
	
	@PutMapping("/update")
	public String updateData(@RequestBody WorkerModel data) {
		workerRepo.save(data);
		return "Update Berhasil";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteData(@PathVariable("id") int id) {
		workerRepo.deleteById(id);
		return "Delete Berhasil";
	}
}
