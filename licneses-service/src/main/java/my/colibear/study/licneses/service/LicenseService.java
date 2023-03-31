package my.colibear.study.licneses.service;

import my.colibear.study.licneses.model.entity.License;

import java.util.List;

public interface LicenseService {
    License getLicense(String organizationId, String licenseId);
    List<License> getLicensesByOrganizationId(String organizationId);
    void saveLicense(final String organizationId, final String productName, final String licenseType);
}
