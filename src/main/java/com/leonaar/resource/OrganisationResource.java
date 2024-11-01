package com.leonaar.resource;

import com.leonaar.entity.Organisation;
import com.leonaar.repository.AbstractRepository;
import com.leonaar.repository.OrganisationRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Path("/organisations")
public class OrganisationResource extends AbstractResource<Organisation> {
    @Inject
    OrganisationRepository organisationRepository;

    @Override
    protected AbstractRepository<Organisation> getRepository() {
        return organisationRepository;
    }

    @GET
    @Path("{id:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Organisation getOrganisation(Long id) {
        Organisation company = organisationRepository.findById(id);
        if (company == null) {
            throw new NotFoundException("Unknown organisation: " + id);
        }
        return company;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Organisation> list(@QueryParam("page") int page, @QueryParam("pageSize") int pageSize) {
        // TODO filter only my organisation
        return organisationRepository.list(page, pageSize);
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Organisation createOrganisation(@Valid Organisation organisation) {
        organisationRepository.persist(organisation);
        organisation.creationDate = LocalDate.now(ZoneId.of("GMT"));
        return organisation;
    }

    @DELETE
    public boolean deleteOrganisation(Long id) {
        return organisationRepository.deleteById(id);
    }
}
