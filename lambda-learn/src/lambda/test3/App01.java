package lambda.test3;

import java.util.function.Supplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.BiFunction;

/*
 * 静态方法引用 类名::staticMethod
 */
public class App01 {
	public static void main(String[] args) {
		// 1. 有参无返回值
		Consumer<String> c1 = (str) -> {System.out.println(str);};
		Consumer<String> c2 = str -> System.out.println(str);
		Consumer<String> c3 = App01::printStr;
		c3.accept("c3: hello world");
		
		// 2. 无参有返回值
		Supplier<String> s1 = () -> {return "s1: hello world";};
		Supplier<String> s2 = () -> "s1: hello world";
		Supplier<String> s3 = App01::getStr;
		System.out.println(s3.get());
		
		// 3. 有参有返回值
		Function<String, Integer> f1 = (str) -> {return str.length();};
		Function<String, Integer> f2 = str -> str.length();
		Function<String, Integer> f3 = App01::getLen;
		System.out.println("f3: " + f3.apply("hello world"));
		
		// 4. 两个输入一个输出
		BiFunction<String, String, Integer> bf1 = (str1, str2) -> {return str1.length() + str2.length();};
		BiFunction<String, String, Integer> bf2 = (str1, str2) -> str1.length() + str2.length();
		BiFunction<String, String, Integer> bf3 = App01::getLen1;
		System.out.println(bf3.apply("java", "ee"));
	}
	
	public static void printStr(String str) {
		System.out.println(str);
	}
	
	public static String getStr() {
		return "s3: hello world";
	}
	
	public static Integer getLen(String str) {
		return str.length();
	}
	
	public static Integer getLen1(String str1, String str2) {
		return str1.length() + str2.length();
	}
}
