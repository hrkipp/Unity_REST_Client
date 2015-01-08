package ffm.rest.client;

import ffm.rest.client.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class POSTTest {

	Actions actions;

	@Before
	public void setup(){
		actions = new Actions("http://rest.forefrontmath.com");
//		actions = new Actions("http://localhost:8080");
	}

	@Test
	public void updateStudentTest() throws Exception {

		Student student = actions.getStudents().get(0);

		String cachedName = student.getFirstname();

		student.setFirstname("Test Firstname");

		actions.updateStudent(student);

		Student student1 = actions.getStudent(student.getId());

		assert student1.getFirstname().equals("Test Firstname");

		student.setFirstname(cachedName);

		actions.updateStudent(student);

		Student student2 = actions.getStudent(student.getId());

		assert student2.getFirstname().equals(cachedName);

	}

	@Test
	public void updateSchoolTest() throws Exception {

		School school = actions.getSchools().get(0);

		String cachedName = school.getName();

		school.setName("Test School Name");

		actions.updateSchool(school);

		School student1 = actions.getSchool(school.getId());

		assert student1.getName().equals("Test School Name");

		school.setName(cachedName);

		actions.updateSchool(school);

		School student2 = actions.getSchool(school.getId());

		assert student2.getName().equals(cachedName);

	}

	@Test
	public void updateTeacherTest() throws Exception {

		Teacher teacher = actions.getTeachers().get(0);

		School school = actions.getSchools().get(0);

		teacher.setSchool(school);

		String cachedName = teacher.getFirstname();

		teacher.setFirstname("Test Teacher Name");

		actions.updateTeacher(teacher);

		Teacher student1 = actions.getTeacher(teacher.getId());

		assert student1.getFirstname().equals("Test Teacher Name");

		teacher.setFirstname(cachedName);

		actions.updateTeacher(teacher);

		Teacher student2 = actions.getTeacher(teacher.getId());

		assert student2.getFirstname().equals(cachedName);

	}

	@Test
	public void updateSectionTest() throws Exception {

		Section student = actions.getSections().get(0);

		String cachedName = student.getName();

		student.setName("Test Section Name");

		actions.updateSection(student);

		Section student1 = actions.getSection(student.getId());

		assert student1.getName().equals("Test Section Name");

		student.setName(cachedName);

		actions.updateSection(student);

		Section student2 = actions.getSection(student.getId());

		assert student2.getName().equals(cachedName);

	}

	@Test
	public void updateStudentSectionAssociationTest() throws Exception {

		Student student = actions.getStudents().get(0);

		StudentSectionAssociation association = actions.getStudentSectionAssociations(student).get(0);

		String sectionID = association.getSectionId();

		Date oldDate = association.getEndDate();

		Date newDate = new Date(100, 1, 1);

		association.setEndDate(newDate);

		actions.updateStudentSectionAssociation(association);

		association = actions.getStudentSectionAssociations(student).stream().filter(ssa -> ssa.getSectionId().equals(sectionID)).findFirst().get();

		assert association.getEndDate().equals(newDate);

		association.setEndDate(oldDate);

		actions.updateStudentSectionAssociation(association);

		association = actions.getStudentSectionAssociations(student).stream().filter(ssa -> ssa.getSectionId().equals(sectionID)).findFirst().get();

		assert association.getEndDate().equals(oldDate);

	}

	@Test
	public void updateStudentSchoolAssociationTest() throws Exception {

		Student student = actions.getStudents().get(0);

		StudentSchoolAssociation association = actions.getStudentSchoolAssociations(student).get(0);

		String sectionID = association.getSchoolId();

		Date oldDate = association.getExitWithdrawDate();

		Date newDate = new Date(100, 1, 1);

		association.setExitWithdrawDate(newDate);

		actions.updateStudentSchoolAssociation(association);

		association = actions.getStudentSchoolAssociations(student).stream().filter(ssa -> ssa.getSchoolId().equals(sectionID)).findFirst().get();

		assert association.getExitWithdrawDate().equals(newDate);

		association.setExitWithdrawDate(oldDate);

		actions.updateStudentSchoolAssociation(association);

		association = actions.getStudentSchoolAssociations(student).stream().filter(ssa -> ssa.getSchoolId().equals(sectionID)).findFirst().get();

		assert association.getExitWithdrawDate().equals(oldDate);

	}

}