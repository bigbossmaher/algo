package sortroutines;

import runtime.Sorter;


public class BubbleSort1 extends Sorter{

	int arr[];
	@Override
	public int[] sort(int[] arr) {
		
		this.arr=arr;
		int count =0;
		int len=arr.length;
		for (int i=0;i<len; ++i) {
			count =0;
			for (int j=0;j<len-i-1;++j) {
				
				if (arr[j]>arr[j+1]) {
					swap(j,j+1);
					count++;
				}
			}
			if (count==0) break;
		}
		
		return arr;
	}

	void swap(int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

}
