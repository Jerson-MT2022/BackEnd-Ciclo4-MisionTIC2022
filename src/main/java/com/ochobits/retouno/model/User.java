
package com.ochobits.retouno.model;

import javax.persistence.Column;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 *
 * @author estdiag
 */

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    
    @Id
    private Integer id;
    @NonNull
    @Column (name= "user_identification", nullable=false)
    private String identification;
    @NonNull
    @Column (name= "user_name", nullable = false, length =80)
    private String name;
    @NonNull
    @Column (name= "user_address", nullable = false)
    private String address;
    @NonNull
    @Column (name= "user_cellPhone", nullable = false)
    private String cellPhone;
    @NonNull
    @Column (name= "user_email", nullable = false, length =50) 
    private String email;
    @NonNull
    @Column (name= "user_password", nullable = false, length =50) 
    private String password;
    @NonNull
    @Column (name= "user_zone", nullable = false)
    private String zone;
    @NonNull
    @Column (name= "user_type", nullable = false)
    private String type;
    
    
    
    
}
