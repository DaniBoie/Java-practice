package labs.lab10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Set;

/**
 * A class for performing various analyses on a set of Instagrammers data
 *
 */
public class InstagrammersStats {
	
	/**
	 * Given a Stream of Instagrammers and a country, return the top Instagrammer
	 * (by rank) in the given country. If there are no Instagrammers in that country,
	 * return an empty Optional<Instagrammer>
	 * 
	 * @param	instagrammers	stream of Instagrammers
	 * @param	country			country to search for
	 * 
	 * @return	top Instagrammer in country, or empty Optional, if none in country
	 */
	public static Optional<Instagrammer> problem1_getTopIGerInCountry(Stream<Instagrammer> instagrammers, String country) {

		Optional<Instagrammer> result = instagrammers
			.filter(i -> i.getCountry().equals(country))
			.sorted((s, t) -> s.getRank() - t.getRank())
			.findFirst();

		return result;
	}
	
	
	/**
	 * Given a Stream of Instagrammers and a category, return a List containing the 
	 * Instagrammer(s) in that category with the most followers. The list should only 
	 * contain multiple Instagrammers if there are multiple Instagrammers who have the 
	 * most followers. The order of the list should follow the order in which those 
	 * Instagrammers appear in the stream.
	 * 
	 * @param	instagrammers	stream of Instagrammers
	 * @param	category		category to search for
	 * 
	 * @return	List containing top Instagrammer(s) in category
	 */
	public static List<Instagrammer> problem2_getMostFollowedIGerInCategory(Stream<Instagrammer> instagrammers, String category) {

		List<Instagrammer> result = instagrammers
			.filter(i -> i.getCategory().equals(category))
			.sorted((s, t) -> Math.toIntExact(t.getNumFollowers() - s.getNumFollowers()))
			.collect(Collectors.toList());

		if (!result.isEmpty()) {
			Long highest = result.get(0).getNumFollowers();
			ArrayList<Instagrammer> finalResult = new ArrayList<>();
			for (Instagrammer instagrammer : result) {
				if (instagrammer.getNumFollowers() == highest) {
					finalResult.add(instagrammer);
				}
			}
			return finalResult;
		}		
		return result;
	}
	
	
	/**
	 * Given a Stream of Instagrammers, return a String that contains the names of all countries
	 * represented by the Instagrammers, ordered lexicographically, each name separated by ", ".
	 * Do not include blank country names.
	 * 
	 * @param	instagrammers	stream of Instagrammers
	 * 
	 * @return	a String containing the names of all countries represented in the stream, each name
	 * separated by ", "
	 */
	public static String problem3_getAllCountries(Stream<Instagrammer> instagrammers) {

		// Get unique countries
		Set<String> countries = instagrammers
			.map(c -> c.getCountry())
			.collect(Collectors.toSet());

		// Sort them lexographically
		String[] list = {};
		list = countries.toArray(list);
		Arrays.sort(list);

		// Remove any empty String in the list.
		ArrayList<String> list2 = new ArrayList<>();
		Collections.addAll(list2, list);
		list2.remove("");

		return String.join(", ", list2);
	}
	
	
	/**
	 * Given a Stream of Instagrammers and a category String, return the number of Instagrammers in
	 * a category that contains the given category String (case-insensitive).
	 * 
	 * @param	instagrammers	stream of Instagrammers
	 * @param	category		category search string
	 * 
	 * @return	number of Instagrammers in a category that contains the given category String (case-insensitive)
	 */
	public static long problem4_countIGersInCategory(Stream<Instagrammer> instagrammers, String category) {

		long number = instagrammers
			.filter(i -> i.getCategory().toLowerCase().contains(category.toLowerCase()))
			.count();

		return number;
	}
	
	
	/**
	 * Given a Stream of Instragrammers, return a Map<String, Double> that maps each country to
	 * the average Instagrammer rank in that country
	 * 
	 * This map should be sorted lexicographically by country name.
	 * 
	 * If the stream is empty, return an empty map.
	 * 
	 * @param	instagrammers	stream of Instagrammers
	 * 
	 * @return	a mapping of country to average Instagrammer rank in that country
	 */
	public static Map<String, Double> problem5_getAvgRankPerCountry(Stream<Instagrammer> instagrammers) {

		Map<String, Double> countryMap = new HashMap<>();
		Map<String, Integer> itemMap = new HashMap<>();

		instagrammers
			.forEach(i -> {
				String country = i.getCountry();
				int rank = i.getRank();

				if (countryMap.containsKey(country)) {
					// update total rank in countryMap
					double currentRank = countryMap.get(country);
					currentRank += rank;
					countryMap.put(country, currentRank);

					// update item total in itemMap
					int currentItems = itemMap.get(country);
					currentItems += 1;
					itemMap.put(country, currentItems);
				} else {
					countryMap.put(country, (double) rank);
					itemMap.put(country, 1);
				}
			});

		countryMap.forEach((country, rank) -> {
			double totalRank = countryMap.get(country);
			int itemNumber = itemMap.get(country);
			
			countryMap.put(country, totalRank/itemNumber);
		});

		return countryMap;
	}
	
	
	/**
	 * Given a Stream of Instagrammers, return a list of all categories, ordered from most
	 * frequent to least frequent. If two categories have the same number of Instagrammers,
	 * order them lexicographically by their category names.
	 * 
	 * @param instagrammers		stream of Instagrammers
	 * 
	 * @return	a list of all categories, ordered from most frequent to least frequent
	 */
	public static List<String> problem6_getCategories(Stream<Instagrammer> instagrammers) {

		class Pair<T, S> {
			private T first;
			private S second;

			public Pair(T first, S second) {
				this.first = first;
				this.second = second;
			}
		}

		Map<String, Integer> categoryMap = new HashMap<>();

		// From stream count occurances of each category
		instagrammers
			.forEach(i -> {
				String category = i.getCategory();
					if (categoryMap.containsKey(category)) {
						int frequency = categoryMap.get(category);
						categoryMap.put(category, frequency + 1);
					} else {
						categoryMap.put(category, 1);
					}
			});

		// Create a list of pairs to sort through
		ArrayList<Pair<String, Integer>> result = new ArrayList<>();
		categoryMap.forEach((category, frequency) -> {
			Pair<String, Integer> sortPair = new Pair<>(category, frequency);
			result.add(sortPair);
		});

		// sort lexographically
		result.sort((s, t) -> s.first.compareTo(t.first));
		// sort by frequency
		result.sort((s, t) -> t.second.compareTo(s.second));

		// return variable
		ArrayList<String> finalResult = new ArrayList<>();

		for (Pair<String, Integer> category : result) {
			finalResult.add(category.first);
		}

		return finalResult;
	}
	
	
	/**
	 * Given a Stream of Instagrammers and an integer n, return a list of the top n countries, 
	 * sorted in descending order by number of Instagrammers. If two countries have the same number
	 * of Instagrammers, order them lexicographically by country name. Ignore blank country
	 * names.
	 * 
	 * If there are < n countries represented in the stream, return them all, sorted in the order
	 * previously stated.
	 * 
	 * @param instagrammers		stream of Instagrammers
	 * @param n					number of results desired
	 * 
	 * @return	a list of the top n countries
	 */
	public static List<String> problem7_getTopNCountries(Stream<Instagrammer> instagrammers, int n) {

		class Pair<T, S> {
			private T first;
			private S second;

			public Pair(T first, S second) {
				this.first = first;
				this.second = second;
			}
		}

		Map<String, Integer>	countryMap = new HashMap<>();

		// From stream count occurances of each category
		instagrammers
				.forEach(i -> {
					String country = i.getCountry();
					if (countryMap.containsKey(country)) {
						int frequency =	countryMap.get(country);
						countryMap.put(country, frequency + 1);
					} else {
						countryMap.put(country, 1);
					}
				});

		// Create a list of pairs to sort through
		ArrayList<Pair<String, Integer>> result = new ArrayList<>();
		countryMap.forEach((country, frequency) -> {
			if (!country.equals("")) {
				Pair<String, Integer> sortPair = new Pair<>(country, frequency);
				result.add(sortPair);
			}
		});

		// sort lexographically
		result.sort((s, t) -> s.first.compareTo(t.first));
		// sort by frequency
		result.sort((s, t) -> t.second.compareTo(s.second));

		// return variable
		ArrayList<String> finalResult = new ArrayList<>();


		if (n > result.size()) {
			n = result.size();
		}

		for (int i = 0; i < n; i++) {
			String country = result.get(i).first;
			finalResult.add(country);
		}

		return finalResult;
	}
	
	
	/**
	 * Given a Stream of Instagrammers and two integers (min and max), return a String that 
	 * contains the names of all Instagrammers with an engagement number within that range,
	 * ordered lexicographically, each name separated by a single space
	 * 
	 * @param	instagrammers	stream of Instagrammers
	 * @param	min				min engagement
	 * @param	max				max engagement
	 */
	public static String problem8_getAllIGersInEngagementRange(Stream<Instagrammer> instagrammers, int min, int max) {
		
		List<String> returnVar = instagrammers
			.filter(i -> i.getEngagement() >= min && i.getEngagement() <= max)
			.sorted((s, t) -> s.compareTo(t))
			.map(i -> i.getName())
			.collect(Collectors.toList());

		return String.join(" ", returnVar);
	}
	
	
	/**
	 * Given a Stream of Instagrammers and a string, return the first Instagrammer found 
	 * in the stream whose name contains that string (case-sensitive). 
	 * 
	 * If no Instagrammer name contains the string, or the stream is empty, return an 
	 * empty Optional<Instagrammer>
	 * 
	 * @param	instagrammers	stream of Instagrammers
	 * @param	str				search string
	 * 
	 * @return	first Instagrammer found whose name contains the string (case-sensitive)
	 */
	public static Optional<Instagrammer> problem9_getFirstIGerContainingString(Stream<Instagrammer> instagrammers, String str) {

		return instagrammers
			.filter(i -> i.getName().contains(str))
			.findFirst();

	}
	
	
	/**
	 * Given a Stream of Instagrammers and a boolean value distinct, return the number
	 * of Instagrammers in the stream, excluding duplicates if distinct is true.
	 * 
	 * A duplicate Instagrammer is one with the same name as another Instagrammer.
	 * 
	 * @param	instagrammers	stream of Instagrammers
	 * @param	distinct		whether or not to exclude duplicates
	 * 
	 * @return	the number of Instagrammers in the stream
	 */
	public static long problem10_countInstagrammers(Stream<Instagrammer> instagrammers, boolean distinct) {

		if (distinct) {
			return instagrammers
				.distinct()
				.count();
		} else {
			return instagrammers
				.count();
		}
	}
}