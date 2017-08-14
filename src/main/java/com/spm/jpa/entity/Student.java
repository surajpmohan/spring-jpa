package com.spm.jpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="student")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;
    @Column
    private String firstName;
    @Column
    private String lastName;
}
