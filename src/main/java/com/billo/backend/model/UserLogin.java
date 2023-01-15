package com.billo.backend.model;

import com.billo.backend.enums.Indices;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = Indices.USER_LOGIN_INDEX)
public class UserLogin {

    @Id
    private String id;

    private  User user;

    @Field(type = FieldType.Text)
    private String token;

    @Field(type = FieldType.Text)
    private String tokenExpireTime;
}
