package ivan.makevic.IvanMakevic2022204484;

import ivan.makevic.IvanMakevic2022204484.DTO.BirthdayDTO;
import ivan.makevic.IvanMakevic2022204484.DTO.GiftDTO;
import ivan.makevic.IvanMakevic2022204484.Entities.BirthdayEntity;
import ivan.makevic.IvanMakevic2022204484.Entities.GiftEntity;
import ivan.makevic.IvanMakevic2022204484.Repos.BirthdayRepo;
import ivan.makevic.IvanMakevic2022204484.Repos.GiftRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class Kontroller {
    @Autowired
    private BirthdayRepo birthdayRepo;

    @Autowired
    private GiftRepo giftRepo;

    @GetMapping("/getBirthdays")
    public ResponseEntity<List<BirthdayEntity>> getBirthdays() {
        return ResponseEntity.ok(birthdayRepo.findAll());
    }

    @GetMapping("/getSpecificBirthday/{birthdayId}")
    public Optional<BirthdayEntity> getSpecificThread(@PathVariable Long birthdayId) {
        return birthdayRepo.findById(birthdayId);
    }

    @PostMapping("/createBirthday")
    public ResponseEntity<BirthdayEntity> createBirthday(@RequestBody BirthdayDTO request) {
        BirthdayEntity newBrithday = birthdayRepo.save(new BirthdayEntity(request.bdayFor, request.bdayAt));
        return ResponseEntity.ok(newBrithday);
    }

    @PostMapping("/createGift")
    public ResponseEntity<GiftEntity> createGift(@RequestBody GiftDTO request) throws Exception {
        BirthdayEntity forBday = birthdayRepo.findById(request.birthdayId)
                .orElseThrow(() -> new Exception("Thread not found with id " + request.birthdayId));
        GiftEntity newGift = giftRepo.save(new GiftEntity(request.giftText, request.giftPrice, forBday));
        return ResponseEntity.ok(newGift);
    }
}
