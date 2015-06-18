package models.WarenkorbKomponente;

import models.KonfigurationKomponente.DTO.KonfigurationDTO;
import models.KonfigurationKomponente.IKofigurationKomponente;
import models.KonfigurationKomponente.IKonfiguration;
import models.KonfigurationKomponente.KonfigurationKomponente;
import models.WarenkorbKomponente.DTO.WarenkorbSessionDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 18.06.15.
 */
public class WarenkorbKomponente implements IWarenkorbKomponente {




    @Override
    public IWarenkorb createEmptyWarenkorb() {
        return (IWarenkorb) new Warenkorb();
    }

    @Override
    public IWarenkorb fromSessionDTO(WarenkorbSessionDTO sessionDTO) {

        if(sessionDTO == null || sessionDTO.getKonfigurationen() == null) return (IWarenkorb) new Warenkorb();
        IKofigurationKomponente  konfigurationKomponente = new KonfigurationKomponente();
        List<IKonfiguration> konfigurationList = new ArrayList();

        for(KonfigurationDTO dto : sessionDTO.getKonfigurationen()){

            konfigurationList.add(konfigurationKomponente.fromKonfigurtionDTO(dto));
        }

        IWarenkorb warenkorb = new Warenkorb(konfigurationList);
        return warenkorb;
    }
}
