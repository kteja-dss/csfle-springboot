package com.confluent.jsondto;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.confluent.kafka.schemaregistry.annotations.Schema;
import io.confluent.kafka.schemaregistry.annotations.SchemaReference;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // Include fields only if they are not null
@Schema(value = "{\n" + //
        "  \"$schema\": \"http://json-schema.org/draft-07/schema#\",\n" + //
        "  \"additionalProperties\": false,\n" + //
        "  \"properties\": {\n" + //
        "    \"address\": {\n" + //
        "      \"additionalProperties\": false,\n" + //
        "      \"properties\": {\n" + //
        "        \"city\": {\n" + //
        "          \"default\": \"\",\n" + //
        "          \"type\": \"string\"\n" + //
        "        },\n" + //
        "        \"geoLocation\": {\n" + //
        "          \"additionalProperties\": false,\n" + //
        "          \"properties\": {\n" + //
        "            \"latitude\": {\n" + //
        "              \"confluent:tags\": [\n" + //
        "                \"PII\"\n" + //
        "              ],\n" + //
        "              \"default\": \"\",\n" + //
        "              \"type\": \"string\"\n" + //
        "            },\n" + //
        "            \"longitude\": {\n" + //
        "              \"confluent:tags\": [\n" + //
        "                \"PII\"\n" + //
        "              ],\n" + //
        "              \"default\": \"\",\n" + //
        "              \"type\": \"string\"\n" + //
        "            }\n" + //
        "          },\n" + //
        "          \"type\": \"object\"\n" + //
        "        },\n" + //
        "        \"postalCode\": {\n" + //
        "          \"confluent:tags\": [\n" + //
        "            \"PII\"\n" + //
        "          ],\n" + //
        "          \"default\": \"\",\n" + //
        "          \"type\": \"string\"\n" + //
        "        },\n" + //
        "        \"state\": {\n" + //
        "          \"default\": \"\",\n" + //
        "          \"type\": \"string\"\n" + //
        "        },\n" + //
        "        \"street\": {\n" + //
        "          \"default\": \"\",\n" + //
        "          \"type\": \"string\"\n" + //
        "        }\n" + //
        "      },\n" + //
        "      \"type\": \"object\"\n" + //
        "    },\n" + //
        "    \"emailId\": {\n" + //
        "      \"confluent:tags\": [\n" + //
        "        \"PII\"\n" + //
        "      ],\n" + //
        "      \"default\": \"\",\n" + //
        "      \"type\": \"string\"\n" + //
        "    },\n" + //
        "    \"firstName\": {\n" + //
        "      \"type\": \"string\"\n" + //
        "    },\n" + //
        "    \"id\": {\n" + //
        "      \"type\": \"string\"\n" + //
        "    },\n" + //
        "    \"lastName\": {\n" + //
        "      \"default\": \"\",\n" + //
        "      \"type\": \"string\"\n" + //
        "    },\n" + //
        "    \"middleName\": {\n" + //
        "      \"default\": \"\",\n" + //
        "      \"type\": \"string\"\n" + //
        "    },\n" + //
        "    \"paymentDetails\": {\n" + //
        "      \"anyOf\": [\n" + //
        "        {\n" + //
        "          \"$ref\": \"CreditCardInfo\"\n" + //
        "        },\n" + //
        "        {\n" + //
        "          \"$ref\": \"BankingInfo\"\n" + //
        "        },\n" + //
        "        {\n" + //
        "          \"type\": \"null\"\n" + //
        "        }\n" + //
        "      ]\n" + //
        "    }\n" + //
        "  },\n" + //
        "  \"title\": \"Employee\",\n" + //
        "  \"type\": \"object\"\n" + //
        "}", refs = { @SchemaReference(name = "CreditCardInfo", subject = "CreditCardInfoJson"),
                @SchemaReference(name = "BankingInfo", subject = "BankingInfoJson")
        })
public class Employee {
    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String emailId;
    private Address address;
    private PaymentDetails paymentDetails;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    // Inner classes for Address and PaymentDetails
    public static class Address {
        private String street;
        private String city;
        private String state;
        private GeoLocation geoLocation;
        private String postalCode;

        // Getters and Setters
        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public GeoLocation getGeoLocation() {
            return geoLocation;
        }

        public void setGeoLocation(GeoLocation geoLocation) {
            this.geoLocation = geoLocation;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        // Inner class for GeoLocation
        public static class GeoLocation {
            private String latitude;
            private String longitude;

            // Getters and Setters
            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }
        }
    }

    public static class PaymentDetails {
        private CreditCardInfo creditCardInfo;
        private BankingInfo bankingInfo;

        // Getters and Setters
        public CreditCardInfo getCreditCardInfo() {
            return creditCardInfo;
        }

        public void setCreditCardInfo(CreditCardInfo creditCardInfo) {
            this.creditCardInfo = creditCardInfo;
        }

        public BankingInfo getBankingInfo() {
            return bankingInfo;
        }

        public void setBankingInfo(BankingInfo bankingInfo) {
            this.bankingInfo = bankingInfo;
        }
    }
}