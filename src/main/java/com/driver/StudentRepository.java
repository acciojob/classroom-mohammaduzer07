package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentRepository {

    private List<Student> studentList = new ArrayList<>();
    private List<Teacher> teacherList = new ArrayList<>();

    private HashMap<Teacher, List<Student>> studentTeacherMap = new HashMap<>();
    public void addStudent(Student student){
        studentList.add(student);
    }
    public void addTeacher(Teacher teacher){
        teacherList.add(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher){
        Teacher teacher1 = getTeacherByName(teacher);
        Student student1 = getStudentByName(student);

        List<Student> tempList = studentTeacherMap.getOrDefault(teacher1, new ArrayList<>());
        tempList.add(student1);
        studentTeacherMap.put(teacher1, tempList);
    }

    public Student getStudentByName(String name){
        for(Student student : studentList){
            if(student.getName().equals(name))
                return student;
        }
        return new Student();
    }
    public Teacher getTeacherByName(String name){
        for(Teacher teacher : teacherList){
            if(teacher.getName().equals(name))
                return teacher;
        }
        return new Teacher();
    }
    public List<String> getStudentsByTeacherName(String teacher){
        List<String> allStudentByTeacherName = new ArrayList<>();
        Teacher teacher1 = getTeacherByName(teacher);
        List<Student> studentList1 = studentTeacherMap.getOrDefault(teacher1, new ArrayList<>());
        for(Student student : studentList1){
            allStudentByTeacherName.add(student.getName());
        }
        return allStudentByTeacherName;
    }
    public List<String> getAllStudent(){
        List<String> allStudent = new ArrayList<>();
        for(Student student : studentList){
            allStudent.add(student.getName());
        }
        return allStudent;
    }

    public void deleteTeacherByName(String name){
        Teacher teacher = getTeacherByName(name);
        List<Student> removeTeach_Student = studentTeacherMap.getOrDefault(teacher,new ArrayList<>());
        for(Student student : removeTeach_Student){
            studentList.remove(student);
        }
        studentTeacherMap.remove(teacher);
        teacherList.remove(teacher);
    }
    public void deleteAllTeachers(){
        for(Teacher teacher : new ArrayList<>(teacherList)){
            deleteTeacherByName(teacher.getName());
        }
        teacherList.clear();
        studentTeacherMap.clear();
    }
}
