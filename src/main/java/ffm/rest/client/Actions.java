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

		// Remove this header to actually persist changes
		resty.withHeader("Testing", "true");
	}

	public List<Teacher> getTeachers() {
		return Arrays.asList(get("/teachers",  Teacher[].class));
	}

	public Teacher getTeacher(String email) {
		return get("/teachers/" + email, Teacher.class);
	}

	public List<Student> getStudents(){
		return Arrays.asList(get("/students", Student[].class));
	}

	public List<Student> getStudents(Section section){
		return Arrays.asList(get("/sections/"+section.getId()+"/students", Student[].class));
	}

	public Student getStudent(String id) {
		return get("/students/" + id, Student.class);
	}

	public List<Section> getSections(){
		return Arrays.asList(get("/sections", Section[].class));
	}

	public List<Section> getSections(Teacher teacher){
		return Arrays.asList(get("/teachers/"+teacher.getId()+"/sections", Section[].class));
	}

	public Section getSection(String id) {
		return get("/sections/" + id, Section.class);
	}

	public List<School> getSchools(){
		return Arrays.asList(get("/schools", School[].class));
	}

	public School getSchool(String id) {
		return get("/schools/" + id, School.class);
	}

	public List<StudentSectionAssociation> getStudentSectionAssociations(Student student){
		return Arrays.asList(get("/students/" + student.getId() + "/studentSectionAssociations", StudentSectionAssociation[].class));
	}

	public List<StudentSectionAssociation> getStudentSectionAssociations(Section section){
		return Arrays.asList(get("/sections/"+section.getId()+"/studentSectionAssociations", StudentSectionAssociation[].class));
	}






























	private String read(JSONResource res) throws IOException {
		return new BufferedReader(new InputStreamReader(res.stream())).readLine();
	}

	private <T> T get(String relative, Class<T> clazz) {
		try {
			return gson.fromJson(read(resty.json(root + relative)), clazz);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}


}
