/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package project1;

import java.sql.DriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lucasspain & Fahim
 */
public class ShopAppTest {
    
    public ShopAppTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("-----Starting test-----");
    }
    
    @After
    public void tearDown() {
        System.out.println("-----End of test-----\n");
    }

    /**
     * Test of the login page - makes sure the correct loginFlag will be set when correct login information is given
     */
    @Test
    public void testLoginCorrect() {
        
        ArrayList<Product> productList = new ArrayList<Product>();

        MeatReader meatReader = new MeatReader();
        ArrayList<Product> meatList = meatReader.getMeats();
        productList.addAll(meatList);

        FruitReader fruitReader = new FruitReader();
        ArrayList<Product> fruitList = fruitReader.getFruit();
        productList.addAll(fruitList);

        VegetableReader vegetableReader = new VegetableReader();
        ArrayList<Product> vegetableList = vegetableReader.getVegetable();
        productList.addAll(vegetableList);

        Shop shop1 = new Shop();

        for (int i = 0; i < productList.size(); i++) {
            shop1.addProducts(productList.get(i));
        }
        
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
        LoginModel loginModel = new LoginModel();
        loginModel.db.dbusername = "test";
        loginModel.db.dbpassword = "test";
        LoginController loginController = new LoginController(loginScreen, loginModel);
        

        loginModel.checkName(loginModel.db.dbusername, loginModel.db.dbpassword);
        
        assertTrue(loginModel.data.loginFlag);

    }
    
        /**
     * Test of product search function, makes sure the correct products are displayed when a search is entered.
     */
    @Test
    public void testSearch() {
        
        ArrayList<Product> productList = new ArrayList<Product>();

        MeatReader meatReader = new MeatReader();
        ArrayList<Product> meatList = meatReader.getMeats();
        productList.addAll(meatList);

        FruitReader fruitReader = new FruitReader();
        ArrayList<Product> fruitList = fruitReader.getFruit();
        productList.addAll(fruitList);

        VegetableReader vegetableReader = new VegetableReader();
        ArrayList<Product> vegetableList = vegetableReader.getVegetable();
        productList.addAll(vegetableList);

        Shop shop1 = new Shop();

        for (int i = 0; i < productList.size(); i++) {
            shop1.addProducts(productList.get(i));
        }
        
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
        LoginModel loginModel = new LoginModel();
        loginModel.db.dbusername = "test";
        loginModel.db.dbpassword = "test";
        LoginController loginController = new LoginController(loginScreen, loginModel);
        

        loginModel.checkName(loginModel.db.dbusername, loginModel.db.dbpassword);
        
        ViewAllItems allItems = new ViewAllItems();
        
        String searchTerm = "Chicken";
        
        ArrayList<Product> searchResult = allItems.search(searchTerm);
        System.out.println("Search term is: "+searchTerm);
        
        for (Product p : searchResult)
        {
            boolean searchTest = (p.getName().contains(searchTerm));

            assertTrue(searchTest);
            if (searchTest)
            {
                System.out.println(p+" contains the search term");
            }
            else
            {
                System.out.println(p+" does not contain the search term");
            }

        }

    }
        /**
     * Test to make sure the tables have been created
     */
    @Test
    public void testTables() {

        ArrayList<Product> productList = new ArrayList<Product>();

        MeatReader meatReader = new MeatReader();
        ArrayList<Product> meatList = meatReader.getMeats();
        productList.addAll(meatList);

        FruitReader fruitReader = new FruitReader();
        ArrayList<Product> fruitList = fruitReader.getFruit();
        productList.addAll(fruitList);

        VegetableReader vegetableReader = new VegetableReader();
        ArrayList<Product> vegetableList = vegetableReader.getVegetable();
        productList.addAll(vegetableList);

        Shop shop1 = new Shop();

        for (int i = 0; i < productList.size(); i++) {
            shop1.addProducts(productList.get(i));
        }

        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
        LoginModel loginModel = new LoginModel();
        loginModel.db.dbusername = "test";
        loginModel.db.dbpassword = "test";
        LoginController loginController = new LoginController(loginScreen, loginModel);

        boolean checkTableUserInfo = loginModel.db.checkTableExisting("UserInfo");
        assertTrue(checkTableUserInfo);

        if (checkTableUserInfo)
        {
            System.out.println("UserInfo table exists");
        }
        else
        {
            System.out.println("UserInfo table does not exist");
        }

        boolean checkTableProducts = loginModel.db.checkTableExisting("Products");
        assertTrue(checkTableProducts);

        if (checkTableProducts)
        {
            System.out.println("Products table exists");
        }
        else {
            System.out.println("Products table does not exist");
        }

    }
    
            /**
     * Test to make sure that products are being added to the cart correctly
     */
    @Test
    public void testCart() {

        ArrayList<Product> productList = new ArrayList<Product>();

        MeatReader meatReader = new MeatReader();
        ArrayList<Product> meatList = meatReader.getMeats();
        productList.addAll(meatList);

        FruitReader fruitReader = new FruitReader();
        ArrayList<Product> fruitList = fruitReader.getFruit();
        productList.addAll(fruitList);

        VegetableReader vegetableReader = new VegetableReader();
        ArrayList<Product> vegetableList = vegetableReader.getVegetable();
        productList.addAll(vegetableList);

        Shop shop1 = new Shop();

        for (int i = 0; i < productList.size(); i++) {
            shop1.addProducts(productList.get(i));
        }

        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
        LoginModel loginModel = new LoginModel();
        loginModel.db.dbusername = "test";
        loginModel.db.dbpassword = "test";
        LoginController loginController = new LoginController(loginScreen, loginModel);
        
        ViewAllItems allItems = new ViewAllItems();  
        Cart.getCartInstance().add(new Fruit("Test Product", "Test Manufacturer", 1.00));
        
        ViewCart viewCart = new ViewCart();
        
        System.out.println(viewCart.getProductList());
        
    }
    
    //Test for login system - Makes sure user wont be logged in if wrong password is entered
        @Test
    public void testLoginIncorrect() {
        
        ArrayList<Product> productList = new ArrayList<Product>();

        MeatReader meatReader = new MeatReader();
        ArrayList<Product> meatList = meatReader.getMeats();
        productList.addAll(meatList);

        FruitReader fruitReader = new FruitReader();
        ArrayList<Product> fruitList = fruitReader.getFruit();
        productList.addAll(fruitList);

        VegetableReader vegetableReader = new VegetableReader();
        ArrayList<Product> vegetableList = vegetableReader.getVegetable();
        productList.addAll(vegetableList);

        Shop shop1 = new Shop();

        for (int i = 0; i < productList.size(); i++) {
            shop1.addProducts(productList.get(i));
        }
        
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
        LoginModel loginModel = new LoginModel();
        loginModel.db.dbusername = "test";
        loginModel.db.dbpassword = "test";
        LoginController loginController = new LoginController(loginScreen, loginModel);
        

        loginModel.checkName(loginModel.db.dbusername, loginModel.db.dbpassword);
        
        loginModel.db.dbusername = "test";
        loginModel.db.dbpassword = "wrongpassword";
        
        loginModel.checkName(loginModel.db.dbusername, loginModel.db.dbpassword);

        assertFalse(loginModel.data.loginFlag);

    }
    
}
