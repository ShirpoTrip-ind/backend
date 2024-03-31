import com.bestind.ShirpoTripAPI.model.Threshold;
import com.bestind.ShirpoTripAPI.repository.ThresholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThresholdService {

    @Autowired
    private ThresholdRepository thresholdRepository;

    public String setThreshold(int value) {
        Threshold threshold = new Threshold();
        threshold.setValue(value);
        thresholdRepository.save(threshold);
        return "Threshold value set successfully";
    }

    public int getThresholdValue() {
        List<Threshold> thresholds = thresholdRepository.findAll();
        if (thresholds.isEmpty()) {
            return 0;
        } else {
            return thresholds.get(0).getValue();
        }
    }
}
