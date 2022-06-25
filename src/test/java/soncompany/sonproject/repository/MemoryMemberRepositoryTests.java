package soncompany.sonproject.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import soncompany.sonproject.domain.Member;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class MemoryMemberRepositoryTests {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        System.out.println("save");
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        System.out.println("finByName");
        Member member1 = new Member();
        member1.setName("s1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("s2");
        repository.save(member2);

        repository.findByName("s1");

        Member result = repository.findByName("s1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        System.out.println("findAll");
        Member member1 = new Member();
        member1.setName("s1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("s2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
