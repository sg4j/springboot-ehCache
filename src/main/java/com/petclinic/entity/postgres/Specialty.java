package com.petclinic.entity.postgres;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.petclinic.entity.NamedEntity;

@Entity
@Table(name = "specialties")
@Cacheable(value=true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Specialty extends NamedEntity {

}
