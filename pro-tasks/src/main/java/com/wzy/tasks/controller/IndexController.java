package com.wzy.tasks.controller;

import com.wzy.pojo.ScheduleJob;
import com.wzy.tasks.service.SchedulerJobService;
import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private SchedulerJobService schedulerJobService;

    @RequestMapping("/")
    public String index(HttpServletRequest request){
        logger.info("[JobController] the url path:------------/index----------------");
        logger.info("[JobController] the method index is start......");
        List<ScheduleJob> jobList = schedulerJobService.getAllScheduleJob();
        request.setAttribute("jobs",jobList);
        System.out.println(jobList);
        logger.info("[JobController] the method index is end......");
        return "index";
    }
}
