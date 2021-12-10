
package ru.avalon.devj120.lab1;


public class Main {


    public static void main(String[] args) {
        try {
            User user1 = new User(15, "Vasya", true);
            User user2 = new User(11233, "Petya", false);
            User user3 = (User)user2.clone();
            User user4 = (User)user1.clone();
                        
            User.printALL();
            
            System.out.println("Is user1 equals user3? : " + user1.equals(user3) );
            System.out.println("Is user1 equals user4? : " + user1.equals(user4) );

            
        } catch (UserException ex) {
            System.out.println(ex.getMessage());
        } catch (CloneNotSupportedException ex) {
             System.out.println(ex.getMessage());
        }
        
    }
    
}
