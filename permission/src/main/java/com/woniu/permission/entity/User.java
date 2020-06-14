package com.woniu.permission.entity;

import lombok.Data;

import java.util.Date;
import java.util.Scanner;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author wugd
 * @create 2020/3/31
 * @since 1.0.0
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Date createtime;
    private Date modifyTime ;
    private String tel ;


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入数a");
        int	a=sc.nextInt();
        System.out.println("输入数n");
        int n=sc.nextInt();
        for(int i=1;i<=n;i++) {
            for(int j=1;j<i;j++) {
                System.out.print(a);
            }
            if (i == n) {
                System.out.print(a);
            }else {
                System.out.print(a+"+");
            }
        }
    }
}
