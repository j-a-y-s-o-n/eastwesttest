package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Profile {

    @Id
    @SequenceGenerator(
        name = "profile_sequence",
        sequenceName =  "profile_sequence",
        allocationSize =  1 
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, 
        generator = "product_sequence"
    )
    private Long id;

    // @NotBlank(message = "First name is required.")
    private String fName;

    // @NotBlank(message = "Last name is required.")
    private String lName;

    // @NotBlank(message = "Email is required.")
    // @Email(message = "Email should be valid.")
    private String eMail; 

    // @NotBlank(message = "Mobile is required.")
    // @Pattern(regexp = "^(?:\\+63|0)9\\d{9}$", message = "Mobile number must be valid (e.g., +639123456789 or 09123456789)")
    private String mobile;

    public Profile(){ 
        
    }

    public Profile(  
        Long id, 
        String fName,
        String lName,
        String eMail, 
        String mobile)
    {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.eMail = eMail;
        this.mobile = mobile;
     }

     public Long getId(){ 
        return this.id;
    }

    public void setId(Long id){ 
        this.id = id;
    }

    public String getFName(){ 
        return this.fName;
    }

    public void setFName(String fName){ 
        this.fName = fName;
    }

    public String getLName(){ 
        return this.lName;
    }

    public void setLName(String lName){ 
        this.lName = lName;
    }

    
    public String getEMail(){ 
        return this.eMail;
    }

    public void setEMail(String eMail){ 
        this.eMail = eMail;
    }

    public String getMobile(){ 
        return this.mobile;
    }

    public void setMobile(String mobile){ 
        this.mobile = mobile;
    }
}
