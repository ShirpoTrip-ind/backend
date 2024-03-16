package com.bestind.ShirpoTripAPI.model.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum RelaxType {
    @JsonProperty("active")
    Active,
    @JsonProperty("passive")
    Passive,
    @JsonProperty("any")
    Any
}