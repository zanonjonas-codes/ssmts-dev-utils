package com.zanonjonascodes.ssmts.{{lower_identifier}};

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class {{capitalize_identifier}}ModelAssembler extends RepresentationModelAssemblerSupport<{{capitalize_identifier}}Entity, {{capitalize_identifier}}ResponseModel> {

  {{capitalize_identifier}}Mapper mapper;

  public {{capitalize_identifier}}ModelAssembler({{capitalize_identifier}}Mapper mapper) {
    super({{capitalize_identifier}}Controller.class, {{capitalize_identifier}}ResponseModel.class);
    this.mapper = mapper;
  }

  @Override
  public {{capitalize_identifier}}ResponseModel toModel({{capitalize_identifier}}Entity entity) {
    {{capitalize_identifier}}ResponseModel responseModel = mapper.toResponse(entity);

    responseModel.add(linkTo(
        methodOn({{capitalize_identifier}}Controller.class)
            .findById(entity.getId()))
        .withSelfRel());

    return responseModel;
  }

  @Override
  public CollectionModel<{{capitalize_identifier}}ResponseModel> toCollectionModel(Iterable<? extends {{capitalize_identifier}}Entity> entities) {
    CollectionModel<{{capitalize_identifier}}ResponseModel> responseModels = super.toCollectionModel(entities);

    responseModels.add(linkTo(methodOn({{capitalize_identifier}}Controller.class).findAll(null)).withSelfRel());

    return responseModels;
  }
}
