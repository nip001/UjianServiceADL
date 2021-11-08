package com.adl.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adl.main.model.BonusModel;
import com.adl.main.model.JoiningModelWorker;

@Repository
public interface BonusRepository extends JpaRepository<BonusModel, Integer>{

	@Query(value="select worker.first_name as firstName,worker.department,(worker.salary+bonus.bonus_amount)as salary,"
			+ "bonus.bonus_date as bonusDate from bonus INNER JOIN worker on worker.worker_id = bonus.worker_ref_id "
			+ "ORDER BY `salary`  DESC LIMIT 5",nativeQuery = true)
	List<JoiningModelWorker> getTopSalary();
}
