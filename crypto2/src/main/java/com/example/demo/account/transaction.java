package com.example.demo.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class transaction {
    private boolean received;
    private String receiver;
    private int sum;
    public transaction(boolean received,int sum,String receiver){
        this.received = received;
        this.sum = sum;
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        String toReturn = ((received==true)?"Received ":"Sent to ")+receiver+" "+Integer.toString(sum)+"\n";
        return toReturn;
    }
}
