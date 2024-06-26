package jpabook.jpashop.repository;

import jakarta.transaction.Transactional;
import jpabook.jpashop.domain.Member;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember() {
        Member member = new Member();
        member.setUsername("memberA");
        // Long saveId = memberRepository.save(member);
//        Member findMember = memberRepository.find(saveId);
//        Assertions.assertEquals(member.getUsername(), findMember.getUsername());
//        assertEquals(member.getId(), findMember.getId());
//        assertEquals(member, findMember);
    }
}
