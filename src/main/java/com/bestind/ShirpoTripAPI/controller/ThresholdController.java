import com.bestind.ShirpoTripAPI.service.ThresholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/threshold")
public class ThresholdController {

    @Autowired
    private ThresholdService thresholdService;

    @PutMapping("/{value}")
    public String setThreshold(@PathVariable int value) {
        return thresholdService.setThreshold(value);
    }

    @GetMapping
    public int getThresholdValue() {
        return thresholdService.getThresholdValue();
    }
}
