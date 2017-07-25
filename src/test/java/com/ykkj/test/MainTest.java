package com.ykkj.test;

import org.junit.Test;

/**
 * Created by Administrator on 2017/6/23 0023.
 */
public class MainTest {

    @Test
    public void getStack() {
        char[] s = new char[100];
        char[] a;
        int next;
        String str = "hahah";
        a = str.toCharArray();
        int len = str.length();
        int mid = len / 2 - 1;

        int top = 0;
        for (int i = 0; i <= mid; i++) {
            s[++top] = a[i];
        }

        if (len % 2 == 0) {
            next = mid + 1;
        } else {
            next = mid + 2;
        }

        for(int i=next;i<=len-1;i++){
            if(a[i] != s[top]){
                break;
            }
            top--;
        }
        if(top == 0){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }


    }
}
