package com.alisnobby.rutest.models;



import org.junit.*;


public class CartTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {


    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {

    }

    @Test
    public void test1CartIsEmpty() {

        Cart cart = new Cart();
        org.junit.Assert.assertEquals("Empty cart", true, cart.isEmpty());
    }

    @Test
    public void addProduct() {

        Cart cart = new Cart();
        cart.addProduct(new Product("gucci bag"));
        //comment
        //org.junit.Assert.assertEquals("1 item in cart ", cart.);
    }
}
