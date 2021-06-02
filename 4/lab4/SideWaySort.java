package lab4;

import java.util.List;



public class SideWaySort {

	
		public static int [] recSort(int a[], int s, int e) {
			
			if (s<e) { 
				
			int mid = (s+e-1)/2;


			 recSort(a, s,mid);
			 recSort(a,mid+1,e);
			
			a=merge(a, s,mid,e);
			 
			}
			
			a=sideWaySort(a);
			return a;
		}
		public static int []sideWaySort(int [] a) {
			int i=0,j=a.length-1;
			int newarray[] = new int [a.length];
			for (int k=0; k<newarray.length-2;k=k+2) {
				if(i==j) break;
				newarray[k]= a[i];
				newarray[k+1]=a[j];
				i++;
				j--;
				
			}
			
			
			return newarray;
		}
		
	static	int [] merge(int [] arr, int s, int mid, int e) {
			
			int l1=mid-s+1;
			int l2=e-mid;
			int [] L1= new int[l1];
			int [] L2 = new int[l2];
			int [] finalArray= new int [l1+l2];
			
			for (int i =0;i<l1;++i)
			{
				L1[i]= arr[s+i];
			}
			for (int i =0;i<l2-1;++i)
			{
				L2[i]= arr[(mid+1)+i];
			}
			
			// we have two sorted L1 and L2
			int i=0, j=0, k=0;
			while (i<L1.length&& j<L2.length) {
				
				if (L1[i]<=L2[j]) {
					finalArray[k]= L1[i];
					i++;
				}else {
					finalArray[k]=L2[j];
					j++;
				}
					k++;
			}
			
			while (i<L1.length) {
				finalArray[k]=L1[i];
				i++;
				k++;
			}
			while (j<L2.length) {
				finalArray[k]=L2[j];
				j++;
				k++;
			}
			
			return finalArray;
		}
		
	
	public static void main(String[] args) {
		
		int [] arr= {1,2,17,-4,-6,8};
		int [] sorted = recSort(arr, 0, arr.length);
		int[]sideWaySort=sideWaySort(sorted);
		for (int i=0;i<sideWaySort.length;i++) {
			System.out.print(sideWaySort[i]+" ");
		}
	}

}
