package com.anuj.testspringboot.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<PersonEntity> getAllPersons(){
        TypedQuery<PersonEntity> allPersonsQuery = entityManager.createNamedQuery("get_all_persons", PersonEntity.class);
        return allPersonsQuery.getResultList();
    }

    public PersonEntity insertPerson(PersonEntity person){
        return entityManager.merge(person);
    }

    public PersonEntity updatePerson(PersonEntity person){
        return entityManager.merge(person);
    }

    public void deleteById(int personId){
        entityManager.remove(1001);
    }
}
