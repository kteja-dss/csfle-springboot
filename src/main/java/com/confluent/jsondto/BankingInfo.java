package com.confluent.jsondto;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.confluent.kafka.schemaregistry.annotations.Schema;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // Include fields only if they are not null
@Schema(value = "{\n" + //
        "  \"$schema\": \"http://json-schema.org/draft-07/schema#\",\n" + //
        "  \"additionalProperties\": false,\n" + //
        "  \"properties\": {\n" + //
        "    \"accountId\": {\n" + //
        "      \"default\": \"\",\n" + //
        "      \"type\": \"string\"\n" + //
        "    },\n" + //
        "    \"accountPassword\": {\n" + //
        "      \"confluent:tags\": [\n" + //
        "        \"PII\"\n" + //
        "      ],\n" + //
        "      \"default\": \"\",\n" + //
        "      \"type\": \"string\"\n" + //
        "    }\n" + //
        "  },\n" + //
        "  \"title\": \"BankingInfo\",\n" + //
        "  \"type\": \"object\"\n" + //
        "}", refs = {})
public class BankingInfo {
    private String accountId;
    private String accountPassword;
}
