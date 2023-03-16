package org.zerock.review4.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerock.review4.domain.Board;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test  //데이터베이스에 insert를 실행하는 기능은 JpaRepository의 save()기능을 통해서 이루어진다. 엔티티 객체가 없다면 insert를 있다면 update를 자동으로 실행한다.
    public void testInsert() {
        IntStream.rangeClosed(1, 100).forEach(i -> { //rangeClosed는 range와 다르게 끝 값을 포함해서 반환한다.
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

        Long bno = 200L;

        Optional<Board> result = boardRepository.findById(bno);

        Board board = result.orElseThrow();

        board.change("update..title 100", "update content 100");

        boardRepository.save(board);
    }

    @Test //굳이 select문이 먼저 실행되는 이유는 JPA를 이용한다는 것은 영속 컨텍스트와 데이터베이스를 동기화해서 관리한다는 의미입니다.
    public void testDelete() {
        Long bno = 2L;

        boardRepository.deleteById(bno);
    }

    @Test
    public void testPaging() {

        //1 page order by desc
        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());

        Page<Board> result = boardRepository.findAll(pageable); //pageable을 이용하면 리턴 타입은 Page<T> 타입을 이용할 수 있다. 데이터가 많은경우 count 처리를 자동으로 실행.
        //findAll은 내부적으로 페이징 처리에 필요한 여러 정보를 처리합니다.(다음 페이지가 존재하는지, 이전 페이지가 존재하는지, 전체 데이터 개수는 몇개인지)

        log.info("total count: " + result.getTotalElements());
        log.info("total pages: " + result.getTotalPages());
        log.info("total number: " + result.getNumber());
        log.info("total size: " + result.getSize());

        List<Board> todoList = result.getContent();

        todoList.forEach(board -> log.info(board));
    }

    //Querydsl 확인
    @Test
    public void testSearch1() {

        //2 page order by bno desc
        Pageable pageable = PageRequest.of(1, 10, Sort.by("bno").descending());

        boardRepository.search1(pageable);

    }

    @Test
    public void testSearchAll(){

        String[] types = {"t", "c", "w"};

        String keyword = "1";

        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());

        Page<Board> result = boardRepository.searchAll(types, keyword, pageable);

        //total pages
        log.info(result.getTotalPages());

        //page size
        log.info(result.getSize());

        //pageNumber
        log.info(result.getNumber());

        //prev next
        log.info(result.hasPrevious() + ": " + result.hasNext());

        result.getContent().forEach(board ->  log.info(board));
    }
}
