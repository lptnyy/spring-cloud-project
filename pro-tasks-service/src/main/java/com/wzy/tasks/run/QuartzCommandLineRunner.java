package com.wzy.tasks.run;

import com.wzy.tasks.jobs.TestJob;
import com.wzy.tasks.service.impl.TestQuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class QuartzCommandLineRunner implements CommandLineRunner {

    @Autowired
    TestQuartzService quartzService;

    @Override
    public void run(String... args) throws Exception {
//        Map<String, Integer> map = new HashMap<>();
//
//        map.put("name",2);
//        quartzService.deleteJob("job2", "test");
//        quartzService.addJob(TestJob.class, "job2", "test", "10 * * * * ?", map);
//
//        map.put("name",3);
//        quartzService.deleteJob("job3", "test2");
//        quartzService.addJob(TestJob.class, "job3", "test2", "15 * * * * ?", map);
    }
}
