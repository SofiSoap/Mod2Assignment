import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Practice {

	public static void main(String[] args) throws IOException {

		FileInputStream fin = new FileInputStream("text.txt"); 
		Scanner fileInput = new Scanner(fin);

		// We need the key to be the string that is how we are identifying it
		TreeMap<String, Integer> wordTree = new TreeMap<>(Collections.reverseOrder());

		while (fileInput.hasNext()) {
			String nextWord = fileInput.next(); 					

			nextWord = nextWord.toLowerCase().replaceAll("[\\u0026-\\u0060]", "").replaceAll("\\”", "")
					.replaceAll("\\“", "");

			if (wordTree.containsKey(nextWord)) {
				wordTree.put(nextWord, wordTree.get(nextWord) + 1); // increase associated key's(string)'s value

				// wordFromFille (KEY IS WORD, SECOND IS FREQUENCY)
				// map.put(key, map.get(key) + 1);
			} else {
				wordTree.put(nextWord, 1); // put value in tree
				// increase associated key's(string)'s value
			}
		}

		// Close
		fileInput.close();
		fin.close();

		// flip
		// *****************************************************************************

		Set<Entry<String, Integer>> entries = wordTree.entrySet();

		Comparator<Entry<String, Integer>> valueComparator = new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
				Integer v1 = e1.getValue();
				Integer v2 = e2.getValue();
				return v2.compareTo(v1);

			}
		};

		// we will need a list
		List<Entry<String, Integer>> wordTree2List = new ArrayList<Entry<String, Integer>>(entries);

		// sort
		Collections.sort(wordTree2List, valueComparator);

		LinkedHashMap<String, Integer> sortedByValue = new LinkedHashMap<String, Integer>(wordTree2List.size());

		// copy
		for (Entry<String, Integer> entry : wordTree2List) {
			sortedByValue.put(entry.getKey(), entry.getValue());
		}

		// print
		// *****************************************************************************
		System.out.println("Top 20 most common words: ");
		System.out.println(" ");
		Set<Entry<String, Integer>> wordsSortedByValue = sortedByValue.entrySet();

		int j = 0;
		int k = 1;
		for (Entry<String, Integer> mapping : wordsSortedByValue) {

			if (j <= 19) {
				System.out.print(k + ".");
				System.out.println(mapping.getKey() + "\t:" + mapping.getValue());
			} else {
				break;
			}
			k++;
			j++;
		}

	}

}

