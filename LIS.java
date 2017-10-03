/*************************************************************************
    > File Name: LIS.java
    > Author: gaowenfeng
    > Mail: 1152057576@qq.com 
    > Created Time: 2017-09-27
 ************************************************************************/
public class LIS{
	public static void main(String[] args){
		int[] A = {5,3,4,8,6,7};
		int[] d = new int[A.length];
		int len = 0;
		for(int i=0;i<A.length;i++){
			d[i]=1;
			for(int j=0;j<i;j++){
				if(A[j]<=A[i]&&d[j]+1>d[i])
					d[i]=d[j]+1;
			}
			System.out.println("前"+(i+1)+"个数的最长非降序子序列长度为"+d[i]);
			if(d[i]>len)
				len=d[i];
		}

		System.out.println("最长非降序子序列为"+len);
	}
}

