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
    private final static String findEstateOfferByTitle = "select e from EstateOffer as e where e.title = :ref";
    private final static String findEstateOffer = "select e from EstateOffer as e";

    public void setSessionFactory(SessionFactory _sessionFactory) {
        this.sessionFactory = _sessionFactory;
    }

    @Override
    public EstateOffer findById(int id) {
        return (EstateOffer) this.sessionFactory.getCurrentSession().get(EstateOffer.class, id);
    }

    @Override
    public List<EstateOffer> findAll() {
        query = this.sessionFactory.getCurrentSession().createQuery(findEstateOffer);
        List<EstateOffer> list = query.list();

        return list;
    }

    @Override
    public List<EstateOffer> findByTitle(String title) {
        query = this.sessionFactory.getCurrentSession().createQuery(findEstateOfferByTitle);
        query.setString("ref", title);
        List<EstateOffer> list = query.list();

        return list;
    }

    @Override
    public void save(EstateOffer estateOffer) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(estateOffer);
    }

    @Override
    public void remove(int id) {
        Object record = this.sessionFactory.getCurrentSession().load(EstateOffer.class, id);
        this.sessionFactory.getCurrentSession().delete(record);
    }
}
