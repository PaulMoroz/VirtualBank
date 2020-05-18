package com.example.demo.service.api;

import com.example.demo.account.account;
import com.example.demo.account.transaction;

import java.util.ArrayList;
import java.util.List;

public interface AccountService {
    account register(String name,String pass);
    account getAccount(String name,String pass);
}
