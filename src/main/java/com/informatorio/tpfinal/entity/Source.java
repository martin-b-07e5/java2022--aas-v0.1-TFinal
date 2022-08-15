package com.informatorio.tpfinal.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "sources")  // table name
public class Source {
    //    ----------------------------------------------------------------
    @OneToMany(mappedBy = "source")
    Set<Article> articles;  // don't delete this line
    //    ----------------------------------------------------------------
    // https://www.baeldung.com/jpa-many-to-many
//    @ManyToMany(mappedBy = "sources")
//    Set<Article> articles;  // don't delete this line.
    //    ----------------------------------------------------------------
    @Id  // for PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // for AI
    @Column(name = "id_source") // column name
    private Long id_source;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Code (like slug) is mandatory")
    private String code;

    //    baeldung.com/javax-validation
    @PastOrPresent
    @Column(name = "created_at") // column name
    private LocalDate createdAt = LocalDate.now();


    //     constructors
    public Source() {
    }

    public Source(String name) {
        this.name = name;
    }


    //     getters and setters
    public Long getId_source() {
        return id_source;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setName(String name) {
        this.name = name.trim();
        setCode(this.name);  // necessary
    }

    public void setCode(String name) {
        this.code = name.toLowerCase().replace(" ", "-");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Source)) return false;
        Source source = (Source) o;
        return id_source.equals(source.id_source) &&
                name.equals(source.name) &&
                code.equals(source.code) &&
                createdAt.equals(source.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_source, name, code, createdAt);
    }

    @Override
    public String toString() {
        return "Source{" +
                "id_source=" + id_source +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", created_at=" + createdAt +
                '}';
    }

}
