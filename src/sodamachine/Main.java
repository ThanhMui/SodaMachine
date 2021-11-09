/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sodamachine;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author ASUS
 */
public class Main {
    Scanner sc = new Scanner(System.in);
    public static long numberMonney = 0;
    public static   Product product;
    public static  SodaMachine soda ;
    public static int day = 2;
    public static void main(String[] args) 
    {
    Main main = new Main();
    for(  day =1; day < 3; day++)
       {
            System.out.println("Day:  "+ day);
            if( day == 2)
            {
                // if day next list product day 1 = null 
              SodaMachine.listProductsSelected = new ArrayList<>();
            }
              main.executeSodaMachine();
        }
    }
    public void executeSodaMachine(){
       soda = new SodaMachine();
      product = new Product();
        String answer = "no";
        System.out.println("-------Product--------");
        System.out.println("1.Enter number monney");
        System.out.println("2.Choose product");
        System.out.println("3.Releases the selected product and receive promotion(if any).");
        System.out.println("4.Change product.");
        System.out.println("5(Options different).Exit and Receive a refund by canceling the request.");
        while (!answer.equals("yes")) {   
             System.out.println("Enter one option from program ............");
             String option = String.valueOf(sc.nextLine());
            switch(option){
                case "1":
                {
                    // not user enter monney after entered
                    if( numberMonney == 0){
                            numberMonney = soda.inputMonney(numberMonney);
                        if( soda.checkMonney(numberMonney)== true){
                                System.out.println("You enter "+ numberMonney);
                        }else{
                                System.out.println("You enter fail type monney. Please re-enter.");
                                numberMonney = 0;
                   }
                     }else{
                        System.out.println("You seleted monney! Please select option defferent.");
                    }
                    break;
                }
                case "2":
                {
                    if(numberMonney != 0){
                        soda.selectProduct(product);
                    }else{
                        System.out.println("You have not entered the money.Please choose option 1 to enter monney.");
                    }
                    break;
                }
                case "3":{
                    // not promotioned
                    int sizeProductsInit = SodaMachine.listProductsSelected.size();
                     if( numberMonney != 0){
                        int i = 1;
                        System.out.println("You selected "+ SodaMachine.listProductsSelected.size()+ " product");
                        System.out.println("-----------------Products you selected-------------- ");
                        for( Product p : SodaMachine.listProductsSelected){
                            System.out.println(i+ ".- Name: "+ p.getName()+ " - Price: "+ p.getPrice());
                            i++;
                        }
                        // day first
                        if( day ==1 ){
                             int k= 1;
                        // promotion first
                            SodaMachine.PromotionDayFirst(product);
                            if(SodaMachine.listProductsSelected.size() >  sizeProductsInit){
                                  System.out.println("Products after promotioned:  "+ SodaMachine.listProductsSelected.size()+ " product");
                                  System.out.println("-----------------Your Products after promotioned-------------- ");
                                for( Product p : SodaMachine.listProductsSelected)
                                {
                                   
                                   System.out.println(k+ ".- Name: "+ p.getName()+ " - Price: "+ p.getPrice());
                                   k++;
                                }
                            }
                        } else if( day == 2){
                            int j =1;
                            SodaMachine.PromotionDayNext(product);
                             if(SodaMachine.listProductsSelected.size() >  sizeProductsInit){
                                  System.out.println("Products after promotioned:  "+ SodaMachine.listProductsSelected.size()+ " product");
                                  System.out.println("-----------------Your Products after promotioned-------------- ");
                                for( Product p : SodaMachine.listProductsSelected)
                                {
                                    
                                   System.out.println(j+ ".- Name: "+ p.getName()+ " - Price: "+ p.getPrice());
                                   j++;
                                }
                            }
                        }
                     }
                   break;
                }
                case "4":{
                    if( numberMonney != 0){
                     System.out.println("----------Change products you selected--------");
                     System.out.println("------Please choose----");
                     System.out.println("1. Add product");
                     System.out.println("2. Delete product");
                     System.out.println("3.Exit");
                     String choose = "no";
                      while (!choose.equals("yes")) {   
                        System.out.println("Enter one option change product");
                        String opt = String.valueOf(sc.nextLine());
                        switch(opt){
                            case "1":{
                                System.out.println("Add product");
                                soda.selectProduct(product);
                                break;
                            }
                            case "2": 
                            {
                                System.out.println("Delete product");
                                soda.removeProductSelected(SodaMachine.listProductsSelected);
                                break;
                            }
                            default:
                            {
                                System.out.print("You want exit change products ?(yes/no(defferent)): ");
                                choose = sc.nextLine();
                                if(choose.equals("yes") ){
                                    System.out.println("You exited change product.");
                                    break;
                                }else {
                                    System.out.println("Continue change product.....");
                                     }    
                                }
                            }
                      }
                      
                    }
                    break;
                }
                default:
                 {
                    if( numberMonney != 0){
                    System.out.print("You want exit programming...?(yes/no(different)): ");
                    answer = sc.nextLine();
                    if(answer.equals("yes") ){
                        System.out.println("Number monney you refunded: "+ numberMonney);
                        numberMonney = 0; // khi huy yeu cau xet so tien user nhap vao la 0
                        System.out.println("You exited programming...... .");
                        break;
                    }else {
                        System.out.println("Continue select product.....");
                    }
                }
            }
        }
    }
    
 }
}
