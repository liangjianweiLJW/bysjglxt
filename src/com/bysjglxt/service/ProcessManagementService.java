package com.bysjglxt.service;

import java.util.List;

import com.bysjglxt.domain.DO.bysjglxt_defence;
import com.bysjglxt.domain.DO.bysjglxt_evaluate_review;
import com.bysjglxt.domain.DO.bysjglxt_evaluate_tutor;
import com.bysjglxt.domain.DO.bysjglxt_examination_formal;
import com.bysjglxt.domain.DO.bysjglxt_process_definition;
import com.bysjglxt.domain.DO.bysjglxt_record_progress;
import com.bysjglxt.domain.DO.bysjglxt_report_opening;
import com.bysjglxt.domain.DO.bysjglxt_summary;
import com.bysjglxt.domain.DO.bysjglxt_task_definition;
import com.bysjglxt.domain.DO.bysjglxt_taskbook;
import com.bysjglxt.domain.DTO.ProcessDefinitionDetailDTO;
import com.bysjglxt.domain.DTO.TaskDTO;
import com.bysjglxt.domain.VO.ProcessManagementVO;

public interface ProcessManagementService {

	/**
	 * @说明 点击创建流程 1. 创建流程定义记录 1 成功 -1失败
	 * @param SelectTopicProcessDefinition
	 * @return
	 */
	public String createSelectTopicProcessDefine(bysjglxt_process_definition selectTopicProcessDefinition);

	/**
	 * @说明 点击创建任务定义
	 * @param selectTopicTaskDefine
	 * @return
	 */
	public int createSelectTopicTaskDefine(bysjglxt_task_definition selectTopicTaskDefine);

	/**
	 * 遍历出流程定义
	 * 
	 * @return
	 */
	public List<bysjglxt_process_definition> listProcessDefinition();

	/**
	 * @param processInstanceName
	 *            流程实例名称 process_definition_id 流程定义ID operation 操作者ID processNum
	 *            流程编号 1 选题流程 2毕业设计流程 3答辩流程
	 * 
	 * @说明 创建流程和任务实例 参数：流程定义ID 1.成功 -4 系统繁忙，所输入的参数有问题 -1 无权限开启流程-2已经开启流程
	 *     -3实例化流程失败
	 * 
	 * @return
	 */
	public int openProcess(String processInstanceName, String process_definition_id, String operation);

	/**
	 * 遍历出所有的定义表
	 * 
	 * @return
	 */
	public ProcessDefinitionDetailDTO processDefinitionDetailDTO(String processDefinitionId);

	/**
	 * 删除流程定义
	 * 
	 * @param processDefinitionId
	 * @return 1:成功 -4系统繁忙，输入的参数有误 -3删除失败
	 */
	public int deleteProcessDefinition(List<String> listProcessDefinitionId);

	/**
	 * 点击我的任务，将内容分页显示
	 * 
	 * @param processManagementVo
	 * @return
	 */
	public ProcessManagementVO getMyTaskByPage(ProcessManagementVO processManagementVo, String userID);

	/**************************** 在点击通过或者是打回以及 ***************************************************/

	/**
	 * 通过: 实现思路: 1.根据任务实例ID获取任务实例对象 2.直接根据对象更改当前任务实例状态
	 * 3.根据a该对象的任务实例ID当作父任务实例ID来寻找下一个任务实例 4.根据next任务实例对象ID获得实例对象 5.更改任务实例状态 
	 * 打回：
	 * 		实现思路:
	 * 		1.根据任务实例ID获取任务实例实例对象
	 * 		2.将当前实例对象更改未未开始
	 * 		3.先获得返回任务实例的ID
	 * 		4.再往上遍历得到父任务结点,当父任务结点为返回任务结点的时候将该父任务结点的状态进行变化
	 */
	// 1.通过
	public int pass(String taskInstanceId);
	// 2.打回
	public int repulse(String taskInstanceId);

}
