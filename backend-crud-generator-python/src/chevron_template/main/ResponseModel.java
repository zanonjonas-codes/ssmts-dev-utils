package com.zanonjonascodes.ssmts.{{lower_identifier}};

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class {{capitalize_identifier}}ResponseModel extends RepresentationModel<{{capitalize_identifier}}ResponseModel> {
  protected String id;

}
