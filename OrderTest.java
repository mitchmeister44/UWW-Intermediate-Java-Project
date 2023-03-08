import java.util.*;
public class OrderTest {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        Order userOrder = new Order();
        userOrder.displayItems();
        userOrder.getItems(input);
        userOrder.printSummary();
        int postOrderChoice = userOrder.postOrder(input);
        while(true){
            if(postOrderChoice == 2){
                userOrder.displayItems();
                userOrder.getItems(input);
                userOrder.printSummary();
                postOrderChoice = userOrder.postOrder(input);
            }
            else if(postOrderChoice == 1){
                userOrder.payment(input);
                break;
            }
        }
    }
}