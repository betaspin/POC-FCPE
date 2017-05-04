package fr.imie.fcpe;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Stateless(name = "EtablissementEJB")
public class EtablissementServices {

    @PersistenceContext
    EntityManager em;

    public EtablissementServices() {
    }

    public List<EtablissementBO> findAll(){
//        @SuppressWarnings("unchecked")
//        EtablissementEntity etab = (EtablissementEntity) em.createNativeQuery("SELECT id FROM etablissement WHERE id = 1").getSingleResult();

//        em.createNativeQuery("INSERT INTO etablissement (id) VALUES (5)").executeUpdate();

        @SuppressWarnings("unchecked")
        List<EtablissementEntity> data1 = em.createNamedQuery("EtablissementEntity.findAll").getResultList();
        System.out.println("data1: " + data1.size());

        //@SuppressWarnings("unchecked")
        List<EtablissementEntity> data2 = em.createNativeQuery("SELECT etablissement.id FROM etablissement").getResultList();

        System.out.println("data2: " + data2.size());

        List<EtablissementBO> etablissementsBO = new ArrayList<>();

        for(EtablissementEntity etablissementEntity: data1){
            etablissementsBO.add(EtablissementBO.mapEtablissementEntityToBO(etablissementEntity));
        }

        return etablissementsBO;
    }
}
