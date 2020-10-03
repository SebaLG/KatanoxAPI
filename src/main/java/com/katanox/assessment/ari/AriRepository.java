package com.katanox.assessment.ari;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AriRepository extends JpaRepository<Ari, Long> {


}
