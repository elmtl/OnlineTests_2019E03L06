package com.acquisio.basic.java.question03;

import org.junit.Test;

import static org.junit.Assert.*;

public class IssueResolvingTest {
    @Test
    public void factorial() throws Exception {
        assertEquals(5040, new IssueResolving().factorial(7));
        assertEquals(1, new IssueResolving().factorial(0));
    }

}
