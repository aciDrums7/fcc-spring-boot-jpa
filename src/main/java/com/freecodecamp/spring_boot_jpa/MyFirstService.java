package com.freecodecamp.spring_boot_jpa;

import static java.lang.StringTemplate.STR;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySources({
        @PropertySource("classpath:custom.yaml"), @PropertySource("classpath:custom-2.yaml") })
public class MyFirstService {

    // ? 2 - Field Injection
    // @Autowired
    // @Qualifier("mySecondBean") //* qualifier search by @Bean name or @Qualifier
    private final MyFirstClass myFirstClass;

    private final Environment environment;

    @Value("${myCustomProperty}")
    private String customPropertyFromYaml;

    @Value("${myCustomProperty2}")
    private String customPropertyFromYaml2;

    // ? 1 - Constructor Injection
    // ! RECOMMENDED WAY
    // ^ @Autowired is optional if only one constructor
    public MyFirstService(/* @Qualifier("bean2") */ MyFirstClass myFirstClass, Environment environment) {
        this.myFirstClass = myFirstClass;
        this.environment = environment;
    }

    public String tellAStory() {
        return STR."the dependency is saying: \{myFirstClass.sayHello()}";
    }

    public String getJavaVersion() {
        return environment.getProperty("java.version");
    }

    public String getOsName() {
        return environment.getProperty("os.name");
    }

    public String readProperty() {
        return environment.getProperty("myCustomProperty");
    }

    public String getMyCustomPropertyFromYaml() {
        return this.customPropertyFromYaml;
    }

    public String getMyCustomPropertyFromYaml2() {
        return this.customPropertyFromYaml2;
    }

    // ? 3 - Method Injection
    /*
     * @Autowired
     * public void injectDependencies(MyFirstClass myFirstClass) {
     * this.myFirstClass = myFirstClass;
     * }
     */

    // ? 4 - Setter Injection
    /*
     * @Autowired
     * public void setMyFirstClass(MyFirstClass myFirstClass) {
     * this.myFirstClass = myFirstClass;
     * }
     */
}
