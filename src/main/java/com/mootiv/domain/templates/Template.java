package com.mootiv.domain.templates;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
abstract class Template {

    protected String name;
    protected String description;
    protected LocalDate creationDate;

}
