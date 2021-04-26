package org.example.quarkus;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Concrete")
public class ConcreteEntity extends AbstractEntity {

    public ConcreteEntity() {
        super();
    }

}