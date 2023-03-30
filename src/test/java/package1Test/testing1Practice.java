package package1Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class testing1Practice {
	
	
	@BeforeSuite
    public void beforeSuite() {
        System.out.println("beforeSuite:  that will run once before all tests " + "in this SUITE have RUN");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("afterSuite:  that will run only once after all " + "test in this suite have run");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("beforeClass:  will run only once before the first " + "test method in the current class is invoked");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("afterClas:  will run only once after all the test " + "methods in the current class have run");

    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("beforeTest:  will run before any test method belonging " + "to the classes inside <test> tag is run");
    }

    @AfterTest
    public void afterTest() {
        System.out.println(
                "afterTest:  will run after all the test methods belonging " + "to the classes inside the <test> tag have run");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod:  This annotated method will be run before each test method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod(:  This annotated method will be run after each test method");

    }
    @Test
    public void test1() {
    	System.out.println("test1");
    	
    }
    @Test
    public void test2() {
    	System.out.println("test2");
    	
    }

}
