package tt;

import io.cucumber.messages.types.Product;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.mail.internet.InternetAddress;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Logger;

import static org.example.Main.logger;

public class mytest {

    private boolean validation;
    private boolean isLogged;

    private String enteredemail;
    private boolean forget=false;

    private boolean purchaseConfirmed = false;

    private static String currentUserRole;
    private String lastNotification;
    private final Map<String, Recipe> recipes = new HashMap<>();
    private final Map<String, List<String>> feedbacks = new HashMap<>();
    private final Map<String, List<String>> recipeCommentsAndRatings = new HashMap<>();
    private String feedbackResponse;
    private static List<Message> messages;  // A list to store all messages
    private static Map<String, List<Message>> userMessages;  // A map to associate users with their received messages



    public mytest() {
        Person u1 = new Person("1", "haya", "123456", "haya@gmail.com", "Qalqilya", "0599221233", "user");

        Person u2 = new Person("2", "rama", "123456", "rama@gmail.com", "nablus", "0599221233", "user");
        Person o1 = new Person("3", "sara", "123456", "sara@gmail.com", "Tulkarm", "0599221233", "owner");
        Person o2 = new Person("4", "maya", "123456", "maya@gmail.com", "nablus", "0599221233", "owner");
        Person o3 = new Person("4", "masa", "123456", "masa@gmail.com", "nablus", "0599221233", "owner");
        Person o4 = new Person("4", "ramah", "123456", "ramah@gmail.com", "nablus", "0599221233", "owner");
        Person o5 = new Person("4", "dima", "123456", "s12112448@stu.najah.edu", "nablus", "0599221233", "owner");
        Person sup1 = new Person("5", "nora", "123456", "nora@gmail.com", "Qalqilya", "0599221233", "supplier");
        Person sup2 = new Person("6", "ali", "123456", "ali@gmail.com", "Tulkarm", "0599221233", "supplier");

        addUser(u1);
        addUser(u2);
       
        addUser(o1);
        addUser(o2);
        addUser(o3);
        addUser(o4);
        addUser(o5);
        addUser(sup1);
        addUser(sup2);



       /* Tproduct p1 = new Tproduct("1","Chocolate Cake", "Desserts", 15, 50);
        Tproduct p2 = new Tproduct("2","Vanilla Ice Cream", "Frozen Desserts", 15, 30);
        Tproduct p3 = new Tproduct("3","Apple Pie", "Baked Goods", 15, 20);
        Tproduct p4 = new Tproduct("4","Cinnamon Roll", "Pastries", 10, 40);

        addproduct(p1);
        addproduct(p2);
        addproduct(p3);
        addproduct(p4);*/


        // Example recipes
        recipe r1 = new recipe("001", "Chocolate Chip Cookies", "Delicious classic cookies with chocolate chips.", "Alice Johnson", "Dessert", "Contains Gluten, Contains Dairy");
        recipe r2 = new recipe("002", "Apple Pie", "Traditional apple pie with a flaky crust.", "Bob Smith", "Dessert", "Contains Gluten");
        recipe r3 = new recipe("003", "Cheesecake", "Creamy cheesecake with a graham cracker crust.", "Carol Lee", "Dessert", "Contains Gluten, Contains Dairy");
        recipe r4 = new recipe("004", "Banana Bread", "Moist bread made with ripe bananas.", "Dave Wilson", "Snack", "Contains Gluten");
        recipe r5 = new recipe("005", "Gluten-Free Chocolate Cake", "A delicious gluten-free chocolate cake.", "John Doe", "Dessert", "Gluten-Free");
        recipe r6 = new recipe("006", "Nut-Free Brownies", "Delicious brownies that are completely nut-free.", "Jane Doe", "Dessert", "Nut-Free");



        addrecipe(r1);
        addrecipe(r2);
        addrecipe(r3);
        addrecipe(r4);
        addrecipe(r5);
        addrecipe(r6);



       // List<Tproduct> order1Products = new ArrayList<>();
       /* order1Products.add(p1);
        order1Products.add(p3);
        Torder myOrder1 = new Torder("Order 1: Cakes and Pies", new Date(), "Includes various cakes and pies", order1Products);

        List<Tproduct> order2Products = new ArrayList<>();
        order2Products.add(p2);
        order2Products.add(p4);
        Torder myOrder2 = new Torder("Order 2: Ice Cream and Rolls", new Date(), "Ice cream and pastries combo", order2Products);


        List<Tproduct> order3Products = new ArrayList<>(List.of(p1, p2, p3, p4));
        Torder myOrder3 = new Torder("Order 3: Full Menu", new Date(), "A full range of desserts", order3Products);

        addorder(myOrder2);
        addorder(myOrder1);
        addorder(myOrder3);*/
        messages = new ArrayList<>();
        userMessages = new HashMap<>();


        Store store1 = new Store("S001", "Sweet Delights", "maya@gmail.com");
        store1.addProduct(new Tproduct("P001", "Chocolate Cake", "Dessert", 15.99, 10));
        store1.addProduct(new Tproduct("P002", "Vanilla Ice Cream", "Dessert", 7.99, 20));
        store1.addProduct(new Tproduct("P003", "Strawberry Tart", "Dessert", 12.50, 5));

// Example Store 2
        Store store2 = new Store("S002", "Gourmet Goodies", "sara@gmail.com");
        store2.addProduct(new Tproduct("P004", "Blueberry Muffin", "Bakery", 4.99, 15));
        store2.addProduct(new Tproduct("P005", "Cinnamon Roll", "Bakery", 3.50, 25));
        store2.addProduct(new Tproduct("P006", "Apple Pie", "Bakery", 14.99, 8));

// Example Store 3
        Store store3 = new Store("S003", "Healthy Treats", "masa@gmail.com");
        store3.addProduct(new Tproduct("P007", "Gluten-Free Brownie", "Gluten-Free", 9.99, 12));
        store3.addProduct(new Tproduct("P008", "Vegan Cookies", "Vegan", 6.99, 18));
        store3.addProduct(new Tproduct("P009", "Almond Milkshake", "Vegan", 5.99, 10));

// Example Store 4
        Store store4 = new Store("S004", "The Chocolate Factory", "ramah@gmail.com");
        store4.addProduct(new Tproduct("P010", "Dark Chocolate Bar", "Confectionery", 2.99, 50));
        store4.addProduct(new Tproduct("P011", "Milk Chocolate Truffles", "Confectionery", 11.99, 30));
        store4.addProduct(new Tproduct("P012", "White Chocolate Fudge", "Confectionery", 7.99, 20));

// Example Store 5
        Store store5 = new Store("S005", "Bread & Butter", "s12112448@stu.najah.edu");
        store5.addProduct(new Tproduct("P013", "Sourdough Bread", "Bakery", 5.99, 15));
        store5.addProduct(new Tproduct("P014", "Bagel", "Bakery", 1.99, 40));
        store5.addProduct(new Tproduct("P015", "Baguette", "Bakery", 3.99, 20));

// Add all stores to the stores list
        stores.add(store1);
        stores.add(store2);
        stores.add(store3);
        stores.add(store4);
        stores.add(store5);



    }







    private static final List<Person> up = new ArrayList<>();
    private static final List<Tproduct> prolist = new ArrayList<>();
    private static List<recipe> reclist = new ArrayList<>();
    public static  List<Torder> orderlist = new ArrayList<>();
    public static  List<Store> stores = new ArrayList<>();



    public void addMessage(Message message) {
        messages.add(message);
    }


    public void addUser(Person user) {
        up.add(user);
    }

    public void addproduct(Tproduct product) {
        prolist.add(product);
    }

    public void removeproduct(Tproduct product) {
        prolist.remove(product);
    }


    public void addrecipe(recipe recipe) {
        reclist.add(recipe);
    }

    public void addorder(Torder order) {
        orderlist.add(order);
    }

    public void setLogged(boolean isLogged) {
        this.isLogged = isLogged;
    }
    public void iAmNotInSystem(mytest obj) {
        obj.isLogged = false;
    }
    private static boolean searchinusernullflag;
    public void setUsernameAndPassAndPassFromSystem(String email, String pass) {
        validation = false;
        for (Person u : up) {

            if (email.equals(u.getEmail()) && u.getPass().equals(pass)) {
                validation = true;

                break;

            }
        }
    }

    public boolean getValidation() {
        return validation;
    }


    public void setEmptyUsernameOrEmptyPass(String name, String pass) {

        if (name.isEmpty() || pass.isEmpty()) {
            validation = false;

        }


    }

    public void takePass(String newPass) {
        for (Person user : up) {

            if (user.getEmail().equals(enteredemail)) {
                user.setPass(newPass);

            }
            passwordUpdated = true;
        }

    }
    public void setEnteredemail(String s){

        enteredemail=s;
    }
    private boolean passwordUpdated = false;
    public boolean getPasswordUpdated() {



            return passwordUpdated;

    }


    public boolean getForget() {

        return forget;
    }


    public static boolean idTest(String id) {
        for (Person person : up) {
            if (person.getID().equals(id)) {
                return false;
            }
        }
        return true;
    }

    public static boolean gmailTest(String email) {
        if (email == null) {
            return false;
        }

        // Regex pattern for validating Gmail address
        String emailRegex = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    // Validate Password: Must be 8-16 characters, include at least one letter, one digit, and one special character
    public static boolean passwordTest(String password) {
        if (password == null || password.length() < 8 || password.length() > 16) {
            return false;
        }

        boolean hasLetter = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                hasLetter = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        return hasLetter && hasDigit && hasSpecialChar;
    }

    // Check if the email already exists in the system (stub implementation)
    public static boolean registerWithExistingEmail(String email) {
        Person user = searchInUser(email);
        // Email is not found, meaning it's not registered yet
        return user != null;  // Email is found, meaning it's already registered

    }
    public static boolean nameTest(String name) {
        return name != null && name.trim().length() > 0 && name.matches("[a-zA-Z ]+");
    }

    public static boolean phoneTest(String phone) {
        return phone != null && phone.matches("\\d{10}");
    }
    public static boolean isCityValid(String city) {
        if (city == null || city.trim().isEmpty()) {
            return false;
        }
        return true;
    }
    public static boolean isRoleValid(String role) {
        if (role == null || role.trim().isEmpty()) {
            return false;
        }
        if (!role.equalsIgnoreCase("user") && !role.equalsIgnoreCase("owner") && !role.equalsIgnoreCase("supplier")) {
            return false;
        }
        return true;
    }

    public void createAccountForUser( String id,String un, String pa,String em, String city, String pn, String role) {

        addUser(new Person(id, un,pa,em,city,pn,role));

    }



    private static final Map<String, Account> accounts = new HashMap<>();

    private static String lastDisplayedMessage;
    private static boolean accountDeleted;
    private static boolean accountUpdated;

    static {
        // Pre-populate the accounts with an example account for testing
        accounts.put("existing@example.com", new Account("existing@example.com", "Existing User", "1234567890"));
    }

    public static boolean isAdmin() {
        return "admin".equalsIgnoreCase(currentUserRole);
    }

    public static boolean addAccount(String flag) {
        // Simulate adding an account based on the flag
        if ("true".equalsIgnoreCase(flag)) {
            Account newAccount = new Account("new@example.com", "New User", "0987654321");
            accounts.put(newAccount.getEmail(), newAccount);
            lastDisplayedMessage = "Account added successfully.";
            return true;
        } else {
            lastDisplayedMessage = "Failed to add account.";
            return false;
        }
    }

    public static boolean emailTest(String email) {
        return email != null && email.contains("@") && email.endsWith(".com");
    }



    public static String getDisplayedMessage() {
        return lastDisplayedMessage;
    }

    public static boolean deleteAccount(String email) {
        if (accounts.containsKey(email)) {
            accounts.remove(email);
            lastDisplayedMessage = "Account deleted successfully.";
            accountDeleted = true;
            return true;
        } else {
            lastDisplayedMessage = "Account not found.";
            accountDeleted = false;
            return false;
        }
    }

    public static boolean isAccountDeleted() {
        return accountDeleted;
    }

    public static boolean emailExists(String email) {
        return accounts.containsKey(email);
    }


    public static boolean updateAccount(String email, String name, String phone) {
        if (accounts.containsKey(email)) {
            Account account = accounts.get(email);
            account.setName(name);
            account.setPhone(phone);
            accountUpdated = true;
            lastDisplayedMessage = "Account updated successfully.";
            return true;
        } else {
            accountUpdated = false;
            lastDisplayedMessage = "Account update failed.";
            return false;
        }
    }

    public static boolean isAccountUpdated() {
        return accountUpdated;
    }

    public void validUserPass(String userName, String pass) {
        setForget(false);
        for (Person u : up) {
            if (userName.equals(u.getUserName()) && pass.equals("Forget")) {
                setForget(true);
                enteredemail = userName;
                break;

            }
        }
    }



    public void setForget(boolean forget) {
        this.forget = forget;
    }


    // Inner class representing an account
    private static class Account {
        private final String email;
        private String name;
        private String phone;

        public Account(String email, String name, String phone) {
            this.email = email;
            this.name = name;
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }



    public boolean isUserLoggedIn() {
        return isLogged;
    }
    public void browseDessertRecipes() {
        System.out.println("Browsing dessert recipes...");
        // In a real system, you might load or filter recipes here
    }
    public boolean isDessertRecipesListVisible() {
        return !reclist.isEmpty();
    }
    public void searchDessertRecipes(String keyword) {
        List<recipe> filteredRecipes = new ArrayList<>();
        for (recipe r : reclist) {
            if (r.getrename().toLowerCase().contains(keyword.toLowerCase())) {
                filteredRecipes.add(r);
            }
        }
        reclist = filteredRecipes;
    }
    public boolean dessertRecipesContainKeyword(String keyword) {
        for (recipe r : reclist) {
            if (r.getrename().toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
    public void filterRecipesByDietaryNeed(String dietaryNeed) {
        List<recipe> filteredRecipes = new ArrayList<>();
        for (recipe r : reclist) {
            // Assuming dietary needs are part of the recipe description
            if (r.getDescreption().toLowerCase().contains(dietaryNeed.toLowerCase())) {
                filteredRecipes.add(r);
            }
        }
        reclist = filteredRecipes;
    }
    public boolean isGlutenFreeRecipeListVisible() {
        for (recipe r : reclist) {
            if (r.getDescreption().toLowerCase().contains("gluten-free")) {
                return true;
            }
        }
        return false;
    }
    public void filterRecipesByAllergy(String allergy) {
        List<recipe> filteredRecipes = new ArrayList<>();
        for (recipe r : reclist) {
            if (r.getDescreption().toLowerCase().contains(allergy.toLowerCase())) {
                filteredRecipes.add(r);
            }
        }
        reclist = filteredRecipes;
    }
    public boolean isNutFreeRecipeListVisible() {
        for (recipe r : reclist) {
            if (r.getDescreption().toLowerCase().contains("nut-free")) {
                return true;
            }
        }
        return false;
    }
    public void viewDessertRecipe(String recipeTitle) {
        for (recipe r : reclist) {
            if (r.getrename().equalsIgnoreCase(recipeTitle)) {
                System.out.println("Viewing recipe: " + r.getrename());
                break;
            }
        }
    }
    public void chooseToPurchaseRecipe(String recipeTitle) {
        // Simulate purchasing process
        System.out.println("Chosen to purchase: " + recipeTitle);
    }
    public void completePayment() {
        // Simulate the payment completion
        purchaseConfirmed = true;
        System.out.println("Payment process completed successfully.");
    }
    public boolean isPurchaseConfirmed() {
        return purchaseConfirmed;
    }
    public void setCurrentUserRole(String role) {
        currentUserRole = role;
    }

    public boolean isLoggedInAs(String role) {
        return currentUserRole != null && currentUserRole.equalsIgnoreCase(role);
    }






    public void rejectRecipe(String recipeTitle, String reason) {
        Recipe recipe = recipes.get(recipeTitle);
        if (recipe != null) {
            recipe.setStatus("Rejected");
            lastNotification = reason;
        }
    }

    public String getLastNotification() {
        return lastNotification;
    }

    public void makeRecipePubliclyVisible(String recipeTitle) {
        Recipe recipe = recipes.get(recipeTitle);
        if (recipe != null) {
            recipe.setStatus("Public");
        }
    }

    public void deleteRecipe(String recipeTitle) {
        recipes.remove(recipeTitle);
    }

    public void viewRecipeFeedback(String recipeTitle) {
        // This method would typically fetch feedback data from the data store
    }



    public void addFeedbackToRecipe(String recipeTitle, String feedback) {
        feedbacks.computeIfAbsent(recipeTitle, k -> new ArrayList<>()).add(feedback);
    }

    public void removeFeedbackFromRecipe(String recipeTitle, String feedback) {
        List<String> recipeFeedback = feedbacks.get(recipeTitle);
        if (recipeFeedback != null) {
            recipeFeedback.remove(feedback);
        }
    }

    public boolean isFeedbackVisible(String recipeTitle, String feedback) {
        List<String> recipeFeedback = feedbacks.get(recipeTitle);
        return recipeFeedback != null && recipeFeedback.contains(feedback);
    }

    public void respondToFeedback(String response) {
        feedbackResponse = response;
    }

    public boolean isFeedbackResponseVisible() {
        return feedbackResponse != null && !feedbackResponse.isEmpty();
    }

    public void submitNewRecipe(String title, String description) {
        recipes.put(title, new Recipe(title, "Pending"));
    }

    public boolean isRecipeAwaitingApprovalOnProfile() {
        return recipes.values().stream().anyMatch(recipe -> "Pending".equalsIgnoreCase(recipe.getStatus()));
    }

    public void deleteOwnRecipe(String recipeTitle) {
        recipes.remove(recipeTitle);
    }

    public boolean isRecipeVisibleOnProfile(String recipeTitle) {
        return recipes.containsKey(recipeTitle);
    }

    public void markRecipeAsTried(String recipeTitle) {
        // This method can mark the recipe as tried by the user in the database
    }

    public void leaveFeedbackOnRecipe(String recipeTitle, String comment) {
        addFeedbackToRecipe(recipeTitle, comment);
    }

    public void deleteFeedbackOnRecipe(String recipeTitle, String comment) {
        removeFeedbackFromRecipe(recipeTitle, comment);
    }

    // Inner class representing a Recipe
    private static class Recipe {
        private final String title;
        private String status; // "Pending", "Public", "Rejected"

        public Recipe(String title, String status) {
            this.title = title;
            this.status = status;
        }

        public String getTitle() {
            return title;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
    public void approveRecipe(String recipeTitle) {
        Recipe recipe = recipes.get(recipeTitle);
        if (recipe != null) {
            recipe.setStatus("Public");
        }
    }
    public boolean isRecipePubliclyVisible(String recipeTitle) {
        Recipe recipe = recipes.get(recipeTitle);
        return recipe != null && "Public".equalsIgnoreCase(recipe.getStatus());
    }

    public void addCommentAndRatingToRecipe(String recipeTitle, String comment, int rating) {
        List<String> comments = recipeCommentsAndRatings.getOrDefault(recipeTitle, new ArrayList<>());
        comments.add(comment + " (Rating: " + rating + ")");
        recipeCommentsAndRatings.put(recipeTitle, comments);
        System.out.println("Added comment and rating to " + recipeTitle + ": " + comment + " (Rating: " + rating + ")");
    }
    public boolean areAllCommentsAndRatingsVisible(String recipeTitle) {
        List<String> comments = recipeCommentsAndRatings.get(recipeTitle);
        if (comments != null && !comments.isEmpty()) {
            System.out.println("Comments and ratings for " + recipeTitle + " are visible: " + comments);
            return true;
        }
        System.out.println("No comments or ratings found for " + recipeTitle);
        return false;
    }
    public Tproduct[] getProlist() {

        return new Tproduct[0];
    }
    public static Person searchInUser(String string1) {
        for (Person p : up) {
            if (p.getEmail().equals(string1)) {
                return p;
            }
        }
        searchinusernullflag=true;
        return null;
    }
    private static List<Person> getUsersByRole(String role) {
        List<Person> filteredList = new ArrayList<>();
        for (Person p : up) { // Assuming 'up' is the list containing all users
            if (p.getRole().equalsIgnoreCase(role)) {
                filteredList.add(p);
            }
        }
        return filteredList;
    }
    public void showUserListForAdminWithDeletion(String role, Scanner input) {
        StringBuilder s = new StringBuilder();

        String orangeColor = "\u001B[38;5;202m"; // ANSI escape code for orange color
        String resetColor = "\u001B[0m"; // ANSI escape code to reset color

        String headerFormat = orangeColor + "%-10s\t%-20s\t%-30s\t%-15s\t%-20s" + resetColor + "\n";
        String rowFormat = "%-10s\t%-20s\t%-30s\t%-15s\t%-20s\n";

        s.append("\n");
        s.append(String.format(headerFormat, "ID", "Name", "Email", "Phone Number", "City"));

        List<Person> filteredList = getUsersByRole(role);

        for (Person p : filteredList) {
            s.append(String.format(rowFormat,
                    p.getID(), p.getUserName(), p.getEmail(), p.getPhoneNum(), p.getCity()));
        }

        System.out.println(s.toString());

        System.out.print("Do you want to delete any account? (yes/no): ");
        String choice = input.nextLine().trim().toLowerCase();

        if (choice.equals("yes")) {
            System.out.print("Please enter the email of the account to delete: ");
            String emailToDelete = input.nextLine().trim();

            Person userToDelete = searchInUser(emailToDelete);

            if (userToDelete != null) {
                deleteUserByEmail(emailToDelete);
                System.out.println("User with email " + emailToDelete + " has been successfully deleted.");
            } else {
                System.out.println("No user found with the email " + emailToDelete + ". Please try again.");
            }
        }
    }
    public void deleteUserByEmail(String email) {
        Person userToRemove = searchInUser(email);
        if (userToRemove != null) {
            up.remove(userToRemove);  // Assuming `up` is the list of all users
        }
    }
    public String displayUserStatisticsByCity() {
        Map<String, Integer> cityCounts = new HashMap<>();

        for (Person p : up) {  // Assuming `up` is your list of users
            String city = p.getCity();
            cityCounts.put(city, cityCounts.getOrDefault(city, 0) + 1);
        }

        StringBuilder stats = new StringBuilder();
        String orangeColor = "\u001B[38;5;202m"; // ANSI escape code for orange color
        String resetColor = "\u001B[0m"; // ANSI escape code to reset color

        stats.append("\n");
        stats.append(String.format(orangeColor + "%-20s\t%-15s" + resetColor + "\n", "City", "Number of Users"));

        for (Map.Entry<String, Integer> entry : cityCounts.entrySet()) {
            stats.append(String.format("%-20s\t%-15d\n", entry.getKey(), entry.getValue()));
        }

        return stats.toString();
    }





    public void displayUserStatisticsAndListByCity(Scanner input) {
        // Display statistics
        String stats = displayUserStatisticsByCity();
        System.out.println(stats);

        // Ask if the admin wants to view users from a specific city
        System.out.print("Do you want to view the list of users from a specific city? (yes/no): ");
        String choice = input.nextLine().trim().toLowerCase();

        if (choice.equals("yes")) {
            System.out.print("Please enter the city: ");
            String city = input.nextLine().trim();

            List<Person> usersInCity = getUsersByCity(city);

            if (usersInCity.isEmpty()) {
                System.out.println("No users found in the city: " + city);
            } else {
                System.out.println("\nList of users in " + city + ":");
                StringBuilder userList = new StringBuilder();
                userList.append(String.format("%-10s\t%-20s\t%-30s\t%-15s\n", "ID", "Name", "Email", "Phone Number"));
                for (Person p : usersInCity) {
                    userList.append(String.format("%-10s\t%-20s\t%-30s\t%-15s\n",
                            p.getID(), p.getUserName(), p.getEmail(), p.getPhoneNum()));
                }
                System.out.println(userList.toString());
            }
        }


    }

    private List<Person> getUsersByCity(String city) {
        List<Person> usersInCity = new ArrayList<>();
        for (Person p : up) {  // Assuming `up` is your list of users
            if (p.getCity().equalsIgnoreCase(city)) {
                usersInCity.add(p);
            }
        }
        return usersInCity;
    }
    // Sample implementation of getAllRecipes()
    public static void displayAllRecipes(Scanner input) {
        // Ensure the list is not empty
        if (reclist.isEmpty()) {
            System.out.println("No recipes available.");
            return;
        }
        displayRecipes(reclist);

    }
    public static void searchRecipesByName(Scanner input) {
        System.out.print("Enter the name of the recipe you are searching for: ");
        String searchName = input.nextLine().toLowerCase().trim(); // Convert input to lowercase and trim spaces

        List<recipe> matchingRecipes = new ArrayList<>();

        for (recipe recipe : reclist) {
            // Convert recipe name to lowercase and trim spaces before comparison
            if (recipe.getrename().toLowerCase().trim().contains(searchName)) {
                matchingRecipes.add(recipe);
            }
        }

        if (matchingRecipes.isEmpty()) {
            System.out.println("No recipes found with the name: " + searchName);
        } else {
            displayRecipes(matchingRecipes);
        }
    }
    public static void viewMyDessertCreations(String userEmail, Scanner input) {
        List<recipe> userRecipes = new ArrayList<>();

        for (recipe r : reclist) {
            if (r.getowner_of_recipe().equals(userEmail)) {
                userRecipes.add(r);
            }
        }

        if (userRecipes.isEmpty()) {
            System.out.println("You haven't posted any dessert creations yet.");
        } else {
            System.out.println("Here are your dessert creations:");
            displayRecipes(userRecipes);

            System.out.print("Do you want to delete any of your posts? (yes/no): ");
            String response = input.nextLine().trim().toLowerCase();

            if (response.equals("yes")) {
                System.out.print("Enter the ID of the recipe you want to delete: ");
                String recipeIdToDelete = input.nextLine().trim();

                recipe recipeToDelete = null;
                for (recipe r : userRecipes) {
                    if (r.getreid().equals(recipeIdToDelete)) {
                        recipeToDelete = r;
                        break;
                    }
                }

                if (recipeToDelete != null) {
                    reclist.remove(recipeToDelete);
                    System.out.println("Recipe deleted successfully.");
                } else {
                    System.out.println("No recipe found with the given ID.");
                }
            } else {
                System.out.println("No recipes deleted.");
            }
        }
    }


    public static void displayRecipes(List<recipe> recipes){

        // Define ANSI color codes for styling
        String headerColor = "\u001B[38;5;208m"; // Light orange color
        String resetColor = "\u001B[0m"; // Reset color

        // Header for recipes
        String headerFormat = headerColor + "╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗" + resetColor + "\n";
        String recipeHeaderFormat = headerColor + "║ %-10s ║ %-30s ║ %-50s ║ %-30s ║ %-25s ║ %-33s ║" + resetColor + "\n";
        String recipeRowFormat = "║ %-10s ║ %-30s ║ %-50s ║ %-30s ║ %-25s ║ %-33s ║" + "\n";

        // Print header
        System.out.println(headerFormat);
        System.out.printf(recipeHeaderFormat, "ID", "Recipe Name", "Description", "Owner", "Type", "Dietary Needs");
        System.out.println(headerFormat);

        // Print each recipe

        for (recipe recipe : recipes) {
            System.out.printf(recipeRowFormat,
                    recipe.getreid(),
                    recipe.getrename(),
                    recipe.getDescreption(),
                    recipe.getowner_of_recipe(),
                    recipe.getType(),
                    recipe.getDietaryNeeds());
        }

        // Print footer
        System.out.println(headerFormat);

    }
    public static void filterRecipesByDietaryNeeds(Scanner input) {
        System.out.print("Enter dietary needs or food allergies (e.g., 'gluten-free', 'nut-free', 'vegan'): ");
        String dietaryFilter = input.nextLine().toLowerCase().trim(); // Convert input to lowercase and trim spaces

        List<recipe> filteredRecipes = new ArrayList<>();

        for (recipe recipe : reclist) {
            if (recipe.getDietaryNeeds().toLowerCase().contains(dietaryFilter)) {
                filteredRecipes.add(recipe);
            }
        }

        if (filteredRecipes.isEmpty()) {
            System.out.println("No recipes found matching the dietary needs or food allergies: " + dietaryFilter);
        } else {
            displayRecipes(filteredRecipes); // Display the filtered recipes
        }
    }
    private static List<recipe> pendingRecipes = new ArrayList<>();
    public static void postRecipe(Scanner input, String userEmail) {

        System.out.print("Enter the ID of the recipe: ");
        String rid = input.nextLine();

        System.out.print("Enter the name of the recipe: ");
        String recipeName = input.nextLine();

        System.out.print("Enter the description of the recipe: ");
        String description = input.nextLine();

        System.out.print("Enter the type of recipe: ");
        String type = input.nextLine();

        System.out.print("Enter the dietary needs or food allergies: ");
        String dietaryNeeds = input.nextLine();

        // Create the recipe with the user's email as the owner
        recipe newRecipe = new recipe(rid, recipeName, description, userEmail, type, dietaryNeeds);

        // Add the recipe to the pending list
        pendingRecipes.add(newRecipe);

        System.out.println("Your recipe has been submitted and is waiting for admin approval.");
    }
    public static void reviewPendingRecipes(Scanner input) {
        if (pendingRecipes.isEmpty()) {
            System.out.println("No pending recipes for approval.");
            return;
        }

        for (int i = 0; i < pendingRecipes.size(); i++) {
            recipe pendingRecipe = pendingRecipes.get(i);
            System.out.println("\nRecipe " + (i + 1) + ":");
            System.out.println("ID: " + pendingRecipe.getreid());
            System.out.println("Name: " + pendingRecipe.getrename());
            System.out.println("Description: " + pendingRecipe.getDescreption());
            System.out.println("Owner: " + pendingRecipe.getowner_of_recipe());
            System.out.println("Type: " + pendingRecipe.getType());
            System.out.println("Dietary Needs: " + pendingRecipe.getDietaryNeeds());

            System.out.print("Do you want to approve this recipe? (yes/no): ");
            String choice = input.nextLine();

            if (choice.equalsIgnoreCase("yes")) {
                // Move the recipe from pending to approved
                reclist.add(pendingRecipe);
                pendingRecipes.remove(i);
                System.out.println("Recipe approved and added to the list.");
            } else if (choice.equalsIgnoreCase("no")) {
                System.out.print("Enter a rejection message to send to the user: ");
                String rejectionMessage = input.nextLine();
                System.out.println("Recipe rejected. Message sent to the user: " + rejectionMessage);
                pendingRecipes.remove(i);
            }
        }
    }

    private static List<Feedback> feedbackList = new ArrayList<>();
    public static void provideFeedback(Scanner input, String userEmail) {
        System.out.print("Enter your feedback: ");
        String feedbackText = input.nextLine();

        String feedbackId = UUID.randomUUID().toString(); // Generate a unique ID for feedback

        Feedback feedback = new Feedback(feedbackId, userEmail, feedbackText);
        feedbackList.add(feedback);

        System.out.println("Thank you for your feedback!");
    }
    public static void manageFeedback(Scanner input) {
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback available.");
            return;
        }

        // Display all feedback
        System.out.println("All Feedback:");
        for (Feedback feedback : feedbackList) {
            System.out.println(feedback);
        }

        // Ask admin if they want to delete or respond to any feedback
        System.out.print("Enter the Feedback ID to delete or respond (or press Enter to cancel): ");
        String feedbackId = input.nextLine();

        if (feedbackId.isEmpty()) {
            System.out.println("No action taken.");
            return;
        }

        Feedback feedbackToManage = null;
        for (Feedback feedback : feedbackList) {
            if (feedback.getFeedbackId().equals(feedbackId)) {
                feedbackToManage = feedback;
                break;
            }
        }

        if (feedbackToManage != null) {
            System.out.println("Do you want to (D)elete or (R)espond to this feedback?");
            String action = input.nextLine().toUpperCase();

            if (action.equals("D")) {
                feedbackList.remove(feedbackToManage);
                System.out.println("Feedback deleted successfully.");
            } else if (action.equals("R")) {
                System.out.print("Enter your response: ");
                String response = input.nextLine();
                feedbackToManage.setResponse(response);
                System.out.println("Response added successfully.");
            } else {
                System.out.println("Invalid action.");
            }
        } else {
            System.out.println("No feedback found with the given ID.");
        }
    }
    public static void showMyFeedbacks(String userEmail, Scanner input) {
        List<Feedback> userFeedbacks = new ArrayList<>();

        for (Feedback feedback : feedbackList) {
            if (feedback.getUserEmail().equals(userEmail)) {
                userFeedbacks.add(feedback);
            }
        }

        if (userFeedbacks.isEmpty()) {
            System.out.println("You have not provided any feedback yet.");
        } else {
            for (Feedback feedback : userFeedbacks) {
                System.out.println(feedback);
                if (feedback.getResponse() != null) {
                    System.out.println("Response from Admin: " + feedback.getResponse());
                }
            }
        }

        System.out.print("Do you want to delete any of your feedback? (yes/no): ");
        String deleteChoice = input.nextLine().toLowerCase();

        if (deleteChoice.equals("yes")) {
            System.out.print("Enter the Feedback ID to delete: ");
            String feedbackId = input.nextLine();

            Feedback feedbackToDelete = null;
            for (Feedback feedback : userFeedbacks) {
                if (feedback.getFeedbackId().equals(feedbackId)) {
                    feedbackToDelete = feedback;
                    break;
                }
            }

            if (feedbackToDelete != null) {
                feedbackList.remove(feedbackToDelete);
                System.out.println("Feedback deleted successfully.");
            } else {
                System.out.println("No feedback found with the given ID.");
            }
        }
    }

    public static void manageRecipes(Scanner input) {
        if (reclist.isEmpty()) {
            System.out.println("No recipes available.");
            return;
        }

        // Display all recipes
        System.out.println("All Recipes:");
            displayAllRecipes(input);


        // Ask admin if they want to delete any recipe
        System.out.print("Enter the Recipe ID to delete (or press Enter to cancel): ");
        String recipeId = input.nextLine();

        if (recipeId.isEmpty()) {
            System.out.println("No recipes deleted.");
            return;
        }

        // Find the recipe by ID and delete it
        recipe recipeToDelete = null;
        for (recipe recipe : reclist) {
            if (recipe.getreid().equals(recipeId)) {
                recipeToDelete = recipe;
                break;
            }
        }

        if (recipeToDelete != null) {
            reclist.remove(recipeToDelete);
            System.out.println("Recipe deleted successfully.");
        } else {
            System.out.println("No recipe found with the given ID.");
        }
    }
    public static void editUserAccount(Scanner input, String userEmail) {
        Person userToEdit = null;
        for (Person user : up) {
            if (user.getEmail().equals(userEmail)) {
                userToEdit = user;
                break;
            }
        }

        if (userToEdit == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Editing your account details:");
        System.out.println("1. Edit Name");
        System.out.println("2. Edit Phone Number");
        System.out.println("3. Edit City");
        System.out.println("4. Edit Password");
        System.out.print("Choose an option: ");
        int choice = input.nextInt();
        input.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter new name: ");
                String newName = input.nextLine();
                userToEdit.setname(newName);
                break;
            case 2:
                System.out.print("Enter new phone number: ");
                String newPhone = input.nextLine();
                userToEdit.setPhoneNum(newPhone);
                break;
            case 3:
                System.out.print("Enter new city: ");
                String newCity = input.nextLine();
                userToEdit.setCity(newCity);
                break;
            case 4:
                System.out.print("Enter new password: ");
                String newPassword = input.nextLine();
                userToEdit.setPass(newPassword);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        System.out.println("Account details updated successfully.");
    }



    public static void deleteUserAccount(Scanner input, String userEmail) {
        Person userToDelete = null;
        for (Person user : up) {
            if (user.getEmail().equals(userEmail)) {
                userToDelete = user;
                break;
            }
        }

        if (userToDelete == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Are you sure you want to delete your account? (yes/no): ");
        String confirmation = input.nextLine().toLowerCase();

        if (confirmation.equals("yes")) {
            up.remove(userToDelete);
            System.out.println("Account deleted successfully.");
        } else {
            System.out.println("Account deletion canceled.");
        }
    }
    public static void updateBusinessInfo(String userEmail, Scanner input) {
        Person user = searchInUser(userEmail);  // Assuming this method exists to find a user by email

        if (user != null && (user.getRole().equals("owner") || user.getRole().equals("supplier"))) {
            System.out.println("Current business information: " + (user.getBusinessInfo() == null ? "No information provided" : user.getBusinessInfo()));
            System.out.print("Enter new business information: ");
            String newBusinessInfo = input.nextLine();
            user.setBusinessInfo(newBusinessInfo);
            System.out.println("Business information updated successfully.");
        } else {
            System.out.println("You are not authorized to update business information.");
        }
    }
    public static boolean isemailExists(String email) {
        // Iterate through the list of registered users (up) to check if the email exists
        for (Person person : up) {
            if (person.getEmail().equalsIgnoreCase(email)) {
                return true; // Email found
            }
        }
        return false; // Email not found
    }

    // Method for sending a new message without a reply
    public static void sendMessage(String senderEmail, String recipientEmail, String messageContent, String originalMessageId) {

        String messageId = UUID.randomUUID().toString();
        Message message = new Message(messageId, senderEmail, recipientEmail, messageContent, originalMessageId);
        messages.add(message);
        userMessages.computeIfAbsent(recipientEmail, k -> new ArrayList<>()).add(message);
        System.out.println("Message sent successfully to " + recipientEmail);
    }




    // Method to send a new message without an original message ID
    public static void sendMessage(String senderEmail, String recipientEmail, String messageContent) {
        sendMessage(senderEmail, recipientEmail, messageContent, null);  // Pass null for the originalMessageId
    }


    public void viewMessages(String userEmail, Scanner input) {
        List<Message> receivedMessages = userMessages.getOrDefault(userEmail, new ArrayList<>());
        if (receivedMessages.isEmpty()) {
            System.out.println("You have no received messages.");
            return;
        }

        System.out.println("You have received the following messages:");
        for (Message message : receivedMessages) {
            System.out.printf("Message from %s: %s\n", message.getSenderEmail(), message.getMessageContent());

            System.out.print("Would you like to reply to this message? (yes/no): ");
            String replyChoice = input.nextLine().trim().toLowerCase();

            if (replyChoice.equals("yes")) {
                System.out.print("Enter your reply: ");
                String replyContent = input.nextLine();
                if (replyContent.isEmpty()) {
                    System.out.println("No reply entered, skipping...");
                    continue;
                }

                sendMessage(userEmail, message.getSenderEmail(), replyContent, message.getMessageId());

            }
        }
        System.out.println("--------------------------------------------------\n");
    }


    public void viewConversationHistory(String userEmail) {
        List<Message> allMessages = new ArrayList<>(messages); // Assume 'messages' is your global message list
        Map<String, List<Message>> conversations = new HashMap<>();

        // Filter messages related to the user and organize by conversation
        for (Message message : allMessages) {
            if (message.getSenderEmail().equals(userEmail) || message.getRecipientEmail().equals(userEmail)) {
                String conversationKey = message.getOriginalMessageId() == null ? message.getMessageId() : message.getOriginalMessageId();
                conversations.computeIfAbsent(conversationKey, k -> new ArrayList<>()).add(message);
            }
        }

        // Sort and display each conversation
        for (Map.Entry<String, List<Message>> entry : conversations.entrySet()) {
            entry.getValue().sort(Comparator.comparing(Message::getTimestamp)); // Sort messages by timestamp

            System.out.println("Conversation:");
            for (Message message : entry.getValue()) {
                String direction = message.getSenderEmail().equals(userEmail) ? "You said:" : "Said by " + getNameByEmail(message.getSenderEmail()) + ":";
                System.out.printf("%s %s\n", direction, message.getMessageContent());
            }
            System.out.println("---------------------------------------------");
        }
    }

    // Helper method to get user's name by email, assuming you have access to user details
    private String getNameByEmail(String email) {
        // Assuming 'up' is your list of all persons
        for (Person person : up) {
            if (person.getEmail().equals(email)) {
                return person.getUserName(); // Assuming Person class has a getUserName method
            }
        }
        return "Unknown"; // Default case if user is not found
    }

    public Message getLastSentMessage() {
        if (!messages.isEmpty()) {
            return messages.get(messages.size() - 1);
        }
        return null;
    }

    public List<Message> getMessagesForUser(String userEmail) {
        return userMessages.getOrDefault(userEmail, new ArrayList<>());
    }
    public static void sendEmailTo(String recipient, String s) {


        try {
            Properties properties = System.getProperties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("sweetmang24@gmail.com\n", "hxpl udae osmm aagc");
                }
            });

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sweetmang24@gmail.com\n"));
            message.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(recipient, false));

            message.setSubject("Sweet Management System");
            message.setText(s);
            Transport.send(message);
            System.out.println("Sending email to: " + recipient);

        } catch (MessagingException m) {
            logger.info("MessagingException");
        }
    }
    private static Person user = new Person();
    public static void displayStoresAndProducts(Scanner input,String useremail) {

        String resetColor = "\u001B[0m"; // Reset color
        String[] storeColors = {
                "\u001B[38;5;208m", // Light orange color
                "\u001B[38;5;46m",  // Green color
                "\u001B[38;5;21m",  // Blue color
                "\u001B[38;5;196m", // Red color
                "\u001B[38;5;226m"  // Yellow color
        };

        String headerFormat = "╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n";
        String storeHeaderFormat = "║ %-10s ║ %-30s ║ %-50s ║\n";
        String productHeaderFormat = "║ %-10s ║ %-30s ║ %-20s ║ %-10s ║ %-10s ║ %-10s ║\n";
        String productRowFormat = "║ %-10s ║ %-30s ║ %-20s ║ %-10s ║ %-10s ║ %-10s ║\n";
        String divider = "╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣\n";
        String footer = "╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n";

        System.out.println(headerFormat);
        System.out.printf("║ %-10s ║ %-30s ║ %-50s ║\n", "Store ID", "Store Name", "Owner");
        System.out.println(divider);

        int colorIndex = 0;
        for (Store store : stores) {
            String storeColor = storeColors[colorIndex % storeColors.length];
            colorIndex++;

            // Print the store details in the store-specific color
            System.out.printf(storeColor + storeHeaderFormat + resetColor, store.getSid(), store.getStoreName(), store.getstoreowner());

            // Add spacing between store information and products for clarity
            System.out.println("  ");

            // Print product header with discount column
            System.out.printf(storeColor + productHeaderFormat + resetColor, "Product ID", "Product Name", "Category", "Price", "Quantity", "Discount");
            for (Tproduct product : store.getProducts()) {
                String discountStatus = product.hasDiscount() ? "Yes" : "No";
                System.out.printf(productRowFormat, product.getPid(), product.getproductName(), product.getcategory(), product.getprice(), product.getquantity(), discountStatus);
            }
            System.out.println(divider);
        }
        System.out.println(footer);

        // Verify that the user is logged in and has a valid email

        // Ask the user if they want to place an order
        System.out.print("Do you want to place an order? (yes/no): ");
        String orderChoice = input.nextLine().trim().toLowerCase();

        if (orderChoice.equals("yes")) {
            System.out.println("Placing order for user email: " + user.getEmail());
            placeOrder(input, useremail);
        }
    }

    private static List<Torder> pendingorders = new ArrayList<>();

    public static void placeOrder(Scanner input, String userEmail) {
        double totalPrice = 0.0;
        System.out.print("Enter the Store ID you want to order from: ");
        String storeId = input.nextLine().trim();

        Store selectedStore = findStoreById(storeId);
        if (selectedStore == null) {
            System.out.println("Store not found.");
            return;
        }

        List<Tproduct> productsInOrder = new ArrayList<>();
        boolean continueOrdering = true;
        while (continueOrdering) {
            System.out.print("Enter the Product ID you want to order: ");
            String productId = input.nextLine().trim();

            Tproduct selectedProduct = selectedStore.findProductById(productId);
            if (selectedProduct == null) {
                System.out.println("Product not found.");
                continue;
            }

            System.out.print("Enter the quantity: ");
            int quantity = Integer.parseInt(input.nextLine().trim());

            if (quantity > selectedProduct.getquantity()) {
                System.out.println("Insufficient quantity available.");
                continue;
            }

            selectedProduct.setquantity(quantity);
            productsInOrder.add(selectedProduct);

            totalPrice += selectedProduct.getprice() * quantity;

            System.out.print("Do you want to order another product from this store? (yes/no): ");
            String anotherOrder = input.nextLine().trim().toLowerCase();

            if (!anotherOrder.equals("yes")) {
                continueOrdering = false;
            }
        }

        System.out.println("Total price: " + totalPrice);
        System.out.print("Do you confirm the order? (yes/no): ");
        String confirmOrder = input.nextLine().trim().toLowerCase();

        if (confirmOrder.equals("yes")) {
            String orderId = generateOrderId();  // Implement this method to generate a unique order ID
            Torder newOrder = new Torder(orderId, userEmail, productsInOrder);
            pendingorders.add(newOrder);

            System.out.println("Your order has been placed and is waiting for store owner approval.");
            sendOrderNotification(newOrder);
        } else {
            System.out.println("Order canceled.");
        }
    }

    private static String generateOrderId() {
        return "O" + (int)(Math.random() * 10000);
    }

    private static Store findStoreById(String storeId) {
        for (Store store : stores) {
            if (store.getSid().equals(storeId)) {
                return store;
            }
        }
        return null;
    }

    public static void managePendingOrders(Scanner input, String ownerEmail) {
        for (Store store : stores) {
            if (store.getstoreowner().equalsIgnoreCase(ownerEmail)) {
        if (pendingorders.isEmpty()) {
            System.out.println("No pending orders for approval.");
            return;
        }

        for (int i = 0; i < pendingorders.size(); i++) {
            Torder order = pendingorders.get(i);
                    System.out.println("Order details:");
                    System.out.println("Order ID: " + order.getOid());
                    System.out.println("User email: " + order.getUserEmail());
                    System.out.println("Order Date: " + order.getOrderTime());
                    System.out.println("Total Amount: $" + order.getTotal());

                    for (Tproduct product : order.getProducts()) {
                        System.out.println("Product ID: " + product.getPid() + ", Name: " + product.getproductName() +
                                ", Quantity: " + product.getquantity() + ", Price: $" + product.getprice());
                    }

                    System.out.print("Do you want to approve this order? (yes/no): ");
                    String decision = input.nextLine().trim().toLowerCase();

                    if (decision.equals("yes")) {
                        orderlist.add(order);
                        pendingorders.remove(i);
                        System.out.println("Order approved and added to completed orders.");
                        for (Tproduct orderedProduct : order.getProducts()) {
                            Tproduct storeProduct = store.findProductById(orderedProduct.getPid());
                            if (storeProduct != null) {
                                int newQuantity = storeProduct.getquantity() - orderedProduct.getquantity();
                                if (newQuantity >= 0) {
                                    storeProduct.setquantity(newQuantity);
                                    System.out.println("Quantity updated for Product ID: " + storeProduct.getPid());
                                } else {
                                    System.out.println("Order quantity exceeds available stock for Product ID: " + storeProduct.getPid());
                                    break;
                                }
                            } else {
                                System.out.println("Product not found for ID: " + orderedProduct.getPid());
                                break;
                            }
                        }
                    } else if (decision.equals("no")) {
                        pendingorders.remove(i);
                        System.out.println("Order rejected.");
                    }
                }
            }
        }
    }
    public static void viewAllOrders(String ownerEmail) {
        for (Store store : stores) {
            if (store.getstoreowner().equalsIgnoreCase(ownerEmail)) {
                if (orderlist.isEmpty()) {
                    System.out.println("There are no orders to display.");
                    return;
                }

                for (Torder order : orderlist) {
                    System.out.println(order);
                    System.out.println("---------------------------------------------------");
                }
            }
        }
    }

    public static void viewMyOrders(String userEmail) {
        List<Torder> userorders = new ArrayList<>();

        for (Torder order : orderlist) {
            if (order.getUserEmail().equals(userEmail)) {
                userorders.add(order);
            }
        }

        if (userorders.isEmpty()) {
            System.out.println("You have no orders.");
        } else {
            for (Torder order : userorders) {
                System.out.println(order);
            }
        }
    }


    public static void viewProductsByOwner(String ownerEmail) {
        for (Store store : stores) {
            if (store.getstoreowner().equalsIgnoreCase(ownerEmail)) {
                System.out.println("Products for Store: " + store.getStoreName());
                for (Tproduct product : store.getProducts()) {
                    System.out.printf("Product ID: %s, Name: %s, Category: %s, Price: %.2f, Quantity: %d\n",
                            product.getPid(), product.getproductName(), product.getcategory(), product.getprice(), product.getquantity());
                }
                System.out.println();
            }
        }
    }
    public static void addProduct(Scanner input, String ownerEmail) {
        for (Store store : stores) {
            if (store.getstoreowner().equalsIgnoreCase(ownerEmail)) {
                System.out.print("Enter product name: ");
                String productName = input.nextLine();
                System.out.print("Enter product category: ");
                String category = input.nextLine();
                System.out.print("Enter product price: ");
                double price = input.nextDouble();
                System.out.print("Enter product quantity: ");
                int quantity = input.nextInt();
                input.nextLine(); // consume newline

                // Assuming product ID is auto-generated or entered manually
                String productId = "P" + (store.getProducts().size() + 1);

                Tproduct newProduct = new Tproduct(productId, productName, category, price, quantity);
                store.addProduct(newProduct);
                System.out.println("Product added successfully.");
            }
        }
    }
  public static void updateProduct(Scanner input, String ownerEmail) {
        for (Store store : stores) {
            if (store.getstoreowner().equalsIgnoreCase(ownerEmail)) {
                System.out.print("Enter product ID to update: ");
                String productId = input.nextLine();

                Tproduct product = store.findProductById(productId);
                if (product != null) {
                    System.out.print("Enter new product name (leave blank to keep current): ");
                    String productName = input.nextLine();
                    System.out.print("Enter new category (leave blank to keep current): ");
                    String category = input.nextLine();
                    System.out.print("Enter new price (enter -1 to keep current): ");
                    double price = input.nextDouble();
                    System.out.print("Enter new quantity (enter -1 to keep current): ");
                    int quantity = input.nextInt();
                    input.nextLine(); // consume newline

                    if (!productName.isEmpty()) product.setproductName(productName);
                    if (!category.isEmpty()) product.setcategory(category);
                    if (price != -1) product.setPrice(price);
                    if (quantity != -1) product.setquantity(quantity);

                    System.out.println("Product updated successfully.");
                } else {
                    System.out.println("Product not found.");
                }
            }
        }
    }
    public static void deleteProduct(Scanner input, String ownerEmail) {
        for (Store store : stores) {
            if (store.getstoreowner().equalsIgnoreCase(ownerEmail)) {
                System.out.print("Enter product ID to delete: ");
                String productId = input.nextLine();

                Tproduct product = store.findProductById(productId);
                if (product != null) {
                    store.removeProduct(product);
                    System.out.println("Product deleted successfully.");
                } else {
                    System.out.println("Product not found.");
                }
            }
        }
    }





    public static void applyDiscount(Scanner input, String ownerEmail) {
        // Prompt user for product ID to apply discount
        System.out.println("Enter the ID of the product to apply discount:");
        String productId = input.nextLine().trim();

        // Find the store owned by the user
        Store userStore = null;
        for (Store store : stores) {
            if (store.getstoreowner().equalsIgnoreCase(ownerEmail)) {
                userStore = store;
                break;
            }
        }

        if (userStore == null) {
            System.out.println("No store found for the provided email.");
            return;
        }

        // Find the product in the store
        Tproduct product = userStore.findProductById(productId);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        // Prompt user for discount details
        System.out.println("Enter the discount type (fixed/percentage):");
        String discountType = input.nextLine().trim().toLowerCase();

        System.out.println("Is the discount temporary? (yes/no):");
        String temporary = input.nextLine().trim().toLowerCase();
        boolean isDiscountTemporary = temporary.equals("yes");

        LocalDate discountStartDate = null;
        LocalDate discountEndDate = null;

        if (isDiscountTemporary) {
            System.out.println("Enter the start date of the discount (yyyy-mm-dd):");
            discountStartDate = LocalDate.parse(input.nextLine().trim());
            System.out.println("Enter the end date of the discount (yyyy-mm-dd):");
            discountEndDate = LocalDate.parse(input.nextLine().trim());
        }

        if (discountType.equals("fixed")) {
            System.out.println("Enter the discount amount (fixed value):");
            double discountAmount = input.nextDouble();
            input.nextLine(); // consume newline
            applyFixedDiscount(product, discountAmount);
        } else if (discountType.equals("percentage")) {
            System.out.println("Enter the discount percentage:");
            double discountPercentage = input.nextDouble();
            input.nextLine(); // consume newline
            applyPercentageDiscount(product, discountPercentage);
        } else {
            System.out.println("Invalid discount type. Please choose 'fixed' or 'percentage'.");
        }

        if (isDiscountTemporary) {
            System.out.println("Discount will be applied from " + discountStartDate + " to " + discountEndDate);
        }
    }

    private static void applyFixedDiscount(Tproduct product, double discountAmount) {
        double newPrice = product.getprice() - discountAmount;
        if (newPrice < 0) newPrice = 0; // Ensure price does not go negative
        product.setprice(newPrice);
        product.setDiscount(true); // Set discount status
        System.out.println("Fixed discount applied: $" + discountAmount + " off product " + product.getproductName());
        showDiscountedProduct(product);
    }

    private static void applyPercentageDiscount(Tproduct product, double discountPercentage) {
        double newPrice = product.getprice() * (1 - discountPercentage / 100);
        if (newPrice < 0) newPrice = 0; // Ensure price does not go negative
        product.setprice(newPrice);
        product.setDiscount(true); // Set discount status
        System.out.println("Percentage discount applied: " + discountPercentage + "% off product " + product.getproductName());
        showDiscountedProduct(product);
    }

    private static void showDiscountedProduct(Tproduct product) {
        System.out.printf("Product ID: %s, Name: %s, New Price: %.2f\n",
                product.getPid(), product.getproductName(), product.getprice());
    }

    public static void monitorSales(String ownerEmail, List<Store> stores, List<Torder> orderList) {
        // Create a map to store total sales per product
        Map<String, Double> sales = new HashMap<>();

        // Find the store of the given owner email
        Store ownerStore = null;
        for (Store store : stores) {
            if (store.getstoreowner().equalsIgnoreCase(ownerEmail)) {
                ownerStore = store;
                break;
            }
        }

        if (ownerStore == null) {
            System.out.println("Store not found for the given owner email.");
            return;
        }

        // Process orders to calculate total sales for each product
        for (Torder order : orderList) {
            for (Tproduct product : order.getProducts()) {
                // Check if the product belongs to the store
                Tproduct storeProduct = ownerStore.findProductById(product.getPid());

                if (storeProduct != null) {
                    double totalPrice = product.getprice() * product.getquantity();
                    sales.put(product.getPid(), sales.getOrDefault(product.getPid(), 0.0) + totalPrice);
                }
            }
        }

        // Print sales data
        System.out.println("Sales Report:");
        for (Map.Entry<String, Double> entry : sales.entrySet()) {
            System.out.println("Product ID: " + entry.getKey());
            System.out.println("Total Sales: $" + entry.getValue());
            System.out.println("---------------------------------------------------");
        }
    }



    public static void identifyBestSellingProducts(String ownerEmail, List<Store> stores, List<Torder> orderList) {
        Map<String, Integer> salesQuantity = new HashMap<>();

        // Find the store of the given owner email
        Store ownerStore = null;
        for (Store store : stores) {
            if (store.getstoreowner().equalsIgnoreCase(ownerEmail)) {
                ownerStore = store;
                break;
            }
        }

        if (ownerStore == null) {
            System.out.println("Store not found for the given owner email.");
            return;
        }

        // Process orders to calculate total quantity sold for each product
        for (Torder order : orderList) {
            for (Tproduct product : order.getProducts()) {
                // Check if the product belongs to the store
                Tproduct storeProduct = ownerStore.findProductById(product.getPid());

                if (storeProduct != null) {
                    salesQuantity.put(product.getPid(), salesQuantity.getOrDefault(product.getPid(), 0) + product.getquantity());
                }
            }
        }

        // Find the best-selling product
        String bestSellingProduct = null;
        int maxQuantity = 0;
        for (Map.Entry<String, Integer> entry : salesQuantity.entrySet()) {
            if (entry.getValue() > maxQuantity) {
                maxQuantity = entry.getValue();
                bestSellingProduct = entry.getKey();
            }
        }

        // Print best-selling product
        if (bestSellingProduct != null) {
            System.out.println("Best-Selling Product ID: " + bestSellingProduct);
            System.out.println("Quantity Sold: " + maxQuantity);
        } else {
            System.out.println("No sales data available.");
        }
    }



    public static void monitorProfitsAndGenerateReport(List<Store> stores, List<Torder> orderList) {
        // Map to store total sales per store
        Map<String, Double> storeSales = new HashMap<>();

        // Process orders to calculate total sales for each store
        for (Torder order : orderList) {
            for (Tproduct product : order.getProducts()) {
                for (Store store : stores) {
                    Tproduct storeProduct = store.findProductById(product.getPid());
                    if (storeProduct != null && storeProduct.getPid().equals(product.getPid())) {
                        double totalPrice = product.getprice() * product.getquantity();
                        storeSales.put(store.getSid(), storeSales.getOrDefault(store.getSid(), 0.0) + totalPrice);
                    }
                }
            }
        }

        // Print financial report
        String reportContent = "Financial Report:\n\n";
        for (Map.Entry<String, Double> entry : storeSales.entrySet()) {
            reportContent += "Store ID: " + entry.getKey() + "\n";
            reportContent += "Total Sales: $" + entry.getValue() + "\n";
            reportContent += "------------------------------------\n";
        }

        System.out.println(reportContent);

        // Ask if the admin wants to print the report
        System.out.println("Do you want to print this report as a PDF? (yes/no)");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine().trim().toLowerCase();

        if (choice.equals("yes")) {
            try {
                createPdfReport(reportContent);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Failed to create PDF report.");
            }
        }
    }

    // Helper method to create a PDF report
    private static void createPdfReport(String content) throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("FinancialReport.pdf"));
        document.open();
        document.add(new Paragraph(content));
        document.close();

        System.out.println("PDF report created successfully.");
    }
    public static void identifyBestSellingProductsInEachStore(List<Store> stores, List<Torder> orderList) {
        for (Store store : stores) {
            Map<String, Integer> salesQuantity = new HashMap<>();

            // Process orders to calculate total quantity sold for each product in the store
            for (Torder order : orderList) {
                for (Tproduct product : order.getProducts()) {
                    Tproduct storeProduct = store.findProductById(product.getPid());
                    if (storeProduct != null) {
                        salesQuantity.put(product.getPid(), salesQuantity.getOrDefault(product.getPid(), 0) + product.getquantity());
                    }
                }
            }

            // Find the best-selling product
            String bestSellingProduct = null;
            int maxQuantity = 0;
            for (Map.Entry<String, Integer> entry : salesQuantity.entrySet()) {
                if (entry.getValue() > maxQuantity) {
                    maxQuantity = entry.getValue();
                    bestSellingProduct = entry.getKey();
                }
            }

            // Print best-selling product information
            System.out.println("Store ID: " + store.getSid());
            if (bestSellingProduct != null) {
                System.out.println("Best-Selling Product ID: " + bestSellingProduct);
                System.out.println("Quantity Sold: " + maxQuantity);
            } else {
                System.out.println("No sales data available.");
            }
            System.out.println("------------------------------------");
        }



    }

    private static void sendOrderNotification(Torder order) {
        // Find the store and store owner based on the products in the order
        Tproduct firstProduct = order.getProducts().get(0);  // Assuming all products in the order are from the same store
        Store store = findStoreByProductId(firstProduct.getPid());
        String storeOwnerEmail = store.getstoreowner();
        Person storeOwner = findPersonByEmail(storeOwnerEmail);
        Person customer = findPersonByEmail(order.getUserEmail());

        // Construct the email message
        String emailContent = "Dear " + storeOwner.getUserName() + ",\n\n" +
                "You have received a new order! Below are the details to help you prepare and dispatch the order promptly.\n\n" +
                "Order ID: " + order.getOid() + "\n" +
                "Customer Name: " + customer.getUserName() + "\n" +
                "Customer Email: " + order.getUserEmail() + "\n" +
                "Ordered Items:\n";

        // Loop through ordered items and append details to the email content
        for (Tproduct product : order.getProducts()) {
            emailContent += " - " + product.getproductName() + ": " + product.getquantity() + " pcs\n";
        }

        // Append total amount and customer contact details
        emailContent += "\nTotal Amount: $" + order.getTotal() + "\n" +
                "Delivery Address: " + customer.getCity() + "\n" +
                "Contact Number: " + customer.getPhoneNum()+ "\n\n" +
                "Please confirm the receipt of this order and update the order status in your dashboard.\n\n" +
                "Thank you for your prompt attention to this order.\n\n" +
                "Best regards,\n" +
                "[The admin]\n";

        // Send the email
        sendEmailTo(storeOwnerEmail, emailContent);
    }
    private static Store findStoreByProductId(String productId) {
        for (Store store : stores) {
            if (store.findProductById(productId) != null) {
                return store;
            }
        }
        return null;
    }

    private static Person findPersonByEmail(String email) {
        for (Person person : up) {  // Assuming usersList contains all users, store owners, and suppliers
            if (person.getEmail().equalsIgnoreCase(email)) {
                return person;
            }
        }
        return null;
    }



}










