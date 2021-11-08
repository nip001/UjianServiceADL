package com.adl.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="worker")
public class WorkerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int workerId;
	private String firstName;
	private String lastName;
	private int salary;
	private String joiningDate;
	private String department;
	
}
