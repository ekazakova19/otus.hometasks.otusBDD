package otus.bdd.testProperties;

import org.aeonbits.owner.Config;
import org.springframework.stereotype.Service;


public interface TestConfig extends Config{
    @DefaultValue("chrome")
    String browser();
    @DefaultValue("al.kz93@mail.ru")
    String user();
    @DefaultValue("090393elka!")
    String password();
}
