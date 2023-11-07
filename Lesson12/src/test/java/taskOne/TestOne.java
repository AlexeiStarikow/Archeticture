package test.java.taskOne;

import org.junit.*;

public class TestOne {

    @BeforeClass
    public static void setUpClass() {
        System.out.println("BeforeClass - This will be executed once before all tests in this class.");
    }

    @Before
    public void setUp() {
        System.out.println("Before - This will be executed before each test.");
    }

    @Test
    public void testMethod1() {
        System.out.println("Test Method 1 - This is a sample test.");
    }

    @Test
    public void testMethod2() {
        System.out.println("Test Method 2 - This is another sample test.");
    }

    @After
    public void tearDown() {
        System.out.println("After - This will be executed after each test.");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("AfterClass - This will be executed once after all tests in this class.");
    }
}
