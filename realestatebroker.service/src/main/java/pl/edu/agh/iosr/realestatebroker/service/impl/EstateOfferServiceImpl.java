package pl.edu.agh.iosr.realestatebroker.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import pl.edu.agh.iosr.realestatebroker.dao.EstateOfferDAO;
import pl.edu.agh.iosr.realestatebroker.model.EstateOffer;

import java.util.List;

/**
 * Created by grzegorz on 2015-05-09.
 */
public class EstateOfferServiceImpl {

    private static final transient Log LOG = LogFactory.getLog(EstateOfferServiceImpl.class);

    private EstateOfferDAO estateOfferDAO;

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
