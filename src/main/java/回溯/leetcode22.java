package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成，经典回溯
 */
public class leetcode22 {
    static List<String> ret=new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        help(new StringBuilder(),0,0,n);
        return ret;
    }
    public static void help(StringBuilder sb,int left,int right,int n){
        if(right>left||sb.length()>2*n)return;
        if(sb.length()==2*n){
            ret.add(sb.toString());
            System.out.println(sb.toString());
            return;
        }
        if(left<n){
            sb.append("(");
            help(sb,left+1,right,n);
            sb.deleteCharAt(sb.length()-1);


        }
        if(right<n){
            sb.append(")");
            help(sb,left,right+1,n);
            sb.deleteCharAt(sb.length()-1);

        }

    }

    public static void main(String[] args) {
        generateParenthesis(3);
    }
}
