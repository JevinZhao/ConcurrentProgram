package cn.jevin.n1;

/**
 * 栈帧演示
 * 主方法进栈，压入到最底部
 * method2方法进栈
 * method2方法进栈
 * method2方法出栈
 * method1方法出栈
 * main 出栈
 */
public class StackFrames {
    public static void main(String[] args) {
        method1(10);
    }
    private static void method1(int x){
        int y=x+1;
        Object m=method2();
        System.out.println(m);
    }
    private static Object method2() {
        Object n= new Object();
        return n;
    }
}
