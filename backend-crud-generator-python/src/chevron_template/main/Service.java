package com.zanonjonascodes.ssmts.{{lower_identifier}};

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zanonjonascodes.ssmts.core.rest.crud.CrudMapper;
import com.zanonjonascodes.ssmts.core.rest.crud.CrudServiceAbstract;

@Service
public class {{capitalize_identifier}}Service extends CrudServiceAbstract<{{capitalize_identifier}}Entity, String, {{capitalize_identifier}}RequestModel, {{capitalize_identifier}}ResponseModel> {

  private {{capitalize_identifier}}Repository repository;

  private {{capitalize_identifier}}Mapper mapper;
  
  private {{capitalize_identifier}}ModelAssembler modelAssembler;

  private PagedResourcesAssembler<{{capitalize_identifier}}Entity> pagedResourcesAssembler;

  public {{capitalize_identifier}}Service(ObjectMapper objectMapper, {{capitalize_identifier}}Repository repository, {{capitalize_identifier}}Mapper mapper,
      {{capitalize_identifier}}ModelAssembler modelAssembler, PagedResourcesAssembler<{{capitalize_identifier}}Entity> pagedResourcesAssembler) {
    super(objectMapper);
    this.repository = repository;
    this.mapper = mapper;
    this.modelAssembler = modelAssembler;
    this.pagedResourcesAssembler = pagedResourcesAssembler;
  }

  @Override
  public CrudMapper<{{capitalize_identifier}}Entity, String, {{capitalize_identifier}}RequestModel, {{capitalize_identifier}}ResponseModel> getMapper() {
    return mapper;
  }

  @Override
  public JpaRepository<{{capitalize_identifier}}Entity, String> getRepository() {
    return repository;
  }

  @Override
  public RepresentationModelAssemblerSupport<{{capitalize_identifier}}Entity, {{capitalize_identifier}}ResponseModel> getModelAssembler() {
    return modelAssembler;
  }

  @Override
  public PagedResourcesAssembler<{{capitalize_identifier}}Entity> getPagedResourcesAssembler() {
    return pagedResourcesAssembler;
  }

}
