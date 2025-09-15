package com.Project.App.JobsApp.controller;

import com.Project.App.JobsApp.model.JobPost;
import com.Project.App.JobsApp.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class JobPostController {

    @Autowired
    private JobPostService jobPostService;

    @GetMapping({"/","home"})
    public String home()
    {
        System.out.println("Test Home");
        return "home";
    }

    @GetMapping("addjob")
    public String addjob()
    {
        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost)
    {
        jobPostService.addJob(jobPost);
        return "success";
    }

    @GetMapping("viewalljobs")
    public String viewJobs(Model m) {
        List<JobPost> jobs = jobPostService.getAllJobs();
       if(!jobs.isEmpty()) m.addAttribute("jobPosts", jobs);
       return "viewalljobs";
    }
}
