package otus.bdd.testProperties;

import org.aeonbits.owner.Config;

public interface TestConfig extends Config{
    @DefaultValue("chrome")
    String browser();
    @DefaultValue("testuser@mail.com")
    String user();
    @DefaultValue("12345")
    String password();
}
