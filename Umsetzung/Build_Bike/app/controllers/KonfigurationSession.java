package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.KonfigurationKomponente.DTO.KonfigurationDTO;
import models.KonfigurationKomponente.IKofigurationKomponente;
import models.KonfigurationKomponente.IKonfiguration;
import models.KonfigurationKomponente.Konfiguration;
import models.KonfigurationKomponente.KonfigurationKomponente;
import play.libs.Json;
import play.mvc.Controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by dima on 13.06.15.
 */
public class KonfigurationSession extends Controller {

    // Session Konstante fuer temp Konfiguration
    private static final String KONFIGURATION = "TMP_KONFIGURATION";
    private static Map<String,String> mokupSession = new HashMap();

    public static void setKonfigurationInSession(KonfigurationDTO dto){

        JsonNode dto_Json = Json.toJson(dto);
        System.err.println("speichere in Session: "+dto.getStep_10());
        mokupSession.put(KONFIGURATION,dto_Json.toString());
//        session(KONFIGURATION,dto_Json.toString());
    }

    public static KonfigurationDTO getKonfigurationFromSession(){

//        if(!session().containsKey(KONFIGURATION)) return null;
        if(!mokupSession.containsKey(KONFIGURATION)) return null;

//        String dto_Json_String = session(KONFIGURATION);
        String dto_Json_String = mokupSession.get(KONFIGURATION);

        JsonNode dto_Json = Json.parse(dto_Json_String);
        KonfigurationDTO dto = Json.fromJson(dto_Json, KonfigurationDTO.class);
        System.out.println("lade aus Session: "+dto.getStep_10());

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
