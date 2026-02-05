package week7.day1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class LearnMap {
	
	public static void main(String[] args) {
		//Key and Value
		Map<Integer,String> employeeDetails = new TreeMap<Integer,String>();
		
		employeeDetails.put(100, "Hari");
		employeeDetails.put(200, "Prasad");
		employeeDetails.put(300, "Hari");
		employeeDetails.put(400, "Naveen");
		
		//If there ia duplicate Key,then Map will have the latest value for the key.
		//employeeDetails.put(100, "Sam");
		
		
		//get() - pass the key, will retrieve the value
		System.out.println(employeeDetails.get(100));
		
		employeeDetails.remove(300);
		
		
		//it will take Key+Value as a single value
		Set<Entry<Integer, String>> entrySet = employeeDetails.entrySet();
		
		for (Entry<Integer, String> eachEntry : entrySet) {
			
			System.out.println(eachEntry.getKey()+"-->"+eachEntry.getValue());
			
		}
		
		
		
		
	}

}
