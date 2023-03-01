package com.example.user.jpa;

import com.example.user.model.Features;
import com.example.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeatureRepository extends JpaRepository<Features,Integer> {

    List<Features> findByUser(User user);
}
