package manager;

import model.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DataProviderUser {
    @DataProvider
    public Iterator<Object[]> loginData(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"mara@gmail.com", "Mmar123456$"});
        list.add(new Object[]{"dototo1223456@gmail.com", "Mmar123456$"});
        return list.iterator();
    };

    @DataProvider
    public Iterator<Object[]> loginData_negative(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().withEmail("maragmail.com").withPassword("Mmar123456$")});
        list.add(new Object[]{new User().withEmail("mara@gmail.com").withPassword("Mmar123456")});
        list.add(new Object[]{new User().withEmail("notMaria@gmail.com").withPassword("Mmar123456$")});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> loginModels(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().withEmail("mara@gmail.com").withPassword("Mmar123456$")});
        list.add(new Object[]{new User().withEmail("dototo1223456@gmail.com").withPassword("Mmar123456$")});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> registr_success(){
        List<Object[]> list = new ArrayList<>();
        Random random = new Random();
        int i = random.nextInt(1000);
        list.add(new Object[]{new User().withEmail("dototo"+i+"@gmail.com").withPassword("Mmar123456$")});

        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> regData_negative(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().withEmail("maragmail.com").withPassword("Mmar123456$")});
        list.add(new Object[]{new User().withEmail("mara@gmail.com").withPassword("Mmar123456")});

        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> regData_negativeRegistredUserWithNewPassword(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().withEmail("mara@gmail.com").withPassword("Xcj123456$")});

        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> login_fromFile(){
        List<Object[]> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/test.csv")));
            String line = reader.readLine();
            while (line!=null) {
                String[] arr = line.split(",");
                list.add(new Object[]{new User().withEmail(arr[0]).withPassword(arr[1])});
                line = reader.readLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list.iterator();
    }
}
