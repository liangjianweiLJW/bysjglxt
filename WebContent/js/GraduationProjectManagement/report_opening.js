function Initialization_report_opening() {

	var banner_report_opening = document
			.getElementById("banner_report_opening");
	banner_report_opening.click();
}

function report_opening() {
	document.getElementById("GraduationProjectTitle").innerHTML = '学生上传开题报告';
	var xhr = false;
	var formData = new FormData();
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				var report_opening = JSON.parse(xhr.responseText);
				var tab = document.getElementById("tab5");
				tab.innerHTML = '';
				/*
				 * 
				 */
				var textarea_0 = document.createElement("textarea");
				textarea_0.id = 'report_opening_id';
				textarea_0.style = "display:none;"
				textarea_0.innerHTML = report_opening.report_opening_id;
				tab.appendChild(textarea_0);
				/*
				 * 
				 */
				var textarea_1 = document.createElement("textarea");
				textarea_1.id = 'student_id_report_opening';
				textarea_1.style = "display:none;"
				textarea_1.innerHTML = report_opening.report_opening_student;
				tab.appendChild(textarea_1);
				/*
				 * 
				 */
				var textarea_2 = document.createElement("textarea");
				textarea_2.id = 'report_file_is_xiazai';
				textarea_2.style = "display:none;"
				textarea_2.innerHTML = report_opening.report_file_is_xiazai;
				tab.appendChild(textarea_2);
				/*
				 * 
				 */
				var h4 = document.createElement("h4");
				h4.innerHTML = '提交开题报告：';
				tab.appendChild(h4);
				/*
				 * 
				 */
				var div = document.createElement("div");
				div.id = "div_report_opening_box";
				tab.appendChild(div);
				if (report_opening.report_opening_file != null) {
					var div_2 = document.createElement("div");
					div_2.innerHTML = '<button class="btn btn-default" '
							+ 'onclick="addReportOpeningFile()">上传</button>';
					tab.appendChild(div_2);
					if (report_opening.report_opening_file != '') {
						reportOpeningFileChange(report_opening.report_opening_file);
					}

				} else {
					var div_2 = document.createElement("div");
					div_2.innerHTML = '<button class="btn btn-default" '
							+ 'onclick="addReportOpeningFile()">上传</button>';
					tab.appendChild(div_2);
				}

				var ulSave = document.createElement("ul");
				ulSave.className='pager wizard';
				var liSave = document.createElement("li");
				liSave.id='button_SaveGraduationProject';
				var aSave = document.createElement('a');
				aSave.href='####';
				aSave.onclick = Save_report_opening
				aSave.text='提交更新';
				liSave.appendChild(aSave);
				ulSave.appendChild(liSave);
				tab.appendChild(ulSave);
				
				/*
				 * 让不是现在进行的流程的不可编辑
				 */
				var button_SaveGraduationProject = document
						.getElementById("button_SaveGraduationProject");
				var div_reportopening_del = document
						.getElementById("div_report_opening_del");
				if ('-1' == k) {
					if ("学生上传开题报告" != current_processDefinitionName) {
						div_2.parentNode.removeChild(div_2);
						button_SaveGraduationProject.style.display = "none";
						div_reportopening_del.style.display = "none";
					} else if (userStudentDTO != null) {
						if (current_processInstanceUserID == userStudentDTO.bysjglxtStudentUser.user_student_id) {
							button_SaveGraduationProject.style.display = "block";
							div_reportopening_del.style.display = "block";
						} else {
							div_2.parentNode.removeChild(div_2);
							button_SaveGraduationProject.style.display = "none";
							div_reportopening_del.style.display = "none";
						}
					} else if (userTeacherDTO != null) {
						if (current_processInstanceUserID == userTeacherDTO.bysjglxtTeacherUser.user_teacher_id) {
							button_SaveGraduationProject.style.display = "block";
							div_reportopening_del.style.display = "block";
						} else {
							div_2.parentNode.removeChild(div_2);
							button_SaveGraduationProject.style.display = "none";
							div_reportopening_del.style.display = "none";
						}
					} else {
						div_2.parentNode.removeChild(div_2);
						button_SaveGraduationProject.style.display = "none";
						div_reportopening_del.style.display = "none";
					}
				} else if ('1' == k) {
					if (userStudentDTO != null) {
						if (_userId_Task == userStudentDTO.bysjglxtStudentUser.user_student_id) {
							button_SaveGraduationProject.style.display = "block";
							div_reportopening_del.style.display = "block";
						} else {
							div_2.parentNode.removeChild(div_2);
							button_SaveGraduationProject.style.display = "none";
							div_reportopening_del.style.display = "none";
						}
					} else if (userTeacherDTO != null) {
						if (_userId_Task == userTeacherDTO.bysjglxtTeacherUser.user_teacher_id) {
							button_SaveGraduationProject.style.display = "block";
							div_reportopening_del.style.display = "block";
						} else {
							div_2.parentNode.removeChild(div_2);
							button_SaveGraduationProject.style.display = "none";
							div_reportopening_del.style.display = "none";
						}
					} else {
						div_2.parentNode.removeChild(div_2);
						button_SaveGraduationProject.style.display = "none";
						div_reportopening_del.style.display = "none";
					}
				}

			} else {
				toastr.error(xhr.status);
			}
		}
	}
	xhr
			.open("POST",
					"/bysjglxt/graduationProject/GraduationProjectManagement_get_ReportOpening");
	xhr.send(formData);
}