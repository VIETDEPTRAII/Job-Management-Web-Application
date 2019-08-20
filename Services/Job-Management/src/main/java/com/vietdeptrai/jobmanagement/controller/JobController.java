package com.vietdeptrai.jobmanagement.controller;

import com.vietdeptrai.jobmanagement.model.Job;
import com.vietdeptrai.jobmanagement.service.JobService;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/Job")
public class JobController {
	
		@Autowired
		JobService repositoryJob;
	
		// Get All Jobs
		@RequestMapping(value = "/GetAllJobs", method = RequestMethod.GET)
		public ResponseEntity<List<Job>> listAllJobs() {
			List<Job> listJobs = repositoryJob.findAll();
			if (listJobs.isEmpty()) {
				return new ResponseEntity<List<Job>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Job>>(listJobs, HttpStatus.OK);
		}
		
		// Get One Job By Id
		@RequestMapping(value = "/GetJob/{id}", method = RequestMethod.GET)
		public Job findJobByID(@PathVariable("id") long id) {
			Job job = repositoryJob.getOne((int) id);
			if (job == null) {
				ResponseEntity.notFound().build();
			}
	
			return job;
		}
	
		// Insert Id
		@RequestMapping(value = "/InsertJob", method = RequestMethod.POST, produces = {
				MediaType.APPLICATION_ATOM_XML_VALUE,
				MediaType.APPLICATION_JSON_VALUE }, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
		@ResponseBody
		public Job insertJob(Job jobForm) {
			try 
			{
				return repositoryJob.save(jobForm);
			} catch (Exception e) {
				return null;
			}
		}
	
		// Update job
		@RequestMapping(value = "/UpdateJob", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
		public ResponseEntity<Job> updateMonAn(@Valid Job jobForm) {
			Job job = repositoryJob.getOne(jobForm.getId());
			if (job == null) {
				return ResponseEntity.notFound().build();
			}
			
			job.setJobname(jobForm.getJobname());
			job.setJobtype(jobForm.getJobtype());
			job.setSalary(jobForm.getSalary());
			job.setCompany(jobForm.getCompany());
			job.setLocation(jobForm.getLocation());
			job.setDesc(jobForm.getDesc());

			Job updatedJob = repositoryJob.save(job);
			return ResponseEntity.ok(updatedJob);
		}
	
		// Delete job
		@RequestMapping(value = "/{id}", method = RequestMethod.POST)
		public ResponseEntity<Job> deleteMonAn(@PathVariable(value = "id") int id) {
			Job job = repositoryJob.getOne(id);
			if (job == null) {
				return ResponseEntity.notFound().build();
			}
			repositoryJob.delete(job);
			return ResponseEntity.ok().build();
		}
			
}
