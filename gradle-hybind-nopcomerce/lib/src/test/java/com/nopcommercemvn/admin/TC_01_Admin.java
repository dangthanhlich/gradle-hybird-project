package com.nopcommercemvn.admin;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommercemvn.adminmvn.AdminPageObject;
import pageObjects.nopCommercemvn.adminmvn.PageGeneratorManager;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;
import java.util.Random;

public class TC_01_Admin extends BaseTest {

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        adminPage = PageGeneratorManager.getAdminPage(driver);

        firstName = "Automation";
        lastName = "FC";
    }

    @Test
    public void Admin_01_Login(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login to system");
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: open page");
   }

    @Test
    public void Admin_02_Search_With_Product_Name(Method method) {

    }

    @Test
    public void Admin_03_Search_With_Product_Name_parent_Catefory_unChecked(Method method) {

    }

    @Test
    public void Admin_04_Search_With_Product_Name_parent_Catefory_Checked(Method method) {

    }

    @Test
    public void Admin_05_Search_With_Product_Name_Child_Category(Method method) {

    }

    @Test
    public void Admin_06_Search_With_Product_Name_Manufacturer(Method method) {

    }

    @Test
    public void Admin_07_Go_directly_to_product_SKU(Method method) {

    }

    @Test
    public void Admin_08_Create_new_Customer(Method method) {

    }

    @Test
    public void Admin_09_Search_Customer_with_Email(Method method) {

    }

    @Test
    public void Admin_10_Search_Customer_With_First_Last_Name(Method method) {

    }

    @Test
    public void Admin_11_Search_Customer_Company(Method method) {

    }

    @Test
    public void Admin_12_Search_Customer_And_Full_Data(Method method) {

    }

    @Test
    public void Admin_13_Edit_Customer(Method method) {

    }

    @Test
    public void Admin_14_Add_New_Address_In_Customer_Detail(Method method) {

    }

    @Test
    public void Admin_15_Edit_Address_in_Cutomer_Detail(Method method) {

    }

    @Test
    public void Admin_15_Delete_Address_in_Customer_Detail(Method method) {

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public int generateFakeNumber() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }

    private WebDriver driver;
    AdminPageObject adminPage;
    String firstName, lastName, emailAddress, validPassword;
}
