package zbsmirnova.isotopicRatioParser.service;

import zbsmirnova.isotopicRatioParser.model.U;
import zbsmirnova.isotopicRatioParser.repository.URepository;

import java.time.LocalDate;
import java.util.List;

public class UServiceImpl implements UService{
    @Autowired
    URepository repository;

    @Override
    public U save(U u) {
        return repository.save(u);
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
    public U get(int id) {
        return repository.get(id);
    }

    @Override
    public U get(String sampleName) {
        return repository.get(sampleName);
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
