package lambda.test3;

import java.util.function.Consumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/*
 * 对象方法引用
 */
public class App03 {
	public static void main(String[] args) {
		// 1. 一个输入, 零个输出
		Consumer<Foo> c1 = f -> f.getString1();
		Consumer<Foo> c2 = Foo::getString1;
		c2.accept(new Foo());
		
		// 2. 一个输入, 一个输出
		Function<Foo, Integer> f1 = f -> f.getLength();
		Function<Foo, Integer> f2 = Foo::getLength;
		System.out.println("f2: " + f2.apply(new Foo()));
		
		// 3. 两个输入, 一个输出
		BiFunction<Foo, String, Integer> bf1 = (f, str) -> f.getLength(str);
		BiFunction<Foo, String, Integer> bf2 = Foo::getLength;
		System.out.println("bf2: " + bf2.apply(new Foo(), "hello world."));
	}
}

class Foo {
	public void getString1() {
		System.out.println("c2: hello");
	}
	
	public Integer getLength() {
		return "hello".length();
	}
	
	public Integer getLength(String str) {
		return str.length();
	}
}