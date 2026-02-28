import java.util.ArrayList;
import java.util.List;

public class List{
    public static void main(String[] args) {
       List users = new ArrayList<>();
       users.add("alles");
         users.add("babe");
         users.add("charlie");

         System.out.println("all users");
         
         for(Object user : users){
            System.out.println(user);
         }
}


