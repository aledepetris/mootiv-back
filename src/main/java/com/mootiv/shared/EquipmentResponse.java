package com.mootiv.shared;

import com.mootiv.domain.Equipment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class EquipmentResponse {

    private Integer id;

    private String name;

    private String description;

    private String alt_img;

    public static EquipmentResponse mapFrom(Equipment equipment) {
        return new EquipmentResponse(equipment.getId(), equipment.getName(), equipment.getDescription(), equipment.getAlt_img());
    }

}
