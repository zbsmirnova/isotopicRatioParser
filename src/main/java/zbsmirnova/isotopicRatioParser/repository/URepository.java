package zbsmirnova.isotopicRatioParser.repository;

import zbsmirnova.isotopicRatioParser.model.U;

import java.time.LocalDate;
import java.util.List;

public interface URepository {
    U save(U u);

    boolean delete(int id);

    boolean delete(String sampleName);

    U get(int id);

    U get(String sampleName);

    List<U> getByDate(LocalDate date);

    // ORDERED dateTime desc
    List<U> getBetween(LocalDate startDate, LocalDate endDate);

    List<U> getAll();
}
