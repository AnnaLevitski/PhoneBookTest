package manager;

import model.Contact;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DataProviderContact {

    @DataProvider
    public Iterator<Object[]> contactSuccess(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                Contact.builder()
                        .name("Joan")
                        .lastName("LName")
                        .phone("04523466753")
                        .email("name@gmail.com")
                        .address("TA Blond 11")
                        .description("")
                        .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("HoJoan")
                        .lastName("Here")
                        .phone("04523466753")
                        .email("hname@gmail.com")
                        .address("TA Blond 11")
                        .description("qwe")
                        .build()
        });
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> contact_negative(){
        List<Object[]> list = new ArrayList<>();
        Random random = new Random();
        int i = random.nextInt(10000000)+456750;
        list.add(new Object[]{
                Contact.builder()
                .name("No Last Name Here!!!!")
                .lastName("")
                .phone("045"+i)
                .email("name@gmail.com")
                .address("Na 11o BM")
                .description("")
                .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("")
                        .lastName("LName")
                        .phone("045"+i)
                        .email("name@gmail.com")
                        .address("TA Blond 11")
                        .description("")
                        .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Nam")
                        .lastName("LName")
                        .phone("045"+i)
                        .email("name@gmail.com")
                        .address("")
                        .description("")
                        .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Nam")
                        .lastName("LName")
                        .phone("045"+i)
                        .email("name@gmail.com")
                        .address("")
                        .description("")
                        .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Nam")
                        .lastName("LName")
                        .phone("045"+i)
                        .email("")
                        .address("Na 11o BM")
                        .description("")
                        .build()
        });
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> contact_negativeAlertPresent(){
        List<Object[]> list = new ArrayList<>();
        Random random = new Random();
        int i = random.nextInt(10000000)+456750;
        list.add(new Object[]{
                Contact.builder()
                        .name("Nam")
                        .lastName("LName")
                        .phone("0")
                        .email("name@gmail.com")
                        .address("Pizza 60")
                        .description("")
                        .build()
        });
        return list.iterator();
    }
}
