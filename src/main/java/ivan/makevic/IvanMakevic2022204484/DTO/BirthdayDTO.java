package ivan.makevic.IvanMakevic2022204484.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


public class BirthdayDTO {
    public String bdayFor;
    public LocalDateTime bdayAt;

    public BirthdayDTO(String bdayFor, LocalDateTime bdayAt) {
        this.bdayFor = bdayFor;
        this.bdayAt = bdayAt;
    }
}
