package chapter05;

import chapter04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamOperations {

	public static void main(String[] args) {

		List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("bef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 500, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));

		List<String> vegetariansMenu = menu.stream().filter(Dish::isVegetarian).map(Dish::getName).collect(Collectors.toList());
		System.out.println(vegetariansMenu);

		/*filter even unique elements in a stream*/
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		numbers.stream().filter(integer -> integer % 2 == 0).distinct().forEach(System.out::println);

		/*skip elements in a stream*/
		menu.stream().filter(dish -> dish.getCalories() > 400).skip(2).map(Dish::getName).forEach(System.out::println);

		String[] arrayOfWords = { "Hello", "World" };
		Stream<String> words = Arrays.stream(arrayOfWords);
		words.map(word -> word.split("")).flatMap(Arrays::stream).distinct().forEach(System.out::println);

		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		integers.stream().map(integer -> integer * integer).forEach(System.out::print);

		System.out.println();
		if (menu.stream().anyMatch(Dish::isVegetarian)) {
			System.out.println("This menu has vegetarian");
		}

		boolean isHealthy = menu.stream().allMatch(dish -> dish.getCalories() < 1000);
		System.out.println(isHealthy);

		menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(dish -> System.out.println(dish.getName()));

		Optional<Integer> reduceExample1 = integers.stream().reduce(Integer::sum);
		System.out.println(reduceExample1.get());

		Optional<Integer> reduceExample2 = integers.stream().reduce(Integer::max);
		System.out.println(reduceExample2.get());



	}
}
