package com.leonaar.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class Organisation extends PanacheEntity {
    @Column(columnDefinition = "varchar(255)", unique = true)
    @NotNull(message = "Organisation name is mandatory")
    @NotBlank(message="Organisation name may not be blank")
    public String name;

    @Column(columnDefinition = "varchar(255)")
    @NotNull(message = "Organisation email is mandatory")
    @NotBlank(message="Organisation email may not be blank")
    public String email;

    @Column(columnDefinition = "varchar(5)")
    @NotNull(message = "Organisation language is mandatory")
    @NotBlank(message="Organisation language may not be blank")
    public String languageCode;

    public LocalDate creationDate;

    @Column(columnDefinition = "varchar(64)")
    @NotNull(message = "Organisation timeZone is mandatory")
    @NotBlank(message="Organisation timeZone may not be blank")
    public String timeZone;

    @Column(columnDefinition = "varchar(5)")
    @NotNull(message = "Organisation currencyCode is mandatory")
    @NotBlank(message="Organisation currencyCode may not be blank")
    public String currencyCode;
}
