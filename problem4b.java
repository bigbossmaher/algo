import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class problem4b {
	public static void main(String[] args) {
		List<Integer> l = new LinkedList<Integer>();

        l.add(10);
        l.add(3);
        l.add(9);
        l.add(4);
        l.add(8);
        l.add(5);

        System.out.println(findmin(l,0));
        System.out.println(l);
       sort(l);
       System.out.println(l);
        
        
	}
	
	public static int findmin(List<Integer> List , int i) {
		int min = i;
		for(int j = i ; j<List.size() ; j++) {
			if(List.get(j)<List.get(min)) {
				min = j;
				
			}
		}
		return min;
	}
	
	public static void sort(List<Integer> list){
		for (int i = 0; i < list.size(); i++) {
			int tempval = list.get(findmin(list, i));
			int tempmin = findmin(list, i);
			int tempi = list.get(i);
			list.set(i, tempval );
			list.set(tempmin, tempi );
			
			
			
			
		}
	}


}
