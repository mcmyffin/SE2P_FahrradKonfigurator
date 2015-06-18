package models.WarenkorbKomponente;

import models.WarenkorbKomponente.DTO.WarenkorbSessionDTO;

/**
 * Created by dima on 18.06.15.
 */
public interface IWarenkorbKomponente {

    public IWarenkorb createEmptyWarenkorb();

    public IWarenkorb fromSessionDTO(WarenkorbSessionDTO sessionDTO);

}
