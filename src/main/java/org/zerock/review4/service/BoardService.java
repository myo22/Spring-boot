package org.zerock.review4.service;

import org.zerock.review4.domain.Board;
import org.zerock.review4.dto.BoardDTO;

public interface BoardService {

    Long register(BoardDTO boardDTO);

    BoardDTO readOne(Long bno);

    void modify(BoardDTO boardDTO);

    void remove(Long bno);
}
