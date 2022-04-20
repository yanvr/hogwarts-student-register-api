package com.letscode.hogwartsstudentregister.dto.clients;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class HouseInfo {

    private UUID id;
    private String name;
    private String animal;
    private String founder;
    private List<Value> values;
}
