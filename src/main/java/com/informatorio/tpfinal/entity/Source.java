package com.informatorio.tpfinal.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "sources")  // table name
public class Source {
    @Id  // for PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // for AI
    @Column(name = "id_source") // column name
    private Long idSource;
    private String name;
    private Long code;
    private String content;
    @Column(name = "created_at") // column name
    private LocalDate createdAt;

    // constructor
    public Source() {
    }

    // constructor
    public Source(Long idSource, String name, Long code, String content, LocalDate createdAt) {
        this.idSource = idSource;
        this.name = name;
        this.code = code;
        this.content = content;
        this.createdAt = createdAt;
    }

    // getters and setters
    public Long getIdSource() {
        return idSource;
    }

    public void setIdSource(Long idSource) {
        this.idSource = idSource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    // Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Source)) return false;
        Source source = (Source) o;
        return idSource.equals(source.idSource) &&
                name.equals(source.name) &&
                code.equals(source.code) &&
                content.equals(source.content) &&
                createdAt.equals(source.createdAt);
    }

    // HashCode
    @Override
    public int hashCode() {
        return Objects.hash(idSource, name, code, content, createdAt);
    }

    // ToString
    @Override
    public String toString() {
        return "Source{" +
                "id_source=" + idSource +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", content='" + content + '\'' +
                ", created_at=" + createdAt +
                '}';
    }
}
