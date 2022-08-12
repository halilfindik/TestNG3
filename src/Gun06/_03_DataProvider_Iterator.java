package Gun06;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _03_DataProvider_Iterator {

    @Test (dataProvider = "getData")
    //@Parameters("username") this is not needed when above dataProvider is given
    void UsernameTest(String username) {
        System.out.println("Username=" + username);
    }

    @DataProvider (name="getData")
    public Iterator<Object> getData() {
        List<Object> data=new ArrayList<>();
        data.add("Halil");
        data.add("Uğur");
        data.add("Uğur");

        return data.iterator();
    }

    /*********************************************************/

    @Test (dataProvider = "users")
    void UsernameTest2(String username, String password) {
        System.out.println("Username=" + username + "password =" + password);
    }

    @DataProvider (name="users")
    public Iterator<Object[]> getData2() {
        List<Object[]> data=new ArrayList<>();
        data.add(new Object[]{"Halil","123456"});
        data.add(new Object[]{"Alper","qwerty"});
        data.add(new Object[]{"Hakan","lkshaflkahs"});

        return data.iterator();
    }
}
