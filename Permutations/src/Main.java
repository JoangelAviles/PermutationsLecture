import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		ArrayList<String> result = permutations("foo");
		System.out.println(result);
		System.out.println("Total permutations: " + result.size());
	}

	public static ArrayList<String> permutations(String s) {
		ArrayList<String> result = new ArrayList<String>();

		if (s.length()==0) {
			result.add("");
			return result;
		}

		// Loop through the letters of the word
		for (int i=0; i<s.length(); i++) {

			// Remove each letter
			// Form a new (shorter) word with the rest of letters
			String shorterWord = s.substring(0, i) + s.substring(i+1);

			// Find the permutations for the shorter letter
			ArrayList<String> shorterPermutations = permutations(shorterWord);

			// Attach the previously removed letter to each permutation
			for (int j=0; j<shorterPermutations.size(); j++) {
				String stringToAdd = s.charAt(i) + shorterPermutations.get(j);
				result.add(stringToAdd);
			}
		}
		// Return the list with the new permutations
		return result;
	}

}
