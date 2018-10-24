package zbsmirnova.isotopicRatioParser.service;

import zbsmirnova.isotopicRatioParser.model.AbstractPb;
import zbsmirnova.isotopicRatioParser.model.ConcentrationPb;
import zbsmirnova.isotopicRatioParser.model.IsotopicPb;

import java.time.LocalDate;
import java.util.List;

public interface PbService {
    AbstractPb save(AbstractPb pb);

    boolean delete(int id);

    boolean delete(String sampleName);

    boolean deleteIsotopic(String sampleName);

    boolean deleteConcentration(String sampleName);

    IsotopicPb getIsotopic(int id);

    ConcentrationPb getConcentration(int id);

    IsotopicPb getIsotopic(String sampleName);

    ConcentrationPb getConcentration(String sampleName);

    // ORDERED dateTime desc
    List<IsotopicPb> getBetweenIsotopic(LocalDate startDate, LocalDate endDate);

    // ORDERED dateTime desc
    List<ConcentrationPb> getBetweenConcentration(LocalDate startDate, LocalDate endDate);

    List<IsotopicPb> getByDateIsotopic(LocalDate date);

    List<ConcentrationPb> getByDateConcentration(LocalDate date);

    List<IsotopicPb> getAllIsotopic();

    List<ConcentrationPb> getAllConcentration();

}
