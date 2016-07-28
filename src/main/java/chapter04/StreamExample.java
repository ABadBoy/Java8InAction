package chapter04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {

	public static void main(String[] args) {

		List<Dish> menu = Arrays.asList	(new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("bef",false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit",true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 500, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH));

		List<String> threeHighCaloricDishNames = menu.stream().filter(dish -> dish.getCalories()>300)
				.map(Dish::getName)
				.limit(3)
				.collect(Collectors.toList());

		System.out.println(threeHighCaloricDishNames);

		List<String> fourHighCaloricDishNames = menu.stream().filter(dish -> {
			System.out.println("filter "+dish.getName()+" "+dish.getCalories());
			return dish.getCalories() > 400;
		}).map(dish -> {
			System.out.println("mapping " + dish.getName());
			return dish.getName();
		}).limit(4).collect(Collectors.toList());

		System.out.println(fourHighCaloricDishNames);
	}


}
