package ffm.rest.client.model;

import java.util.Date;

public class StudentSectionAssociation {

	private String sectionId;
	private String studentId;
	private Date beginDate;
	private Date endDate;
	private String id;

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getSectionId() {
		return sectionId;
	}

	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
