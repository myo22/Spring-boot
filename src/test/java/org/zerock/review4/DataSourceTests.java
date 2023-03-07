package org.zerock.review4;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
@Log4j2
public class DataSourceTests {

    @Autowired
    private DataSource dataSource; //이 DataSource는 application.properties에 설정된 DataSource관련 설정을 통해서 생성된 bean이다.

    @Test
    public void testConnection() throws SQLException {

        //이 구문이 종료할때 con.close()가 호출된다 자동으로 닫아주는것
        @Cleanup
        Connection con = dataSource.getConnection();

        log.info(con);

        //단정 메서드로 테스트 케이스의 수행 결과를 판별합니다. 아래꺼는 객체 con이 null이 아닌지 확인하는 것입니다.
        Assertions.assertNotNull(con);
    }
}
