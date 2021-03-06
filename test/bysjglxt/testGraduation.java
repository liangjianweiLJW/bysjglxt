package bysjglxt;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bysjglxt.domain.DO.bysjglxt_evaluate_tutor;
import com.bysjglxt.domain.VO.TeacherTutorStudentVO;
import com.bysjglxt.service.GraduationProjectManagementService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext*.xml" })
public class testGraduation {

	@Resource
	private GraduationProjectManagementService graduationProjectManagementService;

	public void setGraduationProjectManagementService(
			GraduationProjectManagementService graduationProjectManagementService) {
		this.graduationProjectManagementService = graduationProjectManagementService;
	}

	@Test
	public void fss() {
		bysjglxt_evaluate_tutor bysjglxt_evaluate_tutor = new bysjglxt_evaluate_tutor();
		bysjglxt_evaluate_tutor = graduationProjectManagementService
				.get_EvaluateTutor("9aad2819-8d92-4a61-9d95-4b1098169d9d");
		System.out.println(
				graduationProjectManagementService.generateTutorTotalGraduationComment(bysjglxt_evaluate_tutor));
	}


	// 测试保存毕业论文
	@Test
	public void saveGrad() {
		File file = null;
		int i = 0;
		try {
			i = graduationProjectManagementService.saveDissertation(file, "", "860f9cbb-1557-4702-96eb-eaa4e310e88c",
					"");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(i);
	}

	// 测试分页显示指导的任务
	@Test
	public void testTutor() {
		TeacherTutorStudentVO teacherTutorStudentVO = new TeacherTutorStudentVO();
		teacherTutorStudentVO.setState(2);
		teacherTutorStudentVO = graduationProjectManagementService.teacherTutorStudentVO(teacherTutorStudentVO,
				"ee5ee741-7677-4541-8a85-dc2f670f6316");
		System.out.println(teacherTutorStudentVO);
	}

	// 测试导出封面
	@Test
	public void testCover() {
		try {
			graduationProjectManagementService.exportCover("860f9cbb-1557-4702-96eb-eaa4e310e88c");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 测试导出任务书
	@Test
	public void testTask() {
		try {
			graduationProjectManagementService.exportTask("860f9cbb-1557-4702-96eb-eaa4e310e88c");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 测试导出开题报告
	@Test
	public void testReport() {
		try {
			graduationProjectManagementService.exportOpeningReport("860f9cbb-1557-4702-96eb-eaa4e310e88c");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 测试导出情况记录
	@Test
	public void testRecord() {
		try {
			graduationProjectManagementService.exportPerfect("860f9cbb-1557-4702-96eb-eaa4e310e88c");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 测试个人学习工作总结
	@Test
	public void testSummary() {
		try {
			graduationProjectManagementService.exportSummary("860f9cbb-1557-4702-96eb-eaa4e310e88c");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 测试导出形式审查表
	@Test
	public void testExportFormal() {
		try {
			graduationProjectManagementService.exportFormal("860f9cbb-1557-4702-96eb-eaa4e310e88c");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 测试导出指导老师评价表
	@Test
	public void testTeacherOpin() {
		try {
			graduationProjectManagementService.exportTeacherOpin("860f9cbb-1557-4702-96eb-eaa4e310e88c");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 测试导出评阅老师评价表
	@Test
	public void testReview() {
		try {
			graduationProjectManagementService.exportReviewOpin("860f9cbb-1557-4702-96eb-eaa4e310e88c");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 测试答辩
	@Test
	public void testDefence() {
		try {
			graduationProjectManagementService.exportDefence("860f9cbb-1557-4702-96eb-eaa4e310e88c");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 测试到处毕业设计书
	@Test
	public void testA() {
		List<String> l = new ArrayList<>();
		l.add("353265b4-dabe-40c3-a193-05591a4db318");
		l.add("f3ac7ce1-50e5-43c9-b6f0-1a918e7577cc");
		try {
			graduationProjectManagementService.exportAll(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
