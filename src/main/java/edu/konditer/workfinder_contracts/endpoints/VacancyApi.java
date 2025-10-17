package edu.konditer.workfinder_contracts.endpoints;

import edu.konditer.workfinder_contracts.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "vacancies", description = "API для работы с вакансиями")
@RequestMapping("/api/vacancies")
public interface VacancyApi {

    @Operation(summary = "Получить вакансию по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Вакансия найдена"),
            @ApiResponse(responseCode = "404", description = "Вакансия не найдена",
                    content = @Content(schema = @Schema(implementation = StatusResponse.class)))
    })
    @GetMapping("/{id}")
    EntityModel<VacancyResponse> getVacancyById(@PathVariable("id") Long id);

    @Operation(summary = "Получить список всех вакансий с фильтрацией и пагинацией")
    @ApiResponse(responseCode = "200", description = "Список вакансий")
    @GetMapping
    PagedModel<EntityModel<VacancyResponse>> getAllVacancies(
            @Parameter(description = "Название профессии") @RequestParam(defaultValue = "") int jobName,
            @Parameter(description = "Номер страницы (0..N)") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Размер страницы") @RequestParam(defaultValue = "10") int size
    );

    @Operation(summary = "Создать новую вакансию")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Вакансия успешно создана"),
            @ApiResponse(responseCode = "400", description = "Невалидный запрос",
                    content = @Content(schema = @Schema(implementation = StatusResponse.class)))
    })
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<EntityModel<VacancyResponse>> createVacancy(@Valid @RequestBody VacancyRequest request);

    @Operation(summary = "Обновить вакансию")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Вакансия успешно обновлена"),
            @ApiResponse(responseCode = "404", description = "Вакансия не найдена",
                    content = @Content(schema = @Schema(implementation = StatusResponse.class)))
    })
    @PutMapping("/{id}")
    EntityModel<VacancyResponse> updateVacancy(@PathVariable Long id, @Valid @RequestBody VacancyRequest request);

    @Operation(summary = "Удалить вакансию")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Вакансия успешно удалена"),
            @ApiResponse(responseCode = "404", description = "Вакансия не найдена",
                    content = @Content(schema = @Schema(implementation = StatusResponse.class)))
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteVacancy(@PathVariable Long id);
}
