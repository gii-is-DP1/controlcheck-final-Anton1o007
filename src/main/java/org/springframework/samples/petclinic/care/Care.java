package org.springframework.samples.petclinic.care;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Care extends BaseEntity{
    @NotEmpty
    @Column(unique=true)
    @Size(min = 5, max = 30)
    String name;
    @NotEmpty
    String description;
    @ManyToMany(cascade = CascadeType.ALL)
    @NotEmpty
    @Size(min = 1)
    @JoinColumn(name = "compatible_pet_types")
    Set<PetType> compatiblePetTypes;
}
