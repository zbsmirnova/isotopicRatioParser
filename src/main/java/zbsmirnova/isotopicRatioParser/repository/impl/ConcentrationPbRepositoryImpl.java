package zbsmirnova.isotopicRatioParser.repository.impl;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zbsmirnova.isotopicRatioParser.model.ConcentrationPb;
import zbsmirnova.isotopicRatioParser.model.IsotopicPb;
import zbsmirnova.isotopicRatioParser.repository.ConcentrationPbRepository;
import zbsmirnova.isotopicRatioParser.repository.IsotopicPbRepository;
import zbsmirnova.isotopicRatioParser.util.ElementUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;
import java.util.function.IntConsumer;

import static zbsmirnova.isotopicRatioParser.util.ValidationUtil.checkNotFoundWithId;

@Repository
@Transactional(readOnly = true)
public class ConcentrationPbRepositoryImpl implements ConcentrationPbRepository {

    @PersistenceContext
    EntityManager em;

    //saving only new elements, updating is not allowed
    @Transactional
    @Override
    public ConcentrationPb save(ConcentrationPb pb) {
        if(!ElementUtil.isNew(pb))return null;
        else{
            em.persist(pb);
            return pb;
        }
    }

    @Transactional
    @Override
    public boolean delete(int id) {
        return em.createNamedQuery(ConcentrationPb.DELETE_BY_ID)
                .setParameter("id", id)
                .executeUpdate() != 0;

    }

    @Transactional
    @Override
    public boolean delete(String sampleName) {
        return em.createNamedQuery(ConcentrationPb.DELETE_BY_SAMPLE_NAME)
                .setParameter("sampleName", sampleName)
                .executeUpdate() != 0;
    }

    @Override
    public ConcentrationPb get(int id) {
        return em.find(ConcentrationPb.class, id);
    }

    @Override
    public ConcentrationPb get(String sampleName) {
        List<ConcentrationPb> elements = em.createNamedQuery(ConcentrationPb.GET_BY_SAMPLE_NAME, ConcentrationPb.class)
                .setParameter("sampleName", sampleName)
                .getResultList();
        return DataAccessUtils.singleResult(elements);
    }

    @Override
    public List<ConcentrationPb> getByDate(LocalDate date) {
        //ConcentrationPb.GET_BY_DATE
        return em.createQuery("SELECT p FROM ConcentrationPb p WHERE p.date=:date", ConcentrationPb.class)
                .setParameter("date", date).getResultList();
    }


    @Override
    public List<ConcentrationPb> getBetween(LocalDate startDate, LocalDate endDate) {
        return em.createNamedQuery(ConcentrationPb.GET_BETWEEN, ConcentrationPb.class)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate).getResultList();
    }

    @Override
    public List<ConcentrationPb> getAll() {
        return em.createNamedQuery(ConcentrationPb.ALL_SORTED, ConcentrationPb.class)
                .getResultList();
    }
}
