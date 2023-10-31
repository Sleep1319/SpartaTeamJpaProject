package jpaSparta.jpaProject.repository;

import jpaSparta.jpaProject.domain.Address;
import jpaSparta.jpaProject.domain.Notice.Notice;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer>{



    Page<Notice> findAll(Pageable pageable);

}
