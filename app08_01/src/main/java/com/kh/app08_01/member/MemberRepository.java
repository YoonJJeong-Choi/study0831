package com.kh.app08_01.member;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void join(MemberEntity entity) {
        em.persist(entity);
    }

    public MemberEntity login(MemberDto dto) {
        String jpql = "select m from MemberEntity m where m.userId = :x and m.userPwd = :y";
        return em
                .createQuery(jpql, MemberEntity.class)
                .setParameter("x", dto.getUserId())
                .setParameter("y", dto.getUserPwd())
                .getSingleResult();
    }

    public MemberEntity findByNo(Long writerNo) {
        return em.find(MemberEntity.class, writerNo);
    }
}
