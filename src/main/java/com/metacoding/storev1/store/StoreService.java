package com.metacoding.storev1.store;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreService {

    private StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Transactional
    public void 상품등록(String name, int stock, int price) {
        storeRepository.save(name, stock, price);
    }

    public Store 상세보기(int id) {
        Store store = storeRepository.findById(id);
        return store;
    }

    public List<Store> 상품목록() {
        List<Store> storeList = storeRepository.findAll();
        return storeList;
    }

    @Transactional // delelte, insert, update시에 사용: 함수 종료시 commit 됨
    public void 상품삭제(int id) {
        // 1. 상품조회
        Store store = storeRepository.findById(id);
        // 2. 상품이 없으면 - Repository에서 try-catch가 가능하지만 책임을 구분하는 차원에서 Service에서 처리한다.
        if (store == null) {
            throw new RuntimeException("상품이 없는데 어떻게 삭제하지?");
        }
        storeRepository.deleteById(id);// write(DML=insert, delete, update)
    }

    @Transactional
    public void 상품수정(int id, String name, int stock, int price) {
        // 1. 상품조회
        Store store = storeRepository.findById(id);
        // 2. 상품이 없으면 - Repository에서 try-catch가 가능하지만 책임을 구분하는 차원에서 Service에서 처리한다.
        if (store == null) {
            throw new RuntimeException("상품없어");
        }
        storeRepository.updateById(id, name, stock, price);// write(DML=insert, delete, update)

    }
}