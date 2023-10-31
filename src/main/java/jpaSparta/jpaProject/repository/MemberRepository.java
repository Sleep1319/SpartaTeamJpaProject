package jpaSparta.jpaProject.repository;


import jpaSparta.jpaProject.domain.Address;
import jpaSparta.jpaProject.domain.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("SELECT m FROM Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("SELECT m FROM Member m WHERE m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

    //로그인
    public Member tryLogin(String user_id, String pw) {
        Member member = new Member();
        try {
            member = em.createQuery("SELECT m FROM Member m WHERE m.user_id = :user_id AND m.pw = :pw", Member.class)
                    .setParameter("user_id", user_id)
                    .setParameter("pw", pw)
                    .getSingleResult();
            return member;
        } catch (NoResultException e) {
            return member;
        }
    }

    //회원정보 수정
    public void updateUserInfo(Member member) {
        Member updateUser = em.find(Member.class, member.getId());
            updateUser.setPhone(member.getPhone());
            updateUser.setAddress(member.getAddress());
        em.merge(updateUser);

    }
//    public int updateUserInfo(Long id, String phone, Address address) {
//        return em.createQuery("UPDATE Member m SET m.phone = :phone, m.address.addr = :addr, m.address.detail_addr = :detail_addr, m.address.zipcode = :zipcode" +
//                        " WHERE m.id = :id")
//                .setParameter("phone", phone).setParameter("addr", address.getAddr()).setParameter("detail_addr", address.getDetail_addr())
//                .setParameter("zipcode", address.getZipcode()).setParameter("id", id)
//                .executeUpdate();
//    }

//    // 페이징 관련
//    public List<Member> getBoardList(int first, int max) {
//        int start = (first - 1) * max;
//
//        if(first < 0) {
//            first = 0;
//        }
//
//        System.out.println("first =" + first + ", max =" + max);
//
//        return em.createQuery("select m from Member m ORDER BY m.id DESC", Member.class)
//                .setFirstResult(start)
//                .setMaxResults(max)
//                .getResultList();
//    }
//
//
//    public int getRowCount() {
//        return em.createQuery("SELECT count(m.id) FROM Member m", Long.class)
//                .getFirstResult();
//    }
}
