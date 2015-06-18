package models.WarenkorbKomponente;

import models.KonfigurationKomponente.DTO.KonfigurationDTO;
import models.KonfigurationKomponente.IKonfiguration;
import models.WarenkorbKomponente.DTO.WarenkorbDTO;
import models.WarenkorbKomponente.DTO.WarenkorbSessionDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 18.06.15.
 */
public class Warenkorb implements IWarenkorb {

    List<IKonfiguration> konfigurationList;

    
    Warenkorb(){
        konfigurationList = new ArrayList();
    }

    Warenkorb(List<IKonfiguration> konfigurationList){
        if(konfigurationList == null) new Warenkorb();
        this.konfigurationList = konfigurationList;
    }

    @Override
    public List<IKonfiguration> getKonfigurationen() {
        return konfigurationList;
    }

    @Override
    public void addKonfiguration(IKonfiguration konfiguration) {
        konfigurationList.add(konfiguration);
    }

    @Override
    public boolean removeKonfiguration(long konfigurationID) {

        IKonfiguration zuLoeschendeKonfiguration = null;
        for(IKonfiguration eineKonfiguration : konfigurationList){

            if(eineKonfiguration.getKonfigurationsID() == konfigurationID){
                zuLoeschendeKonfiguration = eineKonfiguration;
                break;
            }
        }

        if(zuLoeschendeKonfiguration != null){
            return konfigurationList.remove(zuLoeschendeKonfiguration);
        }
        return false;
    }

    @Override
    public int getGesamtpreis() {

        int preis = 0;

        for(IKonfiguration eineKonfiguration : konfigurationList){
            preis += eineKonfiguration.getKonfigurationsPreis();
        }

        return preis;
    }

    @Override
    public WarenkorbSessionDTO toSessionDTO() {

        List<KonfigurationDTO> konfDTOList = new ArrayList(this.konfigurationList.size());
        for(IKonfiguration eineKonfi : konfigurationList){

            konfDTOList.add(eineKonfi.asDTO());
        }

        WarenkorbSessionDTO sessionDTO = new WarenkorbSessionDTO(konfDTOList);
        return sessionDTO;
    }

    @Override
    public WarenkorbDTO toDTO() {

        WarenkorbDTO warenkorbDTO = new WarenkorbDTO(konfigurationList,getGesamtpreis());
        return warenkorbDTO;
    }
}
