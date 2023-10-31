package jpaSparta.jpaProject;

import jpaSparta.jpaProject.domain.Address;
import jpaSparta.jpaProject.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

/***
 * 빠르게 초기 값 세팅을 위한 DB이기 떄문에 yml create가 아니고 update일시 주석 처리 필요
 */
@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {

        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;

        public void dbInit1() {
            Member member = createMember("admin", "1234", "관리자", "01011112222",
                    "서울 양천구 가로공원로66길 23", "301호", "07917");
            em.persist(member);
        }

        private Member createMember(String user_id, String pw, String name, String phone, String addr, String detail_addr, String zipcode) {
            Member member = new Member();
            member.setUser_id(user_id);
            member.setPw(pw);
            member.setName(name);
            member.setPhone(phone);
            member.setAddress(new Address(addr, detail_addr, zipcode));
            return member;
        }
    }

}
