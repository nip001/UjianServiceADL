package com.adl.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adl.main.model.ResponseDerpatmentWorker;
import com.adl.main.model.ResponseTitleWorker;
import com.adl.main.model.WorkerModel;

@Repository
public interface WorkerRepository extends JpaRepository<WorkerModel, Integer>{

	@Query(value="SELECT * from worker where salary in (SELECT salary from worker GROUP BY salary HAVING COUNT(*) >1)"
			,nativeQuery =  true)
	List<WorkerModel> getDuplicateSalary();
	
	@Query(value = "SELECT department,COUNT(*) as jumlahOrang from worker GROUP BY department",nativeQuery = true)
	List<ResponseDerpatmentWorker> getDepartment();
	
	@Query(value = "SELECT title.title,COUNT(*) as jumlahOrang from worker "
			+ "INNER JOIN title ON title.worker_ref_id=worker.worker_id GROUP BY title.title",nativeQuery = true)
	List<ResponseTitleWorker> getTitle();
}
