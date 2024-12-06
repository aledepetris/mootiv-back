package com.mootiv.domain.persona;

import com.mootiv.domain.Condition;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Embeddable
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ClinicalHistory {

    @OneToMany
    @JoinColumn(name = "student_id")
    private Set<Condition> medicalHistory;

}
