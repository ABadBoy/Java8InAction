package chapter02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FilteringApples {

	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));
		List<Apple> heavyApples = filterApples(inventory, new AppleHeavyWeightPredicate());
		System.out.println(heavyApples);

		List<Apple> greenApples = filterApples(inventory, new AppleGreenColorPredicate());
		System.out.println(greenApples);

	}

	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if (predicate.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
}
