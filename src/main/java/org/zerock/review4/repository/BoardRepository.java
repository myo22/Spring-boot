package org.zerock.review4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.review4.domain.Board;

//JPARepository라는 인터페이스를 이용해서 선언만으로 데이터베이스 관련 작업을 어느정도 처리할 수 있습니다(CRUD, 페이징)

public interface BoardRepository extends JpaRepository<Board, Long>{ //<엔티티타입, ID타입>을 지정해줘야 한다.
}
