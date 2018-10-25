package zbsmirnova.isotopicRatioParser.repository;

import zbsmirnova.isotopicRatioParser.model.Rb;

import java.time.LocalDate;
import java.util.List;

public interface RbRepository {
    Rb save(Rb rb);

    boolean delete(int id);

    boolean delete(String sampleName);

    Rb get(int id);

    Rb get(String sampleName);

    List<Rb> getByDate(LocalDate date);

    // ORDERED dateTime desc
    List<Rb> getBetween(LocalDate startDate, LocalDate endDate);

    List<Rb> getAll();
}
