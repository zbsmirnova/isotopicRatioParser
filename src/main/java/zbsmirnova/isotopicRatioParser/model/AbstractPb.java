package zbsmirnova.isotopicRatioParser.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@MappedSuperclass
@Access(AccessType.FIELD)
public class AbstractPb extends Element{
    @Column(name = "ratio206207", nullable = false)
    @NotNull
    private double ratio206207;
    @Column(name = "err206207", nullable = false)
    @NotNull
    private double err206207;
    @Column(name = "ratio206208", nullable = false)
    @NotNull
    private double ratio206208;
    @Column(name = "err206208", nullable = false)
    @NotNull
    private double err206208;

    public AbstractPb(String sampleName, LocalDate date) {
        super(sampleName, date);
    }

    public AbstractPb(int id, String sampleName, LocalDate date){
        super(id, sampleName, date);
    }

    public AbstractPb(String sampleName, LocalDate date, double ratio206207,
                           double err206207, double ratio206208, double err206208){
        super(sampleName, date);
        this.ratio206207 = ratio206207;
        this.err206207 = err206207;
        this.ratio206208 = ratio206208;
        this.err206208 = err206208;
    }

    public AbstractPb(int id, String sampleName, LocalDate date, double ratio206207,
                           double err206207, double ratio206208, double err206208){
        this(sampleName, date, ratio206207, err206207, ratio206208, err206208);
        this.id = id;
    }

    public AbstractPb(AbstractPb pb){
        this(pb.id, pb.sampleName, pb.date, pb.ratio206207, pb.err206207,
                pb.ratio206208, pb.err206208);
    }

    public AbstractPb() {
    }

    public void setRatio206207(double ratio206207) {
        this.ratio206207 = ratio206207;
    }

    public void setErr206207(double err206207) {
        this.err206207 = err206207;
    }

    public void setRatio206208(double ratio206208) {
        this.ratio206208 = ratio206208;
    }

    public void setErr206208(double err206208) {
        this.err206208 = err206208;
    }

    public double getPb206207() {
        return ratio206207;
    }

    public double getPb206207err() {
        return err206207;
    }

    public double getPb206208() {
        return ratio206208;
    }

    public double getPb206208err() {
        return err206208;
    }


}
