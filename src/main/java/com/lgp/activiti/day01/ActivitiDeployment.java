package com.lgp.activiti.day01;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

/**
 * 流程定义的部署工作
 * act_re_deployment
 * act_ge_property
 * act_re_procdef
 * act_ge_bytearray
 */
public class ActivitiDeployment {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("diagram/holiday.bpmn20.xml")
                .addClasspathResource("diagram/holiday.png")
                .name("请假申请流程")
                .deploy();
        System.out.println(deploy.getId());
        System.out.println(deploy.getName());

    }
}
