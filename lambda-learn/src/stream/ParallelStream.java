package stream;

import java.util.Optional;
import java.util.stream.Stream;

/*
 * Stream 的多线程: parallel
 */
public class ParallelStream {

	public static void main(String[] args) {
		
		// 设置 Stream 并行线程数
		// 方式1: 在运行时指定: -Djava.util.concurrent.ForkJoinPool.common.parallelism=4
		// 方式2: 通过 System 指定
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "4");

		Optional<Integer> max = Stream.iterate(1, x -> x + 1).limit(200).peek(x -> {
			System.out.println(x + ": " + Thread.currentThread().getName());
		}).parallel().max(Integer::compare);

		System.out.println("max: " + max.get());
	}

}
