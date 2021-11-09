/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sodamachine;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author ASUS
 */
public class SodaMachine {
    Scanner sc = new Scanner(System.in);
    public static  List<Product> selectProductsPromotion = null;
    public static long totalMonneyPromotionFirst = 0;
    public static long numberMonney = 0;
    public  static long monneyPromotionLimit = 50000;
    public static List<Product>  listProductsSelected = new ArrayList<>();
    public static void main(String[] args) {
        SodaMachine sodaMachine = new SodaMachine();
        Product pro = new Product();
        List<Product> selectProducts = sodaMachine.selectProduct(pro);
        System.out.println("Product selected");
        for( Product p : selectProducts){
              System.out.println("name: "+ p.getName()+ " -Price: "+ p.getPrice());
        }
          // to test !!!!!!
//        }
//                System.out.println("size: "+ selectProducts.size());
//                int dem =0;
//            for( int i= 0; i< selectProducts.size()-2; i++){
//                if( selectProducts.get(i).getName().equals(selectProducts.get(i+ 1).getName()) &&selectProducts.get(i+1).getName().equals(selectProducts.get(i+ 2).getName())&& 
//                        selectProducts.get(i).getName().equals(selectProducts.get(i+ 2).getName()) && (i+1)<selectProducts.size()&&(i+2)<selectProducts.size()){
//                    dem++;
//                    System.out.println("Amount 3 product consecutive:  "+ dem);
//                    System.out.println( "1. "+selectProducts.get(i));
//                    System.out.println( "1. "+selectProducts.get(i+ 1));
//                    System.out.println( "1. "+selectProducts.get(i+ 2));
//                }
//            }
//            List<Product> changeProductSelected =  sodaMachine.changeProductSelected(selectProducts);
//             for( Product product: changeProductSelected){
//                 System.out.println("Product not deleted: "+ "Name: "+ product.getName()+ "- Price: "+ product.getPrice());
//             }
    }
    // check money user enter.
    public boolean checkMonney(long numberMoney){
        if( numberMoney == 10000 || numberMoney == 20000 || numberMoney == 50000
                || numberMoney == 100000 || numberMoney == 200000){
            return true;
        }
        return false;
    } 
    public List<Product> selectProduct(Product product){
       // String product= null;
        String []arrProducts = {"Coke", "Pepsi", "Soda"};
        long price = 0;
        long totalPrice = 0;
        String answer = "no";
        System.out.println("-------Product--------");
        System.out.println("1.Coke (10.000 VND)");
        System.out.println("2.Pepsi (10.000 VND)");
        System.out.println("3.Soda (20.000 VND)");
        System.out.println("4.Exit");
        while (!answer.equals("yes")) { 
             System.out.println("Enter one option product");
             String option = String.valueOf(sc.nextLine());
            switch(option){
                case "1":
                   // product = arrProducts[1];
                    if( totalPrice <= Main.numberMonney){
                    price= 10000;
                    totalPrice=+price;
                    product.setName(arrProducts[0]);
                    product.setPrice(price);
                   listProductsSelected.add(new Product(product.getName(), product.getPrice()));
                    }else{
                        System.out.println("Not enough money to buy. Please enter 4 exit the product purchase.");
                    }
                    break;
                case "2": 
                  //  product = arrProducts[2];
                      if( totalPrice <= Main.numberMonney){
                    price= 10000;
                    totalPrice=+price;
                    product.setName(arrProducts[1]);
                    product.setPrice(price);
                    listProductsSelected.add(new Product(product.getName(), product.getPrice()));
                      }else{
                        System.out.println("Not enough money to buy. Please enter 4 exit the product purchase.");
                    }
                    break;
                case "3": 
                  //  product = arrProducts[1];
                      if( totalPrice <= Main.numberMonney){
                     price= 20000;
                     totalPrice=+price;
                     product.setName(arrProducts[2]);
                     product.setPrice(price);
                     listProductsSelected.add(new Product(product.getName(), product.getPrice()));
                      }else{
                        System.out.println("Not enough money to buy. Please enter 4 exit the product purchase.");
                    }
                    break;
                default:
                    System.out.print("You want exit select product?(yes/no(different)): ");
                    answer = sc.nextLine();
                    if(answer.equals("yes") ){
                        System.out.println("You exit select product.");
                        break;
                       
                    }else {
                        System.out.println("Continue select product.....");
                    }
            }
        }
        return listProductsSelected;
    }
    private long cancelRequest(long monneyInput){
            long myMonney = monneyInput;
            return myMonney;
    }
    // total monney 10% promotion product
    public static void PromotionDayFirst (Product product){
        List<Product> productsPromotion = new ArrayList<>();
       // SodaMachine sodaMachine = new SodaMachine();
//         selectProductsPromotion = sodaMachine.selectProduct(product);
//        for( String p : selectProducts){
//            System.out.println("product: "+ p);
//            sou
//        }
                System.out.println("size: "+ listProductsSelected.size());
                int dem = 0;
                int min = 1;
                int max = 10;
                int countProduct = 0;
                int promotionProgram = 5;
            for( int i= 0; i< listProductsSelected.size()-2; i++){
                if( listProductsSelected.get(i).getName().equals(listProductsSelected.get(i+ 1).getName()) &&listProductsSelected.get(i+1).getName().equals(listProductsSelected.get(i+ 2).getName())&& 
                        listProductsSelected.get(i).getName().equals(listProductsSelected.get(i+ 2).getName()) && (i+1)<listProductsSelected.size()&&(i+2)<listProductsSelected.size()){
                    dem++;
                    if( dem >0 ){
                    System.out.println("you will chance receive 1 product free.(You You purchased 3 product consecutive)");
                        // promotion 10%
                        int promotionUser = (int) (Math.random()*(max-min+1)+min); 
                        if( promotionUser == promotionProgram){
                        totalMonneyPromotionFirst+=listProductsSelected.get(i).getPrice();
                        listProductsSelected.add(new Product(listProductsSelected.get(i).getName(), listProductsSelected.get(i).getPrice()));
                        countProduct++;
                        productsPromotion.add(new Product(listProductsSelected.get(i).getName(), listProductsSelected.get(i).getPrice()));
                        // The limited budget for the program is 50,000 a day.
                        if( totalMonneyPromotionFirst >= monneyPromotionLimit){
                            break;
                          }
                        }
                    }
                    //System.out.println( countProduct+"-Name: "+listProductsSelected.get(i).getName() + " Price: "+ listProductsSelected.get(i).getPrice());
//                    System.out.println("Amount 3 product consecutive:  "+ dem);
//                    System.out.println( "1. "+listProductsSelected.get(i));
//                    System.out.println( "1. "+listProductsSelected.get(i+ 1));
//                    System.out.println( "1. "+listProductsSelected.get(i+ 2));
                }
            }
            if( dem< 0){
                System.out.println("You have no chance to receive promotions from the program. ");
            }else{
                if( countProduct> 0 && productsPromotion.size()>0){
                    int k =1;
                    System.out.println("You received "+ countProduct+ " from program. ");
                    for( Product p : productsPromotion){
                        System.out.println(k+ "- Name: "+ p.getName()+ " Price: "+ p.getPrice());
                        k++;
                    }
                }else{
                    System.out.println("Sorry.Wish you luck next time.");
                }
            }
    }
    // increate 50% day next
    public static void PromotionDayNext(Product product){
         List<Product> productsPromotion = new ArrayList<>();
        System.out.println("total monney promotion day first:  "+ totalMonneyPromotionFirst);
        //50% 
        long totalMonneyPromotionNext = 0;
        int countProduct = 0;
        //SodaMachine sodaMachine = new SodaMachine();
        //List<Product> selectProductsPromotionNext = sodaMachine.selectProduct(product);
//        for( String p : selectProducts){
//            System.out.println("product: "+ p);
//            sou
//                   
//        }
             //   System.out.println("size: "+ selectProductsPromotionNext.size());
                int dem = 0;
                int min = 1;
                int max = 2;
                int promotionProgram = 1;
            for( int i= 0; i< listProductsSelected.size()-2; i++){
                if( listProductsSelected.get(i).getName().equals(listProductsSelected.get(i+ 1).getName()) &&listProductsSelected.get(i+1).getName().equals(listProductsSelected.get(i+ 2).getName())&& 
                        listProductsSelected.get(i).getName().equals(listProductsSelected.get(i+ 2).getName()) && (i+1)<listProductsSelected.size()&&(i+2)<listProductsSelected.size()){
                    dem++;
                    if( dem >0 && totalMonneyPromotionFirst < 50){
                        System.out.println("you will chance receive 1 product free.(You You purchased 3 product consecutive)");
                        int promotionUser = (int) (Math.random()*(max-min+1)+min); 
                        if( promotionUser == promotionProgram){
                        System.out.println("you get 1 product free.(You bought 3 product consecutive)");
                        totalMonneyPromotionNext+=listProductsSelected.get(i).getPrice();
                        listProductsSelected.add(new Product(listProductsSelected.get(i).getName(), listProductsSelected.get(i).getPrice()));
                        countProduct++;
                        // The limited budget for the program is 50,000 a day.
                        if( totalMonneyPromotionNext >= monneyPromotionLimit){
                            break;
                            }
                        }
                    }else if( dem >0 && totalMonneyPromotionFirst > 50){
                        System.out.println("you will chance receive 1 product free.(You You purchased 3 product consecutive)");
                        int minP = 1;
                        int maxP = 2;
                        int promotionFromProgram = 7;
                         int promotionU = (int) (Math.random()*(maxP-minP+1)+minP); 
                        if( promotionU == promotionFromProgram){
                        totalMonneyPromotionNext+=listProductsSelected.get(i).getPrice();
                        listProductsSelected.add(new Product(listProductsSelected.get(i).getName(), listProductsSelected.get(i).getPrice()));
                        countProduct++;
                        // The limited budget for the program is 50,000 a day.
                        if( totalMonneyPromotionNext >= monneyPromotionLimit){
                            break;
                            }
                        }
                    }
                    //System.out.println("Amount 3 product consecutive:  "+ dem);
                   // System.out.println( countProduct+"-Name: "+listProductsSelected.get(i).getName() + " Price: "+ listProductsSelected.get(i).getPrice());
                    
                }
            }
            if( dem< 0){
                System.out.println("You have no chance to receive promotions from the program. ");
            }else{
                if( countProduct> 0){
                    int k =1;
                    System.out.println("You received "+ countProduct+ " from program. ");
                    for( Product p : productsPromotion){
                        System.out.println(k+ "- Name: "+ p.getName()+ " Price: "+ p.getPrice());
                        k++;
                    }
                }else{
                    System.out.println("Wish you luck next time.");
                }
            }
    }
    // delete product selected
    public  List<Product> removeProductSelected(List<Product> listProductsChanged){
      //  List<Product> listProductsDeleted = new ArrayList<>();
       String answer = null;
       for( int i= 0 ; i< listProductsChanged.size(); i++){
           System.out.println("Your product "+ (i)+" : ");
           System.out.println("Name: "+ listProductsChanged.get(i).getName()+ " -Price: "+ listProductsChanged.get(i).getPrice());
           System.out.println("You can delete?(yes/no)");
           answer = String.valueOf(sc.nextLine());
           if(answer.equals("yes") ){
               listProductsChanged.remove(i);
           }
       }
        return listProductsChanged;
    }
            // input user Enter
    public long inputMonney(long numberMoney){
             boolean flag = true;
              do {   
            try {
                System.out.print("Enter money: "); 
                numberMoney = Long.parseLong(sc.nextLine()); 
                flag = false; 
            } catch (Exception e) { 
                System.out.println("Fail!. Please re-enter."); 
            }                  
        } while (flag); 
            return numberMoney;
    }
    /**
     * @param args the command line arguments
     */
}
