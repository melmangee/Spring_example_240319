package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestComtroller {
	
	@Autowired
	private StudentBO studentBO;
	
	//C: create
	@GetMapping("/create")
	public StudentEntity create() {
		String name = "박진아";
		String phoneNumber = "010-1111-2222";
		String email = "jina@naver.com";
		String dreamJob = "간호사";
		
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
	
	// U: update
	@GetMapping("/update")
	public StudentEntity update() {
		// id가 7번인 dreamJob 변경(나무꾼)
		return studentBO.updateStudentDreamJobById(7, "나무꾼");
	}
	
	//D: Delete
	@GetMapping("/delete")
	public String delete() {
		// id가 8인 데이터 삭제
		studentBO.deleteStudentById(8);
		return "삭제 성공";
	}
}
