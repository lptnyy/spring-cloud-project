package com.wzy.tasks.jobs;


import com.wzy.pojo.ScheduleJob;
import com.wzy.tasks.service.QuartzService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

@Service("quartzJobFactory")
public class QuartzJobFactory extends QuartzJobBean {

    @Autowired
    QuartzService quartzService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        ScheduleJob object = (ScheduleJob) jobExecutionContext.getMergedJobDataMap().get("scheduleJob");
        if(object.getMethodName()==null || object.getMethodName().equals("")){
            quartzService.executeTask(object.getBeanName());
        }else {
            quartzService.executeTask(object.getBeanName(),object.getMethodName());
        }
    }
}
