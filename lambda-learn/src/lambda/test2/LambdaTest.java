package lambda.test2;

import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LambdaTest {

	public static void main(String[] args) throws Exception {
		// 1. 没有参数也没有返回值
		Runnable r1 = new Runnable() {
			public void run() {
				System.out.println("r1 run...");
			}
		};
		r1.run();
		
		Runnable r2 = () -> {System.out.println("r2 run...");};
		r2.run();
		
		Runnable r3 = () -> System.out.println("r3 run...");
		r3.run();
		System.out.println("----------------------------------");
		
		// 2. 没有参数有返回值
		Callable<String> c1 = new Callable<String>() {
			public String call() throws Exception {
				return "hello c1";
			}
		};
		
		Callable<String> c2 = () -> {return "hello c2";};
		
		Callable<String> c3 = () -> "hello c3";
		
		System.out.println(c1.call());
		System.out.println(c2.call());
		System.out.println(c3.call());
		System.out.println("----------------------");
		
		// 3. 有参数没有返回值
		UserMapper uerMapper1 = new UserMapper() {
			public void insert(User user) {
				System.out.println("userMapper1: " + user);
			}
		};
		
		UserMapper uerMapper2 = (User user) -> {System.out.println("uerMapper2: " + user);};
		
		UserMapper uerMapper3 = user -> System.out.println("uerMapper3: " + user);
		
		uerMapper1.insert(new User());
		uerMapper2.insert(new User());
		uerMapper3.insert(new User());
		System.out.println("----------------------------------");
		
		// 4. 有参数也有返回值
		OrderMapper orderMapper1 = new OrderMapper() {
			public int insert(Order order) {
				System.out.println("orderMapper1: " + order);
				return 1;
			}
			
		};
		
		OrderMapper orderMapper2 = order -> {return 1;};
		
		OrderMapper orderMapper3 = order -> 1;
		
		System.out.println("orderMapper1: " + orderMapper1.insert(new Order()));
		System.out.println("orderMapper2: " + orderMapper2.insert(new Order()));
		System.out.println("orderMapper3: " + orderMapper3.insert(new Order()));
		
		// 5. 调用函数时注意事项
		Runnable r4 = () -> get();
		Runnable r5 = () -> exec();
		
		Supplier<Integer> s = () -> get();
//		Supplier<Integer> s = () -> exec();	// 调用的方法无返回值, 所以报错
		
		BiFunction<String, String, Integer> f = (str1, str2) -> str1.length() + str2.length();
		System.out.println(f.apply("java", "se"));
		
		UnaryOperator<Integer> u = n -> {
			int sum = 0;
			for(int i = 0; i < n; i++) {
				sum += i;
			}
			return sum;
		};
		
		System.out.println(u.apply(10));
	}
	
	static int get() {
		return 1;
	}
	
	static void exec() {
		
	}
	
}

interface UserMapper {
	void insert(User user);
}

interface OrderMapper {
	int insert(Order order);
}

class User {
	
}

class Order {
	
}
