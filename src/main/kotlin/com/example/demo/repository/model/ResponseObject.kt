package com.example.demo.repository.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class ResponseObject(
        private val status: String?,
        private val message: String?,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        private val data: Any?
)