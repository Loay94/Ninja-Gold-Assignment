package com.ninjagoldgame.gold;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;
import java.util.Random;

@Controller
public class NinjaGold {
    int number =0;
    int valueForEach=0;
    String valueNew="";
    String valueNewred="";
    @RequestMapping(value = "/process",method = RequestMethod.POST)
    public String ninjaGold(@RequestParam String value, HttpSession session){

        if(value.equals("farm_values")){
            Random rand = new Random();
            valueForEach=rand.nextInt(10)+10;
             number += valueForEach;
            valueNew+="You entered a Farm and earned"+valueForEach+"gold ( "+new java.util.Date()+" )<br/>";
            return "redirect:/";
        }
         if(value.equals("cave_values")){
            Random rand = new Random();
             valueForEach=rand.nextInt(5)+5;
             number += valueForEach;
                 valueNew+="You entered a Cave and earned"+valueForEach+"gold ( "+new java.util.Date()+" )<br/>";
             return "redirect:/";
        }
         if(value.equals("house_values")){
            while(true){
                Random rand = new Random();
                int chechNumber = rand.nextInt(5);
                if( 2 < chechNumber){
                    valueForEach=chechNumber;
                number += chechNumber;
                    valueNew+="You entered a House and earned"+valueForEach+"gold ( "+new java.util.Date()+" )<br/>";
                break;
                }
            }
             return "redirect:/";
         }
         if(value.equals("casino_values")){
            Random rand = new Random();
             valueForEach=rand.nextInt(50)*(rand.nextBoolean()?-1:1);
             number +=valueForEach ;

             if(valueForEach>0){
                 valueNew+="You entered a Casino and earned"+valueForEach+"gold ( "+new java.util.Date()+" ) <br/>";
             }
             else {
                 valueNewred+="You entered a Casino and takes"+valueForEach+"gold ( "+new java.util.Date()+" )<br/>";
             }
         return "redirect:/";
         }
        return "ninjagold.jsp";
    }
    @RequestMapping("/")
    public String ninja(Model model, HttpSession session){
        if(session.isNew()){
            session.setAttribute("number","0");
            session.setAttribute("describtion"," ");
            session.setAttribute("describtionred"," ");
        }
        else{  session.setAttribute("describtion",valueNew);
            session.setAttribute("number",number);}
            session.setAttribute("describtionred",valueNewred);

        return "ninjagold.jsp";
    }
    @RequestMapping("/reset")
    public String ResetValues(HttpSession session){
        valueNew="";
        number = 0;
        valueNewred="";

        return "redirect:/";
    }

}
