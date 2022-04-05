package com.io.employee.run;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.io.employee.model.vo.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		EmployeeTest test = new EmployeeTest();
		test.saveEmployee();
		test.loadEmployee();
	}

	private void loadEmployee() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.dat"));){
			Employee[] emp = new Employee[3];
			
			for(int i = 0; i < emp.length; i++) {
				emp[i] = (Employee)ois.readObject();
				emp[i].printEmployee();
			}
		} catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private void saveEmployee() {
		Employee[] emp = new Employee[3];
		emp[0] = new Employee(1, "홍길동", '남', "01012341234", "영업부", 1_000_000 , 10);
		emp[1] = new Employee(2, "신사임당", '여', "01012333333", "구매부", 2_000_000 , 15);
		emp[2] = new Employee(3, "세종대왕", '남', "01023444444", "홍보부", 3_000_000 , 20);
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.dat"));) {
			for(int i = 0; i < emp.length; i++) {
				oos.writeObject(emp[i]);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
