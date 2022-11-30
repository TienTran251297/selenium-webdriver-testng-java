package javaBasic;

public class Student {

	String name;
	int age;
	
	public Student(String name, int age) {
		this.name =  name;
		this.age = age;
	}
	
	public void display () {
		System.out.println("name: " + name);
		System.out.println("age: " + age);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] students = new Student[3];
		students[0] = new Student("a", 1);
		students[1] = new Student("b", 2);
		students[2] = new Student("c", 3);
		for (int i = 0; i < 3; i++) {
			students[i].display();
		}
	}
}
