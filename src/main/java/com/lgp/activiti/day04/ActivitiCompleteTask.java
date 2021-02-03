package com.lgp.activiti.day04;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

/**
 * 当前用户任务处理
 * act_hi_actinst
 * act_hi_identitylink
 * act_hi_taskinst
 *
 * act_ru_identitylink
 * act_ru_task
 */
public class ActivitiCompleteTask {
    public static void main(String[] args) {
        // 1.获取ProocessEngine
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();

        // 处理任务，结合当前用户任务列表的查询操作的话，任务ID:2505   task.getId()
        Task task = taskService.createTaskQuery().taskAssignee("zhangsan").singleResult();
        taskService.complete(task.getId());
    }
}
