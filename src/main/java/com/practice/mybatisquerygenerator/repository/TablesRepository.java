package com.practice.mybatisquerygenerator.repository;

import com.practice.mybatisquerygenerator.entity.Tables;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@NoArgsConstructor
public class TablesRepository {

    @PersistenceContext
    EntityManager em;

    public void init(){

    }
    public void save(Tables tableList){
        em.persist(tableList);
    }
    public Tables findOne(Long id){
        return em.find(Tables.class, id);
    }
    public Tables findOne(String name){
        TypedQuery<Tables> query =  em.createQuery("SELECT t FROM Tables t WHERE t.name =:name", Tables.class);
        return query.setParameter("name", name).getSingleResult();
    }

}
