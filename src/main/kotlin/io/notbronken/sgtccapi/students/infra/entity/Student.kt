package io.notbronken.sgtccapi.students.infra.entity

import io.notbronken.sgtccapi.proposals.infra.entity.Proposal
import io.notbronken.sgtccapi.semesters.infra.entity.Grade
import io.notbronken.sgtccapi.students.infra.enumeration.StudentStatus
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.ZonedDateTime

@Entity
@Table(name = "STUDENTS")
class Student(
    @Id
    @Column(nullable = false, length = 20, unique = true)
    val registration: String,
    @Column(nullable = false, length = 50)
    val name: String,
    @Column(nullable = false, length = 50, unique = true)
    val email: String,
    @Column(nullable = false, length = 11, unique = true)
    val phone: String,
    @Column(nullable = false, length = 11, unique = true)
    val cpf: String,
    @Column(name = "CREATED_AT", nullable = false)
    val createdAt: ZonedDateTime = ZonedDateTime.now(),
    @OneToMany(mappedBy = "student")
    val classes: Set<Grade> = setOf(),
    @OneToMany(mappedBy = "author")
    val proposals: Set<Proposal> = setOf(),
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val status: StudentStatus,
) {
}