package models.WarenkorbKomponente.DTO;

import models.KonfigurationKomponente.DTO.KonfigurationDTO;
import models.KonfigurationKomponente.IKonfiguration;

import java.util.List;

/**
 * Created by dima on 18.06.15.
 */
public class WarenkorbDTO {

    private List<IKonfiguration> konfigurationList;
    private int gesamtpreis;


    public WarenkorbDTO(List<IKonfiguration> konfigurationList, int gesamtpreis){
        this.konfigurationList = konfigurationList;
        this.gesamtpreis = gesamtpreis;
    }

    public List<IKonfiguration> getKonfigurationList() {
        return konfigurationList;
    }

    public int getGesamtpreis() {
        return gesamtpreis;
    }
}
