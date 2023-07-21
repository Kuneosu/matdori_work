package com.mysite.matdori.information.repository;

import com.mysite.matdori.information.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<Information, Long> {

}
