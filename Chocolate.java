import java.util.*;
class Chocolate{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        
        int s,l=0,sub=0;
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        // for(int i=0;i<n;i++){
        //     System.out.println(arr[i]);
        // }
        int m=sc.nextInt();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        List <Integer>lis=new ArrayList<>();
        for(int i=0;i<n-m+1;i++){
             for(int j=i;j<i+2;j++){
                s=arr[j];
                if(s<arr[j]){
                   l=arr[j];
                }else{
                    s=arr[j];
                }
                sub=s-l;
                
            }
            lis.add(sub);
        }
        System.out.println(Collections.min(lis));
    }
}