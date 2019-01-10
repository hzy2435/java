package lambda.test3;

import java.util.function.Consumer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/*
 * 构造方法引用
 */
public class App04 {

	public static void main(String[] args) {
		
		// 1. 无参构造方法引用
		Runnable r1 = () -> new Student();
		Runnable r2 = Student::new;
		r2.run();
		
		// 2. 一个参数的构造方法引用
		Consumer<String> s1 = str -> new Student(str);
		Consumer<String> s2 = Student::new;
		s2.accept("myname");
		
		Consumer<Integer> s3 = a -> new Student(a);
		Consumer<Integer> s4 = Student::new;
		s4.accept(56);
		
		// 3. 两个参数的构造方法引用
		BiConsumer<String, Integer> bf1 = (name, age) -> new Student(name, age);
		BiConsumer<String, Integer> bf2 = Student::new;
		bf2.accept("xiaobai", 23);
		
		// 4. jdk
		Consumer<List> cl = ArrayList::new;
		
	}
	
}

class Student {
	String name;
	Integer age;
	
	public Student() {
		System.out.println("Person()");
	}
	
	public Student(String name) {
		System.out.println("Persion(name): " + name);
	}
	
	public Student(Integer age) {
		System.out.println("Person(age): " + age);
	}
	
	public Student(String name, Integer age) {
		System.out.println("Person(name, age): name: " + name + ", age: " + age);
	}
}
