package com.acquisio.basic.java.question01;

import org.junit.Test;

import static org.junit.Assert.*;

public class FooBarTest {

    @Test
    public void testFooBar3() {
        assertEquals("Foo", new FooBar().fooBar(3));
        assertEquals("FooBar", new FooBar().fooBar(15));
        assertEquals("23", new FooBar().fooBar(23));
    }

}
