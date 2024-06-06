package ivan.makevic.IvanMakevic2022204484.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "Birthdays")
@Getter
@Setter
public class Birthday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "birthday_id")
    private Long birthDayId;

    @Column(name = "bday_for")
    private String bdayFor;

    @Column(name = "bday_at")
    private LocalDateTime bdayAt;


}
