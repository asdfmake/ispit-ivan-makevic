package ivan.makevic.IvanMakevic2022204484.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Gifts")
@Getter
@Setter
public class Gift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gift_id")
    private Long giftId;

    @Column(name = "gift_text")
    private String giftText;

    @Column(name = "gift_price")
    private float giftPrice;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
