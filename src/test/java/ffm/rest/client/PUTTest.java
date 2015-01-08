package ffm.rest.client;

import ffm.rest.client.enums.SchoolYear;
import ffm.rest.client.model.School;
import ffm.rest.client.model.Section;
import ffm.rest.client.model.Student;
import ffm.rest.client.model.Teacher;
import org.junit.Before;
import org.junit.Test;

public class PUTTest {

	Actions actions;

	@Before
	public void setup() {
		actions = new Actions("http://rest.forefrontmath.com");
//		actions = new Actions("http://localhost:8080");
	}

	@Test
	public void createTeacherTest() throws Throwable {

		School school = new School();

		school.setName("School Name");

		school.setId("SchoolID");

		actions.createSchool(school);

		Teacher teacher = new Teacher();

		teacher.setFirstname("Firstname");

		teacher.setId("teacher@example.org");

		teacher.setLastname("Lastname");

		teacher.setSchool(school);

		actions.createTeacher(teacher);

		Teacher teacher1 = actions.getTeacher("teacher@example.org");

		assert teacher1.getLastname().equals(teacher.getLastname());

		assert teacher1.getFirstname().equals(teacher.getFirstname());

		assert teacher1.getId().equals(teacher.getId());

		assert teacher1.getSchool().getId().equals("SchoolID");

		actions.deleteTeacher("teacher@example.org");

		actions.deleteSchool(school.getId());

		assert actions.getTeacher("teacher@example.org") == null;

	}

	@Test
	public void createStudentTest() throws Throwable {

		Student student = new Student();

		student.setFirstname("Firstname");

		student.setId("student@example.org");

		student.setLastname("Lastname");

		actions.createStudent(student);

		Student student1 = actions.getStudent("student@example.org");

		assert student1.getLastname().equals(student.getLastname());

		assert student1.getFirstname().equals(student.getFirstname());

		assert student1.getId().equals(student.getId());

		actions.deleteStudent("student@example.org");

		assert actions.getStudent("student@example.org") == null;

	}

	@Test
	public void createSchoolTest() throws Throwable {

		School school = new School();

		school.setName("School Name");

		school.setId("SchoolID");

		actions.createSchool(school);

		School school1 = actions.getSchool("SchoolID");

		assert school1.getName().equals(school.getName());

		assert school1.getId().equals(school.getId());

		actions.deleteSchool("SchoolID");

		assert actions.getSchool("SchoolID") == null;

	}

	@Test
	public void createSectionTest() throws Throwable {

		Section section = new Section();

		section.setName("Section Name");

		section.setId("SectionID");

		section.setSchoolYear(SchoolYear.current());

		section.setSchoolId("SchoolID");

		School school = new School();

		school.setName("School Name");

		school.setId("SchoolID");

		Teacher teacher = new Teacher();

		teacher.setFirstname("Firstname");

		teacher.setId("teacher@example.org");

		teacher.setLastname("Lastname");

		teacher.setSchool(school);

		section.getTeachers().add(teacher);

		actions.createSchool(school);

		actions.createTeacher(teacher);

		actions.createSection(section);

		Section section1 = actions.getSection("SectionID");

		assert section1.getName().equals(section.getName());

		assert section1.getId().equals(section.getId());

		assert section1.getSchoolYear().equals(SchoolYear.current());

		assert section1.getSchoolId().equals("SchoolID");

		assert section1.getTeachers().get(0).getFirstname().equals("Firstname");

		assert section1.getTeachers().get(0).getLastname().equals("Lastname");

		assert section1.getTeachers().get(0).getId().equals("teacher@example.org");

		actions.deleteSection("SectionID");

		actions.deleteTeacher(teacher.getId());

		actions.deleteSchool("SchoolID");

		assert actions.getSection("SectionID") == null;

	}


}
