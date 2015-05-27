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
import pl.edu.agh.iosr.realestatebroker.model.Message;
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
public class MessageDaoTest {

    public static final int EXISTENT_ID = 1;
    public static final int NON_EXISTENT_ID = 10;
    public static final String EXISTENT_TOPIC = "Pytanie";
    public static final String NON_EXISTENT_TOPIC = "notopic";
    public static final int MESSAGE_TO_DELETE_ID = 1;

    @Autowired
    private MessageDAO messageDAO;

    @Test
    @DatabaseSetup("classpath:pl/edu/agh/iosr/realestatebroker/dao/messageData.xml")
    public void findById_NoMessagesFound_ShouldReturnEmptyList() {
        Message message = messageDAO.findById(NON_EXISTENT_ID);
        assertNull(message);
    }

    @Test
    @DatabaseSetup("classpath:pl/edu/agh/iosr/realestatebroker/dao/messageData.xml")
    public void findById_Found() {
        Message message = messageDAO.findById(EXISTENT_ID);
        assertNotNull(message);
    }

    @Test
    @DatabaseSetup("classpath:pl/edu/agh/iosr/realestatebroker/dao/messageData.xml")
    public void findByTopic_NoMessagesFound_ShouldReturnEmptyList() {
        List<Message> messageList = messageDAO.findByTopic(NON_EXISTENT_TOPIC);
        assertThat(messageList.size(), is(0));
    }

    @Test
    @DatabaseSetup("classpath:pl/edu/agh/iosr/realestatebroker/dao/messageData.xml")
    public void findByTopic_FoundOne() {
        List<Message> messageList = messageDAO.findByTopic(EXISTENT_TOPIC);
        assertThat(messageList.size(), is(1));
    }

    @Test
    @DatabaseSetup("classpath:pl/edu/agh/iosr/realestatebroker/dao/emptyData.xml")
    public void findAll_NoMessagesFound() {
        List<Message> messageList = messageDAO.findAll();
        assertThat(messageList.size(), is(0));
    }

    @Test
    @DatabaseSetup("classpath:pl/edu/agh/iosr/realestatebroker/dao/messageData.xml")
    public void findAll_FoundTwo() {
        List<Message> messageList = messageDAO.findAll();
        assertThat(messageList.size(), is(2));
    }

    @Test
    @DatabaseSetup("classpath:pl/edu/agh/iosr/realestatebroker/dao/oneMessageData.xml")
    @ExpectedDatabase("classpath:pl/edu/agh/iosr/realestatebroker/dao/noMessagesData.xml")
    public void remove_Removed() {
        messageDAO.remove(MESSAGE_TO_DELETE_ID);
    }

}
