package com.metacoding.storev1.log;

import java.util.List;
import org.springframework.stereotype.Service;
import com.metacoding.storev1.log.LogResponse.ListPage;

// import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LogService {

    // @Autowired
    private LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public List<ListPage> 구매목록() {
        return logRepository.findAllJoinStore();
    }

}
