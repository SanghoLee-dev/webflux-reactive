package com.example.webfluxreactive.service;

import com.example.webfluxreactive.entity.Memo;
import com.example.webfluxreactive.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;

    public Flux<Memo> getMemos() {
        return memoRepository.findAll();
    }
}
