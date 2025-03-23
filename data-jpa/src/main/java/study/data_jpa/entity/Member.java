package study.data_jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter //보통 setter를 사용하지는 않지만 테스트용으로 사용
public class Member {
    @Id @GeneratedValue
    private Long id;
    private String username;
}
