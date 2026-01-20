package kg.lalafo.lalafo_service.controller;

import kg.lalafo.lalafo_service.dto.AdDto;
import kg.lalafo.lalafo_service.service.LalafoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdController {

    private final LalafoService lalafoService;

    public AdController(LalafoService lalafoService) {
        this.lalafoService = lalafoService;
    }

    @GetMapping("/test-result")
    public List<AdDto> getTestResult() {
        return lalafoService.getAds();
    }
}
