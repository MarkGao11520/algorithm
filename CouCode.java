/*************************************************************************
    > File Name: CouCode.java
    > Author: gaowenfeng
    > Mail: 1152057576@qq.com 
    > Created Time: 2017-09-27
 ************************************************************************/
public class CouCode{
	public static void main(String[] args){
		int sum = 11;
		int[] v = {1,3,5};
		int[] min = new int[sum+1];
		for(int i=1;i<=sum;i++){
			min[i]=i;
		}
		min[0]=0;
		for(int i=1;i<=sum;i++){
			for(int j=0;j<v.length;j++){
				if(v[j]<=i&&min[i-v[j]]+1<min[i]){
					min[i]=min[i-v[j]]+1;
				}
			}
			System.out.println("凑齐"+i+"需要"+min[i]+"个硬币");
		}
	}
}

