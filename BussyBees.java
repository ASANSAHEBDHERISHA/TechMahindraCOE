import java.util.*;
public class BussyBees {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int m=sc.nextInt();
        int avg=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                avg=(arr[i]+arr[j])/2;
                if(avg>=m){
                    System.out.println("("+arr[i]+","+arr[j]+")");
                }
            }
        }
    }
}
