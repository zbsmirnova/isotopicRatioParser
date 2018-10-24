package zbsmirnova.isotopicRatioParser.repository;

import zbsmirnova.isotopicRatioParser.model.AbstractPb;
import zbsmirnova.isotopicRatioParser.model.IsotopicPb;
import zbsmirnova.isotopicRatioParser.util.ElementUtil;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class IsotopicPbJpaRepository implements PbRepository {

    @PersistenceContext
    EntityManager em;

    //saving only new elements, updating is not allowed
    @Transactional
    @Override
    public IsotopicPb save(IsotopicPb pb) {
        if(!ElementUtil.isNew(pb))return null;
        else{
            em.persist(pb);
            return pb;
        }
    }

    @Transactional
    @Override
    public boolean delete(int id) {
        return em.createNamedQuery(IsotopicPb.DELETE_BY_ID)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Transactional
    @Override
    public boolean delete(String sampleName) {
        return em.createNamedQuery(IsotopicPb.DELETE_BY_SAMPLE_NAME)
                .setParameter("sampleName", sampleName)
                .executeUpdate() != 0;
    }

    @Override
    public IsotopicPb get(int id) {
        return em.find(IsotopicPb.class, id);
    }

    @Override
    public IsotopicPb get(String sampleName) {
        List<IsotopicPb> elements = em.createNamedQuery(IsotopicPb.GET_BY_SAMPLE_NAME, IsotopicPb.class)
                .setParameter(1, sampleName)
                .getResultList();
        return DataAccessUtils.singleResult(elements);
    }

    @Override
    public List<? extends AbstractPb> getByDate(LocalDate date) {

        return em.createQuery(IsotopicPb.GET_BY_DATE, IsotopicPb.class)
                .setParameter("date", date).getResultList();
    }

    @Override
    public List<? extends AbstractPb> getBetween(LocalDate startDate, LocalDate endDate) {
        return em.createNamedQuery(IsotopicPb.GET_BETWEEN, IsotopicPb.class)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate).getResultList();
    }

    @Override
    public List<IsotopicPb> getAll() {
        return em.createNamedQuery(IsotopicPb.ALL_SORTED, IsotopicPb.class)
                .getResultList();
    }
}
