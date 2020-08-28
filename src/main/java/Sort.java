import java.util.*;
public class Sort {
    public static void main(String[] args){
        Sort s = new Sort();
        List<Integer> numbers = new ArrayList<>();
       for(int i=1;i<49;i++)
           numbers.add(i);
       Collections.shuffle(numbers);
       System.out.println(numbers+"\n");
       List<Integer> winningCombination = numbers.subList(0,6);
       Collections.sort(winningCombination);
       System.out.println(winningCombination);
       System.out.println(s.com(1024)/1024);
    }
    public  int com(int x){
        int k=0;
        for(int i=1;i<x+1;i++)
            k+=i;
        return k;
    }
}
