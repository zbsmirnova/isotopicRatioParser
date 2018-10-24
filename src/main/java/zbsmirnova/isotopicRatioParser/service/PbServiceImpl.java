package zbsmirnova.isotopicRatioParser.service;

import zbsmirnova.isotopicRatioParser.model.AbstractPb;
import zbsmirnova.isotopicRatioParser.model.Pb;
import zbsmirnova.isotopicRatioParser.repository.PbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;


@Service
public class PbServiceImpl implements PbService {

    private final PbRepository isotopicPbRepository;

    @Autowired
    public PbServiceImpl(PbRepository repository) {
        this.isotopicPbRepository = repository;
    }

    @Override
    public AbstractPb save(AbstractPb pb) {
        Assert.notNull(pb, "element must not be null");

    }

    @Override
    public boolean delete(int id) {
        return isotopicPbRepository.delete(id);
    }

    @Override
    public boolean delete(String sampleName) {
        return isotopicPbRepository.delete(sampleName);
    }

    @Override
    public Pb get(int id) {
        return isotopicPbRepository.get(id);
    }

    @Override
    public Pb get(String sampleName) {
        return isotopicPbRepository.get(sampleName);
    }

    @Override
    public List<Pb> getBetween(LocalDate startDate, LocalDate endDate) {
        Assert.notNull(startDate, "start date must not be null");
        Assert.notNull(endDate, "end date must not be null");
        return isotopicPbRepository.getBetween(startDate, endDate);
    }

    @Override
    public List<Pb> getAll() {
        return isotopicPbRepository.getAll();
    }
}
