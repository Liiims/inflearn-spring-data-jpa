package study.datajpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import study.datajpa.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Page<Member> findByAge(int age, Pageable pageable);

    @Query(value = "select m from Member m left join m.team t",
            countQuery = "select count(m) from Member m")
    Page<Member> findWithTeam(Pageable pageable);

    @Modifying
    @Query("update Member m set m.age = m.age + 1 where m.age >= 20")
    int bulkAgePlus(int age);
}
