/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserOrder;

import java.util.ArrayList;
/**
 *
 * @author Ankita Mhatre
 */
public class UserOrderDirectory {
    private ArrayList<UserOrder> userOrderList;

    public UserOrderDirectory() {
        userOrderList = new ArrayList<UserOrder>();
    }

   
    
    public ArrayList<UserOrder> getUserOrderList() {
        return userOrderList;
    }

    public void setUserOrderList(ArrayList<UserOrder> userOrderList) {
        this.userOrderList = userOrderList;
    }
    
        public UserOrder addOrder(UserOrder order) {

        System.out.println("in add orderdir");
        userOrderList.add(order);
        return order;
    }
    
}
