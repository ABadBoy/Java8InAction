package chapter02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class FilteringApples {

	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));
		List<Apple> heavyApples = filterApples(inventory, new AppleHeavyWeightPredicate());
		System.out.println(heavyApples);

		List<Apple> greenApples = filterApples(inventory, new AppleGreenColorPredicate());
		System.out.println(greenApples);

		List<Apple> redApples = filterApples(inventory, (Apple apple) -> "red".equals(apple.getColor()));
		System.out.println(redApples);

		/*System.out.println(inventory);
		inventory.sort(new Comparator<Apple>() {
			@Override public int compare(Apple o1, Apple o2) {
				return o1.getWeight().compareTo(o2.getWeight());
			}
		});*/

		System.out.println(inventory);
		inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
		System.out.println(inventory);
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
