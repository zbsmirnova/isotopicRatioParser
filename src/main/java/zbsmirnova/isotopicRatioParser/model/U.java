package zbsmirnova.isotopicRatioParser.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NamedQueries({
        @NamedQuery(name = U.ALL_SORTED, query = "SELECT u FROM U u ORDER BY u.date DESC"),
        @NamedQuery(name = U.DELETE_BY_ID, query = "DELETE FROM U u WHERE u.id=:id"),
        @NamedQuery(name = U.DELETE_BY_SAMPLE_NAME, query = "DELETE FROM U u WHERE u.sampleName=:sampleName"),
        @NamedQuery(name = U.GET_BETWEEN, query = "SELECT u FROM U u " +
                "WHERE u.date BETWEEN :startDate AND :endDate ORDER BY u.date DESC"),
        @NamedQuery(name = U.GET_BY_SAMPLE_NAME, query = "SELECT u FROM U u WHERE u.sampleName=:sampleName"),
        @NamedQuery(name = U.GET_BY_DATE, query = "SELECT u FROM U u WHERE u.date=:date"),
})

@Entity
@Table(name = "u_samples", uniqueConstraints =
        {@UniqueConstraint(columnNames = {"sampleName"}, name = "u_unique_idx")})
public class U extends Element {
    public static final String ALL_SORTED = "U.getAll";
    public static final String GET_BY_SAMPLE_NAME = "U.getBySampleName";
    public static final String GET_BY_DATE = "U.getByDate";
    public static final String DELETE_BY_ID = "U.deleteById";
    public static final String DELETE_BY_SAMPLE_NAME = "U.deleteBySampleName";
    public static final String GET_BETWEEN = "U.getBetween";

    @Column(name = "ratio238235", nullable = false)
    @NotNull
    private double ratio238235;
    @Column(name = "err238235", nullable = false)
    @NotNull
    private double err238235;

    public U(){}

    public U(String sampleName, LocalDate date){
        super(sampleName, date);
    }

    public U(int id, String sampleName, LocalDate date){ super(id, sampleName, date);}

    public U(String sampleName, LocalDate date, double ratio238235, double err238235){
        super(sampleName, date);
        this.ratio238235 = ratio238235;
        this.err238235 = err238235;
    }

    public U(int id, String sampleName, LocalDate date, double ratio238235, double err238235){
        super(id, sampleName, date);
        this.ratio238235 = ratio238235;
        this.err238235 = err238235;
    }

    public U(U u){
        this(u.id, u.sampleName, u.date, u.ratio238235, u.err238235);
    }

    public double getU238235() {
        return ratio238235;
    }

    public double getU238235err() {
        return err238235;
    }

    @Override
    public String toString() {
        return "U, sample  " + sampleName +
                " measurement date " + date +
                ", isotopic ratios: 238/235 " + ratio238235 + " stdErr " + err238235;
    }
}