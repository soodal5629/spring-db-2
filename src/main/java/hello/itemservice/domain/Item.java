package hello.itemservice.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity // JPA가 사용하는 객체
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 스프링부트와 통합해서 사용하면 필드 이름을 테이블 컬럼 명으로 변경 시
    // 카멜 케이스를 언더스코어로 자동으로 변환하기 떄문에 사실 아래의 어노테이션 생략 가능함
    @Column(name = "item_name", length = 10)
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
