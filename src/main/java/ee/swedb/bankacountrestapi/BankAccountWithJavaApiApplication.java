package ee.swedb.bankacountrestapi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.HashMap;


@SpringBootApplication
public class BankAccountWithJavaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountWithJavaApiApplication.class, args);

        HashMap< Integer, String > currencyCode = new HashMap< Integer, String>();

    }

}
