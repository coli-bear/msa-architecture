package my.colibear.study.licneses.model.repository;

import my.colibear.study.licneses.model.entity.License;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LicenseRepository extends JpaRepository<License, Long> {
    List<License> findByOrganizationId(String organizationId);
    Optional<License> findByOrganizationIdAndLicenseId(String organizationId, String licenseId);
}
