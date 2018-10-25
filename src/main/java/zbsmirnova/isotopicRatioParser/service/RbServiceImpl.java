package zbsmirnova.isotopicRatioParser.service;

import zbsmirnova.isotopicRatioParser.model.Rb;
import zbsmirnova.isotopicRatioParser.repository.RbRepository;

import java.time.LocalDate;
import java.util.List;

public class RbServiceImpl implements RbService{
    @Autowired
    RbRepository repository;

    @Override
    public Rb save(Rb rb) {
        return repository.save(rb);
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
    public Rb get(int id) {
        return repository.get(id);
    }

    @Override
    public Rb get(String sampleName) {
        return repository.get(sampleName);
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
