package com.example.demo.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class account {
    private String name;
    private String password;
    private int money;
    private ArrayList<transaction> history;
    public account(String name,String password){
        this.name = name;
        this.password = password;
    }
    public String getLogin(){
        return this.name;
    }
    public String getPassword(){
        return this.password;
    }
    public void receiveMoney(int sum,String from){
        this.history.add(new transaction(false,sum,from));
        this.money+=sum;
    }
    public void sendMoney(int sum,String to){
        this.money-=sum;
        this.history.add(new transaction(true,sum,to));
    }
    public void sendMoneyOut(int sum,String CardName){
        CardName = "Card: "+CardName;
        this.money-=sum;
        this.history.add(new transaction(true,sum,CardName));
    }
    public int getMoney(){
        return this.money;
    }
    public String getHistory(){
        String toReturn = "";
        for(int i = 0;i<this.history.size();i++){
            toReturn+=this.history.get(i).toString();
        }
        return toReturn;
    }
}
