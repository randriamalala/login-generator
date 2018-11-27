package geco;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginGeneratorTest {

    private static LoginService loginService;
    private static LoginGenerator loginGenerator;

    @Before
    public void setUp() throws Exception {
        loginService = new LoginService(new String[] {"JROL", "BPER", "CGUR",
                "JDU", "JRAL", "JRAL1"});
        loginGenerator = new LoginGenerator(loginService);
    }

    @Test
    public void generateLoginForNomAndPrenom() {
        Assert.assertEquals("PDUR est le login genere pour Paul Durand",
                "PDUR", loginGenerator.generateLoginForNomAndPrenom("Durand",
                 "Paul"       ));
    }

    @Test
    public void generateLoginForJRAL2() {
        Assert.assertEquals("JRAL2 devrait être le login généré",
                "JRAL2", loginGenerator.generateLoginForNomAndPrenom("Ralling",
                        "John"));
    }

    @Test
    public void generateLoginJROL1() {
        Assert.assertEquals("JROL1 est le login généré pour Jean Rolling",
                "JROL1", loginGenerator.generateLoginForNomAndPrenom("Rolling", "Jean"));
    }

    @Test
    public void generateLoginPDUR() {
        Assert.assertEquals("PDUR est le login généré pour Paul Dùrand",
                "PDUR", loginGenerator.generateLoginForNomAndPrenom("Dùrand"
                        , "Paul"));
    }

    @Test
    public void generationLoginPDU() {
        Assert.assertEquals("PDU login généré pour Paul Du",
                "PDU", loginGenerator.generateLoginForNomAndPrenom("Du",
                        "Paul"));
    }
}