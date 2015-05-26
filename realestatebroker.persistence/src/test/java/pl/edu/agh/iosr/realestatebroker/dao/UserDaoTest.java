package pl.edu.agh.iosr.realestatebroker.dao;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
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
import static org.junit.Assert.assertThat;

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
@DatabaseSetup("classpath:pl/edu/agh/iosr/realestatebroker/dao/userData.xml")
@ExpectedDatabase("classpath:pl/edu/agh/iosr/realestatebroker/dao/emptyData.xml")
public class UserDaoTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void findByLogin_NoUsersFound_ShouldReturnEmptyList() {
        List<User> estateOfferList = userDAO.findByLogin("NOLOGIN");
        assertThat(estateOfferList.size(), is(0));
    }

    @Test
    public void findAll_foundTwo() {
        List<User> estateOfferList = userDAO.findAll();
        assertThat(estateOfferList.size(), is(2));
    }

}
