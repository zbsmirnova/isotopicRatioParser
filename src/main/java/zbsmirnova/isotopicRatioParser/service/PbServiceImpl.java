package zbsmirnova.isotopicRatioParser.service;

import zbsmirnova.isotopicRatioParser.model.ConcentrationPb;
import zbsmirnova.isotopicRatioParser.model.Pb;
import zbsmirnova.isotopicRatioParser.repository.IsotopicPbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;


@Service
public class PbServiceImpl implements PbService {

    private final IsotopicPbRepository repository;

    @Autowired
    public PbServiceImpl(IsotopicPbRepository repository) {
        this.repository = repository;
    }

    @Override
    public ConcentrationPb save(ConcentrationPb pb) {
        Assert.notNull(pb, "element must not be null");
        return repository.save(pb);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }

    @Override
    public boolean delete(String sampleName) {
        return repository.delete(sampleName);
    }

    @Override
    public Pb get(int id) {
        return repository.get(id);
    }

    @Override
    public Pb get(String sampleName) {
        return repository.get(sampleName);
    }

    @Override
    public List<Pb> getBetween(LocalDate startDate, LocalDate endDate) {
        Assert.notNull(startDate, "start date must not be null");
        Assert.notNull(endDate, "end date must not be null");
        return repository.getBetween(startDate, endDate);
    }

    @Override
    public List<Pb> getAll() {
        return repository.getAll();
    }
}
