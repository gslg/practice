package com.collection;

import java.io.Serializable;

public class UserInfo implements Serializable {  
    private static final long serialVersionUID = 996890129747019948L;  
    private String name;
    /*
     * transient关键字：Java的serialization提供了一种持久化对象实例的机制。
     * 当持久化对象时，可能有一个特殊的对象数据成员，我们不想用serialization机制来保存它。为了在一个特定对象的一个域上关闭serialization，可以在这个域前加上关键字transient
     */
    private transient String psw;  
  
    public UserInfo(String name, String psw) {  
        this.name = name;  
        this.psw = psw;  
    }  
  
    public String toString() {  
        return "name=" + name + ", psw=" + psw;  
    }  
}
