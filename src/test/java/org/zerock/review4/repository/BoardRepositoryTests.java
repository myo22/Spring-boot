package org.zerock.review4.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.review4.domain.Board;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test  //데이터베이스에 insert를 실행하는 기능은 JpaRepository의 save()기능을 통해서 이루어진다. 엔티티 객체가 없다면 insert를 있다면 update를 자동으로 실행한다.
    public void testInsert() {
        IntStream.rangeClosed(1,100).forEach( i -> { //rangeClosed는 range와 다르게 끝 값을 포함해서 반환한다.
            Board board = Board.builder()
                    .title("title..." + i)
                    .content("content..." + i)
                    .writer("user" + (i % 10))
                    .build();

            Board result = boardRepository.save(board);
            log.info("BNO : " + result.getBno());
        });
    }

    @Test
    public void testSelect() {
        Long bno = 100L;

        Optional<Board> result = boardRepository.findById(bno); //Optional은 null 또는 값을 감싸서 NPE로부터 부담을 줄이기 위해 등장한 클래스이다.

        Board board = result.orElseThrow(); //orElseThrow는 Optional의 인자가 null일 경우 예외처리를 시킨다.

        log.info(board);
    }

    @Test
    public void testUpdate() {

        Long bno = 100L;

        Optional<Board> result = boardRepository.findById(bno);

        Board board = result.orElseThrow();

        board.change("update..title 100", "update content 100");

        boardRepository.save(board);
    }
}
