package zbsmirnova.isotopicRatioParser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zbsmirnova.isotopicRatioParser.model.Rb;
import zbsmirnova.isotopicRatioParser.repository.RbRepository;

import java.time.LocalDate;
import java.util.List;

import static zbsmirnova.isotopicRatioParser.util.ValidationUtil.checkNotFound;
import static zbsmirnova.isotopicRatioParser.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RbServiceImpl implements RbService{

    @Autowired
    RbRepository repository;

    @Override
    public Rb save(Rb rb) {
        return repository.save(rb);
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
    public Rb get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public Rb get(String sampleName) {
        return checkNotFound(repository.get(sampleName), sampleName);
    }

    @Override
    public List<Rb> getByDate(LocalDate date) {
        return repository.getByDate(date);
    }

    @Override
    public List<Rb> getBetween(LocalDate startDate, LocalDate endDate) {
        return repository.getBetween(startDate, endDate);
    }

    @Override
    public List<Rb> getAll() {
        return repository.getAll();
    }
}