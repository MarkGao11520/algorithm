/*************************************************************************
    > File Name: Main_jrh_AC.java
    > Author: gaowenfeng
    > Mail: 1152057576@qq.com 
    > Created Time: 2017-09-28
 ************************************************************************/
import java.util.Scanner;
import java.lang.Integer;
public class Main_jrh_AC{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n+1];
		for(int i=1;i<n+1;i++)
			A[i]=sc.nextInt();
		int kk = sc.nextInt();
		int dd = sc.nextInt();

		/** 使用f存储从n个数中选择k个数时，最后一个数是one的时候最大乘积 f[one][k]
		 *  使用g存储从n个数中选择k个数时，最后一个数是one的时候最小乘积 g[one][k]
		 *  g的存在是由于A的值可能为负，当A[one]为负时，f[one][k]应为前k-1个数的最小乘积乘以A[one]
		 * */ 
		int[][] f = new int[n+1][kk+1];
		int[][] g = new int[n+1][kk+1];

		for(int one=1;one<n+1;one++){
			f[one][1]=A[one];
			g[one][1]=A[one];
		}

		/**
		 * 状态:从n个数中选择k个数，最后一个数的位置为one，k个数两两间隔不超过dd的最大间隔f[one][k]
		 * 子问题: f[one][k]等于从n个数中选择k-1个数，最后一个数为one的前一个数left，k-1个数两两间隔不超过dd的最大间隔(满足约
		 * 束条件)
		 * 状态转换方程: f[one][k] = max{f[left][k-1]*A[one],g[left][k-1]*A[one]}(max(k-1,one-d)<left<one-1)
		 * */
		for(int k=2;k<kk+1;k++){
			for(int one=k;one<n+1;one++){
				int tempMax = Integer.MIN_VALUE;
				int tempMin = Integer.MAX_VALUE;
				for(int left = Math.max(k-1,one-dd);left<=one-1;left++){
 					if(Math.max(f[left][k-1]*A[one],g[left][k-1]*A[one])>tempMax)
						tempMax = Math.max(f[left][k-1]*A[one],g[left][k-1]*A[one]);
					if(Math.min(f[left][k-1]*A[one],g[left][k-1]*A[one])<tempMin)
						tempMin = Math.min(f[left][k-1]*A[one],g[left][k-1]*A[one]);
				}
				f[one][k]=tempMax;
				g[one][k]=tempMin;
			}
		}

		
		int result = Integer.MIN_VALUE;
		for(int one = kk;one<n+1;one++){
			if(f[one][kk]>result)
				result = f[one][kk];
		}

		System.out.println(result);
	
	}
}

