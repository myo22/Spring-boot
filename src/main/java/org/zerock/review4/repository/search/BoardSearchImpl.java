package org.zerock.review4.repository.search;

import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.review4.domain.Board;
import org.zerock.review4.domain.QBoard;

import java.util.List;

public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch {

    public BoardSearchImpl(){
        super(Board.class); //자식 클래스 생성자에서 부모 클래스의 생성자를 호출하기 위해 사용됩니다.
    }

    @Override //Querydsl의 목적은 '타입' 기반으로 '코드'를 이용해서 JPQL 쿼리를 생성하고 실행하는 것이다. 이때 코드를 만드는 대신 클래스가 Q도메인 클래스입니다.
    public Page<Board> search1(Pageable pageable) {
        QBoard board = QBoard.board; //Q도메인 객체

        JPQLQuery<Board> query = from(board); // select.. from board
                                               //@Query로 작성했던 JPQL을 코드를 통해서 생성할 수 있게 합니다 이를 통해 where이나 group by 홋은 조인 처리등이 가능

        query.where(board.title.contains("1")); //where title like....

        //paging
        this.getQuerydsl().applyPagination(pageable, query);

        List<Board> list = query.fetch(); //JQPLQuery의 실행은 fetch()라는 기능을 이용

        long count = query.fetchCount(); //fetchCount()를 이용하면 count 쿼리를 실행할 수 있습니다.

        return null;
    }
}
