import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;


public class Practice {

	public static void main  (String[] args) throws IOException {
		//
		
		
		
		FileInputStream fin  = new FileInputStream("text.txt"); //	change name, will give expeciont lol?
		Scanner fileInput = new Scanner(fin);
		
		//we need the key to be the string that is how we are identifying it
		TreeMap<String, Integer> tree2 = new TreeMap<>(Collections.reverseOrder());
		
		while(fileInput.hasNext()) {
			String nextWord = fileInput.next();
			
			if(tree2.containsKey(nextWord)) {
				tree2.put(nextWord, tree2.get(nextWord)+1);			//increase associated key's(string)'s value
									
				
				//map.put(key, map.get(key) + 1);
			}else{
				tree2.put(nextWord, 1);						//put value in tree2
											//increase associated key's(string)'s value
			}
		}
		
		//CLOSE
		fileInput.close();
		fin.close();
		/**
		for(String i : tree2.keySet()) {//INTERATES THROUGH THE KEY , thats why here that i is a String 
				System.out.print(i + " ");
				System.out.println(tree2.get(i));
				
		
		}
		
		System.out.println(" ");
		System.out.println(" "); **/
		//********************** flip *(****************************************************************************************
		
		
		Set<Entry<String, Integer>> entries = tree2.entrySet();
		
		Comparator<Entry<String, Integer>> valueComparator = new Comparator<Entry<String,Integer>>() {
			
			@Override 
			public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) { 
				Integer v1 = e1.getValue();
				Integer v2 = e2.getValue(); 
				return v2.compareTo(v1); 
				
				} 
			};
			
			// Sort method needs a List, so let's first convert Set to List in Java
			List<Entry<String, Integer>> wordTree2List = new ArrayList<Entry<String, Integer>>(entries);
			
			// sorting HashMap by values using comparator 
			Collections.sort(wordTree2List, valueComparator); 
			
			LinkedHashMap<String, Integer> sortedByValue = new LinkedHashMap<String, Integer>(wordTree2List.size());
			
			// copying entries from List to Map 
			for(Entry<String, Integer> entry : wordTree2List){ 
				sortedByValue.put(entry.getKey(), entry.getValue()); 
				} 
			
			System.out.println("Top 20 most common words: ");
			System.out.println(" ");
			Set<Entry<String, Integer>> wordsSortedByValue = sortedByValue.entrySet(); 
			

			int j = 0;
			for(Entry<String, Integer> mapping : wordsSortedByValue) {
				
				if(j<=19) {
					System.out.println(mapping.getKey() + " : " + mapping.getValue());
				}else {
					break;
				}
				j++;
			}


		
	}
		
		
	}


