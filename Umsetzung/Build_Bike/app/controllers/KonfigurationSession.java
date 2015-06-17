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

//     Session Konstante fuer temp Konfiguration
    private static final String KONFIGURATION = "TMP_KONFIGURATION";
//    private static Map<String,String> mokupSession = new HashMap();

    private static void setKonfiguration(KonfigurationDTO dto){

        JsonNode dto_Json = Json.toJson(dto);
//        mokupSession.put(KONFIGURATION,dto_Json.toString());
        session(KONFIGURATION,dto_Json.toString());
    }

    private static KonfigurationDTO getKonfiguration(){

        if(!session().containsKey(KONFIGURATION)) return null;
//        if(!mokupSession.containsKey(KONFIGURATION)) return null;

        String dto_Json_String = session(KONFIGURATION);
//        String dto_Json_String = mokupSession.get(KONFIGURATION);

        JsonNode dto_Json = Json.parse(dto_Json_String);
        KonfigurationDTO dto = Json.fromJson(dto_Json, KonfigurationDTO.class);

        return dto;
    }


    private static IKonfiguration fromDTO(KonfigurationDTO dto){

        IKofigurationKomponente kofigurationKomponente = new KonfigurationKomponente();
        IKonfiguration konfiguration = kofigurationKomponente.fromKonfigurtionDTO(dto);

        return konfiguration;
    }

    private static KonfigurationDTO toDTO(IKonfiguration konfiguration){

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


    public static IKonfiguration getKonfigurationFromSession(){

        KonfigurationDTO dto = getKonfiguration();
        IKonfiguration konfiguration = fromDTO(dto);
        return konfiguration;
    }

    public static void setKonfigurationToSession(IKonfiguration konfiguration){

        KonfigurationDTO dto = toDTO(konfiguration);
        setKonfiguration(dto);
    }


}
