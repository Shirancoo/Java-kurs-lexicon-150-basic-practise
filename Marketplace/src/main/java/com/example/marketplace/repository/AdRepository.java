package com.example.marketplace.repository;

import com.example.marketplace.model.Advertisement;
import com.example.marketplace.model.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface AdRepository extends CrudRepository<Advertisement, UUID> {
    List<Advertisement> findByExpirationDateAfter(LocalDate date);
    List<Advertisement> findByCreator(User user);
}
