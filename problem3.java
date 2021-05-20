import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import lab1.powerset.PowerSet;

public class problem3 {

	public static void main(String[] args) {
//		int[] array = {1,3,9,4,8,5};
//		List l = Arrays.asList(array);
		
		List<Integer> l = new ArrayList<Integer>();
		  
        // using add() to initialize values
        // [10, 20, 30, 40]
        l.add(1);
        l.add(3);
        l.add(9);
        l.add(4);
        l.add(8);
        l.add(5);
        
		System.out.println(subsetSum(l, 31));

	}
	public static boolean sumFound(List list, int k) {
		for (int i = 0 ; i < list.size() ; i++) {
			System.out.println("starting with " + (int)list.get(i));
			int sum = 0 ;
			for(int j = i ; j< list.size() ; j++) {
				sum = sum + (int)list.get(j);
				System.out.println("-----"+j+" sum ="+sum);
				if(sum == k) return true;
				if(sum>k) break;
			}
		}
		return false;
	}
	
		public static boolean subsetSum(List<Integer> list, Integer z) {
			List<Set<Integer>> P = PowerSet.powerSet(list);
			for(int i=0;i<P.size();i++) {
				int sum = 0 ;
				Set<Integer> tab = P.get(i);
				for(Integer k : tab) {sum = sum +k;};
				if(sum == z) {System.out.println(tab);return true;}
				
			}
			return false;
		}
	

}
