package com.lgp.activiti.day05;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

/**
 * 查询流程定义信息
 */
public class QueryProcessDefinition {
    public static void main(String[] args) {
        // 1. 获取ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2.获取RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 3.获取ProcessDefinitionQuery对象
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();

        // 4.设置查询条件，并查询出当前的所有流程定义   查询条件：流程定义的key=holiday
        List<ProcessDefinition> holiday = processDefinitionQuery.processDefinitionKey("holiday")
                .orderByProcessDefinitionVersion() // 设置排序方式
                .desc()
                .list();

        // 5.输出流程定义信息
        holiday.stream().forEach(item->{
            System.out.println("流程定义ID："+item.getId());
            System.out.println("流程定义名称："+item.getKey());
            System.out.println("流程定义的KEY："+item.getName());
            System.out.println("流程定义的版本号："+item.getVersion());
            System.out.println("流程部署的ID："+item.getDeploymentId());
        });


    }
}
