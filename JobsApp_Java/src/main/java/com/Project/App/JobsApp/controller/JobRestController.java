package com.Project.App.JobsApp.controller;

import com.Project.App.JobsApp.model.JobPost;
import com.Project.App.JobsApp.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobPostService jobPostService;


    @PostMapping("handleForm")
    public boolean handleForm(JobPost jobPost) {
        jobPostService.addJob(jobPost);
        return true;
    }

    @GetMapping("jobPosts")
    public List<JobPost> viewJobs(Model m) {
        return jobPostService.getAllJobs();
    }
}
