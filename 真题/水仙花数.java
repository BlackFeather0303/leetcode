/*
数学上有个水仙花数，他是这样定义的： “水仙花数”是指一个三位数，它的各位数字的立方和等于其本身，比如：153=1^3+5^3+3^3。 现在要求输出所有在m和n范围内的水仙花数。
输入描述:
输入数据有多组，每组占一行，包括两个整数m和n（100 ≤ m ≤ n ≤ 999）。
输出描述:
对于每个测试实例，要求输出所有在给定范围内的水仙花数，就是说，输出的水仙花数必须大于等于m,并且小于等于n，如果有多个，则要求从小到大排列在一行内输出，之间用一个空格隔开;
如果给定的范围内不存在水仙花数，则输出no;
每个测试实例的输出占一行。
示例1
输入
复制
100 120
300 380
输出
复制
no
370 371
 */
 import java.util.*;
 public class Main{
     public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         boolean flag = false;
         while(in.hasNext()){
             int m = in.nextInt();
             int n = in.nextInt();
             String res = "";
             for (int i = m; i <= n;i++) {
                 if (check(i)) {
                     res += i;
                     res += " ";
                     flag = true;
                 }
             }
             if (flag)
                 System.out.println(res.substring(0, res.length()-1));
             if (!flag)
                 System.out.println("no");
         }
     }
     public static boolean check(int i){
         if (i <100 || i>999)
             return false;
         String s = i+"";
         int a = s.charAt(0)-'0';
         int b = s.charAt(1)-'0';
         int c = s.charAt(2)-'0';
         if (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3) == i)
             return true;
         return false;
     }
 }
