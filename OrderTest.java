import java.util.*;
public class OrderTest {
    public static void main (String[] args){
        //Scanner and order object creation
        Scanner input = new Scanner(System.in);
        Order userOrder = new Order();
        //Summary statistic variables
        int canceledOrders = 0;
        int processedOrders = 0;
        int unfulfilled = 0;
        int fulfilled = 0;
        //All encompassing while loop (method calls, accounts for all cases within all methods)
        while(true){
            //Initial call
            userOrder.displayItems();
            userOrder.getItems(input);
            userOrder.printSummary();
            int postOrderChoice = userOrder.postOrder(input);
            //Modification call
            if(postOrderChoice == 2){
                userOrder.displayItems();
                userOrder.getItems(input);
                userOrder.printSummary();

                postOrderChoice = userOrder.postOrder(input);
            }
            //Continues to payment method calls
            if(postOrderChoice == 1){
                processedOrders++;
                //Card payment
                if(userOrder.payment(input) == 1) {
                    canceledOrders++;
                    fulfilled++;
                    userOrder.fileWriter("Fulfilled","Card");
                    System.out.println("Would you like to make another order? Enter '1' for yes or '2' for no");
                    int userContinue = input.nextInt();
                    //Whether the user continues to make another order
                    if(userContinue==1){
                        userOrder.orderIDAdd();
                    }
                    else if(userContinue==2){
                        System.out.println("Thank you, come again!");
                        break;
                    }
                }
                //Cash payment
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
            //Order cancellation
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
        //Summary statistic method call, writes to files
        userOrder.totalSummaryPrint(userOrder.totalSummary(),canceledOrders,fulfilled,unfulfilled);
    }

}
