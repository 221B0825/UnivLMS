package view;

import entity.ELecture;

public class VSugangInfo {
	private VDirectory vCampus;
	private VDirectory vCollege;
	private VDirectory vDepartment;
	private VLecture vLecture;
	String result;

	public VSugangInfo() {
		this.vCampus = new VDirectory();
		this.vCollege = new VDirectory();
		this.vDepartment = new VDirectory();
		this.vLecture = new VLecture();
	}

	public String show() {
			String fileName = this.vCampus.show("data//root");
			fileName = this.vCollege.show("data//" + fileName);
			fileName = this.vDepartment.show("data//" + fileName);
			result = this.vLecture.show("data//" + fileName);
			return result;
		
	}
}
