package org.elsewhen.palindromes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Five Dwarves ( Gimli Fili Ilif Ilmig and Mark) met at the Prancing Pony and played a 
 * word game to determine which permutations of their names resulted in a palindrome. 
 * This program prints out all of those permutations.
 * @author John Callerame
 */
public class Application {
	//The names of the dwarves playing the palindrome game.  This is a List rather than a 
	//Set in case two dwarves with the same name want to play the game together.
	public static List<String> allNames = Arrays.asList(
			new String[] {"Gimli", "Fili", "Ilif", "Ilmig", "Mark"});
	
	/**
	 * Main method
	 * Print out all permutations of names in allNames which are palindromes.
	 * @param args This parameter is required but ignored.
	 */
	public static void main(String[] args) {
		for (int numNames = 1; numNames <= allNames.size(); numNames++) {
			Set<String> permutations = getPermutations(numNames, allNames);
			for (String permutation : permutations) {
				if (isPalindrome(permutation)) {
					System.out.println(permutation);
				}
			}
		}
	}
	
	/**
	 * Tests whether a string is a palindrome
	 * @param str The string to test
	 * @return true if str is a palindrome; false otherwise
	 */
	public static boolean isPalindrome(String str) {
		char[] chars = str.toLowerCase().toCharArray();
		int len = chars.length;
		for (int i = 0; i < len / 2; i++) {
			if (chars[i] != chars[len - 1 - i]) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Gets all permutations of the names containing numNames names
	 * @param numNamesToUse The number of names to use in each permutation
	 * @param names The list of names to draw from
	 * @return The set of permutations of the given list of names containing exactly 
	 * numNames names
	 */
	public static Set<String> getPermutations(int numNamesToUse, List<String> names) {
		if (numNamesToUse < 0) {
			throw new IllegalArgumentException("getPermutations() called with numNames < 0.");
		}
		if (numNamesToUse > names.size()) { 
			throw new IllegalArgumentException("getPermutations() called with numNames > names.size().");
		}
		
		return getPermutations("", numNamesToUse, names);
	}
	
	/*
	 * Internal method used by getPermutations(int, List).
	 * The first parameter (str) is the string built so far.
	 */
	private static Set<String> getPermutations(String str, int numNamesToUse, List<String> names) {
		Set permutations = new HashSet();
		if (numNamesToUse == 0) {
			permutations.add(str);
		} else {
			//For each name...
			for (int i = 0; i < names.size(); i++) {
				String name = names.get(i);
				//Append the current name to the string we pass in to this function
				String newstr = str + name;
				//Strip the current name from the list of names we pass in to this function
				List<String> remainingNames = new ArrayList<>();
				remainingNames.addAll(names.subList(0,  i));
				remainingNames.addAll(names.subList(i + 1, names.size()));
				//To the set of permutations, add all permutations having this name first
				//followed by numNamesToUse - 1 of the remaining names
				permutations.addAll(getPermutations(newstr, numNamesToUse - 1, 
						remainingNames));
			}
		}
		return permutations;
	}
}
