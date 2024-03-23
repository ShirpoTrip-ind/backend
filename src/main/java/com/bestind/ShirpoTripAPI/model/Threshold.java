package com.bestind.ShirpoTripAPI.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "threshold")
@Data
public class Threshold {
    private int value;
}
