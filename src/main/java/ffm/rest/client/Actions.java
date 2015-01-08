package ffm.rest.client;

import com.google.gson.Gson;
import ffm.rest.client.model.*;
import us.monoid.web.JSONResource;
import us.monoid.web.Resty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Actions {

	private String root;
	private Resty resty;
	private Gson gson = new Gson();

	public Actions(String rootURL) {
		this.resty = new Resty();
		this.root = rootURL;
		resty.withHeader("District", "default");
		resty.withHeader("Authorization", "c86646d6-88e0-11e4-b116-123b93f75cba");
	}

	public List<Teacher> getTeachers() {
		return Arrays.asList(get("/teachers", Teacher[].class));
	}

	public Teacher getTeacher(String email) {
		return get("/teachers/" + email, Teacher.class);
	}

	public List<Student> getStudents() {
		return Arrays.asList(get("/students", Student[].class));
	}

	public List<Student> getStudents(Section section) {
		return Arrays.asList(get("/sections/" + section.getId() + "/students", Student[].class));
	}

	public Student getStudent(String id) {
		return get("/students/" + id, Student.class);
	}

	public List<Section> getSections() {
		return Arrays.asList(get("/sections", Section[].class));
	}

	public List<Section> getSections(Teacher teacher) {
		return Arrays.asList(get("/teachers/" + teacher.getId() + "/sections", Section[].class));
	}

	public Section getSection(String id) {
		return get("/sections/" + id, Section.class);
	}

	public List<School> getSchools() {
		return Arrays.asList(get("/schools", School[].class));
	}

	public School getSchool(String id) {
		return get("/schools/" + id, School.class);
	}

	public List<StudentSectionAssociation> getStudentSectionAssociations(Student student) {
		return Arrays.asList(get("/students/" + student.getId() + "/studentSectionAssociations", StudentSectionAssociation[].class));
	}

	public List<StudentSectionAssociation> getStudentSectionAssociations(Section section) {
		return Arrays.asList(get("/sections/" + section.getId() + "/studentSectionAssociations", StudentSectionAssociation[].class));
	}

	public List<StudentSchoolAssociation> getStudentSchoolAssociations(Student student) {
		return Arrays.asList(get("/students/" + student.getId() + "/studentSchoolAssociations", StudentSchoolAssociation[].class));
	}

	public List<StudentSchoolAssociation> getStudentSchoolAssociations(School section) {
		return Arrays.asList(get("/schools/" + section.getId() + "/studentSchoolAssociations", StudentSchoolAssociation[].class));
	}

	public void updateStudent(Student student) {
		post("/students/" + student.getId(), student);
	}

	public void updateTeacher(Teacher student) {
		post("/teachers/" + student.getId(), student);
	}

	public void updateSchool(School student) {
		post("/schools/" + student.getId(), student);
	}

	public void updateSection(Section student) {
		post("/sections/" + student.getId(), student);
	}

	public void updateStudentSectionAssociation(StudentSectionAssociation student) {
		post("/studentSectionAssociations/" + student.getId(), student);
	}

	public void updateStudentSchoolAssociation(StudentSchoolAssociation student) {
		post("/studentSchoolAssociations/" + student.getId(), student);
	}

	public void createTeacher(Teacher teacher) {
		put("/teachers/", teacher);
	}

	public void deleteTeacher(String id) {
		delete("/teachers/", id);
	}

	public void createStudent(Student teacher) {
		put("/students/", teacher);
	}

	public void deleteStudent(String id) {
		delete("/students/", id);
	}

	public void createSchool(School teacher) {
		put("/schools/", teacher);
	}

	public void deleteSchool(String id) {
		delete("/schools/", id);
	}

	public void createSection(Section teacher) {
		put("/sections/", teacher);
	}

	public void deleteSection(String id) {
		delete("/sections/", id);
	}

	public void createStudentSchoolAssociation(StudentSchoolAssociation teacher) {
		put("/studentSchoolAssociation/", teacher);
	}

	public void deleteStudentSchoolAssociation(String id) {
		delete("/studentSchoolAssociation/", id);
	}

	public void createStudentSectionAssociation(StudentSchoolAssociation teacher) {
		put("/studentSectionAssociation/", teacher);
	}

	public void deleteStudentSectionAssociation(String id) {
		delete("/studentSectionAssociation/", id);
	}


	private String read(JSONResource res) throws IOException {
		return new BufferedReader(new InputStreamReader(res.stream())).readLine();
	}

	private <T> T get(String relative, Class<T> clazz) {
		try {
			return gson.fromJson(read(resty.json(root + relative)), clazz);
		} catch (IOException e) {
			return null;
		}
	}

	private void post(String relative, Object object) {
		try {
			resty.json(root + relative, Resty.content(gson.toJson(object)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void put(String relative, Object object) {
		try {
			resty.json(root + relative, Resty.put(Resty.content(gson.toJson(object))));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void delete(String relative, String id) {
		try {
			resty.json(root + relative + id, Resty.delete());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
