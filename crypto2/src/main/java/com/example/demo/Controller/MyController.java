package com.example.demo.Controller;
import com.example.demo.account.account;
import com.example.demo.service.impl.MemAccountService;
import org.apache.coyote.http11.filters.SavedRequestInputFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MyController {

    private final MemAccountService accountService;
    private account myAccount;
    public MyController(MemAccountService accountService) {
        this.accountService = accountService;
        this.myAccount = null;
    }

    @RequestMapping("/")
    public String main(){
        return "redirect:index.html";
    }

    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestParam("name") String name,@RequestParam("Password") String password){
        myAccount =  accountService.register(name,password);
        if(myAccount != null)return "ok";
        else return "error";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam("name") String name,@RequestParam("Password") String password){
        myAccount =  accountService.getAccount(name,password);
        if(myAccount != null)return "ok";
        else return "error";
    }

    @RequestMapping("/send")
    @ResponseBody
    public String send(@RequestParam("name") int sum,@RequestParam("Password") String receiverName){
        account temp =  accountService.getAccount(receiverName);
        if(temp!=null){
            temp.receiveMoney(sum,myAccount.getLogin());
            myAccount.sendMoney(sum,receiverName);
            return "ok";
        }
        return "error";
    }

    @RequestMapping("/sendOut")
    @ResponseBody
    public String sendOut(@RequestParam("name") int sum,@RequestParam("Password") String cardNumber){
        myAccount.sendMoneyOut(sum,cardNumber);
        return "ok";
    }

    @RequestMapping("/getMoney")
    @ResponseBody
    public int getMoney(){
        return myAccount.getMoney();
    }

    @RequestMapping("/getHistory")
    @ResponseBody
    public String getHistory(){
        return myAccount.getHistory();
    }
}
