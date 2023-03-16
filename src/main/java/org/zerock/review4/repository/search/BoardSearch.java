package org.zerock.review4.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.zerock.review4.domain.Board;

public interface BoardSearch {
    Page<Board> search1(Pageable pageable);

    //검색 조건과 키워드를 설정
    Page<Board> searchAll(String[] types, String keyword, Pageable pageable);
}
