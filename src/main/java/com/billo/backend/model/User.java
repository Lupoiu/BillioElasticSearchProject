package com.billo.backend.model;

import com.billo.backend.enums.Indices;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.util.Date;
import java.util.List;

@Document(indexName = Indices.USER_INDEX)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel
public class User  {

    @Id
    @Field(type = FieldType.Text)
    @ApiModelProperty(hidden = true)
    private String id;

    @Field(type = FieldType.Text)
    @ApiModelProperty(position = 1, required = true, value = "Teodor Lupoiu")
    private String fullName;

    @Field(type = FieldType.Text)
    @ApiModelProperty(position = 2, required = true, value = "lupoiu")
    private String username;

    @Field(type = FieldType.Text)
    @ApiModelProperty(position = 3, required = true, value = "*********")
    private String password;

    @Field(type = FieldType.Text)
    @ApiModelProperty(position = 4, required = true, value = "lupoiu@gmail.com")
    private String email;

    @Field(type = FieldType.Text)
    @ApiModelProperty(position = 5, required = true, value = "2023-08-01")
    private String created;

    @Field(type = FieldType.Object)
    @ApiModelProperty(hidden = true)
    List<OrderInformationUser> orderInformationUsers;


}
