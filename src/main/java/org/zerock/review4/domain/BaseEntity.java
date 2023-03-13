package org.zerock.review4.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass //생성자, 생성시간, 수정자, 수정시간을 모든 엔티티에 공통으로 가져가야 하는 상황에서 단순히 부모 클래스를 상속 받는 자식 클래스에 매핑 정보만 제공한다. (추상 클래스이다.)
                  //@MappedSuperclass 어노테이션을 사용함으로써 JPA Entity 클래스들이 BaseEntity를 상속할 경우 BaseEntity class의 필드인 regDate, modDate를 인식하도록 합니다.
@EntityListeners(value = { AutoCloseable.class}) //엔티티가 데이터베이스에 추가되거나 변경될 때 자동으로 시간 값을 지정할 수 있습니다.
                                                 // JPA Entity에서 이벤트가 발생할 때마다 특정 로직을 실행시킬 수 있는 어노테이션입니다. AutoCloseable.class 클래스가 callback listener로 지정되어 Entity에서 이벤트가 발생할 때마다 특정 로직을 수행하게 됩니다.
@Getter
public class BaseEntity {

    @CreatedDate //생성된 시간 정보
    @Column(name = "regdate", updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate //수정된 시간 정보
    @Column(name = "moddate")
    private LocalDateTime modDate;
}
