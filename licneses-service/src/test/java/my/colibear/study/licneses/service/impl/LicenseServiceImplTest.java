package my.colibear.study.licneses.service.impl;

import lombok.extern.slf4j.Slf4j;
import my.colibear.study.licneses.config.ServiceConfig;
import my.colibear.study.licneses.model.entity.License;
import my.colibear.study.licneses.model.repository.LicenseRepository;
import my.colibear.study.licneses.service.LicenseService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(MockitoExtension.class)
class LicenseServiceImplTest {

    @Mock
    LicenseRepository licenseRepository;

    @Mock
    ServiceConfig serviceConfig;

    @Test
    void getLicense() {
        final String licenseType = "seat";
        final String productName = "Teleco";
        final String organizationId = UUID.randomUUID().toString();
        final String exampleProperty = "My Config";
        License license = License.builder()
            .licenseType(licenseType)
            .productName(productName)
            .organizationId(organizationId)
            .build();

        license.generateLicenseId();
        log.info("License       : " + license);

        when(licenseRepository.findByOrganizationIdAndLicenseId(organizationId, license.getLicenseId())).thenReturn(Optional.of(license));
        when(serviceConfig.getExampleProperty()).thenReturn(exampleProperty);
        LicenseService licenseService = new LicenseServiceImpl(licenseRepository, serviceConfig);
        License foundLicense = licenseService.getLicense(organizationId, license.getLicenseId());
        log.info("Found License : " + foundLicense);
        assertEquals(foundLicense.getLicenseId(), license.getLicenseId());
        assertThat(foundLicense).isEqualTo(license);
    }

    @Test
    void getLicensesByOrganizationId() {
    }

    @Test
    void saveLicense() {
    }
}