import java.util.*;
import java.awt.*;
import java.net.*;

 class Driver{
    Scanner sc = new Scanner(System.in);
    String driverId; //primary key
    String driverName;
    String driverMobNumber;
 public int driverStatus; //Let's us know if he is already delivering any order(1);
Driver(){
    driverStatus =0;
}
    public void appointDriver(){
        System.out.print("Enter Driver Id: ");
        driverId = sc.nextLine();
        System.out.print("Enter Driver Name: ");
        driverName = sc.nextLine();
         System.out.print("Enter Driver Mobile Number: ");
        driverMobNumber= sc.nextLine();
    }
    
    public void displayDriverDetails(){
        System.out.println(driverId);
        System.out.println(driverName);
        System.out.println(driverMobNumber);
        System.out.println(driverStatus);
    }

    public void assignDriver(){
        driverStatus = 1;
    }
}

 class Product{
    Scanner sc = new Scanner(System.in);
   public String productId; //primary Key
    String productName;
    String category;
    int productCost;
public void addProduct(){
        System.out.print("product ID: ");
    productId = sc.nextLine();

  System.out.print("Product: ");
    productName = sc.nextLine();

System.out.print("Category: ");
    category = sc.nextLine();

System.out.print("Cost: ");
    productCost = sc.nextInt();
}
 
 public void displayProduct(){
     System.out.println("Product Id: " + productId);
     System.out.println("Product Name: " + productName);
     System.out.println("Category: " + category);
     System.out.println("Product Cost: " + productCost);
 }

}


//--------------------------------------------Cart Class
class Cart{
    String username;
    String password;
    Vector <Product>cartProducts = new Vector<>(); 

    public void signUp(String username, String password){
    this.username = username;
    this.password = password;
    System.out.println("User Created!");
    }

    public void addToCart(Product productToAdd){
        cartProducts.addElement(productToAdd);
        System.out.println("Added To Cart");
    }
    public void displayCartProduct(int i){
        cartProducts.elementAt(i).displayProduct();
    }
}
//Thimk if there will be a different class for bill!

public class MCP{
    //Global vectors
 static Vector <Driver> v = new Vector<>(); //To store driver objects
 static Vector <Product> pList = new Vector<>(10); //To store product  objects
 static Vector <Cart> carts = new Vector<>(10); //To store carts for users

  static void login(){
        String adminUsername = "admin";
        String adminPassword = "admin";
        String userInputUsername;
        String userInputPassword;
    int flag = 0;
    int count = 3;
while(count!=0){
    System.out.print("Enter Username: ");
    Scanner sc = new Scanner(System.in);
    userInputUsername = sc.nextLine();
    System.out.print("Enter Password: ");
    userInputPassword = sc.nextLine();

    if(adminUsername.equals(userInputUsername) && adminPassword.equals(userInputPassword)){
        System.out.println("Access Granted!!");
        System.out.println("---------------Welcome-------------");
        flag = 1;
        break;
    }
    count--;
    System.out.println("Invalid Username/Password. You have " + count + " attempts remaining!");
}
if(flag!=1){
    System.out.println("Access Denied");
    System.exit(0);
}
    }
    
public static void displayMainMenu(){
     int choice;
while(true){
System.out.println("1.Admin Portal");
System.out.println("2.User Portal ");
System.out.println("3.Visit Website");
System.out.println("4.Exit");
  Scanner sc = new Scanner(System.in);
     choice = sc.nextInt();

    switch(choice) {
        case 1: login();
        System.out.print("\033\143");
        displayAdminMenu();
     break;
case 2:
displayUserMenu();
break;
     case 3:
   try {
  Desktop desktop = java.awt.Desktop.getDesktop();
  URI oURL = new URI("http://www.google.com");
  desktop.browse(oURL);
} catch (Exception e) {
  e.printStackTrace();
}
     break;
     case 4:
     System.out.println("Thank You!");
     System.exit(0);
     break;
        default:
        System.out.println("Invalid Choice 1");
        break;
    }
}
}

public static void displayAdminMenu(){
     int adminChoice;
     String productIdToDelete;
while(true){
System.out.println("1.Add Product\n2.View Products\n3.Remove Product\n4.Add Delivery Boy\n5.View Delivery Boys\n6.Back");
System.out.print("Enter Action You Want to Perform: ");
  Scanner sc = new Scanner(System.in);

   adminChoice = sc.nextInt();
        switch(adminChoice){
        case 1: 
        Product p = new Product();
      p.addProduct();
      pList.addElement(p);
        break;
        case 2:
for(int i = 0; i<pList.size(); i++){
    pList.elementAt(i).displayProduct();
    System.out.println("");
}
        break;

        case 3:
    for(int i = 0; i<pList.size(); i++){
    pList.elementAt(i).displayProduct();
    System.out.println("");
    }
System.out.print("Select product id you want to delete: ");
// Scanner sc1 = new Scanner(System.in);
sc.nextLine();
productIdToDelete = sc.nextLine();

 for(int i = 0; i<pList.size(); i++){
     if((pList.elementAt(i).productId).equals(productIdToDelete)){
         pList.removeElementAt(i);
        System.out.println(productIdToDelete + "is deleted");
     }
    }
        break;
        case 4:
        Driver d = new Driver();
        d.appointDriver();        
        v.addElement(d);
        break;
case 5:
for(int i=0; i<v.size(); i++){
    v.elementAt(i).displayDriverDetails();
    System.out.println("");
}


break;

        case 6:
        System.out.print("\033\143");
        displayMainMenu();
        break;
        default:
        System.out.println("Invalid Choice 2");
        break;
        }
}
}

//---------------------------------------User Menu-------------
public static void displayUserMenu(){
    Scanner sc = new Scanner(System.in);
    int userChoice;
    String username;
    String password;
    while(true){
    System.out.println("1.Sign Up");
    System.out.println("2.Login");
    System.out.println("5.Back");
System.out.print("Enter Which action you want to perform: ");
userChoice = sc.nextInt();
 switch(userChoice){
     case 1:
    Cart c = new Cart();
 
sc.nextLine();

System.out.print("Create Username: ");
username = sc.nextLine();
System.out.print("Set Password: ");
password = sc.nextLine();
    c.signUp(username, password);
    carts.addElement(c);
    System.out.println(c.username);
    System.out.println(c.password);
    break;

    case 2:
 sc.nextLine();

System.out.print("Enter username: ");
username = sc.nextLine();
System.out.print("Enter Password: ");
password = sc.nextLine();
menuAfterLiogin(username, password);
    break;

    case 5:
displayMainMenu();
break;
 }

    }
}



static void menuAfterLiogin(String username, String password){
    Scanner sc = new Scanner(System.in);
    int userChoice; //for switch case
    int i; //0
    int flag = 0; //
    Product productToPurchase;
    double  orderTotal =0;
     for(i=0; i<carts.size(); i++){
        if(carts.elementAt(i).username.equals(username) && carts.elementAt(i).password.equals(password)){
            System.out.println("User Cart Found");
        // System.out.println("Value of i = " + i);
        flag= 1;
            break;
            }
        }

    if(flag!=1){
        System.out.println("Invalid username Or password");
        displayUserMenu();
    } 
    
System.out.println("Value of i = " + i);
while(true){
System.out.println("1. Buy a product");
    System.out.println("2.View My Cart");
    System.out.println("4.Confirm and Place Order");
    System.out.println("5.Back");

userChoice = sc.nextInt();
sc.nextLine();
switch(userChoice){
    case 1:
    //Diplay all products
    
    for(int j = 0; j<pList.size(); j++){
    pList.elementAt(j).displayProduct();
    System.out.println("");
    }
    
if(pList.size() ==0){
System.out.println("No Products yet");
} else{ 


System.out.print("Select product id you want to purchase: ");
 String productIdToPurchase = sc.nextLine();

//For tracing purpoase
// System.out.println(productIdToPurchase);


//find complete product object 
// System.out.println("User cart is at:" + i);
for(int j=0; j<pList.size(); j++){
    if(pList.elementAt(j).productId.equals(productIdToPurchase)){
       productToPurchase = pList.elementAt(j);
        carts.elementAt(i).addToCart(productToPurchase);
        break;
    }
}
    //Add item to appropriate cart

    System.out.println("Cart: ");
    for(int j=0; j<carts.elementAt(i).cartProducts.size(); j++){
        carts.elementAt(i).displayCartProduct(j);
    }
}
   break;

case 3:
  System.out.println("--------------------------My Cart: ----------------------------------");
    for(int j=0; j<carts.elementAt(i).cartProducts.size(); j++){
        carts.elementAt(i).displayCartProduct(j);
    }
    break;
   case 4:
//Display Cart and Perform total on Cost property
  System.out.println("-----------------My Invoice----------");
    for(int j=0; j<carts.elementAt(i).cartProducts.size(); j++){
        carts.elementAt(i).displayCartProduct(j);
    }

    for(int j=0; j<carts.elementAt(i).cartProducts.size(); j++){
       orderTotal = orderTotal + carts.elementAt(i).cartProducts.elementAt(j).productCost;
    }

    System.out.println("Your Order Total: " + orderTotal);
//Assign driver and display his details

for(int j=0; j<v.size(); j++){
    if(v.elementAt(j).driverStatus ==0){
   v.elementAt(j).assignDriver();
   v.elementAt(j).displayDriverDetails();
   break;
    }
}
   case 5:
displayMainMenu();
break;
}

}
}

    public static void main(String args[]){  
     displayMainMenu(); 
    }
}

