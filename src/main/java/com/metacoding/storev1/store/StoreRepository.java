package com.metacoding.storev1.store;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class StoreRepository {

    private EntityManager em;

    public StoreRepository(EntityManager em) {
        this.em = em;
    }

    public void save(String name, int stock, int price) {
        Query query = em.createNativeQuery("insert into store_tb(name, stock, price) values(?,?,?)");
        query.setParameter(1, name);
        query.setParameter(2, stock);
        query.setParameter(3, price);
        query.executeUpdate();
    }

    public Store findById(int id) {
        Query query = em.createNativeQuery("select * from store_tb where id = ?", Store.class);
        query.setParameter(1, id);
        try {
            return (Store) query.getSingleResult();
        } catch (Exception e) { // NoResultException
            return null;
        }

    }

    public List<Store> findAll() {
        // 조건 : 오브젝트 매핑은 @Entity가 붙어야지만 가능하다. (디폴트 생성자를 호출)
        // setter가 없어도 들거아는 이유?? 리플렉션으로 다 찾기 때문이다.
        Query query = em.createNativeQuery("select * from store_tb order by id desc", Store.class);
        List<Store> storeList = query.getResultList();
        return storeList;
    }

    public void deleteById(int id) {
        Query query = em.createNativeQuery("delete from store_tb where id=?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public void updateById(int id, String name, String stock, String price) {
        Query query = em.createNativeQuery("update store_tb set name=?, stock=?, price=? where id=?");
        query.setParameter(1, name);
        query.setParameter(2, stock);
        query.setParameter(3, price);
        query.setParameter(4, id);
        query.executeUpdate();
    }
}
