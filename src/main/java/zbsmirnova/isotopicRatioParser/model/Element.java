package zbsmirnova.isotopicRatioParser.model;

import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@MappedSuperclass
@Access(AccessType.FIELD)
public class Element {

    public static final int START_SEQ = 100000;

    //final ElementType elementType;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    protected Integer id;

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "sampleName", nullable = false)
    protected String sampleName;

    @Column(name = "date", nullable = false)
    @NotNull
    protected LocalDate date;


    public Element(){}

    Element(String sampleName, LocalDate date){
        this.sampleName = sampleName;
        this.date = date;
        //this.elementType = builder.elementType;
    }

    Element(int id, String sampleName, LocalDate date){
        this.id = id;
        this.sampleName = sampleName;
        this.date = date;
        //this.elementType = builder.elementType;
    }

    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !getClass().equals(Hibernate.getClass(o))) {
            return false;
        }
        Element that = (Element) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id;
    }
}
