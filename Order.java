import java.util.*;
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

    Order (){
        this.orderID = rand.nextInt(9999);
        this.items = new String[]{"Chicken Burger", "Beef Burger", "Vegetarian Burger", "Small Fry","Medium Fry","Large Fry", "Coffee", "Soda", "Smoothie"};
        this.prices = new double[]{4.99, 3.99, 4.29, 1.09, 1.29, 1.59, 0.99, 0.99, 1.39};
    }

    public int getOrderID() {
        return orderID;
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
        System.out.println("Enter '0' for Chicken, '1' for Beef and '2' for Vegetarian:");
        this.mainItem = input.nextInt();
        System.out.println("How many would you like?");
        this.mainQuantity = input.nextInt();
        System.out.println("Next, choose a fry side size: Small, Medium or Large? ");
        System.out.println("Enter '3' for Small, '4' for Medium and '5' for Large:");
        this.sideItem = input.nextInt();
        System.out.println("How many would you like?");
        this.sideQuantity = input.nextInt();
        System.out.println("Lastly, choose a drink: Coffee, Soda or Smoothie?");
        System.out.println("Enter '6' for Coffee, '7' for Soda and '8' for Smoothie "); 
        this.drinkItem = input.nextInt();
        System.out.println("How many would you like?");
        this.drinkQuantity = input.nextInt();
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
        //System.out.printf("Price Before Tax: $%.2f%n",getPrices());
        //System.out.printf("Order Tax Total (5%): $%.2f%n",taxTotal());
        System.out.printf("Total Amount Due After Tax: $%.2f%n",getTotal());
        //System.out.printf("------Thank you for shopping with us!------%n%n");
    }

    public int postOrder(Scanner input) {
        printSummary();
        System.out.println("Double check your order. Are you ready to proceed?");
        System.out.println("If you'd like to continue to the payment process, press '1'");
        System.out.println("Otherwise, press '2' to modify your order.");
        this.postOrderChoice = input.nextInt();
        return postOrderChoice;
    }

    public int payment(Scanner input) {
        System.out.println("Chose a payment method for your order. We offer cash or credit.");
        System.out.println("Enter '1' for cash and '2' for credit");
        this.paymentChoice = input.nextInt();
        if(paymentChoice == 2) {
            System.out.println("Card accepted, payment completed.");
        }
        else if(paymentChoice == 1) {
            if(cashPayment(input) == 1) {
                return 1;
            }
        }
        return 2;
    }

    public int cashPayment(Scanner input) {
        System.out.printf("You've elected to pay with cash. Your total is $%.2f.%n",getTotal());
        System.out.println("Enter the dollar amount for your cash payment:");
        this.cashDollars = input.nextDouble();
        if(cashDollars > getTotal()){
            System.out.printf("Thank you for your payment! Here is your change: $%.2f%n",cashDollars-getTotal());
        }
        else if(cashDollars < getTotal()){
            System.out.printf("Your payment was insufficient. We're sorry, but your order will be canceled.");
            return 1;
        }
        return 0;
    }
          

}
