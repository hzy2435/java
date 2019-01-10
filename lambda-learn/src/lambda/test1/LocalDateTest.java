package lambda.test1;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/*
 * 常见不可变对象
 */
public class LocalDateTest {

	public static void main(String[] args) {
		// jdk1.8 之前
		BigDecimal a = new BigDecimal("100");
		BigDecimal b = a.add(new BigDecimal("200"));
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		
		// 1.8 新的日期操作类
		LocalDate now1 = LocalDate.now();
		LocalDate now2 = now1.plusDays(1);
		System.out.println("now1: " + now1);
		System.out.println("now2: " + now2);
		
		LocalDateTime time1 = LocalDateTime.now();
		System.out.println("time1: " + time1);
	}
	
}
