package com.letscode.hogwartsstudentregister.dto.clients;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class HouseSelectorKey {

    @JsonProperty("sorting-hat-choice")
    private UUID key;
}
