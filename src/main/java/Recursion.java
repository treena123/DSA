/**
 * @author trinapal
 */
class Recursion {

     public void head(int n){
         if(n== 0){
             return;
         }
          head(n-1);
          System.out.println("the value of n is " + n);
     }

     public void tailRecursion(int n) {
         if( n== 0) {
             return;
         }
         System.out.println("The tail value is " + n);
         tailRecursion(n-1);
     }

     public int fiboHead(int n) {
         if(n==1){
             return 1;
         }
         return n*fiboHead(n-1);
     }
    public int fiboTail(int n, int acc) {
         if(n ==1 ){
             return acc;
         }
         int result = n*acc;
         fiboTail(n-1,acc);
         return result;
    }
     public int factTail(int n, int acc){
         if(n ==0){
             System.out.println("base value is " + acc);
             return acc;
         }
        System.out.println("before recursion " + n);
         int result = factTail(n-1, n*acc);
         System.out.println("after recursion " + result);
         return result;
     }
}


class Main {
    public static void main(String[] args) {
Recursion r = new Recursion();
r.head(5);
r.tailRecursion(9);
System.out.println(r.fiboHead(5));
r.factTail(5, 1);
System.out.println(r.fiboTail(6,1));
    }
}
