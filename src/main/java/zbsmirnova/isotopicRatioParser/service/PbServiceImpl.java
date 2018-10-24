package zbsmirnova.isotopicRatioParser.service;

import zbsmirnova.isotopicRatioParser.model.AbstractPb;
import zbsmirnova.isotopicRatioParser.model.ConcentrationPb;
import zbsmirnova.isotopicRatioParser.model.IsotopicPb;
import zbsmirnova.isotopicRatioParser.repository.ConcentrationPbRepository;
import zbsmirnova.isotopicRatioParser.repository.IsotopicPbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;


@Service
public class PbServiceImpl implements PbService {

    private final IsotopicPbRepository isotopicRepository;

    private final ConcentrationPbRepository concentrationRepository;

    @Autowired
    public PbServiceImpl(IsotopicPbRepository isotopicRepository, ConcentrationPbRepository concentrationRepository) {
        this.isotopicRepository = isotopicRepository;
        this.concentrationRepository = concentrationRepository;
    }

    @Override
    public AbstractPb save(AbstractPb pb) {
        Assert.notNull(pb, "element must not be null");
        if(pb instanceof IsotopicPb) return isotopicRepository.save((IsotopicPb) pb);
        else if(pb instanceof ConcentrationPb) return concentrationRepository.save((ConcentrationPb)pb);
        return null;
    }

    @Override
    public boolean delete(int id) {
        return isotopicRepository.delete(id) | concentrationRepository.delete(id);
    }

    @Override
    public boolean delete(String sampleName) {
        Assert.notNull(sampleName, "sample name date must not be null");
        return isotopicRepository.delete(sampleName) & concentrationRepository.delete(sampleName);
    }

    @Override
    public boolean deleteIsotopic(String sampleName) {
        Assert.notNull(sampleName, "sample name date must not be null");
        return isotopicRepository.delete(sampleName);
    }

    @Override
    public boolean deleteConcentration(String sampleName) {
        Assert.notNull(sampleName, "sample name date must not be null");
        return concentrationRepository.delete(sampleName);
    }

    @Override
    public IsotopicPb getIsotopic(int id) {
        return isotopicRepository.get(id);
    }

    @Override
    public ConcentrationPb getConcentration(int id) {
        return concentrationRepository.get(id);
    }

    @Override
    public IsotopicPb getIsotopic(String sampleName) {
        Assert.notNull(sampleName, "sample name date must not be null");
        return isotopicRepository.get(sampleName);
    }

    @Override
    public ConcentrationPb getConcentration(String sampleName) {
        Assert.notNull(sampleName, "sample name date must not be null");
        return concentrationRepository.get(sampleName);
    }

    @Override
    public List<IsotopicPb> getBetweenIsotopic(LocalDate startDate, LocalDate endDate) {
        Assert.notNull(startDate, "start date must not be null");
        Assert.notNull(endDate, "end date must not be null");
        return isotopicRepository.getBetween(startDate, endDate);
    }

    @Override
    public List<ConcentrationPb> getBetweenConcentration(LocalDate startDate, LocalDate endDate) {
        Assert.notNull(startDate, "start date must not be null");
        Assert.notNull(endDate, "end date must not be null");
        return concentrationRepository.getBetween(startDate, endDate);
    }

    @Override
    public List<IsotopicPb> getByDateIsotopic(LocalDate date) {
        Assert.notNull(date, "date must not be null");
        return isotopicRepository.getByDate(date);
    }

    @Override
    public List<ConcentrationPb> getByDateConcentration(LocalDate date) {
        Assert.notNull(date, "date must not be null");
        return concentrationRepository.getByDate(date);
    }

    @Override
    public List<IsotopicPb> getAllIsotopic() {
        return isotopicRepository.getAll();
    }

    @Override
    public List<ConcentrationPb> getAllConcentration() {
        return concentrationRepository.getAll();
    }


}
