package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    /*optional은 null 그대로 반환하는대신 optional로 감싸서 반환함*/
    /*findById 혹은 findByName 으로 찾기 가능*/
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    /*지금까지 찾은 모든 회원 리스트들 반환*/
    List<Member> findAll();
}
