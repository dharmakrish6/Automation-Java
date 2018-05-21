package moolya.filpkartdemo.tests;

import java.util.ArrayList;

public class Dummy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> sums = new ArrayList<Integer>();
		int c = 0;
		for(long i=1111111;i<=9999999;i++){
			long n = i;
			int sum = 0;
			while(n!=0){
				long rem = n%10;
				sum+=rem;
				n = n/10;
			}
			if(sum%2==0)
				sums.add(sum);
			c++;
		}
		System.out.println(sums.size());
	}

}
