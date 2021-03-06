function Teacher_Take_Recorder() {

	$
			.confirm({
				title : '关闭记录员权限',
				type : 'blue',
				buttons : {
					'关闭' : {
						btnClass : 'btn-blue',
						action : function() {
							var xhr = false;
							xhr = new XMLHttpRequest();
							xhr.onreadystatechange = function() {
								var message;
								if (xhr.readyState == 4) {
									if (xhr.status == 200) {
										toastr.success("已关闭所选教师的记录员权限");
										List_Teacher_By_PageAndSearch(teacher_json.pageIndex);
									} else {
										toastr.error(xhr.status);
									}
								}
							}

							var checkbox_select = document
									.getElementsByClassName("checkbox_select");

							var formData = new FormData();

							for (var num = 0; num < checkbox_select.length; num++) {
								if (checkbox_select[num].checked) {
									formData.append("ListTeacherID",
											checkbox_select[num].id);
								}
							}
							xhr
									.open("POST",
											"/bysjglxt/teacher/TeacherInformationManagement_TakeTeacherRecorder");
							xhr.send(formData);
						}
					},
					'取消' : function() {
					}
				}
			});
}