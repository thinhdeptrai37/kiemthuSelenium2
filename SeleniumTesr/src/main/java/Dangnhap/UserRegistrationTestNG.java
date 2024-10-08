package Dangnhap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserRegistrationTestNG {

    @DataProvider(name = "registrationData")
    public Object[][] registrationData() {
        return new Object[][]{
            {"newUser", "weakPass", false},
            {"newUser", "StrongPass1", true}
        };
    }

    @Test(dataProvider = "registrationData")
    public void testUserRegistration(String username, String password, boolean expectedOutcome) {
        boolean actualOutcome = registerUser(username, password);
        Assert.assertEquals(actualOutcome, expectedOutcome, "Registration outcome should match expected outcome");
    }

    private boolean registerUser(String username, String password) {
        if (username.equals("existingUser")) return false;
        if (password.length() < 8 || !password.matches(".*[A-Z].*")) return false;
        return true;
    }
}
