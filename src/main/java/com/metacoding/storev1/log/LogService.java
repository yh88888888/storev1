package com.metacoding.storev1.log;

import com.metacoding.storev1.log.LogResponse.ListPage;

// import org.springframework.beans.factory.annotation.Autowired;

public class LogService {

    // @Autowired
    private LogRepository logRepository;

    public List<ListPage> 구매목록() {
        return logRepository.findAllJoinStore();
    }

}
