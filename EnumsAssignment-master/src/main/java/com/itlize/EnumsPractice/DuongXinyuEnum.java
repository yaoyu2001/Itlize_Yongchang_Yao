package com.itlize.EnumsPractice;
import javax.naming.ldap.StartTlsRequest;
public enum DuongXinyuEnum {
    Duong("Duong"), Xinyu("Xinyu");
    private String name;
    DuongXinyuEnum(String name){
        this.name = name;
    }
    public String getCatchPhrase(){
        return "Hey, my name is " + name+"!";
    }
    public boolean isDuong(){
        return name.equals("Duong");
    }
    public boolean isXinyu(){
        return name.equals("Xinyu");
    }
}
