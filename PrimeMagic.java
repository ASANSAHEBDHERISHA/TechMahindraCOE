import java.util.*;
public class PrimeMagic {
    public static boolean isPrime(int n){
        if (n <= 1){
            return false;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
        
    }
    public void PrimeList(int n){
        List<Integer> lis=new ArrayList<>();
       for(int i=2;i<=n;i++){

        if(isPrime(i)){
            lis.add(i);
        }
       }
       System.out.println(lis);
       AddPrime(lis);
    }
    public void AddPrime(List<Integer> lis){
        int sum=0;
        int count=0;
        for(int i=0;i<lis.size();i++){
            sum+=lis.get(i);
            if(isPrime(sum)){
                count++;
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        PrimeMagic p=new PrimeMagic();
        p.PrimeList(n);

    }
}
