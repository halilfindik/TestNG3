package Gun06;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _01_DataProvider {

    @Test (dataProvider = "getData")
    //@Parameters("username") this is not needed when above dataProvider is given
    void UsernameTest(String username) {
        System.out.println("Username=" + username);
    }

    @DataProvider
    public Object[] getData() {
        Object[] data={"Halil", "Alper","Uğur",};
        return data;
    }
}
