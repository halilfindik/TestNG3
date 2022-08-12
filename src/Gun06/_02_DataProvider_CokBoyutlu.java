package Gun06;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_DataProvider_CokBoyutlu {

    @Test(dataProvider = "getData")
        //@Parameters("username") this is not needed when above dataProvider is given
    void UsernameTest(String username, String password) {
        System.out.println("Username= " + username + ", password= " + password);
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data={
                {"Halil","asdfgh"},
                {"Alper","12qwerty"},
                {"Hakan","123456"},
                {"Uğur","j98y5klmdf"}
        };
        return data;
    }
}
