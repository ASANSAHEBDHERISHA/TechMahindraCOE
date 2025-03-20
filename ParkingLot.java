import java.util.*;
public class ParkingLot {
    public static void Parking(int n,String a){
        int Scount = 0;
        int max_count=0; 
        for(int i=0;i<n;i++){
            if (a.charAt(i)=='X'){
                Scount=0;
            }
            else{
                Scount+=1;
                if(Scount>max_count){
                    max_count=Scount;
                }
            }
        }
        System.out.println(max_count);
    }
    public static void main(String[]args){
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String  a=sc.nextLine();
        ParkingLot p=new ParkingLot();
        p.Parking(n, a);
    }
}
