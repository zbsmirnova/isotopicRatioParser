package zbsmirnova.isotopicRatioParser.repository.impl;

import zbsmirnova.isotopicRatioParser.model.U;
import zbsmirnova.isotopicRatioParser.repository.URepository;
import zbsmirnova.isotopicRatioParser.util.ElementUtil;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class URepositoryImpl implements URepository {
    @PersistanceContext
    EntityManeger em;

    @Transactional
    @Override
    public U save(U u) {
        if(!ElementUtil.isNew(u))return null;
        else{
            em.persist(u);
            return u;
        }
    }

    @Transactional
    @Override
    public boolean delete(int id) {
        return em.createNamedQuery(U.DELETE_BY_ID)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Transactional
    @Override
    public boolean delete(String sampleName) {
        return em.createNamedQuery(U.DELETE_BY_SAMPLE_NAME)
                .setParameter("sampleName", sampleName)
                .executeUpdate() != 0;
    }

    @Override
    public U get(int id) {
        return em.find(U.class, id);
    }

    @Override
    public U get(String sampleName) {
        return em.createNamedQuery(U.GET_BY_SAMPLE_NAME)
                .setParameter("sampleName", sampleName)
                .getResultList();
    }

    @Override
    public List<U> getByDate(LocalDate date) {
        return em.createNamedQuery(U.GET_BY_DATE)
                .setParameter("date", date)
                .getResultList();
    }

    @Override
    public List<U> getBetween(LocalDate startDate, LocalDate endDate) {
        return em.createNamedQuery(U.GET_BETWEEN)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
    }

    @Override
    public List<U> getAll() {
        return em.createNamedQuery(U.ALL_SORTED)
                .getResultList();
    }
}
