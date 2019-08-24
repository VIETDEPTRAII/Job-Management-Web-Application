package com.vietdeptrai.jobmanagement.service;


import com.vietdeptrai.jobmanagement.model.Job;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JobService extends JpaRepository<Job, Integer>{
	
		//Search Job By Name
		@Query("FROM Job WHERE jobname LIKE %:keyword%")
		public List<Job> searchJobByName(@Param("keyword") String keyword);
		
}
