package com.jetrouter.gymservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;

@Entity(name = "members")
@Table(name = "members")
@Getter
@Setter
public class Member {

    @Id
    @SequenceGenerator(
            name = "members_id_seq",
            sequenceName = "members_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "members_id_seq"
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "paid_until")
    private LocalDateTime paidUntil;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
