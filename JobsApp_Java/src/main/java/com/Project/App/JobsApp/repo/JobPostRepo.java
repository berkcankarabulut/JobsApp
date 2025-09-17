package com.Project.App.JobsApp.repo;

import com.Project.App.JobsApp.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public interface JobPostRepo extends JpaRepository<JobPost, Integer> {

}
