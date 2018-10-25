package zbsmirnova.isotopicRatioParser.repository.impl;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import zbsmirnova.isotopicRatioParser.model.Rb;
import zbsmirnova.isotopicRatioParser.repository.RbRepository;
import zbsmirnova.isotopicRatioParser.util.ElementUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class RbRepositoryImpl implements RbRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public Rb save(Rb rb) {
        if(!ElementUtil.isNew(rb))return null;
        else{
            em.persist(rb);
            return rb;
        }
    }

    @Transactional
    @Override
    public boolean delete(int id) {
        return em.createNamedQuery(Rb.DELETE_BY_ID)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Transactional
    @Override
    public boolean delete(String sampleName) {
        return em.createNamedQuery(Rb.DELETE_BY_SAMPLE_NAME)
                .setParameter("sampleName", sampleName)
                .executeUpdate() != 0;
    }

    @Override
    public Rb get(int id) {
        return em.find(Rb.class, id);
    }

    @Override
    public Rb get(String sampleName) {
        List<Rb> elements =  em.createNamedQuery(Rb.GET_BY_SAMPLE_NAME, Rb.class)
                .setParameter("sampleName", sampleName)
                .getResultList();
        return DataAccessUtils.singleResult(elements);

    }

    @Override
    public List<Rb> getByDate(LocalDate date) {
        return em.createNamedQuery(Rb.GET_BY_DATE, Rb.class)
                .setParameter("date", date)
                .getResultList();
    }

    @Override
    public List<Rb> getBetween(LocalDate startDate, LocalDate endDate) {
        return em.createNamedQuery(Rb.GET_BETWEEN, Rb.class)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
    }

    @Override
    public List<Rb> getAll() {
        return em.createNamedQuery(Rb.ALL_SORTED, Rb.class)
                .getResultList();
    }
}