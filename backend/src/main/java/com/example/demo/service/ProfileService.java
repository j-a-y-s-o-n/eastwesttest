package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.demo.model.Profile;
import com.example.demo.repository.ProfileRepository;

import jakarta.transaction.Transactional;

@Service
public class ProfileService {
    private final ProfileRepository repository;

    public ProfileService(ProfileRepository repository){ 
        this.repository = repository; 
    }
    public List<Profile> getProfile(){ 
        return repository.findAll(); 
    }

    public void addProfile(Profile profile){
        Optional<Profile> profileByEmail = repository.findProfileByEmail(profile.getEMail());
        
        if(profileByEmail.isPresent()){ 
            throw new IllegalStateException("Email is taken.");
        }

        Optional<Profile> profileByMobile = repository.findProfileByMobile(profile.getMobile());
    
        if(profileByMobile.isPresent()){ 
            throw new IllegalStateException("Mobile is taken.");
        }
        
        repository.save(profile); 
    }

    public void deleteProfile(Long id){ 
        boolean exists = repository.existsById(id);

        if(exists){ 
			repository.deleteById(id);
		}else{ 
			throw new IllegalStateException("Profile with id:" + id + " does not exists."); 
		}
    }

    @Transactional
    public void UpdateProfile(Profile profile){ 
        Profile profileRecord = repository.findById(profile.getId())
            .orElseThrow(() -> new IllegalStateException("Profile with id " + profile.getId() + " does not exists."));
        
        if(profile.getFName() != null && 
        profile.getFName().length() > 0 &&
        !Objects.equals(profile.getFName(), profileRecord.getFName()))
        { 
            profileRecord.setFName(profile.getFName());
        }

        if(profile.getLName() != null && 
        profile.getLName().length() > 0 &&
        !Objects.equals(profile.getLName(), profileRecord.getLName()))
        { 
            profileRecord.setLName(profile.getLName());
        }
        
        if (profile.getEMail() != null && profile.getEMail().length() > 0 &&
			!Objects.equals(profileRecord.getEMail(), profile.getEMail())
		){
			Optional<Profile> profileOptional = repository.findProfileByEmail(profile.getEMail()); 
			if ( profileOptional.isPresent()){ 
				throw new IllegalStateException("email is taken");
			}
			profileRecord.setEMail(profile.getEMail()) ;
		}

        if (profile.getMobile() != null && profile.getMobile().length() > 0 &&
			!Objects.equals(profileRecord.getMobile(), profile.getMobile())
		){
			Optional<Profile> profileOptional = repository.findProfileByMobile(profile.getMobile()); 
			if ( profileOptional.isPresent()){ 
				throw new IllegalStateException("mobile is taken");
			}
			profileRecord.setMobile(profile.getMobile()) ;
		}
    }

    
}
