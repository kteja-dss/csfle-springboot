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
        "    \"cardNumber\": {\n" + //
        "      \"default\": \"\",\n" + //
        "      \"type\": \"string\"\n" + //
        "    },\n" + //
        "    \"cardPin\": {\n" + //
        "      \"confluent:tags\": [\n" + //
        "        \"PII\"\n" + //
        "      ],\n" + //
        "      \"default\": \"\",\n" + //
        "      \"type\": \"string\"\n" + //
        "    }\n" + //
        "  },\n" + //
        "  \"title\": \"CreditCardInfo\",\n" + //
        "  \"type\": \"object\"\n" + //
        "}", refs = {})
public class CreditCardInfo {
    private String cardNumber;
    private String cardPin;

}