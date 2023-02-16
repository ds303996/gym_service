package com.jetrouter.gymservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "instructors")
@Table(name = "instructors")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {

    @Id
    @SequenceGenerator(
            name = "instructors_id_seq",
            sequenceName = "instructors_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "instructors_id_seq"
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageURL;

    @Column(name = "active")
    private Boolean active;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
