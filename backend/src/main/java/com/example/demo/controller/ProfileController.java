package com.example.demo.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.helper.StringHelper;
import com.example.demo.model.Profile;
import com.example.demo.service.ProfileService;

@RestController
@RequestMapping("api/profile")
public class ProfileController {

    private final ProfileService service;
    private final StringHelper strHelper;
    @Autowired
    public ProfileController(ProfileService service){ 
        this.service = service;
        this.strHelper = new StringHelper();
    }

    @GetMapping()
    public List<Profile> getProfile(){
        return service.getProfile(); 
    }

    @PostMapping()
    public void addProfile(@RequestBody Profile profile){ 
        this.validate(profile);
        service.addProfile(profile);
    }

    @PutMapping()
    public void updateProfile(@RequestBody Profile profile){ 
        this.validate(profile);
        service.UpdateProfile(profile);
    }

    @DeleteMapping(path = "{profileId}")
    public void deleteProfile(@PathVariable("profileId"
    ) Long profileId){ 
        service.deleteProfile(profileId);
    }

    private void validate(Profile profile){ 
        if(strHelper.isEmptyString(profile.getFName()) )
        { 
            throw new IllegalStateException("First name is required.");
        }

        if(strHelper.isEmptyString(profile.getLName()) )
        { 
            throw new IllegalStateException("Last name is required.");
        }

        if(strHelper.isEmptyString(profile.getEMail()) )
        { 
            throw new IllegalStateException("Email is required.");
        }
        
        if(strHelper.isEmptyString(profile.getMobile()) )
        { 
            throw new IllegalStateException("Mobile is required.");
        }

        if(!strHelper.isValidMobile(profile.getMobile()) )
        { 
            throw new IllegalStateException("Mobile format is invalid.");
        }

        if(!strHelper.isValidEmail(profile.getEMail()) )
        { 
            throw new IllegalStateException("Email format is invalid.");
        }
    }
}
