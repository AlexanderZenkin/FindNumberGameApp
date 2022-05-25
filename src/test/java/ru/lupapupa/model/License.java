package ru.lupapupa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({
        License.JSON_PROPERTY_ID,
        License.JSON_PROPERTY_DESCRIPTION,
        License.JSON_PROPERTY_LICENSE_ID,
        License.JSON_PROPERTY_PRODUCT_NAME,
        License.JSON_PROPERTY_ORGANIZATION_ID,
        License.JSON_PROPERTY_LICENSE_TYPE,
})

@JsonIgnoreProperties(ignoreUnknown = true)
public class License {
    public static final String JSON_PROPERTY_ID = "id";
    private int id;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_LICENSE_ID = "licenseId";
    private String licenseId;

    public static final String JSON_PROPERTY_PRODUCT_NAME = "productName";
    private String productName;

    public static final String JSON_PROPERTY_ORGANIZATION_ID = "organizationId";
    private String organizationId;

    public static final String JSON_PROPERTY_LICENSE_TYPE = "licenseType";
    private String licenseType;

    public License id(int id) {

        this.id = id;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public License description(String description) {

        this.description = description;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public License licenseId(String licenseId) {

        this.licenseId = licenseId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LICENSE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public License productName(String productName) {

        this.productName = productName;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PRODUCT_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public License organizationId(String organizationId) {

        this.organizationId = organizationId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ORGANIZATION_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public License licenseType(String licenseType) {

        this.licenseType = licenseType;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LICENSE_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }
}

