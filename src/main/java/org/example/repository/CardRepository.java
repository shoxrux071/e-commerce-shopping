package org.example.repository;

import org.example.domains.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface CardRepository extends JpaRepository<Card,Long> {

    @Query("select t from Card t where t.user_id = :id")
    List<Card> findByUserId(@Param("id") Long id);

//    void deleteByUser_id(Long id);

    @Modifying
    @Transactional
    @Query("delete from Card where user_id = :userId")
    void deleteByUserId(@Param("userId") Long id);

}
