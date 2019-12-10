package controller;

public class StudentController {
	private static StudentController instance = null;

	public static StudentController getInstance() {
		if(instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	
	private StudentController() {}
	
	//Provera da li student sa indexom postoji u bazi
	public boolean checkIfStudentExist(String index) {
		return false;
	}
}
