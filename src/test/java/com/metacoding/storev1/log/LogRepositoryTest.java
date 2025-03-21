package com.metacoding.storev1.log;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

// import lombok.RequiredArgsConstructor;

@Import(LogRepository.class)
@DataJpaTest // 1 em을 IoC 등록
public class LogRepositoryTest {

    @Autowired // 4. IoC에 있는 것을 DI 한것임
    // final 붙여서 @RequiredArgsConstructor 하는게 가장 깔끔
    private LogRepository logRepository; // 3.

    @Test // 3. 세모버튼 생김
    public void findAllJoinStore_test() { // 2. 매개변수에 아무것도 적을 수 없다.
        java.util.List<LogResponse.ListPage> logList = logRepository.findAllJoinStore();

        for (LogResponse.ListPage listPage : logList) {
            System.out.println(listPage);
        }
    }
}
