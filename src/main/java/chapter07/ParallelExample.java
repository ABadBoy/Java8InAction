package chapter07;

import java.util.stream.Stream;

public class ParallelExample {

	public static void main(String[] args) {
		System.out.println(parallelSum(10));
	}

	public static long parallelSum(long n) {
		return Stream.iterate(1l, i -> i + 1).limit(n).parallel().reduce(0l, Long::sum);
	}
}
