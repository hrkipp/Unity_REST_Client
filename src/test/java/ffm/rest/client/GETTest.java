package ffm.rest.client;

import ffm.rest.client.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GETTest {

	Actions actions;

	@Before
	public void setup(){
		actions = new Actions("http://rest.forefrontmath.com");
//		actions = new Actions("http://localhost:8080");cd
	}

	@Test
	public void getTeachersTest() throws Exception {
		assert !actions.getTeachers().isEmpty();
	}

	@Test
	public void getTeacherTest() throws Exception {
		List<Teacher> teachers = actions.getTeachers();

		assert !teachers.isEmpty();

		Teacher teacher = actions.getTeacher(teachers.get(0).getId());

		assert teacher.getFirstname().equals(teachers.get(0).getFirstname());

		assert teacher.getLastname().equals(teachers.get(0).getLastname());
	}

	@Test
	public void getNonExistantTeacherTest() throws Exception {
		assert actions.getTeacher("NotARealTeacherID") == null;
	}

	@Test
	public void getTeacherSectionsTest() throws Throwable {
		List<Teacher> sections = actions.getTeachers();

		assert !sections.isEmpty();

		List<Section> students = actions.getSections(sections.get(0));

		assert !students.isEmpty();

		for (Section student : students) {
			assert student.getId() != null;
		}

	}

	@Test
	public void getStudentsTest() throws Exception {
		assert !actions.getStudents().isEmpty();
	}

	@Test
	public void getStudentTest() throws Exception {
		List<Student> students = actions.getStudents();

		assert !students.isEmpty();

		Student student = actions.getStudent(students.get(0).getId());

		assert student.getFirstname().equals(students.get(0).getFirstname());

		assert student.getLastname().equals(students.get(0).getLastname());
	}

	@Test
	public void getNonExistantStudentTest() throws Exception {
		assert actions.getTeacher("NotARealStudentID") == null;
	}

	@Test
	public void getSectionsTest() throws Exception {
		assert !actions.getSections().isEmpty();
	}

	@Test
	public void getSectionTest() throws Exception {
		List<Section> sections = actions.getSections();

		assert !sections.isEmpty();

		Section section = actions.getSection(sections.get(0).getId());

		assert section.getName().equals(sections.get(0).getName());
	}

	@Test
	public void getNonExistantSectionTest() throws Exception {
		assert actions.getTeacher("NotARealSectionID") == null;
	}

	@Test
	public void getSectionStudentsTest() throws Throwable {
		List<Section> sections = actions.getSections();

		assert !sections.isEmpty();

		List<Student> students = actions.getStudents(sections.get(0));

		assert !students.isEmpty();

		for (Student student : students) {
			assert student.getId() != null;
		}

	}

	@Test
	public void getSchoolsTest() throws Exception {
		assert !actions.getSchools().isEmpty();
	}

	@Test
	public void getSchoolTest() throws Exception {
		List<School> schools = actions.getSchools();

		assert !schools.isEmpty();

		School school = actions.getSchool(schools.get(0).getId());

		assert school.getName().equals(schools.get(0).getName());
	}

	@Test
	public void getNonExistantSchoolTest() throws Exception {
		assert actions.getTeacher("NotARealSchoolID") == null;
	}

	@Test
	public void getStudentSectionAssociationTest() throws Throwable {

		List<Section> sections = actions.getSections();

		assert !sections.isEmpty();

		List<StudentSectionAssociation> associations = actions.getStudentSectionAssociations(sections.get(0));

		for (StudentSectionAssociation association : associations) {
			assert association.getSectionId().equals(sections.get(0).getId());
		}
	}

	@Test
	public void getStudentSectionAssociationTest1() throws Throwable {

		List<Student> sections = actions.getStudents();

		assert !sections.isEmpty();

		List<StudentSectionAssociation> associations = actions.getStudentSectionAssociations(sections.get(0));

		for (StudentSectionAssociation association : associations) {
			assert association.getStudentId().equals(sections.get(0).getId());
		}
	}



}
