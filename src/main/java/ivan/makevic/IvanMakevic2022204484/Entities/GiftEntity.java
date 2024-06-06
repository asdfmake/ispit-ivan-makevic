package ivan.makevic.IvanMakevic2022204484.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Gifts")
@Getter
@Setter
public class GiftEntity {
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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "birthday_id", nullable = false)
    private BirthdayEntity birthday;

    public GiftEntity(Long giftId, String giftText, float giftPrice, LocalDateTime createdAt, BirthdayEntity birthday) {
        this.giftId = giftId;
        this.giftText = giftText;
        this.giftPrice = giftPrice;
        this.createdAt = createdAt;
        this.birthday = birthday;
    }

    public GiftEntity(String giftText, float giftPrice, BirthdayEntity bday) {
        this.giftText = giftText;
        this.giftPrice = giftPrice;
        this.createdAt = LocalDateTime.now();
        this.birthday = bday;
    }

    public GiftEntity() {
    }
}
