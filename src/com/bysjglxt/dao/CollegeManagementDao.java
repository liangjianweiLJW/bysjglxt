package com.bysjglxt.dao;

import java.util.List;

import com.bysjglxt.domain.DO.bysjglxt_college;
import com.bysjglxt.domain.DO.bysjglxt_section;
import com.bysjglxt.domain.DO.bysjglxt_teacher_basic;
import com.bysjglxt.domain.DO.bysjglxt_teacher_user;
import com.bysjglxt.domain.DTO.CollegeInformationDTO;

public interface CollegeManagementDao {

	public List<bysjglxt_college> getListCollege();

	public List<bysjglxt_teacher_user> getListCollegeAdmin(String college_id);

	public bysjglxt_teacher_basic getTeacherBasicById(String trim);

	public bysjglxt_section getSectionById(String trim);

	public bysjglxt_teacher_user getTeacherUserById(String teacherUserId);

	public void saveObj(Object obj);

	public com.bysjglxt.domain.DO.bysjglxt_college getCollegeByCode(String trim);

	public com.bysjglxt.domain.DO.bysjglxt_college getCollegeByName(String trim);

	public com.bysjglxt.domain.DO.bysjglxt_teacher_basic getTeacherBasicByJobNum(String trim);
	/**
	 * 根据id获取学院
	 * @param id
	 * @return
	 */
	public bysjglxt_college getCollegeById(String id);

	/**
	 * 根据学院id获取管理员信息
	 * @param college_id
	 * @return
	 */
	public bysjglxt_teacher_user getTeacherUserByCollegeId(String college_id);

	public int getTeacherUserCountByCollegeId(String college_id);

	public int getSectionCountById(String college_id);

	public int getMajorCountById(String college_id);

	public String deleteCollegeById(String college_id);


}
