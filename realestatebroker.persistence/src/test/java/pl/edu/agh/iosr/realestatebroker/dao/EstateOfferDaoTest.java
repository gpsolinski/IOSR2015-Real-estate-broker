package pl.edu.agh.iosr.realestatebroker.dao;

/**
 * Created by grzegorz on 2015-05-25.
 */

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
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

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-datasource-beans-test.xml",
"classpath:META-INF/spring/spring-dao-beans.xml"})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@DatabaseSetup("classpath:pl/edu/agh/iosr/realestatebroker/dao/estateOfferData.xml")
public class EstateOfferDaoTest {

    @Autowired
    private EstateOfferDAO estateOfferDAO;

    @Test
    public void findByTitle_NoEstateOffersFound_ShouldReturnEmptyList() {
        List<EstateOffer> estateOfferList = estateOfferDAO.findByTitle("NOT FOUND");
        assertThat(estateOfferList.size(), is(0));
    }
}
