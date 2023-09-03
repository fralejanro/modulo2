package com.sophossolutions.modulo2.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Band {
    private Integer id;
    private String name;
    private String genre;
    private String countryOfOrigin;
    private Integer yearOfCreation;
    private Boolean status;
}
