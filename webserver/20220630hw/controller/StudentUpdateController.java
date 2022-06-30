package com.kh.student.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.common.AbstractController;
import com.kh.student.model.dto.Student;
import com.kh.student.model.service.StudentService;

public class StudentUpdateController extends AbstractController {
	private StudentService studentService;

	public StudentUpdateController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 입력값 처리
		int no = Integer.parseInt(request.getParameter("no"));
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		LocalDateTime now = LocalDateTime.now();
		Student student = new Student(no, name, tel, null, now, null);
		System.out.println("studentUpdate = " + student);
		
		// 업무로직
		int result = studentService.updateStudent(student);
		
		// 비동기 응답
		response.setContentType("application/json;charset=utf-8");
		new Gson().toJson(student, response.getWriter());
		
		return null;
	}
	
}
