package com.zanonjonascodes.ssmts.{{lower_identifier}};

import org.springframework.hateoas.RepresentationModel;
import com.zanonjonascodes.ssmts.core.rest.crud.ResponseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class {{capitalize_identifier}}ResponseModel extends ResponseModel<{{capitalize_identifier}}ResponseModel, String> {

}
