package Dangnhap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DangkyTest {

    // Dữ liệu kiểm thử
    @DataProvider(name = "registrationData")
    public Object[][] registrationData() {
        return new Object[][]{
            {"User", "weakPass", true}, // Tên người dùng đã tồn tại
            {"newUser", "weakPass", true}, // Tên hợp lệ nhưng mật khẩu yếu
            {"newUser", "StrongPass1", true} // Tên và mật khẩu đúng
        };
    }

    @Test(dataProvider = "registrationData")
    public void testUserRegistration(String username, String password, boolean expectedOutcome) {
        boolean actualOutcome = registerUser(username, password);
        Assert.assertEquals(actualOutcome, expectedOutcome, "Registration outcome should match expected outcome");
    }

    // Phương thức đăng ký giả lập
    private boolean registerUser(String username, String password) {
        if (username.equals("existingUser")) return false;
        if (password.length() < 8 || !password.matches(".*[A-Z].*")) return false;
        return true;
    }
}
