package com.lgp.activiti.day06;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;

/**
 * 单个流程实例挂起与激活
 */
public class SuspendProcessInstance2 {
    public static void main(String[] args) {
        // 获取ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 获取runtimeService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();

        // 查询流程实例对象
        ProcessInstance processInstance = runtimeService
                .createProcessInstanceQuery()
                .processInstanceId("2501")
                .singleResult();

        String processInstanceId = processInstance.getId();
        boolean isSuspend = processInstance.isSuspended();


        if (isSuspend){
            runtimeService.activateProcessInstanceById(processInstanceId);
            System.out.println("流程实例："+processInstanceId+"激活");
        }else{
            runtimeService.suspendProcessInstanceById(processInstanceId);
            System.out.println("流程实例："+processInstanceId+"挂起");
        }


    }
}
