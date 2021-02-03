package com.lgp.activiti.day03;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;

import java.util.List;

/**
 * 查询当前用户的任务列表
 */
public class ActivitiQueryTask {
    public static void main(String[] args) {

        // 1.获取processEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2.通过ProcessEngine获取TaskService对象
        TaskService taskService = processEngine.getTaskService();

        // 3.根据流程定义的key，负责人assignee来实现当前用户的任务列表展示
        List<Task> holiday = taskService.createTaskQuery()
                .processDefinitionKey("holiday")
                .taskAssignee("zhangsan")
                .list();

        // 4.任务列表展示
        for (Task task: holiday){
            System.out.println("流程实例ID："+task.getProcessInstanceId());
            System.out.println("任务ID："+task.getId());
            System.out.println("任务负责人："+task.getAssignee());
            System.out.println("任务名称："+task.getName());
        }
    }
}
