package geco;

import org.junit.*;

import java.util.List;

import static org.junit.Assert.*;

public class LoginServiceTest {

    private static LoginService loginService;

    @Before
    public void setUp() throws Exception {
        String[] testLoginExistant = {"malala", "foo", "bar"};
        loginService = new LoginService(testLoginExistant);
    }

    @Test
    public void loginExists() {
        Assert.assertTrue("foo is an existing login",
                loginService.loginExists("foo"));
        Assert.assertFalse("bob is not an existing login",
                loginService.loginExists("bob"));
    }

    @Test
    public void addLogin() {
        String benjamin = "benjamin";
        String franklin = "franklin";
        List<String> allLoginsBefore = loginService.findAllLogins();

        //System.out.println("before = "+allLoginsBefore.toString()+ " size =
        // "+allLoginsBefore.size());

        loginService.addLogin("franklin");

        Assert.assertTrue("franklin is an existing login",
                loginService.loginExists(franklin));

        List<String> allLoginsAfter = loginService.findAllLogins();

        //System.out.println("after = "+allLoginsAfter.toString() + " size =
        // "+allLoginsAfter.size());
        Assert.assertEquals("There is 1 extra login",
                allLoginsBefore.size(),
                allLoginsAfter.size());
    }

    @Test
    public void findAllLoginsStartingWith() {
        List<String> allLoginsStartingWithB =
                loginService.findAllLoginsStartingWith("b");

        Assert.assertEquals("there is 1 logins starting with b (bar) "
               , 1, allLoginsStartingWithB.size());

        Assert.assertEquals("there is no login starting with z",
                0,
                loginService.findAllLoginsStartingWith("z").size());
    }

    @Test
    public void findAllLogins() {
        List<String> allLogins = loginService.findAllLogins();
        Assert.assertEquals("there are 3 logins in total", 3,
                allLogins.size());

        loginService.addLogin("napoleon");
        allLogins = loginService.findAllLogins();

        Assert.assertEquals("there are 4 logins in total after adding " +
                "napoleon", 4, allLogins.size());
    }
}