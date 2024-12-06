package com.mootiv.domain.persona;

import com.mootiv.domain.Condition;
import com.mootiv.error.exception.NotFoundException;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import static com.mootiv.error.ApiMootivErrors.CONDITION_NOT_FOUND;
import static java.util.Objects.isNull;

@Embeddable
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ClinicalHistory {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Set<Condition> conditions;

    public void addCondition(Condition condition) {
        if (isNull(this.conditions)) {
            this.conditions = new HashSet<>();
        }
        this.conditions.add(condition);
    }

    public void removeCondition(Integer idCondition) {
        if (!this.conditions.removeIf(condition -> condition.getId().equals(idCondition))) {
            throw new NotFoundException(CONDITION_NOT_FOUND);
        }
    }
}
