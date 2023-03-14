package org.zerock.review4.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.zerock.review4.domain.Board;

public interface BoardSearch {
    Page<Board> search1(Pageable pageable);
}
