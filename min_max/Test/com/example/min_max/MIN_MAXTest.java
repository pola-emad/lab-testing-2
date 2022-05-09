package com.example.min_max;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MIN_MAXTest {
    @Test
    public void test0() {
        double test_arr[]={10,20,30,40};
        assertTrue(MIN_MAX.max(test_arr) == 40.0);
    }
    @Test
    public void test1() {
        double test_arr[]={-1.5,0.5,10.5,15.5,3.5};
        assertTrue(MIN_MAX.max(test_arr)== 15.5);
    }
    @Test
    public void test2() {
        double test_arr[]={-4.2,-5.3,-7.4,-1.5,-1.5};
        assertTrue(MIN_MAX.max(test_arr) == -1.5);
    }
    @Test
    public void test3() {
        double test_arr[]={0,0,0,0};
        assertTrue(MIN_MAX.max(test_arr) == 0.0);
    }
    @Test
    public void test4() {
        double test_arr[]={10,20,30,40};
        assertTrue(MIN_MAX.min(test_arr) == 10.0);
    }
    @Test
    public void test5() {
        double test_arr[]={-1.5,0.5,10.5,15.5,3.5};
        assertTrue(MIN_MAX.min(test_arr) == -1.5);
    }
    @Test
    public void test6() {
        double test_arr[]={-4.2,-5.3,-7.4,-1.5,-1.5};
        assertTrue(MIN_MAX.min(test_arr) == -7.4);
    }
    @Test
    public void test7() {
        double test_arr[]={0,0,0,0};
        assertTrue(MIN_MAX.min(test_arr) == 0.0);
    }

}