package com.skillstorm;

public class GroupWork {
	
	/**
	 * Extracts the value of a url's query parameter given a url. Note: A url
	 * can contain a list of key-value pairs in the format
	 * {@literal https://www.domain.com/page?key1=value1&key2=value2}
	 * 
	 * Assumes that there is only one {@literal ?} in the url String and the
	 * key-value pairs are always separated by {@literal &}. A key might be
	 * present but not have a value such as in:
	 * {@literal https://www.domain.com/page?key1=&key2=value2} in which case an
	 * empty String is returned.
	 * 
	 * @param url a url containing query parameters
	 * @param key the name of the url's query parameter to grab the value from
	 * @return String containing the value or null if the key is not present.
	 * 
	 * @author Team _____________
	 * 
	 * @throws NullPointerException     if the url or key are null
	 * @throws IllegalArgumentException the key is empty, 
	 *                                  the key handed in contains an illegal character 
	 *                              Illegal characters are:
	 *                                  {@literal ";", "/", "?", ":", "@", "&", "=", "+", ",", and "$"}
	 */
	public static String getQueryParameterValue(String url, String key) {
		return null;
	}
	
	/**
	 * Finds the user id from a url.
	 * 
	 * For example:
	 * {@literal https://www.skillstorm.store.com/user/12345}
	 * 
	 * Searches the url sub-paths for the term "user" and returns the following id as an int.
	 * 
	 * Takes into account the possibility of futher subpaths and url query parameters such as:
	 * 
	 * {@literal https://www.skillstorm.store.com/user/12345/cart_id/5?checkout=false}
	 * 
	 * @param url an absolute URL that contains the userid such as
	 *            {@literal https://www.skillstorm.store.com/user/12345}
	 * @return an int containing the users id number
	 * 
	 * @author Team ________
	 * 
	 * @throws IllegalArgumentException if the url is null or empty
	 * @throws NoSuchElementException if the string does not contain the term "user"
	 * @throws NumberFormatException if the /user/ portion of the url is not followed by a valid number
	 * 
	 */
	public static int getUserId(String url) {
	     return 0;
	}

	/**
	 * Method that takes in a string and changes the capitalization to be title-case as defined 
	 * <a href="https://apastyle.apa.org/style-grammar-guidelines/capitalization/title-case">here</a>
	 * In title case, major words are capitalized, and minor words (3 letters or less) are lower-cased.
	 * 
	 * Title case, capitalizes the following words in a title or heading:
	 * - the first word of the title or heading, even if it is a minor word such as “The” or “A”
	 * - the first word of a subtitle
	 * - the first word after a colon, em dash, or end punctuation in a heading
	 * - major words, including the second part of hyphenated major words 
	 *   (e.g., “Self-Report,” not “Self-report”)
	 * - words of four letters or more (e.g., “With,” “Between,” “From”)
	 * 
	 * Lowercase only minor words that are three letters or fewer in a title or heading 
	 * (except the first word in a title or subtitle or the first word after a colon, em dash, 
	 * or end punctuation in a heading)
	 * - short conjunctions (e.g., “and,” “as,” “but,” “for,” “if,” “nor,” “or,” “so,” “yet”)
	 * - articles (“a,” “an,” “the”)
	 * - short prepositions (e.g., “as,” “at,” “by,” “for,” “in,” “of,” “off,” “on,” “per,” “to,” “up,” “via”)
	 * 
	 * @author Team _______________
	 * 
	 * @param str 
	 * @return The original string with the capitalization changed to title-case 
	 * 
	 * @throws IllegalArgumentException if str is null
	 */
	public String titleCase(String str) {
		return null;
	}
}

