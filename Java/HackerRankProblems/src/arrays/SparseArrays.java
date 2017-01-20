/**

There are n strings. Each string's length is no more than 20 characters. There are also q queries. For each query, you are given a string, and you need to find out how many times this string occurred previously.

Input Format

The first line contains n, the number of strings.
The next n lines each contain a string.
The n+2nd line contains , the number of queries.
The following  lines each contain a query string.

Constraints
 1 <= n,q <= 1000   

Sample Input

4
aba
baba
aba
xzxb
3
aba
xzxb
ab

Sample Output

2
1
0

 * 
 */
package arrays;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ajay
 *
 */
public class SparseArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		myArray myarr = new myArray(n);
		
		while( n != 0){
			String s = sc.next();
			myarr.add2Array(s);
			n--;
		}
		int q = sc.nextInt();
		ArrayList<Integer> sol = new ArrayList<Integer>();
		
		while(q != 0){
			String s = sc.next();
			int index = myarr.findString(s);
			index =  (index == -1) ? 0 : myarr.arr[index].count;
			sol.add(index);
			q--;
		}
		
		for (int i = 0 ; i < sol.size() ; i++)
			System.out.println(sol.get(i));
		
		sc.close();
		
	}
	
}

class myArray {
	
	Node[] arr;
	int last;
	
	public myArray(int n){
		this.arr = new Node[n];
		this.last = 0;
	}
	
	public void add2Array(String s){
		int index = findString(s);
		if (index == -1){
			Node temp = new Node(s,1);
			arr[last] = temp;
			last += 1;
		}
		else {
			arr[index].count += 1;
		}
	}
	
	public int findString(String s) {
		int index = -1;
		
		for(int i = 0; i < last ; i++){
			if (arr[i] != null){
				if(arr[i].val.equals(s)){
					return i;
				}
			}
		}
		return index;
	}

}

class Node {
	String val;
	int count;
	
	public Node(String s, int c){
		this.val = s;
		this.count = c;
	}

	
}
