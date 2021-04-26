package org.example.quarkus;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EntityRepository implements PanacheRepositoryBase<ConcreteEntity, String> {

}
