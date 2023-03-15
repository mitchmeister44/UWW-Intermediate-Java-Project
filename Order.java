import java.util.*;
import java.io.*;
public class Order {
    Random rand = new Random();
    private int orderID;
    private String[] items;
    private double[] prices;
    private int mainQuantity;
    private int sideQuantity;
    private int drinkQuantity;
    private int mainItem;
    private double mainPrice;
    private int sideItem;
    private double sidePrice;
    private int drinkItem;
    private double drinkPrice;
    private int postOrderChoice;
    private int paymentChoice;
    private double cashDollars;
    private int userInput;
    private int userInputQ;

    Order (){
        this.orderID = rand.nextInt(9999);
        this.items = new String[]{"Chicken Burger", "Beef Burger", "Vegetarian Burger", "Small Fry","Medium Fry","Large Fry", "Coffee", "Soda", "Smoothie"};
        this.prices = new double[]{4.99, 3.99, 4.29, 1.09, 1.29, 1.59, 0.99, 0.99, 1.39};
    }

    public int getOrderID() {
        return orderID;
    }

    public void orderIDAdd() {
        this.orderID++;
    }

    public void displayItems() {
        System.out.println("Main Burger Dishes:");
        for(int i = 0; i < 3; i++){
            System.out.printf("Item: %s | Price: %.2f%n",items[i],prices[i]);
        }
        System.out.println("Side Fry Dishes:");
        for(int i = 3; i < 6; i++){
            System.out.printf("Item: %s | Price: %.2f%n",items[i],prices[i]);
        }
        System.out.println("Refreshment Options:");
        for(int i = 6; i < 9; i++){
            System.out.printf("Item: %s | Price: %.2f%n",items[i],prices[i]);
        }
    }

    public void getItems(Scanner input) {
        System.out.println("First, choose a burger dish: Chicken, Beef or Vegetarian?");
        while(true){
            System.out.println("Enter '0' for Chicken, '1' for Beef and '2' for Vegetarian:");
            try{
                userInput= input.nextInt();

                this.mainItem =userInput;
                if(mainItem < 0 || mainItem > 2) {
                    throw new Exception("Invalid input, only '0' '1' and '2' will be accepted.");
                }
                else if (mainItem == 0 || mainItem == 1 || mainItem == 2){
                    break;
                }
            }
            catch(InputMismatchException e) {
                System.out.println("Invalid input, please try again.");
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while(true){
            System.out.println("How many would you like?");
            try{
                userInputQ = input.nextInt();
                totalSummary();
                this.mainQuantity = userInputQ;
                if(mainQuantity <= 0) {
                    throw new Exception("You're hungry aren't you? Please enter a quantity larger than 0.");
                }
                else if(mainQuantity > 0) {
                    break;
                }
            }
            catch(InputMismatchException e) {
                System.out.println("Invalid input, please try again.");
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Next, choose a fry side size: Small, Medium or Large? ");
        while(true){
            System.out.println("Enter '3' for Small, '4' for Medium and '5' for Large:");
            try{
                userInput = input.nextInt();

                this.sideItem = userInput;
                if(sideItem < 3 || sideItem > 5) {
                    throw new Exception("Invalid input, only '3' '4' and '5' will be accepted.");
                }
                if(sideItem == 3 || sideItem == 4 || sideItem == 5) {
                    break;
                }
            }
            catch(InputMismatchException e) {
                System.out.println("Invalid input, please try again.");
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while(true){
            System.out.println("How many would you like?");
            try{
                userInputQ = input.nextInt();
                totalSummary();
                this.sideQuantity = userInputQ;
                if(sideQuantity <= 0) {
                    throw new Exception("You're hungry aren't you? Please enter a quantity larger than 0.");
                }
                else if(sideQuantity > 0) {
                    break;
                }
            }
            catch(InputMismatchException e) {
                System.out.println("Invalid input, please try again.");
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Lastly, choose a drink: Coffee, Soda or Smoothie?");
        while(true){
            System.out.println("Enter '6' for Coffee, '7' for Soda and '8' for Smoothie "); 
            try{
                userInput = input.nextInt();

                this.drinkItem = userInput;
                if(drinkItem < 6 || drinkItem > 8) {
                    throw new Exception("Invalid input, only '6' '7' and '8' will be accepted.");
                }
                if(drinkItem == 6 || drinkItem == 7 || drinkItem == 8) {
                    break;
                }
            }
            catch(InputMismatchException e) {
                System.out.println("Invalid input, please try again.");
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while(true){
            System.out.println("How many would you like?");
            try{
                userInputQ = input.nextInt();
                totalSummary();
                this.drinkQuantity = userInputQ;
                if(drinkQuantity <= 0) {
                    throw new Exception("You're hungry aren't you? Please enter a quantity larger than 0.");
                }
                if(drinkQuantity > 0) {
                    break;
                }
            }
            catch(InputMismatchException e) {
                System.out.println("Invalid input, please try again.");
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getMainQuantity() {
        return this.mainQuantity;
    }

    public int getSideQuantity() {
        return this.sideQuantity;
    }

    public int getDrinkQuantity() {
        return this.drinkQuantity;
    }

    public String getMainName() {
        return this.items[this.mainItem];
    }

    public String getSideName() {
        return this.items[this.sideItem];
    }

    public String getDrinkName() {
        return this.items[this.drinkItem];
    }

    public double getMainPrice() {
        return getMainQuantity()*prices[this.mainItem];
    }

    public double getSidePrice() {
        return getSideQuantity()*prices[this.sideItem];
    }

    public double getDrinkPrice() {
        return getDrinkQuantity()*prices[this.drinkItem];
    }

    public double getPrices() {
        this.mainPrice = getMainPrice();
        this.sidePrice = getSidePrice();
        this.drinkPrice = getDrinkPrice();
        return mainPrice+sidePrice+drinkPrice;
    }

    public double taxTotal () {
        return getPrices()*0.05;
    }

    public double getTotal () {
        return getPrices()+taxTotal();
    }

    public void printSummary() {
        System.out.println("-----------------ORDER SUMMARY-------------------");
        System.out.printf("ORDER ID: %d%n",getOrderID());
        System.out.println("Item Name: \t\tItem Price:");
        System.out.printf("%s x%d\t\t$%.2f%n",getMainName(),getMainQuantity(),getMainPrice());
        System.out.printf("%s x%d\t\t\t$%.2f%n",getSideName(),getSideQuantity(),getSidePrice());
        System.out.printf("%s x%d\t\t\t$%.2f%n",getDrinkName(),getDrinkQuantity(),getDrinkPrice());
        System.out.println("-------------------------------------------");
        System.out.printf("Price Before Tax: $%.2f%n",getPrices());
        System.out.printf("Order Tax Total (5%%): $%.2f%n",taxTotal());
        System.out.printf("Total Amount Due After Tax: $%.2f%n",getTotal());
        System.out.printf("------Thank you for shopping with us!------%n%n");
    }

    public int postOrder(Scanner input) {
        while(true){
            System.out.println("Double check your order. Are you ready to proceed?");
            System.out.println("If you'd like to continue to the payment process, press '1'");
            System.out.println("If you'd like to modify your order and start from scratch, press '2'");
            System.out.println("Otherwise, press 3 to cancel your order.");
            try{
                postOrderChoice = input.nextInt();
                if(postOrderChoice < 0 || postOrderChoice > 3) {
                    throw new Exception("Invalid input, please enter one of the valid choices as specified.");
                }
                if(postOrderChoice == 1 || postOrderChoice == 2 || postOrderChoice == 3) {
                    break;
                }
            }
            catch(InputMismatchException e) {
                System.out.println("Invalid input, please try again.");
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }

        }
        return postOrderChoice;
    }

    public int payment(Scanner input) {
        while(true){
            System.out.println("Chose a payment method for your order. We offer cash or credit.");
            System.out.println("Enter '1' for cash and '2' for credit");
            try{
                this.paymentChoice = input.nextInt();
                if(paymentChoice == 2) {
                    System.out.println("Card accepted, payment completed.");
                    
                    return 1;
                }
                else if(paymentChoice == 1) {
                    if(cashPayment(input) == 1) {
                        
                        return 1;
                    }
                    else if(cashPayment(input) == 2) {
                        
                        return 2;
                    }
                }
                else {
                    throw new Exception();
                }
            }
            catch(InputMismatchException e) {
                System.out.println("Invalid input, please try Again.");
            }
            catch(Exception e) {
                System.out.println("Invalid input, please try Again.");
            }
        }
        
    }

    public int cashPayment(Scanner input) {
        
        while(true){
            System.out.printf("You've elected to pay with cash. Your total is $%.2f.%n",getTotal());
            System.out.println("Enter the dollar amount for your cash payment:");
            
            try{
                this.cashDollars = input.nextDouble();
                if(cashDollars < 0) {
                    throw new Exception("Please enter a positive dollar amount.");
                }
                if(cashDollars >= 0) {
                    if(cashDollars > getTotal()){
                        System.out.printf("Thank you for your payment! Here is your change: $%.2f%n",cashDollars-getTotal());
                        
                        return 1;
                    }
                    else if(cashDollars < getTotal()){
                        System.out.println("Your payment was insufficient. We're sorry, but your order will be canceled.");
                        return 2;
                        
                    }
                }
            }
            catch(InputMismatchException e) {
                System.out.println("Invalid input entered, please enter a positive numerical dollar amount.");
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }

        }
        
                    
    }

    public void fileWriter(){

        try(FileWriter writer= new FileWriter("Orders.txt",true); 
        BufferedWriter b= new BufferedWriter(writer);
        PrintWriter p= new PrintWriter(b)){
            p.println("-----------------ORDER SUMMARY-------------------");
            p.printf("ORDER ID: %d%n",getOrderID());
            p.println("Item Name: \t\tItem Price:");
            p.printf("%s x%d\t\t$%.2f%n",getMainName(),getMainQuantity(),getMainPrice());
            p.printf("%s x%d\t\t\t$%.2f%n",getSideName(),getSideQuantity(),getSidePrice());
            p.printf("%s x%d\t\t\t$%.2f%n",getDrinkName(),getDrinkQuantity(),getDrinkPrice());
            p.println("-------------------------------------------");
            p.printf("Price Before Tax: $%.2f%n",getPrices());
            p.printf("Order Tax Total (5%%): $%.2f%n",taxTotal());
            p.printf("Total Amount Due After Tax: $%.2f%n",getTotal());
            p.printf("------Thank you for shopping with us!------%n%n");

        } catch (IOException i){
            i.printStackTrace();
        }

    }

    public int[] totalSummary(){

        int[] quantList= new int[9];      
        quantList[userInput]=quantList[userInput]+userInputQ;
        return quantList;
    }
    

    public double totalEarned(int[] quantList){
        double totalEarned=0;
        for(int i=0;i<quantList.length;i++){
            totalEarned=totalEarned+quantList[i]*prices[i];
        }
        return totalEarned;
    }

    public void totalSummaryPrint(int[] quantList,int cancelled,int fulfilled,int unfulfilled){
        
        try(FileWriter writer= new FileWriter("Summary.txt",true);
        BufferedWriter b= new BufferedWriter(writer);
        PrintWriter p= new PrintWriter(b)){
            p.printf("Chicken Burger: %d%n",quantList[0]);
            p.printf("Beef Burger: %d%n",quantList[1]);
            p.printf("Vegetarian Burger: %d%n",quantList[2]);
            p.printf("Small Fry: %d%n",quantList[3]);
            p.printf("Medium Fry: %d%n",quantList[4]);
            p.printf("Large Fry: %d%n",quantList[5]);
            p.printf("Coffee: %d%n",quantList[6]);
            p.printf("Soda: %d%n",quantList[7]);
            p.printf("Smoothie: %d%n",quantList[8]);
            p.printf("Total Orders: %d%n",Math.round((cancelled+fulfilled+unfulfilled)/2));
            p.printf("Total Orders Processed: %d:(fulfilled)  %d:(unfulfilled)%n",fulfilled,unfulfilled);
            p.printf("Total Amount Earned: %.2f%n",totalEarned(quantList));

        }catch(IOException i){
            i.printStackTrace();
        }
    }

}
