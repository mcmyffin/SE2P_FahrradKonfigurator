package models.WarenkorbKomponente.DTO;

import models.KonfigurationKomponente.DTO.KonfigurationDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 18.06.15.
 */
public class WarenkorbSessionDTO {

    private List<KonfigurationDTO> konfigurationen;

    public WarenkorbSessionDTO(){}

    public WarenkorbSessionDTO(List<KonfigurationDTO> konfigurationen){
        this.konfigurationen = konfigurationen;
    }

    // GETTER
    public List<KonfigurationDTO> getKonfigurationen() {
        return konfigurationen;
    }

    // SETTER
    public void setKonfigurationen(List<KonfigurationDTO> konfigurationen) {
        this.konfigurationen = konfigurationen;
    }
}
