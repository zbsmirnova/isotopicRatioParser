package zbsmirnova.isotopicRatioParser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zbsmirnova.isotopicRatioParser.model.U;
import zbsmirnova.isotopicRatioParser.repository.URepository;

import java.time.LocalDate;
import java.util.List;

import static zbsmirnova.isotopicRatioParser.util.ValidationUtil.checkNotFound;
import static zbsmirnova.isotopicRatioParser.util.ValidationUtil.checkNotFoundWithId;

@Service
public class UServiceImpl implements UService{

    @Autowired
    URepository repository;

    @Override
    public U save(U u) {
        return repository.save(u);
    }

    @Override
    public boolean delete(int id) {
        return checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public boolean delete(String sampleName) {
        return checkNotFound(repository.delete(sampleName), sampleName);
    }

    @Override
    public U get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public U get(String sampleName) {
        return checkNotFound(repository.get(sampleName), sampleName);
    }

    @Override
    public List<U> getByDate(LocalDate date) {
        return repository.getByDate(date);
    }

    @Override
    public List<U> getBetween(LocalDate startDate, LocalDate endDate) {
        return repository.getBetween(startDate, endDate);
    }

    @Override
    public List<U> getAll() {
        return repository.getAll();
    }
}
