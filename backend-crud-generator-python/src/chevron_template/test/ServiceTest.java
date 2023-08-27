package com.zanonjonascodes.ssmts.unit_tests.{{lower_identifier}};

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zanonjonascodes.ssmts.core.config.parser.JacksonConfig;
import com.zanonjonascodes.ssmts.fixture.{{capitalize_identifier}}Fixture;
import com.zanonjonascodes.ssmts.{{lower_identifier}}.{{capitalize_identifier}}Entity;
import com.zanonjonascodes.ssmts.{{lower_identifier}}.{{capitalize_identifier}}Mapper;
import com.zanonjonascodes.ssmts.{{lower_identifier}}.{{capitalize_identifier}}MapperImpl;
import com.zanonjonascodes.ssmts.{{lower_identifier}}.{{capitalize_identifier}}ModelAssembler;
import com.zanonjonascodes.ssmts.{{lower_identifier}}.{{capitalize_identifier}}Repository;
import com.zanonjonascodes.ssmts.{{lower_identifier}}.{{capitalize_identifier}}ResponseModel;
import com.zanonjonascodes.ssmts.{{lower_identifier}}.{{capitalize_identifier}}Service;

import jakarta.servlet.http.HttpServletRequest;

@ExtendWith(MockitoExtension.class)
public class {{capitalize_identifier}}ServiceTest {

  @Mock
  private {{capitalize_identifier}}Repository repository;

  @InjectMocks
  private {{capitalize_identifier}}Service {{lower_identifier}}Service;

  private {{capitalize_identifier}}Fixture fixture;

  {{capitalize_identifier}}Entity t{{capitalize_identifier}}Entity;

  ObjectMapper objectMapper;

  @BeforeEach
  public void setup() {
    HttpServletRequest mockRequest = new MockHttpServletRequest();
    ServletRequestAttributes servletRequestAttributes = new ServletRequestAttributes(mockRequest);
    RequestContextHolder.setRequestAttributes(servletRequestAttributes);

    JacksonConfig jacksonConfig = new JacksonConfig();
    objectMapper = jacksonConfig.getObjectMapper();

    {{capitalize_identifier}}Mapper mapper = new {{capitalize_identifier}}MapperImpl();
    {{capitalize_identifier}}ModelAssembler {{lower_identifier}}ModelAssembler = new {{capitalize_identifier}}ModelAssembler(mapper);
    PagedResourcesAssembler<{{capitalize_identifier}}Entity> pagedResourcesAssembler = new PagedResourcesAssembler<>(null, null);
    {{lower_identifier}}Service = new {{capitalize_identifier}}Service(objectMapper, repository, mapper, {{lower_identifier}}ModelAssembler, pagedResourcesAssembler);

    fixture = new {{capitalize_identifier}}Fixture();
    t{{capitalize_identifier}}Entity = fixture.getEntity();

  }

  @AfterEach
  public void terdown() {
    RequestContextHolder.resetRequestAttributes();
  }

  @Test
  void test_find_all() {
    Pageable pageable = PageRequest.of(0, 10);
    given(repository.findAll(pageable)).willReturn(fixture.getEntityPage());

    PagedModel<{{capitalize_identifier}}ResponseModel> pagedModel = {{lower_identifier}}Service.findAll(pageable);

    int i = 0;
    for ({{capitalize_identifier}}ResponseModel responseModel : pagedModel) {
      assertEquals(fixture.getEntityList().get(i).getId(), responseModel.getId());
      i = +1;
    }
  }

  @Test
  void test_find_by_id() {
    given(repository.findById(t{{capitalize_identifier}}Entity.getId())).willReturn(Optional.of(t{{capitalize_identifier}}Entity));
    {{capitalize_identifier}}ResponseModel responseModel = {{lower_identifier}}Service.findById(t{{capitalize_identifier}}Entity.getId());
    assertEquals(t{{capitalize_identifier}}Entity.getId(), responseModel.getId());
  }

  @Test
  void test_create() {
    given(repository.save(t{{capitalize_identifier}}Entity)).willReturn(t{{capitalize_identifier}}Entity);
    {{capitalize_identifier}}ResponseModel responseModel = {{lower_identifier}}Service.create(fixture.getRequestModel());
    assertEquals(t{{capitalize_identifier}}Entity.getId(), responseModel.getId());
  }

  @Test
  void test_delete() {
    assertDoesNotThrow(() -> {{lower_identifier}}Service.delete(t{{capitalize_identifier}}Entity.getId()));
  }

}
