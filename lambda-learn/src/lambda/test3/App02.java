package lambda.test3;

import java.util.function.Supplier;
import java.util.function.Consumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/*
 * 实例方法引用
 */
public class App02 {
	public static void main(String[] args) {
		
		Person p = new Person();
		
		// 1. 无参无返回值
		Runnable r1 = () -> System.out.println("r1: hello runnable.");
		Runnable r2 = new Person()::run1;
		r2.run();
		
		// 2. 无参有返回值
		Supplier<String> s1 = () -> new Person().run2();
		Supplier<String> s2 = new Person()::run2;
		System.out.println(s2.get());
		
		// 3. 有参无返回值
		Consumer<Integer> c1 = (n) -> new Person().run3(n);
		Consumer<Integer> c2 = new Person()::run3;
		c2.accept(100);
		
		// 4. 有参有返回值
		Function<String, String> f1 = str -> new Person().upperCase(str);
		Function<String, String> f2 = p::upperCase;
		System.out.println(f2.apply("java se"));
		
		BiFunction<String, String, Integer> bf1 = (str1, str2) -> p.getLength(str1, str2);
		BiFunction<String, String, Integer> bf2 = p::getLength;
		System.out.println(bf2.apply("java", "ee"));
	}
	
}

class Person {
	public void run1() {
		System.out.println("r2: run...");
	}
	
	public String run2() {
		return "a2 is run....";
	}
	
	public void run3(Integer n) {
		System.out.println("c2 is run with " + n);
	}
	
	public String upperCase(String str) {
		return str.toUpperCase();
	}
	
	public Integer getLength(String s1, String s2) {
		return s1.length() + s2.length();
	}
}