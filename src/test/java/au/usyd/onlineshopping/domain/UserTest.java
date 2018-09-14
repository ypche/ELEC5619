package au.usyd.onlineshopping.domain;

import junit.framework.TestCase;

public class UserTest extends TestCase {

	private User user;

    protected void setUp() throws Exception {
        user = new User();
    }

    public void testSetAndGetName() {
        String testName = "aName";
        assertNull(user.getName());
        user.setName(testName);
        assertEquals(testName, user.getName());
    }
}
