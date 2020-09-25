package com.ameya.MobileAppAPI.documents;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("users")
public class User {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String passwordHash;
}
