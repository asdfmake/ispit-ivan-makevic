package ivan.makevic.IvanMakevic2022204484.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Birthdays")
@Getter
@Setter
public class BirthdayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "birthday_id")
    private Long birthDayId;

    @Column(name = "bday_for")
    private String bdayFor;

    @Column(name = "bday_at")
    private LocalDateTime bdayAt;

    @OneToMany(mappedBy = "gift", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GiftEntity> gifts;

    public BirthdayEntity(Long birthDayId, String bdayFor, LocalDateTime bdayAt, List<GiftEntity> gifts) {
        this.birthDayId = birthDayId;
        this.bdayFor = bdayFor;
        this.bdayAt = bdayAt;
        this.gifts = gifts;
    }
}
