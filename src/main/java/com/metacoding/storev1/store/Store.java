package com.metacoding.storev1.store;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // 데이터를 가져오는 메서드
@NoArgsConstructor // JPA가 ObjectMapping을 위해 new할 때 사용함.
@AllArgsConstructor // JPA가 ObjectMapping을 위해 생성자를 만들어줌.
@Table(name = "store_tb") // 테이블 이름 지정
@Entity // 설정파일에서 테이블을 생성한다.
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가(auto_increment)
    private Integer id;
    private String name;
    private Integer stock; // 재고
    private Integer price;

}
// public void setStock(Integer stock) {
// this.stock = stock-qty; 로 써도 이해하기 어려우므로 아래와 같이 직관적으로 Setter를 만들어줌.
// // }
// public void 구매(qty) {
// this.stock = stock-qty;
