package com.Project.App.JobsApp.controller;

import com.Project.App.JobsApp.model.JobPost;
import com.Project.App.JobsApp.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobPostService jobPostService;


    @PostMapping("jobPosts")
    public JobPost handleForm(@RequestBody JobPost jobPost) {
        jobPostService.addJob(jobPost);
        return jobPostService.getJob(jobPost.getPostId());
    }

    @GetMapping("jobPosts")
    public List<JobPost> viewJobs() {
        return jobPostService.getAllJobs();
    }

    @PutMapping("jobPosts")
    public JobPost updateJob(@RequestBody JobPost jobPost)
    {
        jobPostService.updateJob(jobPost);
        return jobPostService.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPosts/{postId}")
    public String deleteJob(@PathVariable int postId)
    {
        jobPostService.deleteJob(postId);
        return "Deleted:"+postId;
    }

    @GetMapping("jobPosts/{postId}")
    public JobPost getJobByID(@PathVariable int postId)
    {
        System.out.println(postId);
        return jobPostService.getJob(postId);
    }
}
