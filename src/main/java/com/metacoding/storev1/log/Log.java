package com.metacoding.storev1.log;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // JPA가 ObjectMapping을 위해 new할 때 사용함.
@AllArgsConstructor // JPA가 ObjectMapping을 위해 생성자를 만들어줌.
@Table(name = "log_tb") // 테이블 이름 지정
@Entity // 설정파일에서 테이블을 생성한다.
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가(auto_increment)
    private Integer id;
    private Integer storeId;// 상품ID(FK)
    private Integer qty; // 구매 개수
    private Integer totalPrice; // qty*store(price)
    private String buyer; // 구매자이름

}