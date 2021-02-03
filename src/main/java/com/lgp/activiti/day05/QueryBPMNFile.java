package com.lgp.activiti.day05;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.sql.*;

/**
 * 需求：
 * 从act_ge_bytearray表中读取两个资源文件
 *
 */
public class QueryBPMNFile {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = defaultProcessEngine.getRepositoryService();
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        processDefinitionQuery.processDefinitionKey("holiday");
        ProcessDefinition processDefinition = processDefinitionQuery.singleResult();
        String deploymentId = processDefinition.getDeploymentId();
        System.out.println(deploymentId);
        System.out.println( processDefinition.getDiagramResourceName());
        InputStream pngIS = repositoryService.getResourceAsStream(deploymentId, processDefinition.getDiagramResourceName());
        InputStream bpmnIS = repositoryService.getResourceAsStream(deploymentId, processDefinition.getResourceName());

        OutputStream pngOS = new FileOutputStream("D:\\devSoft\\IDEA\\workspace\\activiti01\\src\\main\\resources");
        OutputStream bpmnOS = new FileOutputStream("D:\\devSoft\\IDEA\\workspace\\activiti01\\src\\main\\resources");

        IOUtils.copy(pngIS,pngOS);
        IOUtils.copy(bpmnIS,bpmnOS);

        pngOS.close();
        bpmnOS.close();
        pngIS.close();
        bpmnIS.close();


    }
}
