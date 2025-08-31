package com.kh.app08_01.board;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager em;

    public void insert(BoardEntity entity) {
        em.persist(entity);
    }

    public BoardEntity findBoardByNo(Long no) {
        return em.find(BoardEntity.class, no);
    }

    public List<BoardEntity> findBoardAll() {
        String jpql = "select b from BoardEntity b where b.delYn = 'N'";
        return em.createQuery(jpql , BoardEntity.class)
                .getResultList();
    }
}
