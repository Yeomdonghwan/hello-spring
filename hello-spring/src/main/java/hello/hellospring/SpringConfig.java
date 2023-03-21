package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

//    DataSource dataSource;
//    @Autowired
//    SpringConfig(DataSource dataSource){
//        this.dataSource = dataSource;
//    }
//    EntityManager em;
//    @Autowired
//    SpringConfig(EntityManager em){
//        this.em=em;
//    }

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository; //SpringDataJpa가 구현체를 만들어 등록해줌
    }

    @Bean
    public MemberService memberService(){

        return new MemberService(memberRepository);
    }
//
//    @Bean
//    public MemberRepository memberRepository(){
//        //return new JdbcTemplateMemberRepository(dataSource);
////        return new JpaMemberRepository(em);

//    }
//
//    @Bean //AOP를 빈으로 등록
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }
}
