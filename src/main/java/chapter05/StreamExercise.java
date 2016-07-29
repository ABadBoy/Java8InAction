package chapter05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExercise {

	public static void main(String[] args) {

		Trader raoul = new Trader("Raoul","Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");

		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
		);


		/*Find all transactions in 2011 and sort by value (small to high)*/
		List<Transaction> lists = transactions.stream().filter(transaction -> transaction.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
		System.out.println(lists);

		/*What are all the unique cites where the traders work*/
		List<String> collect = transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct()
				.collect(Collectors.toList());
		System.out.println(collect);

		Set<String> collect1 = transactions.stream().map(transaction -> transaction.getTrader().getCity())
				.collect(Collectors.toSet());
		System.out.println(collect1);

		/*Find all traders from Cambridge and sort them by name*/
		List<Trader> traders = transactions.stream().map(Transaction::getTrader)
				.filter(trader -> trader.getCity().equals("Cambridge")).sorted(Comparator.comparing(Trader::getName))
				.collect(Collectors.toList());
		System.out.println(traders);

		/*Are any traders based in Milan*/
		boolean milan = transactions.stream().map(Transaction::getTrader)
				.anyMatch(trader -> trader.getCity().equals("Milan"));
		System.out.println(milan);

		Optional<Integer> integerOptional = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
		System.out.println(integerOptional.get());


		//building streams
		Stream<String> stream = Stream.of("Java8", "Lambdas", "In", "Action");
		stream.map(String::toUpperCase).forEach(System.out::println);




	}
}
