import java.util.ArrayList;
import java.util.List;

public class problem4 {
	public static void main(String[] args) {
		ArrayList<Integer> l = new ArrayList<Integer>();

        l.add(1);
        l.add(3);
        l.add(9);
        l.add(4);
        l.add(8);
        l.add(5);
        System.out.println(l);
        sort(l);
        System.out.println(l);
        
        
	}
	
	public static int findmin(ArrayList<Integer> List , int i) {
		int min = i;
		for(int j = i ; j<List.size() ; j++) {
			if(List.get(j)<List.get(min)) {
				min = j;
				
			}
		}
		return min;
	}
	
	public static void sort(ArrayList<Integer> list){
		for (int i = 0; i < list.size(); i++) {
			int tempval = list.get(findmin(list, i));
			int tempmin = findmin(list, i);
			int tempi = list.get(i);
			list.set(i, tempval );
			list.set(tempmin, tempi );
			
			
			
			
		}
	}


}
