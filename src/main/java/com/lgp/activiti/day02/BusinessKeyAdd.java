package com.lgp.activiti.day02;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * act_ru_execution -> businessKey
 */
public class BusinessKeyAdd {
    public static void main(String[] args) {

        // 1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2.得到RunService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();

        // 3.创建流程实例 流程定义的key需要知道  在表名为：act_re_procdef,列名：key_ 中获取
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("holiday","1001");



        // 4.输出实例相关信息
        System.out.println("流程部署ID：" + instance.getDeploymentId()); // null
        System.out.println("BusinessKey：" + instance.getBusinessKey()); // 1001
        System.out.println("流程定义ID：" + instance.getProcessDefinitionId()); // PROCESS_1:1:4   act_re_procdef
        System.out.println("流程实例ID：" + instance.getId()); // 2501       act_hi_procinst
        System.out.println("活动ID：" + instance.getActivityId()); // null
    }
}
