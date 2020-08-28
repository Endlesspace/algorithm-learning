package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 字母大小写全排列
 */
public class leetcode784 {
    List<String> ret;
    public List<String> letterCasePermutation(String S) {
        ret=new ArrayList<>();
        S=S.toLowerCase();
        dfs(S,new StringBuilder(),0);
        return ret;
    }
    public void dfs(String S,StringBuilder sb,int x){
        if(x==S.length()){
            ret.add(sb.toString());
            return;}
        if(S.charAt(x)>='0'&&S.charAt(x)<='9'){
            sb.append(S.charAt(x));
            dfs(S,sb,x+1);
            sb.deleteCharAt(sb.length()-1);
        }else{
            sb.append(S.charAt(x));
            dfs(S,sb,x+1);
            sb.deleteCharAt(sb.length()-1);
            sb.append(Character.toUpperCase(S.charAt(x)));
            dfs(S,sb,x+1);
            sb.deleteCharAt(sb.length()-1);
        }

    }

    public static void main(String[] args) {
        System.out.println(new leetcode784().letterCasePermutation("a1b2"));
    }
}
