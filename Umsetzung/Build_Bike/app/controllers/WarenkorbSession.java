package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.WarenkorbKomponente.DTO.WarenkorbDTO;
import models.WarenkorbKomponente.DTO.WarenkorbSessionDTO;
import models.WarenkorbKomponente.IWarenkorb;
import models.WarenkorbKomponente.IWarenkorbKomponente;
import models.WarenkorbKomponente.WarenkorbKomponente;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.warenkorb;

/**
 * Created by dima on 18.06.15.
 */
public class WarenkorbSession extends Controller{

    private static final String WARENKORB = "WARENKORB";

    private static WarenkorbSessionDTO getWarenkorb(){

        String jsonString = session(WARENKORB);
        if(jsonString == null) return new WarenkorbSessionDTO(null);

        JsonNode dto_Json = Json.parse(jsonString);
        WarenkorbSessionDTO dto = Json.fromJson(dto_Json,WarenkorbSessionDTO.class);

        return dto;
    }

    private static void setWarenkorb(WarenkorbSessionDTO dto){

        if(dto == null){
            dto = new WarenkorbSessionDTO(null);
        }

        JsonNode dto_Json = Json.toJson(dto);
        session(WARENKORB,dto_Json.toString());
    }

    private static WarenkorbSessionDTO toWarenkorbSessionDTO(IWarenkorb warenkorb){

        if(warenkorb == null){
            IWarenkorbKomponente warenkorbKomponente = new WarenkorbKomponente();
            warenkorb = warenkorbKomponente.createEmptyWarenkorb();
        }

        return warenkorb.toSessionDTO();
    }

    private static IWarenkorb fromWarenkorbSessionDTO(WarenkorbSessionDTO dto){

        IWarenkorbKomponente warenkorbKomponente = new WarenkorbKomponente();

        if(dto == null) return warenkorbKomponente.createEmptyWarenkorb();
        IWarenkorb warenkorb = warenkorbKomponente.fromSessionDTO(dto);

        return warenkorb;
    }

    public static IWarenkorb getWarenkorbFromSession(){

        WarenkorbSessionDTO dto = getWarenkorb();
        IWarenkorb warenkorb = fromWarenkorbSessionDTO(dto);
        return warenkorb;
    }

    public static void setWarenkorbToSession(IWarenkorb warenkorb){

        if(warenkorb == null){
            IWarenkorbKomponente warenkorbKomponente = new WarenkorbKomponente();
            warenkorb = warenkorbKomponente.createEmptyWarenkorb();
        }
        WarenkorbSessionDTO dto = toWarenkorbSessionDTO(warenkorb);
        setWarenkorb(dto);
    }

    public static WarenkorbDTO getWarenkorbFromSessionAsDTO(){

        return getWarenkorbFromSession().toDTO();
    }

    public static void removeKonfiguration(long konfigurationsID){

        IWarenkorb warenkorb = getWarenkorbFromSession();
        warenkorb.removeKonfiguration(konfigurationsID);

        setWarenkorbToSession(warenkorb);
    }

    public static Result removeKonfiguration(){

        DynamicForm form = Form.form().bindFromRequest();

        String konfigNummerString = form.get("delete");

        if(konfigNummerString != null){

            try{
                long konfigNummer = Long.parseLong(konfigNummerString);
                removeKonfiguration(konfigNummer);
            }catch (NumberFormatException ex){}
        }

        warenkorb.render();
        return redirect("/warenkorb");
    }
}
