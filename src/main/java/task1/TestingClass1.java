package task1;
import org.testng.annotations.*;

public class TestingClass1 {
    @BeforeSuite
    public void beforeAsUITE(){
        System.out.println("Before a test suite ");
    }
    @AfterSuite
    public void afterASuite(){
        System.out.println("After a test suite ");
    }
    @BeforeTest
    public void beforeATestRun(){
        System.out.println("Before a test run");
    }
    @AfterTest
    public void afterATestRun(){
        System.out.println("After a test run");
    }
    @BeforeClass
    public void beforeAClass() {
        System.out.println("First method in this class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Last test method in this class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("\t Before a test method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("\t After a test method");
    }

    @Test
    public void testcase1() {
        System.out.println("\t\t Test case 1");
    }

    @Test
    public void testcase2() {
        System.out.println("\t\t Test case 2");
    }
}