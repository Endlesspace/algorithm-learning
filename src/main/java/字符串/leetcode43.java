package 字符串;

/**
 * 大数相乘
 */
public class leetcode43 {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = 0; i <=num1.length()-1 ; ++i) { //注意，必须倒着算！！！！！！否则当首位为0时结果就会错
            int n1 = num1.charAt(i) - '0';
            for (int j = 0; j <=num2.length()-1; ++j) {
                int n2 = num2.charAt(j) - '0';
                int sum = (res[i + j + 1] + n1 * n2); //注意要加上原来的数
                res[i + j + 1] = sum % 10;  //注意这里是等号不是加等号
                res[i + j] += sum / 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;//两数相乘，结果位数不会超过两个数的位数之和，最多有一位0；
            result.append(res[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("123","456"));
    }

}
