function Delete_Section() {

	/*
	 * 
	 */

	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				if (xhr.responseText == "success") {
					toastr.success("删除成功");
					List_Section_By_Page(1);
				}
			} else {
				toastr.error(xhr.status);
			}
		}
	}

	var checkbox_select = document.getElementsByClassName("checkbox_select");

	var ListDeleteSectionNum = null;

	var formData = new FormData();

	for (var num = 0; num < checkbox_select.length; num++) {
		if (checkbox_select[num].checked) {
			formData.append("ListDeleteSectionID", checkbox_select[num].id);
		}

	}

	xhr.open("POST",
			"/bysjglxt/section/SectionInformationManagement_DeleteSection");

	xhr.send(formData);

}