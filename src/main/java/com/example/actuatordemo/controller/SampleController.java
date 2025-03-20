import com.example.actuatordemo.service.ApiAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @Autowired
    private ApiAService apiAService;

    @GetMapping("/api/a/request")
    public String requestToApiB() {
        return apiAService.getDataFromApiB();
    }
}
