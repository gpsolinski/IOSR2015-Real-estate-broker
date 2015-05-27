package pl.edu.agh.iosr.realestatebroker.dao;

/**
 * Created by grzegorz on 2015-05-25.
 */

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import pl.edu.agh.iosr.realestatebroker.model.EstateOffer;
import pl.edu.agh.iosr.realestatebroker.model.User;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-datasource-beans-test.xml",
"classpath:META-INF/spring/spring-dao-beans.xml"})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@DatabaseSetup("classpath:pl/edu/agh/iosr/realestatebroker/dao/emptyData.xml")
public class EstateOfferDaoTest {

    public static final int EXISTENT_ID = 1;
    public static final int NON_EXISTENT_ID = 10;
    public static final String EXISTENT_TITLE = "Cool house";
    public static final String NON_EXISTENT_TITLE = "notitle";
    public static final int ESTATE_OFFER_TO_DELETE_ID = 1;

    @Autowired
    private EstateOfferDAO estateOfferDAO;

    @Test
    @DatabaseSetup("classpath:pl/edu/agh/iosr/realestatebroker/dao/estateOfferData.xml")
    public void findById_NoEstateOffersFound_ShouldReturnEmptyList() {
        EstateOffer estateOffer = estateOfferDAO.findById(NON_EXISTENT_ID);
        assertNull(estateOffer);
    }

    @Test
    @DatabaseSetup("classpath:pl/edu/agh/iosr/realestatebroker/dao/estateOfferData.xml")
    public void findById_Found() {
        EstateOffer estateOffer = estateOfferDAO.findById(EXISTENT_ID);
        assertNotNull(estateOffer);
    }

    @Test
    @DatabaseSetup("classpath:pl/edu/agh/iosr/realestatebroker/dao/estateOfferData.xml")
    public void findByTitle_NoEstateOffersFound_ShouldReturnEmptyList() {
        List<EstateOffer> estateOfferList = estateOfferDAO.findByTitle(NON_EXISTENT_TITLE);
        assertThat(estateOfferList.size(), is(0));
    }

    @Test
    @DatabaseSetup("classpath:pl/edu/agh/iosr/realestatebroker/dao/estateOfferData.xml")
    public void findByLogin_FoundOne() {
        List<EstateOffer> estateOfferList = estateOfferDAO.findByTitle(EXISTENT_TITLE);
        assertThat(estateOfferList.size(), is(1));
    }

    @Test
    @DatabaseSetup("classpath:pl/edu/agh/iosr/realestatebroker/dao/emptyData.xml")
    public void findAll_NoUsersFound() {
        List<EstateOffer> estateOfferList = estateOfferDAO.findAll();
        assertThat(estateOfferList.size(), is(0));
    }

    @Test
    @DatabaseSetup("classpath:pl/edu/agh/iosr/realestatebroker/dao/estateOfferData.xml")
    public void findAll_FoundTwo() {
        List<EstateOffer> estateOfferList = estateOfferDAO.findAll();
        assertThat(estateOfferList.size(), is(2));
    }


    @Test
    @DatabaseSetup("classpath:pl/edu/agh/iosr/realestatebroker/dao/oneEstateOfferData.xml")
    @ExpectedDatabase("classpath:pl/edu/agh/iosr/realestatebroker/dao/oneUserData.xml")
    public void remove_Removed() {
        estateOfferDAO.remove(ESTATE_OFFER_TO_DELETE_ID);
    }

}
