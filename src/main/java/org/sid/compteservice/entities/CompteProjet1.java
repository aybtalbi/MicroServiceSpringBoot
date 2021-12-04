package org.sid.compteservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1" , types = Compte.class )//pour faire la projection juste pour quelque valeur localhost:8082/comptes/1?projection=p1
public interface CompteProjet1 {
    public Long getCode();
    public double getSolde();
}
