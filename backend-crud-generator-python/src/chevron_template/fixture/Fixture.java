package com.zanonjonascodes.ssmts.fixture;

import java.util.List;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import com.zanonjonascodes.ssmts.core.rest.crud.CrudMapper;
import com.zanonjonascodes.ssmts.{{lower_identifier}}.{{capitalize_identifier}}Entity;
import com.zanonjonascodes.ssmts.{{lower_identifier}}.{{capitalize_identifier}}MapperImpl;
import com.zanonjonascodes.ssmts.{{lower_identifier}}.{{capitalize_identifier}}ModelAssembler;
import com.zanonjonascodes.ssmts.{{lower_identifier}}.{{capitalize_identifier}}RequestModel;
import com.zanonjonascodes.ssmts.{{lower_identifier}}.{{capitalize_identifier}}ResponseModel;

public class {{capitalize_identifier}}Fixture extends FixtureAbstract<{{capitalize_identifier}}Entity, String, {{capitalize_identifier}}RequestModel, {{capitalize_identifier}}ResponseModel>{

  public List<{{capitalize_identifier}}Entity> getEntityList() {
    return List.of(
        {{capitalize_identifier}}Entity.builder()
            .id("1")
            .build(),
        {{capitalize_identifier}}Entity.builder()
            .id("2")
            .build());
  }

  @Override
  protected CrudMapper<{{capitalize_identifier}}Entity, String, {{capitalize_identifier}}RequestModel, {{capitalize_identifier}}ResponseModel> getMapper() {
    return new {{capitalize_identifier}}MapperImpl();
  }

  @Override
  protected RepresentationModelAssemblerSupport<{{capitalize_identifier}}Entity, {{capitalize_identifier}}ResponseModel> getModelAssembler() {
    return new {{capitalize_identifier}}ModelAssembler(new {{capitalize_identifier}}MapperImpl());
  }

  
}
