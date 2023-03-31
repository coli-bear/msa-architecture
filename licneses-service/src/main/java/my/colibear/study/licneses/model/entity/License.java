package my.colibear.study.licneses.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "licenses",
    indexes = @Index(name = "idx_licenses_license_id", columnList = "license_id", unique = true)
)
@ToString
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "license_id", nullable = false)
    private String licenseId;

    @Column(name = "organization_id", nullable = false)
    private String organizationId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "license_type")
    private String licenseType;
    @Column(name = "comment")
    private String comment;

    @Builder
    public License(String organizationId, String productName, String licenseType) {
        this.organizationId = organizationId;
        this.productName = productName;
        this.licenseType = licenseType;
    }

    public void generateLicenseId() {
        this.licenseId = UUID.randomUUID().toString();
    }
    public License withComment(String comment) {
        this.comment = comment;
        return this;
    }
}
