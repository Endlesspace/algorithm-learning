package 字符串;

public class Manacher {
    //字符串处理函数，给每个字符前面和后面加上一个字符。作用是可以不用分奇偶做不同的处理
    public char[] manacherString(String str){
        char[] charArr=str.toCharArray();
        char[] newArr=new char[2*charArr.length+1];
        int index=0;
        for(int i=0;i<newArr.length;++i){
            newArr[i] = (i&1)==0?'#':charArr[index++];
        }
        return newArr;
    }
    //主体算法
    public int maxLcpsLength(String str){
        if(str==null||str.length()==0)return 0;
        char[] charArr = manacherString(str);
        int[] pArr = new int [charArr.length];
        int index=-1,pr=-1,max=Integer.MIN_VALUE;
        for(int i=0;i!=charArr.length;i++){
            pArr[i] =pr>i ?Math.min(pArr[2*index-i],pr-i):1;
            while(i+pArr[i]<charArr.length&&i-pArr[i]>-1){
                if(charArr[i+pArr[i]]==charArr[i-pArr[i]]){
                    pArr[i]++;
                }else {
                    break;
                }
            }
            if(i+pArr[i]>pr){
                pr=i+pArr[i];
                index=i;
            }
            max=Math.max(max,pArr[i]);
        }
        return max-1;
    }

    public static void main(String[] args) {
        Manacher manacher = new Manacher();
        System.out.println(manacher.manacherString("abc"));
    }
}
