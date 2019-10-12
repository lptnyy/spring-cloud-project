package com.wzy.tasks.service;

public interface QuartzService {

     void executeTask(String beanName, String methodName);

     void executeTask(String beanName);
}
