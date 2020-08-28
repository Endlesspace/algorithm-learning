package DFS;

/**
 * 汉诺塔问题
 */
public class hannuota {
    int count;
//    public  void hanoi(int n){
//        if(n>0){
//            func(n,"left","mid","right");
//        }
//    }
//    public  void func(int n,String from ,String mid,String to){
//
//        if(n==1){
//            System.out.println("from "+from+" to "+to);
//            count++;
//        }else {
//            func(n-1,from,to,mid);
//            func(1,from,mid,to);
//            func(n-1,mid,from,to);
//        }
//    }
    public void hanoi(int n){
        if(n>0){
            func(n);
        }
    }
    public void func(int n){
        if(n==1){
            count++;
        }else{
            func(n-1);
            func(1);
            func(n-1);
        }
    }

    public static void main(String[] args) {
        hannuota a = new hannuota();
        a.hanoi(4);
        System.out.println(a.count);
    }
}
