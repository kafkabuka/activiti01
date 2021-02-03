package com.lgp.activiti.day06;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

/**
 * 全部流程定义挂起与激活
 */
public class SuspendProcessInstance {
    public static void main(String[] args) {
        // 获取ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 获取RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        ProcessDefinition holiday = processDefinitionQuery.processDefinitionKey("holiday").singleResult();

        boolean isSuspend = holiday.isSuspended();
        if (isSuspend){
            repositoryService.activateProcessDefinitionById(holiday.getId(),true,null);
            System.out.println("流程定义："+holiday.getId()+"激活");
        }else{
            repositoryService.suspendProcessDefinitionById(holiday.getId(),true,null);
            System.out.println("流程定义："+holiday.getId()+"挂起");
        }


    }
}
