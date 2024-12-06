package com.mootiv.shared;

import com.mootiv.domain.Affection;
import com.mootiv.domain.Condition;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter @Setter
public class ConditionResponse {

    private Integer id;
    private AffectionResponse affection;
    private LocalDate diagnosisDate;
    private String severity;
    private String currentStatus;
    private String notes;

    public static ConditionResponse mapFrom(Condition condition) {
        return ConditionResponse.builder()
                .id(condition.getId())
                .affection(AffectionResponse.mapFrom(condition.getAffection()))
                .diagnosisDate(condition.getDiagnosisDate())
                .severity(condition.getSeverity().name())
                .currentStatus(condition.getCurrentStatus().name())
                .notes(condition.getNotes())
                .build();
    }

}
