package testng_learning;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _03_Soft_vs_Hard_Assertions {
    /*
    @Test(priority = 1, description = "Practising hard assert")
    public void method1(){
        //Hard Assertions
        Assert.assertTrue(true);
        Assert.assertTrue(false, "=====Failure=====");

        System.out.println("Hello World");
    }

    @Test(priority = 2, description = "Practising soft assertion")
    public void method2(){
        //Soft assertions
        //
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(true);
        softAssert.assertTrue(false, "=====Failure=====");//Assertion error


        System.out.println("Hello World");
        softAssert.assertAll();

}
/*
     */
    }


