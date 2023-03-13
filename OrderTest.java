import java.util.*;
public class OrderTest {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        Order userOrder = new Order();
        int canceledOrders = 0;
        int processedOrders = 0;
        int unfulfilled = 0;
        int fulfilled = 0;
        while(true){
            userOrder.displayItems();
            userOrder.getItems(input);
            userOrder.printSummary();
            int postOrderChoice = userOrder.postOrder(input);
            if(postOrderChoice == 2){
                userOrder.displayItems();
                userOrder.getItems(input);
                userOrder.printSummary();
                postOrderChoice = userOrder.postOrder(input);
            }
            else if(postOrderChoice == 1){
                processedOrders++;
                if(userOrder.payment(input) == 1) {
                    canceledOrders++;
                    unfulfilled++;
                    userOrder.displayItems();
                    userOrder.getItems(input);
                    userOrder.printSummary();
                    postOrderChoice = userOrder.postOrder(input);
                }
                else if(userOrder.payment(input) == 2) {
                    fulfilled++;
                }
            }
            else if(postOrderChoice == 3){
                System.out.println("Order canceled.");
                canceledOrders++;
            }
            System.out.println("Would you like to make another order? Enter 'y' or 'n'");
            String userContinue = input.nextLine();
            if(userContinue.equalsIgnoreCase("y")){
                userOrder.orderIDAdd();
            }
            else if(userContinue.equalsIgnoreCase("n")){
                System.out.println("Thank you, come again!");
                break;
            }
        }
    }
}
