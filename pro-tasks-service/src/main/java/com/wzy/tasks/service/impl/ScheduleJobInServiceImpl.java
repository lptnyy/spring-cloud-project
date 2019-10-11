package com.wzy.tasks.service.impl;

import com.wzy.mapper.ScheduleJobMapper;
import com.wzy.pojo.ScheduleJob;
import com.wzy.pojo.ScheduleJobExample;
import com.wzy.tasks.service.ScheduleJobInService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("scheduleJobInService")
public class ScheduleJobInServiceImpl implements ScheduleJobInService {

    @Resource
    ScheduleJobMapper scheduleJobMapper;

    @Override
    public int insert(ScheduleJob scheduleJob) {
        int id = scheduleJobMapper.insertSelective(scheduleJob);
        return id;
    }

    @Override
    public int insertSelective(ScheduleJob scheduleJob) {
        int id = scheduleJobMapper.insertSelective(scheduleJob);
        return id;
    }

    @Override
    public ScheduleJob selectByJobNameAngJobGroup(String jobName, String groupName) {
        ScheduleJobExample scheduleJobExample = new ScheduleJobExample();
        scheduleJobExample.createCriteria().andJobGroupEqualTo(groupName).andJobNameEqualTo(jobName);
        List<ScheduleJob> list = scheduleJobMapper.selectByExample(scheduleJobExample);
        if (list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public ScheduleJob selectByPrimaryKey(Integer id) {
        return scheduleJobMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(ScheduleJob scheduleJob) {
        return scheduleJobMapper.updateByPrimaryKeySelective(scheduleJob);
    }

    @Override
    public int updateByExample(ScheduleJob scheduleJob) {
        ScheduleJobExample scheduleJobExample = new ScheduleJobExample();
        scheduleJobExample.createCriteria().andJobNameEqualTo(scheduleJob.getJobName()).andJobGroupEqualTo(scheduleJob.getJobGroup());
        return scheduleJobMapper.updateByExample(scheduleJob,scheduleJobExample);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return scheduleJobMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByJobNameAndJobGroup(String jobName, String jobGroup) {
        ScheduleJobExample scheduleJobExample = new ScheduleJobExample();
        scheduleJobExample.createCriteria().andJobGroupEqualTo(jobGroup).andJobNameEqualTo(jobName);
        return scheduleJobMapper.deleteByExample(scheduleJobExample);
    }
}
