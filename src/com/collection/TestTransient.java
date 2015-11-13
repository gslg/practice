package com.collection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestTransient {  
    public static void main(String[] args) {  
        UserInfo userInfo = new UserInfo("张三", "123456");  
        System.out.println(userInfo);  
        try {  
            // 序列化，被设置为transient的属性没有被序列化  
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(  
                    "UserInfo.out"));  
            o.writeObject(userInfo);  
            o.close();  
        } catch (Exception e) {  
            // TODO: handle exception  
            e.printStackTrace();  
        }  
        try {  
            // 重新读取内容  
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(  
                    "UserInfo.out"));  
            UserInfo readUserInfo = (UserInfo) in.readObject();  
            //读取后psw的内容为null  
            System.out.println(readUserInfo.toString());  
        } catch (Exception e) {  
            // TODO: handle exception  
            e.printStackTrace();  
        }  
    }  
}
