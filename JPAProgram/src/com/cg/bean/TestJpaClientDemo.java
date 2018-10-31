package com.cg.bean;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.cg.dao.StudentDaoImpl;


public class TestJpaClientDemo 
{

	public static void main(String[] args)
	{
		StudentDaoImpl stoDao=new StudentDaoImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter Roll No:");
		int rn=sc.nextInt();
		System.out.println("Enter student name");
		String nm=sc.next();
		
		Student st = new Student();
		st.setRollNo(rn);
		st.setStuName(nm);
		Student stu=stoDao.addStudent(st);
		System.out.println("Date Inserted in the table"+stu);
		System.out.println("----------retrieve the student based on roll number");
		Student student=stoDao.getStuByRollNo(123);
		System.out.println(student);
		System.out.println("Retrieve all data and Display");
		List<Student> stList = stoDao.getAllStudents();
		Iterator<Student> it=stList.iterator();
		System.out.println("RollNo\t\t\t STUNAME");
		System.out.println("----------------------------------------------------");
		while(it.hasNext()){
			Student tempStu=it.next();
			System.out.println(tempStu.getRollNo()+"\t\t"+tempStu.getStuName());
		}
		System.out.println("Deleter 123 roll number");
		System.out.println("RecordDeleted for:"+ stoDao.deleteStudent(123));
		System.out.println("----------Update name----------");
		Student st3=stoDao.updateStudentName(28, "swetha");
		System.out.println("Updated:"+st3);
	}

}
