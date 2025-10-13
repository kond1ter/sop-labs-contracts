package edu.konditer.workfinder_contracts.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record VacancyRequest(@NotBlank(message = "Название вакансии не должно быть пустым") String title,
                             @NotBlank(message = "Описание вакансии не должно быть пустым") String description,
                             @NotBlank(message = "Контакнтый номер не должен быть пустым") String contactPhoneNumber,
                             @Positive(message = "Значение зарплаты должно быть больше нуля") Double salary,
                             @NotNull Long authorId) {
}
