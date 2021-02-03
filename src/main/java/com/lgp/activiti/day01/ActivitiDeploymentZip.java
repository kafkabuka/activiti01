package com.lgp.activiti.day01;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;

import java.io.InputStream;
import java.util.zip.ZipInputStream;

public class ActivitiDeploymentZip {
    public static void main(String[] args) {
        InputStream resourceAsStream = ActivitiDeploymentZip.class
                .getClassLoader()
                .getResourceAsStream("diagram/holiday.zip");
        ZipInputStream zipInputStream = new ZipInputStream(resourceAsStream);
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        Deployment deploy = processEngine.getRepositoryService()
                .createDeployment()
                .addZipInputStream(zipInputStream)
                .name("请假申请单流程")
                .deploy();
        System.out.println(deploy.getName());
        System.out.println(deploy.getId());
    }
}
