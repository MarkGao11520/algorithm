/*************************************************************************
    > File Name: NoPointerChart.java
    > Author: gaowenfeng
    > Mail: 1152057576@qq.com 
    > Created Time: 2017-09-27
 ************************************************************************/
import java.util.Scanner;
import java.lang.Integer;
public class NoPointerChart{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("请输入图的节点数:");
		int V=in.nextInt();
		System.out.println("请输入图的变数:");
		int E=in.nextInt();
		int[][] A = new int[V][V];
		for(int i=0;i<E;i++){
			System.out.println("请输入第"+(i+1)+"条边的信息\n请输入端点1:");
			int j=in.nextInt();
			System.out.println("请输入端点2:");
			int k=in.nextInt();
			System.out.println("请输入权重:");
			int v=in.nextInt();
			A[j-1][k-1]=v;
			A[k-1][j-1]=v;
		}
		for(int i=0;i<V;i++){
			for(int j=0;j<V;j++){
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
		int[] d = new int[V];
		for(int i=0;i<V;i++){
			if(A[0][i]==0)
				d[i]=999;
			else
				d[i]=A[0][i];
		}
		int len=999;
		for(int i=1;i<V;i++){
			for(int j=1;j<V;j++){
				if(i!=j&&d[j]!=999&&A[j][i]>0&&A[j][i]+d[j]<d[i])
					d[i]=A[j][i]+d[j];
			}
			System.out.println("从第1个节点到第"+(i+1)+"个节点的最短路径为"+d[i]);
			if(d[i]>0&&d[i]<len)
				len=d[i];
		}
		System.out.println("从第一个节点到各节点的最短路径为"+len);
	}
}

