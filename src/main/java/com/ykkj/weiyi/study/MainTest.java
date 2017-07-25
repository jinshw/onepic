package com.ykkj.weiyi.study;

import com.ykkj.weiyi.pojo.User;

/**
 * Created by Administrator on 2017/6/23 0023.
 */
public class MainTest {

    public static void main(String[] args) {
        Queue q = new Queue(4);
        User u = new User();
        u.setID("1111");
        u.setName("jinshw");
        System.out.println(q.empty() + " " + q.length());
        q.add(u);
        q.add("jinshw");
        q.add("jinshw11");
        q.add("jinshw22");
        System.out.println(q.empty() + " " + q.length());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.empty() + " " + q.length());

    }


    public static void getStack() {
        String[] s = new String[100], a;
        int next;
        String str = "ahaha";
        a = str.split("");
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

        for(int i=mid;i<=len-1;i++){
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
