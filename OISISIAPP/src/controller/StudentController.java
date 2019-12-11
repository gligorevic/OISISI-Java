package controller;

import model.BazaStudent;

public class StudentController {
	private static StudentController instance = null;

	public static StudentController getInstance() {
		if(instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	
	private StudentController() {}
	
	
	public boolean checkIfStudentExist(String index) {
		return BazaStudent.getInstance().checkExistance(index);
	}
}
