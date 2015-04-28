package pl.edu.agh.iosr.realestatebroker.dao.Impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import pl.edu.agh.iosr.realestatebroker.dao.EstateOfferDAO;
import pl.edu.agh.iosr.realestatebroker.model.EstateOffer;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Query;

/**
 * Created by dpjar_000 on 2015-04-28.
 */
public class EstateOfferDAOImpl implements EstateOfferDAO {

    private static final transient Log LOG = LogFactory.getLog(EstateOfferDAOImpl.class);
    private SessionFactory sessionFactory;
    private Query query = null;
    private final static String findEstateOfferByReference = "select i from estate_offer as i where i."l
    private final static String findEstateOffer = "select i from estate_offer as i";

    public void setSessionFactory(SessionFactory _sessionFactory) {
        this.sessionFactory = _sessionFactory;
    }

    @Override
    public EstateOffer getEstateOffer(long id) {
        return (EstateOffer) this.sessionFactory.getCurrentSession().get(EstateOffer.class, id);
    }

    @Override
    public List<EstateOffer> findEstateOffer() {
        query = this.sessionFactory.getCurrentSession().createQuery(findEstateOffer);
        List<EstateOffer> list = query.list();

        return list;
    }

    @Override
    public List<EstateOffer> findEstateOffer(String key) {
        query = this.sessionFactory.getCurrentSession().createQuery(findEstateOfferByReference);
        query.setString("ref", key);
        List<EstateOffer> list = q.list();

        return list;
    }

    @Override
    public void saveEstateOffer(EstateOffer estateOffer) {
        SessionImpl session = (SessionImpl) this.sessionFactory.getCurrentSession();
        this.sessionFactory.getCurrentSession().saveOrUpdate(estateOffer);
    }

    @Override
    public void removeEstateOffer(long id) {
        Object record = this.sessionFactory.getCurrentSession().load(EstateOffer.class, id);
        this.sessionFactory.getCurrentSession().delete(record);
    }
}
