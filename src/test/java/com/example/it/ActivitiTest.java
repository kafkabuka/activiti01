package com.example.it;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

public class ActivitiTest {
    @Test
    public void testGenerator() {
        ProcessEngineConfiguration resource = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        ProcessEngine processEngine = resource.buildProcessEngine();
        System.out.println(processEngine);
    }
}
