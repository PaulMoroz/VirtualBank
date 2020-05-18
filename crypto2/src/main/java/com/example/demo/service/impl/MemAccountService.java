package com.example.demo.service.impl;

import com.example.demo.account.account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

@Service
public class MemAccountService {
    private ArrayList<account> accounts = new ArrayList<>();

    public account register(String name,String pass){
        for(int i = 0;i<accounts.size();i++){
            if(accounts.get(i).getLogin() == name ){
                return null;
            }
        }
        account t = new account(name,pass);
        accounts.add(t);
        return t;
    }

    public account getAccount(String name,String pass){
        for(int i = 0;i<accounts.size();i++){
            if(accounts.get(i).getLogin() == name && accounts.get(i).getPassword()==pass){
                return accounts.get(i);
            }
        }
        return null;
    }
    public account getAccount(String name){
        for(int i = 0;i<accounts.size();i++){
            if(accounts.get(i).getLogin() == name){
                return accounts.get(i);
            }
        }
        return null;
    }

}
