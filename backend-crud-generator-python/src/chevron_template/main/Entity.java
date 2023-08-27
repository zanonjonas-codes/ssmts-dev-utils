package com.zanonjonascodes.ssmts.{{lower_identifier}};

import com.zanonjonascodes.ssmts.core.data.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "{{lower_identifier}}")
@Data
@EqualsAndHashCode(callSuper=false)
@SuperBuilder
@NoArgsConstructor
public class {{capitalize_identifier}}Entity extends BaseEntity<String> {

}
