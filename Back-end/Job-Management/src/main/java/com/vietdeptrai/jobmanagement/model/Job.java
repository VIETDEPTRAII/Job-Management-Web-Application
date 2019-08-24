package com.vietdeptrai.jobmanagement.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "jobs")
public class Job implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "job_id")
	 private int id;
	 
	 @Column(name = "`jobname`")
	 private String jobname;
	 
	 @Column(name = "`jobtype`")
	 private String jobtype;
	 
	 @Column(name = "`salary`")
	 private String salary;
	 
	 @Column(name = "`company`")
	 private String company;
	 
	 @Column(name = "`location`")
	 private String location;
	 
	 @Column(name = "`desc`")
	 private String desc;
	 
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Job(int id, String jobname, String jobtype, String salary, String company, String location, String desc) {
		super();
		this.id = id;
		this.jobname = jobname;
		this.jobtype = jobtype;
		this.salary = salary;
		this.company = company;
		this.location = location;
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobname() {
		return jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	public String getJobtype() {
		return jobtype;
	}

	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	 	 
}
