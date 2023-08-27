package com.zanonjonascodes.ssmts.{{lower_identifier}};

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zanonjonascodes.ssmts.core.rest.crud.CrudControllerAbstract;
import com.zanonjonascodes.ssmts.core.rest.crud.CrudService;

import lombok.AllArgsConstructor;

@RestController()
@RequestMapping("/{{lower_identifier}}")
@AllArgsConstructor
public class {{capitalize_identifier}}Controller
    extends CrudControllerAbstract<{{capitalize_identifier}}Entity, String, {{capitalize_identifier}}RequestModel, {{capitalize_identifier}}ResponseModel> {

  private {{capitalize_identifier}}Service {{lower_identifier}}Service;

  @Override
  public CrudService<{{capitalize_identifier}}Entity, String, {{capitalize_identifier}}RequestModel, {{capitalize_identifier}}ResponseModel> getCrudService() {
    return {{lower_identifier}}Service;
  }

}
