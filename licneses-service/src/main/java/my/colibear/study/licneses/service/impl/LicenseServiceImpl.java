package my.colibear.study.licneses.service.impl;

import lombok.RequiredArgsConstructor;
import my.colibear.study.licneses.config.ServiceConfig;
import my.colibear.study.licneses.exception.NotFoundException;
import my.colibear.study.licneses.model.entity.License;
import my.colibear.study.licneses.model.repository.LicenseRepository;
import my.colibear.study.licneses.service.LicenseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LicenseServiceImpl implements LicenseService {
    private final LicenseRepository licenseRepository;
    private final ServiceConfig serviceConfig;
    @Override
    public License getLicense(String organizationId, String licenseId) {
        return this.licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId)
            .orElseThrow(() -> new NotFoundException("License Not found (organizationId : " + organizationId + ", licenseId : " + licenseId + ")"))
            .withComment(serviceConfig.getExampleProperty());
    }

    @Override
    public List<License> getLicensesByOrganizationId(String organizationId) {
        return this.licenseRepository.findByOrganizationId(organizationId);
    }

    @Override
    public void saveLicense(final String organizationId, final String productName, final String licenseType) {
        License license = License.builder()
            .organizationId(organizationId)
            .productName(productName)
            .licenseType(licenseType)
            .build();
        license.generateLicenseId();
        this.licenseRepository.save(license);
    }
}
