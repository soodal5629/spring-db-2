package hello.itemservice;

import hello.itemservice.config.*;
import hello.itemservice.repository.ItemRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Import(JdbcTemplateV2Config.class)
//@Import(JdbcTemplateV1Config.class)
//@Import(MemoryConfig.class) // 앞서 설정한 MemoryConfig 를 설정 파일로 사용
@SpringBootApplication(scanBasePackages = "hello.itemservice.web") // 해당 범위만 컴포넌트 스캔함
public class ItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

	@Bean // 빈 등록해줘야 TestDataInit 이 발생함
	@Profile("local") // 특정 프로필의 경우에만 해당 스프링 빈을 등록
	public TestDataInit testDataInit(ItemRepository itemRepository) {
		return new TestDataInit(itemRepository);
	}

}
