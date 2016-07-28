package chapter03;

import chapter02.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference {

	public static void main(String[] args) {

		/*method references*/
		List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));
		inventory.sort(Comparator.comparing(Apple::getWeight));
		System.out.println(inventory);

		List<String> list1 = Arrays.asList("a", "b", "A", "B");
		list1.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
		System.out.println(list1);

		List<String> list2 = Arrays.asList("a", "b", "A", "B");
		list2.sort(String::compareToIgnoreCase);
		System.out.println(list2);

		/*Constructor references*/
		Supplier<Apple> newApple1 = Apple::new;
		Apple apple1 = newApple1.get();
		System.out.println(apple1);

		Function<Integer, Apple> newApple2 = Apple::new;
		Apple apple2 = newApple2.apply(10);
		System.out.println(apple2);

		List<Integer> weights = Arrays.asList(3, 2, 1);
		List<Apple> appleList = map(weights, Apple::new);
		System.out.println(appleList);

		BiFunction<Integer, String, Apple> newApple3 = Apple::new;
		Apple apple3 = newApple3.apply(200, "yellow");
		System.out.println(apple3);


	}

	public static List<Apple> map(List<Integer> list, Function<Integer, Apple> function) {
		List<Apple> apples = new ArrayList<>();
		for (Integer integer : list) {
			apples.add(function.apply(integer));
		}
		return apples;
	}
}

