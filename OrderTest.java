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
            if(postOrderChoice == 1){
                processedOrders++;
                if(userOrder.payment(input) == 1) {
                    canceledOrders++;
                    fulfilled++;
                    userOrder.fileWriter("Fulfilled","Card");
                    System.out.println("Would you like to make another order? Enter '1' for yes or '2' for no");
                    int userContinue = input.nextInt();
                    if(userContinue==1){
                        userOrder.orderIDAdd();
                    }
                    else if(userContinue==2){
                        System.out.println("Thank you, come again!");
                        break;
                    }
                }
                else if(userOrder.payment(input) == 2) {
                    unfulfilled++;
                    userOrder.fileWriter("Unfulfilled","Cash");
                    System.out.println("Would you like to make another order? Enter '1' for yes or '2' for no");
                    int userContinue = input.nextInt();
                    if(userContinue==1){
                        userOrder.orderIDAdd();
                    }
                    else if(userContinue==2){
                        System.out.println("Thank you, come again!");

                        break;
                    }
                }
            }
            else if(postOrderChoice == 3){
                System.out.println("Order canceled.");
                canceledOrders++;
                userOrder.fileWriter("Canceled","N/A");
                System.out.println("Would you like to make another order? Enter '1' for yes or '2' for no");
                int userContinue = input.nextInt();
                if(userContinue==1){
                    userOrder.orderIDAdd();
                }
                else if(userContinue==2){
                    System.out.println("Thank you, come again!");

                    break;
                }
            }

        }

        userOrder.totalSummaryPrint(userOrder.totalSummary(),canceledOrders,fulfilled,unfulfilled);
    }

}
