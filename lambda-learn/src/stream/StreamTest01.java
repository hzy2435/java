package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * Stream API
 */
public class StreamTest01 {

	/*
	 * Stream 源source的5种创建方式
	 */
	// 1. 由数组创建
	static void gen1() {
		String[] arr = { "aaa", "bbb", "ccc", "ddd", "eee" };
		Stream<String> stream = Stream.of(arr);
		stream.forEach(System.out::println);
	}

	// 2. 由集合创建
	static void gen2() {
		List<String> list = Arrays.asList("abc", "cdx", "poi", "lok");
		Stream<String> stream = list.stream();
		stream.forEach(System.out::println);
	}

	// 3. 由 Stream.generate() 创建
	static void gen3() {
		Stream<Integer> stream = Stream.generate(() -> 1);
		stream.limit(20).forEach(System.out::println);
	}

	// 4. 由 Stream.iterate() 创建
	static void gen4() {
		Stream<Integer> stream = Stream.iterate(1, x -> x + 1);
		stream.limit(20).forEach(System.out::println);
	}

	// 5. 其他 api 创建
	static void gen5() throws IOException {

		String str = "abcdefg";
		IntStream stream = str.chars();
		stream.forEach(System.out::println); // stream.foreach(x -> System.out.println(x));

		Files.lines(Paths.get("D:\\D\\Project\\Java\\STS_Workspace\\java\\.gitignore")).forEach(System.out::println);

	}

	public static void main(String[] args) throws IOException {

//		StreamTest01.gen1();
//		StreamTest01.gen2();
//		StreamTest01.gen3();
//		StreamTest01.gen4();
//		StreamTest01.gen5();

//		Arrays.asList(9, 2, 47, 3, 5, 1, 4, 8, 6).stream().filter(x -> x % 2 == 0).forEach(System.out::println);
//		int sum = Arrays.asList(9, 2, 47, 3, 5, 1, 4, 8, 6).stream().filter(x -> x % 2 == 0).mapToInt(x -> x).sum();
//		System.out.println("sum: " + sum);
//
//		Optional<Integer> max = Arrays.asList(9, 2, 47, 3, 5, 1, 4, 8, 6).stream().filter(x -> x % 2 == 0)
//				.max((a, b) -> a - b);
//		System.out.println("max: " + max.get());
//
//		Optional<Integer> min = Arrays.asList(9, 2, 47, 3, 5, 1, 4, 8, 6).stream().filter(x -> x % 2 == 1)
//				.min((a, b) -> a - b);
//		System.out.println("min: " + min.get());
//
//		Optional<Integer> opt = Arrays.asList(9, 10, 47, 3, 5, 1, 4, 8, 6).stream().filter((x -> x % 2 == 0)).findAny();
//		System.out.println("findAny: " + opt.get());
//		opt = Arrays.asList(9, 10, 47, 3, 5, 1, 4, 8, 6).stream().filter(x -> x % 2 == 0).findFirst();
//		System.out.println("findFirst: " + opt.get());
//		opt = Arrays.asList(9, 10, 47, 3, 5, 1, 4, 8, 6).stream().filter(x -> x % 2 == 0).sorted().findFirst();
//		System.out.println("sorted.findFirst: " + opt.get());
//		opt = Arrays.asList(9, 10, 47, 3, 5, 1, 4, 8, 6).stream().filter(x -> x % 2 == 0).sorted((a, b) -> b - a).findFirst();
//		System.out.println("sorted.findFirst: " + opt.get());
//		
//		Arrays.asList(9, 10, 47, 3, 5, 1, 4, 8, 6).stream().sorted().forEach(System.out::println);
//		Arrays.asList(9, 10, 47, 3, 5, 1, 4, 8, 6).stream().sorted((a, b) -> b - a).forEach(System.out::println);
		
//		Arrays.asList("no", "hzy", "lps", "hzyailps", "2017").stream().sorted((a, b) -> a.length() - b.length()).forEach(System.out::println);
		
		// 找出1-50内所有的偶数, 并存到 list
//		List<Integer> list = Stream.iterate(1, x -> x + 1).limit(50).filter(x -> x % 2 == 0).collect(Collectors.toList());
//		System.out.println(list);
		
//		Arrays.asList(1, 7, 2, 3, 90, 38, 5, 2, 3, 6, 38).stream().distinct().forEach(System.out::println);
//		Set<Integer> set = Arrays.asList(1, 7, 2, 3, 90, 38, 5, 2, 3, 6, 38).stream().collect(Collectors.toSet());
//		System.out.println("set: " + set);
		
		// 模拟分页
//		Stream.iterate(1, x -> x + 1).skip(20).limit(10).forEach(System.out::println);
		
		// 将字符串转int, 并求和
//		String[] str = {"111", "222", "333", "444", "555"};
//		int sum1 = Stream.of(str).mapToInt(x -> Integer.valueOf(x)).sum();
//		System.out.println("sum1: " + sum1);
//		int sum2 = Stream.of(str).mapToInt(Integer::valueOf).sum();
//		System.out.println("sum2: " + sum2);
		
		int sum3 = Arrays.asList(13, 28, 1, 23, 89).stream().mapToInt(Integer::valueOf).peek(System.out::println).sum();
		System.out.println("sum3: " + sum3);
		
	}

}
