package com.example.check;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Check_even_oddTest {
    @Test
    public void test0() {
        assertTrue(Check_even_odd.check_even_odd(8) == "even");
    }
    @Test
    public void test1() {
        assertTrue(Check_even_odd.check_even_odd(5.5) == "neither even nor odd");
    }
    @Test
    public void test2() {
        assertTrue(Check_even_odd.check_even_odd(0) == "even");
    }
    @Test
    public void test3() {
        assertTrue(Check_even_odd.check_even_odd(9) == "odd");
    }
    @Test
    public void test4() {
        assertTrue(Check_even_odd.check_even_odd(-1) == "neither even nor odd");
    }
    @Test
    public void test5() {
        assertTrue(Check_even_odd.check_even_odd(-1.5) == "neither even nor odd");
    }
    @Test
    public void test6() {
        assertTrue(Check_even_odd.check_even_odd(-4) == "neither even nor odd");
    }
    @Test
    public void test7() {
        assertTrue(Check_even_odd.check_even_odd(-2.5) == "neither even nor odd");
    }


}