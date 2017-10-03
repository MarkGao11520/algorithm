/**
 * Created by gaowenfeng on 2017/10/2.
 */
import java.util.Scanner;
public class NoPointerChartWithMoney {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int money = sc.nextInt();
        int E = sc.nextInt();
        int[] unVisited = new int[N];  //记录节点访问情况
        int[] M = new int[N];  //记录每个节点的过路费
        int[][] V = new int[N][N];  //记录每条边的权重，初始值为0代表没有边
        int[][] MIN = new int[N][money+1];  //记录从第一个节点到第i个节点还剩j元时的最短路径
        MIN[0][money]=0;
        for(int i=0;i<N;i++){
            M[i]=sc.nextInt();
        }
        for(int i=0;i<E;i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int v = sc.nextInt();
            V[v1][v2] = v;
            V[v2][v1] = v;
        }
//        for(int i=1;i<N;i++){
//            unVisited[i]=Integer.MIN_VALUE;  //未访问过则为最小值
//        }
        unVisited[0]=1;

        for(int i=1;i<N;i++){  //对所有未访问的节点
            for(int j=0;j<N;j++){
                if(unVisited[j]==1){  //考察所有已经访问的节点
                    for(int k=0;k<=money;k++){
                        if(MIN[j][money]>0){
                            boolean noSelf = i!=j;
                            boolean hasLine = V[i][j]!=0;  //是否有边
                            boolean hasEnoughMoney = money-M[i]>=0; //是否有足够多的钱
                            if(noSelf&&hasLine&&hasEnoughMoney
                                    &&MIN[j][unVisited[j]]+V[i][j]< MIN[i][money-M[i]]  //求最小值
                                    ) {
                                MIN[i][money-M[i]] = MIN[j][unVisited[j]] + V[i][j];
                            }
                        }
                    }
                }
            }
            unVisited[i] = 1;  //标记为已经访问
        }
    }
}
