package com.company;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Demonstrates the use of a map to manage a set of objects.
 */
public class UserManagement {
    /**
     * Creates and populates a group of users. Then prompts for
     * interactive searches, and finally prints all users.
     */
    public static void main(String[] args) throws IOException {
        // create a HashMap to track users
        Map<String, User> userMap = new HashMap<String, User>();

        // add a new user to the user map
        // create a new user using, for example,
        // new User("G3122", "Fred", "Kane")
        // do the above to add several users

        userMap.put("G3122", new User("G3122", "Fred", "Kane"));
        userMap.put("G3000", new User("G3000", "Lisa", "Steel"));
        userMap.put("G2345", new User("G2345", "Steve", "Logan"));
        userMap.put("G9847", new User("G9847", "Ada", "Nolan"));
        userMap.put("G0923", new User("G0923", "Marge", "Adams"));

        Scanner scan = new Scanner(System.in);
        String uid;
        User user;

        do {
            System.out.print("Enter User Id (DONE to quit): ");
            uid = scan.nextLine();
            if (!uid.equalsIgnoreCase("DONE")) {
                // search the user map for the input uid
                user = userMap.get(uid);

                // if not found
                if (user == null) {
                    // display a "User Not Found" message
                    System.out.println("User Not Found");
                } else {
                    // otherwise print the user's full name
                    System.out.println(user.toString());
                }
            }

        } while (!uid.equalsIgnoreCase("DONE"));

        // print the number of users and
        System.out.println(userMap.size());
        // print all users in the user map
        Set<String> keySet = userMap.keySet();
        for (String key : keySet) {
            System.out.println(userMap.get(key));
        }
    }
}
