package com.vietdeptrai.jobmanagement.service;

import com.vietdeptrai.jobmanagement.model.Job;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//import org.springframework.data.repository.query.Param;

@Repository
public interface JobService extends JpaRepository<Job, Integer>{
	
//		//Search Job By Name
//		@Query("FROM Jobs WHERE jobname LIKE %:keyword%")
//		public List<Job> SearchJobByName(@Param("keyword") String keyword);
	
}
