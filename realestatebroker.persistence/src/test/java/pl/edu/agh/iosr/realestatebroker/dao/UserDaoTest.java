package pl.edu.agh.iosr.realestatebroker.dao;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.dbunit.JdbcDatabaseTester;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import pl.edu.agh.iosr.realestatebroker.model.User;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by grzegorz on 2015-05-26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-datasource-beans-test.xml",
        "classpath:META-INF/spring/spring-dao-beans.xml"})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })

@DatabaseSetup("classpath:pl/edu/agh/iosr/realestatebroker/dao/emptyData.xml")
public class UserDaoTest {

    public static final int EXISTENT_ID = 1;
    public static final int NON_EXISTENT_ID = 10;
    public static final String EXISTENT_LOGIN = "jdoe";
    public static final String NON_EXISTENT_LOGIN = "nologin";
    public static final String NEW_USER_FIRSTNAME = "Natalie";
    public static final String NEW_USER_LASTNAME = "Portman";
    public static final String NEW_USER_LOGIN = "nport";
    public static final String NEW_USER_EMAIL = "nat@port.com";
    public static final String NEW_USER_PHONE = "0123456";
    public static final int USER_TO_DELETE_ID = 1;

    @Autowired
    private UserDAO userDAO;

    @Test
    @DatabaseSetup("classpath:pl/edu/agh/iosr/realestatebroker/dao/userData.xml")
    public void findById_NoUsersFound_ShouldReturnEmptyList() {
        User foundUser = userDAO.findById(NON_EXISTENT_ID);
        assertNull(foundUser);
    }

    @Test
    @DatabaseSetup("classpath:pl/edu/agh/iosr/realestatebroker/dao/userData.xml")
    public void findById_Found() {
        User foundUser = userDAO.findById(EXISTENT_ID);
        assertNotNull(foundUser);
    }

    @Test
    @DatabaseSetup("classpath:pl/edu/agh/iosr/realestatebroker/dao/userData.xml")
    public void findByLogin_NoUsersFound_ShouldReturnEmptyList() {
        List<User> estateOfferList = userDAO.findByLogin(NON_EXISTENT_LOGIN);
        assertThat(estateOfferList.size(), is(0));
    }

    @Test
    @DatabaseSetup("classpath:pl/edu/agh/iosr/realestatebroker/dao/userData.xml")
    public void findByLogin_FoundOne() {
        List<User> estateOfferList = userDAO.findByLogin(EXISTENT_LOGIN);
        assertThat(estateOfferList.size(), is(1));
    }

    @Test
    @DatabaseSetup("classpath:pl/edu/agh/iosr/realestatebroker/dao/emptyData.xml")
    public void findAll_NoUsersFound() {
        List<User> estateOfferList = userDAO.findAll();
        assertThat(estateOfferList.size(), is(0));
    }

    @Test
    @DatabaseSetup("classpath:pl/edu/agh/iosr/realestatebroker/dao/userData.xml")
    public void findAll_FoundTwo() {
        List<User> estateOfferList = userDAO.findAll();
        assertThat(estateOfferList.size(), is(2));
    }

    @Test
    @DatabaseSetup("classpath:pl/edu/agh/iosr/realestatebroker/dao/oneUserData.xml")
    public void save_Saved() {
        User user = new User();
        user.setId(EXISTENT_ID);
        user.setLogin(NEW_USER_LOGIN);
        user.setFirstName(NEW_USER_FIRSTNAME);
        user.setLastName(NEW_USER_LASTNAME);
        user.setEmail(NEW_USER_EMAIL);
        user.setPhoneNumber(NEW_USER_PHONE);

        userDAO.save(user);

        User new_user = userDAO.findById(EXISTENT_ID);
        assertEquals(user.getLogin(), new_user.getLogin());
    }

    @Test
    @DatabaseSetup("classpath:pl/edu/agh/iosr/realestatebroker/dao/oneUserData.xml")
    @ExpectedDatabase("classpath:pl/edu/agh/iosr/realestatebroker/dao/emptyData.xml")
    public void remove_Removed() {
        userDAO.remove(USER_TO_DELETE_ID);
    }

}
