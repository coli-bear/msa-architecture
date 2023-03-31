package my.colibear.study.licneses.controller;

import my.colibear.study.licneses.controller.dto.LicneseRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/organizations/{organizationId}/licenses")
public class LicenseResource {
    @GetMapping("{licenseId}")
    public LicneseRecord getLicense(
        @PathVariable String organizationId,
        @PathVariable String licenseId
    ) {
        return new LicneseRecord(licenseId, organizationId, "Teleco", "Seat");
    }
}
