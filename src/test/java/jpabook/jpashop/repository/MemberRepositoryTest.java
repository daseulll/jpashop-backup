package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
@Rollback(false)
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    void testMemberSave() throws Exception {
        Member member = new Member();
        member.setUsername("newName");
        Long savedId = memberRepository.save(member);

        Member foundMember = memberRepository.find(savedId);

        Assertions.assertThat(member.getId()).isEqualTo(foundMember.getId());
        Assertions.assertThat(foundMember.getUsername()).isEqualTo("newName");
        Assertions.assertThat(foundMember).isEqualTo(member);


    }


}