package com.driver;

import java.util.List;

public class StudentService {

    StudentRepository SR = new StudentRepository();

    public void addStudent(Student student){
        SR.addStudent(student);
    }
    public void addTeacher(Teacher teacher){
        SR.addTeacher(teacher);
    }
    public void addStudentTeacherPair(String student, String teacher){
        SR.addStudentTeacherPair(student, teacher);
    }
    public Student getStudentByName(String name){
        return SR.getStudentByName(name);
    }
    public Teacher getTeacherByName(String name){
        return SR.getTeacherByName(name);
    }
    public List<String> getStudentByTeacherName(String teacher){
        return SR.getStudentsByTeacherName(teacher);
    }
    public List<String> getAllStudent(){
        return SR.getAllStudent();
    }
    public void deleteTeacherByName(String teacherName){
        SR.deleteTeacherByName(teacherName);
    }
    public void deleteAllTeachers(){
        SR.deleteAllTeachers();
    }
}
