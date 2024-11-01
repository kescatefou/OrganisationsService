package com.leonaar.repository;

import com.leonaar.entity.Organisation;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrganisationRepository implements PanacheRepository<Organisation> {
}
