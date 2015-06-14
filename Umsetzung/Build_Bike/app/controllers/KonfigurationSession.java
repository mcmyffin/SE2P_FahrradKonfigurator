package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.KonfigurationKomponente.DTO.KonfigurationDTO;
import models.KonfigurationKomponente.IKofigurationKomponente;
import models.KonfigurationKomponente.IKonfiguration;
import models.KonfigurationKomponente.Konfiguration;
import models.KonfigurationKomponente.KonfigurationKomponente;
import play.libs.Json;
import play.mvc.Controller;

/**
 * Created by dima on 13.06.15.
 */
public class KonfigurationSession extends Controller {

    // Session Konstante fuer temp Konfiguration
    private static final String KONFIGURATION = "TMP_KONFIGURATION";


    public static void setKonfigurationInSession(KonfigurationDTO dto){

        JsonNode dto_Json = Json.toJson(dto);

        session(KONFIGURATION,dto_Json.toString());
    }

    public static KonfigurationDTO getKonfigurationFromSession(){

        if(!session().containsKey(KONFIGURATION)) return null;

        String dto_Json_String = session(KONFIGURATION);
        JsonNode dto_Json = Json.parse(dto_Json_String);

        KonfigurationDTO dto = Json.fromJson(dto_Json, KonfigurationDTO.class);

        return dto;
    }


    public IKonfiguration fromDTO(KonfigurationDTO dto){

        IKofigurationKomponente kofigurationKomponente = new KonfigurationKomponente();
        IKonfiguration konfiguration = kofigurationKomponente.fromKonfigurtionDTO(dto);

        return konfiguration;
    }

    public KonfigurationDTO toDTO(IKonfiguration konfiguration){

        if(konfiguration == null)
        {
            // leere Konfiguration
            IKonfiguration leereKonfiguration = new Konfiguration();
            return leereKonfiguration.asDTO();
        }
        else
        {
            return konfiguration.asDTO();
        }
    }

}
