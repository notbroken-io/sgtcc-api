package io.notbronken.sgtccapi.students.api.dto

import io.notbronken.sgtccapi.students.infra.entity.Student
import io.notbronken.sgtccapi.students.infra.enumeration.StudentStatus
import java.time.ZonedDateTime

data class StudentCreateDto(
    val registration: String,
    val name: String,
    val email: String,
    val phone: String,
) {
    fun toEntity() = Student(
        registration = registration,
        name = name,
        email = email,
        phone = phone
    )
}

data class StudentUpdateDto(
    val name: String,
    val email: String,
    val phone: String,
    val status: StudentStatus,
)

data class StudentDto(
    val registration: String,
    val name: String,
    val email: String,
    val phone: String,
    val status: StudentStatus,
    val createdAt: ZonedDateTime,
) {
    fun toEntity() = Student(
        registration = registration,
        name = name,
        email = email,
        phone = phone,
        status = status,
        createdAt = createdAt,
    )
}