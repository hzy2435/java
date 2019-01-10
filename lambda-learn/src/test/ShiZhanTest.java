package test;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Lambda 表达式, 方法引用, StreamApi 实战
 */
public class ShiZhanTest {

	/*
	 * 模拟 get 请求参数解析 
	 * eg: http://localhost:8080/index.html?userId=1&itemId=10&keyword=12&token=388820109
	 */
	@Test
	public void test01() {

		String query = "userId=1&itemId=10&keyword=12&token=388820109";
		Map<String, String> params = Stream.of(query.split("&")).map(str -> str.split("="))
				.collect(Collectors.toMap(str -> str[0], str -> str[1]));
		System.out.println("params: " + params);
	}

	/*
	 * 获取对象列表的 id, 并封装为新的列表/字符串输出
	 */
	@Test
	public void test02() {

		List<Long> idList1 = bookList().stream().map(Book::getId).collect(Collectors.toList());
		System.out.println("idList1: " + idList1);

		// 从大到小排序
		Comparator<Long> comparator = (id1, id2) -> Long.compare(id1, id2);
		List<Long> idList2 = bookList().stream().map(Book::getId).sorted(comparator.reversed())
				.collect(Collectors.toList());
		System.out.println("idList2: " + idList2);

		// 将所有 id 以 ',' 分割并返回
		String idStr = bookList().stream().map(book -> book.getId() + "").collect(Collectors.joining(","));
		System.out.println("idStr: " + idStr);
		idStr = bookList().stream().map(book -> book.getId() + "").collect(Collectors.joining(",", "(", ")"));
		System.out.println("idStr1: " + idStr);
		idStr = bookList().stream().map(book -> "'" + book.getId() + "'").collect(Collectors.joining(",", "(", ")"));
		System.out.println("idStr2: " + idStr);
	}

	/*
	 * 获取所有类型并去重
	 */
	@Test
	public void test3() {

		List<String> typeList = bookList().stream().map(Book::getType).collect(Collectors.toList());
		System.out.println("typeList: " + typeList);
		// 去重
		typeList = bookList().stream().map(Book::getType).distinct().collect(Collectors.toList());
		System.out.println("typeList1: " + typeList);
		Set<String> typeSet = bookList().stream().map(Book::getType).collect(Collectors.toSet());
		System.out.println("typeSet: " + typeSet);

	}

	/*
	 * 排序: 1. 根据价格由大到小排序 2. 如果价格相同, 则按照出版日期由近到远排序
	 */
	@Test
	public void test4() {

		// 1. 按照价格默认排序
		System.out.println("按照价格默认由低到高排序:");
		bookList().stream().sorted((book1, book2) -> Double.compare(book1.getPrice(), book2.getPrice()))
				.forEach(System.out::println);

		// 2. 按照价格由高到低排序
		System.out.println("---------------------------");
		System.out.println("按照价格由高到低排序:");
		Comparator<Book> comparator = (book1, book2) -> Double.compare(book1.getPrice(), book2.getPrice());
		bookList().stream().sorted(comparator.reversed()).forEach(System.out::println);

		// 3. 如果价格相同则按照出版日期排序 thenComparing
		System.out.println("---------------------------");
		System.out.println("先按照价格排序, 再按照出版日期由近到远排序:");
		bookList().stream()
				.sorted(comparator.reversed()
						.thenComparing((b1, b2) -> b1.getPublishDate().isBefore(b2.getPublishDate()) ? 1 : -1))
				.forEach(System.out::println);

		// 4. 简写
		System.out.println("---------------------------");
		System.out.println("按照价格默认由低到高排序:");
		bookList().stream().sorted(Comparator.comparing(Book::getPrice)).forEach(System.out::println);

		System.out.println("---------------------------");
		System.out.println("按照价格由高到低排序:");
		bookList().stream().sorted(Comparator.comparing(Book::getPrice).reversed()).forEach(System.out::println);

		System.out.println("---------------------------");
		System.out.println("先按照价格排序, 再按照出版日期由近到远排序:");
		bookList().stream().sorted(Comparator.comparing(Book::getPrice).thenComparing(Book::getPublishDate).reversed())
				.forEach(System.out::println);

	}

	/*
	 * 将 List 转为 Map
	 */
	@Test
	public void test5() {

		Map<Long, Book> bookMap = bookList().stream().collect(Collectors.toMap(Book::getId, book -> book));
		System.out.println("bookMap.keySet: " + bookMap.keySet());
		System.out.println("bookMap: ");
		bookMap.keySet().forEach(key -> {
			System.out.println("key: " + key);
			System.out.println("value: " + bookMap.get(key));
			System.out.println("-------------------------");
		});

	}

	/*
	 * 1. 价格最大/最小 2. 出版日期最新/最旧 3. 价格最贵且出版日期最新
	 */
	@Test
	public void test6() {

		// 1. 价格最大/最小
		Optional<Book> maxPrice = bookList().stream().collect(Collectors.maxBy(Comparator.comparing(Book::getPrice)));
		System.out.println("maxPrice: " + maxPrice.get());
		Optional<Book> minPrice = bookList().stream().collect(Collectors.minBy(Comparator.comparing(Book::getPrice)));
		System.out.println("minPrice: " + minPrice.get());

		// 2. 出版日期最新/最旧
		Optional<Book> publishDate = bookList().stream()
				.collect(Collectors.maxBy(Comparator.comparing(Book::getPublishDate)));
		System.out.println("Newer publishDate: " + publishDate.get());
		publishDate = bookList().stream().collect(Collectors.minBy(Comparator.comparing(Book::getPublishDate)));
		System.out.println("Older publishDate: " + publishDate.get());

		// 3. 价格最贵且出版日期最新
		Optional<Book> book = bookList().stream()
				.collect(Collectors.maxBy(Comparator.comparing(Book::getPrice).thenComparing(Book::getPublishDate)));
		System.out.println("book: " + book);

	}

	/*
	 * 求平均价/总价
	 */
	@Test
	public void test7() {

		Double aver = bookList().stream().collect(Collectors.averagingDouble(Book::getPrice));
		System.out.println("aver: " + aver);

		Double sum = bookList().stream().collect(Collectors.summingDouble(Book::getPrice));
		System.out.println("sum: " + sum);

	}

	/*
	 * 1. 按照类别进行分组 
	 * 2. 分组类别中的书数 
	 * 3. 分组类别中的总价 
	 * 4. 分组类别中平均价 
	 * 5. 分组类别中最贵的书 
	 * 6. 分组类别中最便宜的书 
	 * 7. 分组类别中最新的书
	 */
	@Test
	public void test8() {

		// 1. 按照类别进行分组
		Map<String, List<Book>> bookMap = bookList().stream().collect(Collectors.groupingBy(Book::getType));
		System.out.println("bookMap.keySet: " + bookMap.keySet());
		bookMap.keySet().forEach(key -> {
			System.out.println("key: " + key);
			System.out.println("value: " + bookMap.get(key));
			System.out.println("--------------------------");
		});

		// 2. 分组类别中的书数
		Map<String, Long> bookCount = bookList().stream()
				.collect(Collectors.groupingBy(Book::getType, Collectors.counting()));
		System.out.println("\n\nbookCount: " + bookCount);

		// 3. 分组类别中的总价
		Map<String, Double> bookPrice = bookList().stream()
				.collect(Collectors.groupingBy(Book::getType, Collectors.summingDouble(Book::getPrice)));
		System.out.println("bookPrice: " + bookPrice);

		// 4. 分组类别中平均价
		Map<String, Double> bookAverPrice = bookList().stream()
				.collect(Collectors.groupingBy(Book::getType, Collectors.averagingDouble(Book::getPrice)));
		System.out.println("bookAverPrice: " + bookAverPrice);

		// 5. 分组类别中最贵的书
		Map<String, Optional<Book>> maxPriceBook = bookList().stream()
				.collect(Collectors.groupingBy(Book::getType, Collectors.maxBy(Comparator.comparing(Book::getPrice))));
		System.out.println("maxPriceBook: " + maxPriceBook);

		// 6. 分组类别中最便宜的书
		Map<String, Optional<Book>> minPriceBook = bookList().stream()
				.collect(Collectors.groupingBy(Book::getType, Collectors.minBy(Comparator.comparing(Book::getPrice))));
		System.out.println("minPriceBook: " + minPriceBook);

		// 7. 分组类别中最新的书
		Map<String, Optional<Book>> newerBook = bookList().stream().collect(
				Collectors.groupingBy(Book::getType, Collectors.maxBy(Comparator.comparing(Book::getPublishDate))));
		System.out.println("newBook: " + newerBook);

	}

	/*
	 * 过滤, 找出所有价格大于100的书, 并按出版日期排序
	 */
	@Test
	public void test9() {

		bookList().stream().filter(book -> book.getPrice() > 100d)
				.sorted(Comparator.comparing(Book::getPublishDate).reversed()).forEach(System.out::println);

	}

	private List<Book> bookList() {

		List<Book> bookList = new ArrayList<>();

		bookList.add(new Book(1L, "Java 核心卷", 123d, "编程语言", LocalDate.parse("2010-07-28")));
		bookList.add(new Book(2L, "Java 编程思想", 150d, "编程语言", LocalDate.parse("2008-10-18")));
		bookList.add(new Book(3L, "Python", 55d, "编程语言", LocalDate.parse("2015-11-20")));
		bookList.add(new Book(4L, "Html", 60d, "编程语言", LocalDate.parse("2013-09-02")));
		bookList.add(new Book(5L, "JavaScript", 99d, "编程语言", LocalDate.parse("2010-10-31")));
		bookList.add(new Book(6L, "Linux", 99d, "系统运维", LocalDate.parse("2009-03-13")));
		bookList.add(new Book(7L, "Windows", 55d, "系统运维", LocalDate.parse("2006-04-04")));
		bookList.add(new Book(8L, "Mysql", 123d, "数据库", LocalDate.parse("2014-12-13")));
		bookList.add(new Book(9L, "Oracle", 123d, "数据库", LocalDate.parse("2012-05-28")));
		bookList.add(new Book(10L, "TCP/Ip 协议详解", 145d, "网络", LocalDate.parse("2007-12-03")));
		bookList.add(new Book(11L, "Http 权威指南", 155d, "网络", LocalDate.parse("2011-02-16")));
		bookList.add(new Book(12L, "Netty", 88d, "服务器", LocalDate.parse("2016-08-18")));
		bookList.add(new Book(13L, "Tomcat", 66d, "服务器", LocalDate.parse("2010-11-23")));
		bookList.add(new Book(14L, "算法导论", 201d, "其他", LocalDate.parse("2009-07-04")));
		bookList.add(new Book(15L, "系统安全", 200d, "其他", LocalDate.parse("2000-01-15")));
		bookList.add(new Book(16L, "算法导论(第二版)", 201d, "其他", LocalDate.parse("2014-09-01")));

		return bookList;
	}

}
