package ffm.rest.client.model;

import ffm.rest.client.enums.GradeLevel;
import ffm.rest.client.enums.SchoolYear;

import java.util.Date;

public class StudentSchoolAssociation {

	private String id;
	private String studentId;
	private String schoolId;
	private SchoolYear schoolYear;
	private Date entryDate;
	private GradeLevel gradeLevel;
	private Date exitWithdrawDate;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getExitWithdrawDate() {
		return exitWithdrawDate;
	}

	public void setExitWithdrawDate(Date exitWithdrawDate) {
		this.exitWithdrawDate = exitWithdrawDate;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public SchoolYear getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(SchoolYear schoolYear) {
		this.schoolYear = schoolYear;
	}


	public GradeLevel getGradeLevel() {
		return gradeLevel;
	}

	public void setGradeLevel(GradeLevel gradeLevel) {
		this.gradeLevel = gradeLevel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
