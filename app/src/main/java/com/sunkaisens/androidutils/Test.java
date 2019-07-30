package com.sunkaisens.androidutils;

/**
 * @author:sjy
 * @date:2019-07-30
 * @email:sjy_mail@163.com
 * @Description:
 */
public class Test {
    public static void main(String[] args) {

        assert true;
        System.out.println("断言1没有问题，Go！");

        System.out.println("\n-----------------\n");

        //断言2结果为false,程序终止
        assert false : "断言失败，此表达式的信息将会在抛出异常的时候输出！";
        System.out.println("断言2没有问题，Go！");

    }
}
