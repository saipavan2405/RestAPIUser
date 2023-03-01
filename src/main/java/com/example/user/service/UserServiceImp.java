package com.example.user.service;


import com.example.user.dto.FeatureDto;
import com.example.user.dto.Score;
import com.example.user.dto.UserDto;
import com.example.user.jpa.FeatureRepository;
import com.example.user.jpa.UserRepository;
import com.example.user.model.Features;
import com.example.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FeatureRepository featureRepository;

    @Value("${score.url}")
    private String scoreUrl;


    @Override
    public UserDto getUser(long id) {
         User user =  userRepository.findById(id).orElse(null);
         List<Features> features = featureRepository.findByUser(user);

         List<FeatureDto> featureDtoList = features.stream()
                .map(f -> new FeatureDto(f.attribute, f.value))
                .collect(Collectors.toList());

        RestTemplate restTemplate = new RestTemplate();
        Score score =  restTemplate.getForObject(scoreUrl, Score.class,id);

        UserDto dto = new UserDto();
        dto.setId(id);
        dto.setFname(user.getFname());
        dto.setLname(user.getLname());
        dto.setFeatures(featureDtoList);

        if(score!=null) {
            dto.setScore(score.getValue());
        }
        return dto;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user){
       return userRepository.save(user);
    }

    @Override
    public String delete(long id){
        userRepository.deleteById(id);
        return "Deleted"+id;
    }

}
