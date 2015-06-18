package models.WarenkorbKomponente;

import models.KonfigurationKomponente.IKonfiguration;
import models.WarenkorbKomponente.DTO.WarenkorbDTO;
import models.WarenkorbKomponente.DTO.WarenkorbSessionDTO;

import java.util.List;

/**
 * Created by dima on 18.06.15.
 */
public interface IWarenkorb {

    public List<IKonfiguration> getKonfigurationen();

    public void addKonfiguration(IKonfiguration konfiguration);

    public boolean removeKonfiguration(long konfigurationID);

    public int getGesamtpreis();

    public WarenkorbSessionDTO toSessionDTO();

    public WarenkorbDTO toDTO();
}
