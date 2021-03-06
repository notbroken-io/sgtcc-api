package io.notbronken.sgtccapi.semesters.api.controller

import io.notbronken.sgtccapi.common.model.CreatedResource
import io.notbronken.sgtccapi.semesters.api.dto.SemesterCreateDto
import io.notbronken.sgtccapi.semesters.api.dto.SemesterDto
import io.notbronken.sgtccapi.semesters.api.dto.SemesterUpdateDto
import io.notbronken.sgtccapi.semesters.business.service.SemesterService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.logging.Logger

@RestController
@RequestMapping("/api/semesters")
class SemesterController(
    val semesterService: SemesterService,
) {
    companion object {
        private val LOGGER = Logger.getLogger(SemesterController::class.simpleName)
    }

    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE],
    )
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody dto: SemesterCreateDto): Mono<CreatedResource> = semesterService.create(dto)

    @PutMapping(
        value = ["/{id}"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE],
    )
    @ResponseStatus(HttpStatus.OK)
    fun update(
        @RequestBody dto: SemesterUpdateDto, @PathVariable id: Long
    ): Mono<SemesterDto> = semesterService.update(dto, id)

    @GetMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
    )
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: Long): Mono<SemesterDto> = semesterService.read(id)

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findAll(): Flux<SemesterDto> = semesterService.list()
}