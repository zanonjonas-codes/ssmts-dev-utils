package com.zanonjonascodes.ssmts.{{lower_identifier}};

import org.mapstruct.Mapper;

import com.zanonjonascodes.ssmts.core.rest.crud.CrudMapper;

@Mapper(componentModel = "spring")
public interface {{capitalize_identifier}}Mapper extends CrudMapper<{{capitalize_identifier}}Entity, String, {{capitalize_identifier}}RequestModel, {{capitalize_identifier}}ResponseModel> {

}
