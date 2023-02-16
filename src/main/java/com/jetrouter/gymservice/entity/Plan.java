package com.jetrouter.gymservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "plans")
@Table(name = "plans")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plan {

    @Id
    @SequenceGenerator(
            name = "plans_id_seq",
            sequenceName = "plans_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "plans_id_seq"
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "exercises_plans",
            joinColumns = @JoinColumn(name = "plan_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id")
    )
    private List<Exercise> exercises;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "meals_plans",
            joinColumns = @JoinColumn(name = "plan_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id")
    )
    private List<Meal> meals;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
