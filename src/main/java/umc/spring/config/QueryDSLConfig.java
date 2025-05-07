package umc.spring.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class QueryDSLConfig {
    private final EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory(){
        return new JPAQueryFactory(entityManager);
    }
}


//	@Configuration : 이 클래스가 설정 클래스임을 의미
//	EntityManager : JPA의 핵심 객체로, 영속성 컨텍스트를 관리
//	JPAQueryFactory : QueryDSL의 쿼리를 생성할 때 사용하는 핵심 객체? 이걸 빈으로 등록해야 다른 곳에서 DI로 주입해서 사용할 수 있음