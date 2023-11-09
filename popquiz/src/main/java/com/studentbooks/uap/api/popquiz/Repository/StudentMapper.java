package com.studentbooks.uap.api.popquiz.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.studentbooks.uap.api.popquiz.models.Student;

@Mapper
public interface StudentMapper {
	
	@Insert("INSERT INTO borrower_info (student_number, student_name) VALUES (#{studentNumber}, #{studentName})")
    void insertStudent(Student student);
    Student selectStudentById(Long id);
    List<Student> selectAllStudents();
}