package com.zanonjonascodes.ssmts.unit_tests.{{lower_identifier}};

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.zanonjonascodes.ssmts.fixture.{{capitalize_identifier}}Fixture;
import com.zanonjonascodes.ssmts.{{lower_identifier}}.{{capitalize_identifier}}Service;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class {{capitalize_identifier}}ControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private {{capitalize_identifier}}Service {{lower_identifier}}Service;

  private {{capitalize_identifier}}Fixture {{lower_identifier}}Fixture;

  @Value("${props.basic-auth.user}")
  private String basicAuthUser;

  @Value("${props.basic-auth.password}")
  private String basicAuthPassword;

  @BeforeEach
  private void setup() {
    {{lower_identifier}}Fixture = new {{capitalize_identifier}}Fixture();
  }

  public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

  @Test
	public void test_find_all() throws Exception {
		when({{lower_identifier}}Service.findAll(any())).thenReturn({{lower_identifier}}Fixture.getResponsePagedModel());
		
    this.mockMvc.perform(get("/{{lower_identifier}}")
                          .with(httpBasic(basicAuthUser, basicAuthPassword))).andDo(print()).andExpect(status().isOk())
				                  .andExpect(content().string(containsString({{lower_identifier}}Fixture.getResponseModel().getId())));
	}

  @Test
	public void test_find_by_id() throws Exception {
		when({{lower_identifier}}Service.findById({{lower_identifier}}Fixture.getEntity().getId())).thenReturn({{lower_identifier}}Fixture.getResponseModel());
		
    this.mockMvc.perform(get("/{{lower_identifier}}/{id}", {{lower_identifier}}Fixture.getEntity().getId())
                          .with(httpBasic(basicAuthUser, basicAuthPassword)))
                          .andDo(print())
                          .andExpect(status().isOk())
				                  .andExpect(content().string(containsString({{lower_identifier}}Fixture.getResponseModel().getId())));
	}

  @Test
	public void test_create() throws Exception {
		when({{lower_identifier}}Service.create({{lower_identifier}}Fixture.getRequestModel())).thenReturn({{lower_identifier}}Fixture.getResponseModel());
    this.mockMvc.perform(post("/{{lower_identifier}}")
                          .contentType(APPLICATION_JSON_UTF8)
                          .content({{lower_identifier}}Fixture.getRequestModelAsJson())
                          .with(httpBasic(basicAuthUser, basicAuthPassword)))
                          .andDo(print())
                          .andExpect(status().isCreated())
				                  .andExpect(content().string(containsString({{lower_identifier}}Fixture.getResponseModel().getId())));
	}

  @Test
  public void delete_by_id() throws Exception {
    this.mockMvc.perform(delete("/{{lower_identifier}}/{id}", {{lower_identifier}}Fixture.getEntity().getId())
        .with(httpBasic(basicAuthUser, basicAuthPassword)))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
	public void test_patch() throws Exception {
		when({{lower_identifier}}Service.patch({{lower_identifier}}Fixture.getRequestModelAsMap(), {{lower_identifier}}Fixture.getEntity().getId())).thenReturn({{lower_identifier}}Fixture.getResponseModel());
    this.mockMvc.perform(patch("/{{lower_identifier}}/{id}", {{lower_identifier}}Fixture.getEntity().getId())
                          .contentType(APPLICATION_JSON_UTF8)
                          .content({{lower_identifier}}Fixture.getRequestModelAsJson())
                          .with(httpBasic(basicAuthUser, basicAuthPassword)))
                          .andDo(print())
                          .andExpect(status().isOk())
				                  .andExpect(content().string(containsString({{lower_identifier}}Fixture.getResponseModel().getId())));
	}

}
