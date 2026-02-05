package week7.day1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CharacterOccuranceUsingMap {

	public static void main(String[] args) {
		String name = "HariPrasad";
		
		//convert into character array
		char[] charArray = name.toCharArray();
		
		
		//declare a Map to store the character and their count
		Map<Character,Integer>  values = new LinkedHashMap<Character, Integer>();
		
		for (char ch : charArray) {
			
			if(values.containsKey(ch)) {
				
				values.put(ch, values.get(ch)+1);
						
			}
			else {
				values.put(ch,1);
			}
			
		}
		
		Set<Entry<Character, Integer>> entrySet = values.entrySet();
		
		for (Entry<Character, Integer> eachEntry : entrySet) {
			
			System.out.println(eachEntry.getKey()+"-->"+eachEntry.getValue());
			
		}
		
		
		
		

	}

}
