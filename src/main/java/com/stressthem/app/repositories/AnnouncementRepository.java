package com.stressthem.app.repositories;

import com.stressthem.app.domain.entities.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement,String> {
    List<Announcement>findAllByOrderByAddedOnDesc();
}
