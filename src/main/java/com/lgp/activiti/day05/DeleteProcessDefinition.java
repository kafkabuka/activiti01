package com.lgp.activiti.day05;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

/**
 * 删除已部署的流程定义
 *      背后影响的表:
 *          act_ge_bytearray
 *          act_re_deployment
 *          act_re_procdef
 */
public class DeleteProcessDefinition {
    /**
     * 当我们要删除的流程还在运行，此时删除会失败
     * 如果要强制删除：deleteDeployment（，true），此时会删除未完成的流程节点，最后可以删除流程定义信息
     * @param args
     */
    public static void main(String[] args) {
        // 1. 获取ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2.获取RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 3.执行删除流程定义  参数代表流程部署的ID  getDeploymentId
        repositoryService.deleteDeployment("15001",true);


    }
}
