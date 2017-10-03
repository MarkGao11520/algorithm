/**
 * Created by gaowenfeng on 2017/10/2.
 */
import java.util.Scanner;
public class MaxApple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] A = new int[N][M];
        int[][] F = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                A[i][j] = scanner.nextInt();
            }
        }
        F[0][0]=A[0][0];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                int tempMax = Integer.MIN_VALUE;
                if(i==0&&j>0&&F[i][j-1]+A[i][j]>tempMax)
                    tempMax = F[i][j-1]+A[i][j];
                if(j==0&&i>0&&F[i-1][j]+A[i][j]>tempMax)
                    tempMax = F[i-1][j]+A[i][j];
                if(i>0&&j>0&&Math.max(F[i][j-1]+A[i][j],F[i-1][j]+A[i][j])>tempMax)
                    tempMax = Math.max(F[i][j-1]+A[i][j],F[i-1][j]+A[i][j]);
                if(i>0||j>0)
                F[i][j] = tempMax;
            }
        }
        System.out.println(F[N-1][M-1]);
    }
}
