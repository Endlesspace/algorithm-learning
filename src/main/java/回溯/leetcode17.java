package 回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。        给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
public class leetcode17 {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<String>();
    public void backtrack(String combination, String next_digits) {
        if(next_digits.length()==0){
            output.add(combination);
        }
        else{
            String num =next_digits.substring(0,1);
            for(int i=0;i<phone.get(num).length();i++){
                String temp=phone.get(num).substring(i,i+1);
                backtrack(combination+temp,next_digits.substring(1));
            }
        }

    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }
}
