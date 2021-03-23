package com.example.webfluxreactive.service;

import com.example.webfluxreactive.entity.Memo;
import com.example.webfluxreactive.repository.MemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemoServiceTest {
    @Autowired
    MemoRepository memoRepository;

    @Autowired
    MemoService memoService;

    @Test
    void 테스트() {
        final String content = "메모";
        final Mono<Memo> save = memoRepository.save(Memo.builder()
                .content(content)
                .build());

        final Memo memo = memoService.getMemos()
                .toStream().findFirst().orElseThrow();

        System.out.println(memo.getContent());
        assertThat(memo.getContent()).isEqualTo(content);
    }
}