package controllers;

import models.DatenTypen.Pair;
import models.Exception.KonfigurationException;
import models.Exception.RahmenFormTypException;
import models.Exception.UngueltigerStepException;
import models.KonfigurationKomponente.IKofigurationKomponente;
import models.KonfigurationKomponente.IKonfiguration;
import models.KonfigurationKomponente.KonfigurationKomponente;
import models.TeileKomponente.DTO.EinzelteilDTO;
import models.TeileKomponente.EinzelTeileTyp;
import models.TeileKomponente.Einzelteile.*;
import models.TeileKomponente.ITeileKomponente;
import models.TeileKomponente.RahmenFormTyp;
import models.TeileKomponente.TeileKomponente;
import models.WarenkorbKomponente.DTO.WarenkorbSessionDTO;
import models.WarenkorbKomponente.IWarenkorb;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by dima on 16.06.15.
 */
public class KonfigurationsSchritte extends Controller{

    private static IKofigurationKomponente konfigurationKomponente;
    private static ITeileKomponente teileKomponente;

    // set step1
    public static Result setStep01(){

        DynamicForm form = Form.form().bindFromRequest();

        String fahrradtyp = form.get("Fahrradtyp");

        try {
            RahmenFormTyp rahmenFormTyp = RahmenFormTyp.getRahmenFormTypByString(fahrradtyp);
            IKonfiguration konfiguration = KonfigurationSession.getKonfigurationFromSession();

            konfiguration.setStep1(rahmenFormTyp);
            KonfigurationSession.setKonfigurationToSession(konfiguration);

        } catch (RahmenFormTypException|UngueltigerStepException e) {
            return Verlinkung.konfigurator();
        }

        return Verlinkung.step02();
    }

    // get step2
    public static List<EinzelteilDTO> getRahmenListe() throws UngueltigerStepException {

        konfigurationKomponente = new KonfigurationKomponente();
        teileKomponente = new TeileKomponente();

        IKonfiguration konfiguration = KonfigurationSession.getKonfigurationFromSession();

        List<Rahmen> rahmenUngefiltert = teileKomponente.getRahmenList();
        List<Rahmen> rahmenGefiltert = konfigurationKomponente.filterRahmenByKonfiguration(konfiguration, rahmenUngefiltert);

        List<EinzelteilDTO> rahmenlisteDTO = new ArrayList(rahmenGefiltert.size());
        for(Rahmen einRahmen : rahmenGefiltert){
            EinzelteilDTO rahmenDTO = teileKomponente.toEinzelteilDTO(einRahmen);
            rahmenlisteDTO.add(rahmenDTO);
        }

        return rahmenlisteDTO;
    }

    // setStep02
    public static Result setStep02(){

        DynamicForm form = Form.form().bindFromRequest();

        String rahmenIDAsString = form.get("Rahmen");
        int rahmenID = Integer.parseInt(rahmenIDAsString);

        // todo parse exception fangen!!!

        IKonfiguration konfiguration = KonfigurationSession.getKonfigurationFromSession();

        try {

            konfiguration.setStep2(rahmenID, EinzelTeileTyp.RAHMEN);
            KonfigurationSession.setKonfigurationToSession(konfiguration);

        } catch (KonfigurationException|UngueltigerStepException e) {
            return Verlinkung.step02();
        }

        return Verlinkung.step03();
    }

    // setStep03
    public static Pair<List<String>,List<Integer>> getRahmenFarbeHoehe() throws UngueltigerStepException {

        konfigurationKomponente = new KonfigurationKomponente();
        IKonfiguration konfiguration = KonfigurationSession.getKonfigurationFromSession();

        List<String> farben = konfigurationKomponente.getRahmenFarbenByKonfiguration(konfiguration);
        List<Integer> hoehen = konfigurationKomponente.getRahmenHoehenByKonfiguration(konfiguration);

        return new Pair<List<String>,List<Integer>>(farben,hoehen);
    }

    // setStep03
    public static Result setStep03(){

        DynamicForm form = Form.form().bindFromRequest();

        String hoeheString = form.get("Hoehe");
        int hoehe = Integer.parseInt(hoeheString);
        String farbeString = form.get("Farbe");

        IKonfiguration konfiguration = KonfigurationSession.getKonfigurationFromSession();

        try {

            konfiguration.setStep3(farbeString,hoehe);
            KonfigurationSession.setKonfigurationToSession(konfiguration);

        } catch (UngueltigerStepException|KonfigurationException e) {
            return Verlinkung.step03();
        }
        return Verlinkung.step04();
    }

    // getStep04
    public static List<EinzelteilDTO> getFahrradGabelList() throws UngueltigerStepException {

        konfigurationKomponente = new KonfigurationKomponente();
        teileKomponente = new TeileKomponente();
        IKonfiguration konfiguration = KonfigurationSession.getKonfigurationFromSession();

        List<Gabel> gabelUngefiltert = teileKomponente.getGabelList();
        List<Gabel> gabelGefiltert = konfigurationKomponente.filterGabelByKonfiguration(konfiguration, gabelUngefiltert);

        List<EinzelteilDTO> gabelListe = new ArrayList(gabelGefiltert.size());
        for(Gabel eineGabel : gabelGefiltert){
            gabelListe.add(teileKomponente.toEinzelteilDTO(eineGabel));
        }

        return gabelListe;
    }

    // setStep04
    public static Result setStep04(){

        DynamicForm form = Form.form().bindFromRequest();

        String gabelIdString = form.get("Gabel");
        int gabelId = Integer.parseInt(gabelIdString);

        // todo catch parse exception

        IKonfiguration konfiguration = KonfigurationSession.getKonfigurationFromSession();

        try {
            konfiguration.setStep4(gabelId,EinzelTeileTyp.GABEL);
            KonfigurationSession.setKonfigurationToSession(konfiguration);
        } catch (KonfigurationException|UngueltigerStepException e) {
            return Verlinkung.step04();
        }
        return Verlinkung.step05();
    }

    // getStep05
    public static List<EinzelteilDTO> getFelgeList() throws UngueltigerStepException {

        konfigurationKomponente = new KonfigurationKomponente();
        teileKomponente = new TeileKomponente();
        IKonfiguration konfiguration = KonfigurationSession.getKonfigurationFromSession();

        List<Felge> felgeUngefiltert = teileKomponente.getFelgeList();
        List<Felge> felgeGefiltert = konfigurationKomponente.filterFelgeByKonfiguration(konfiguration, felgeUngefiltert);

        List<EinzelteilDTO> felgeList = new ArrayList(felgeGefiltert.size());
        for(Felge eineFelge : felgeGefiltert){

            felgeList.add(teileKomponente.toEinzelteilDTO(eineFelge));
        }

        return felgeList;
    }

    // setStep05
    public static Result setStep05(){

        DynamicForm form = Form.form().bindFromRequest();

        String felgeIdString = form.get("Felge");
        int felgeId = Integer.parseInt(felgeIdString);

        IKonfiguration konfiguration = KonfigurationSession.getKonfigurationFromSession();

        try {

            konfiguration.setStep5(felgeId,EinzelTeileTyp.FELGE);
            KonfigurationSession.setKonfigurationToSession(konfiguration);

        } catch (KonfigurationException|UngueltigerStepException e) {
            return Verlinkung.step05();
        }
        return Verlinkung.step06();
    }

    // getStep06
    public static List<EinzelteilDTO> getMantelList() throws UngueltigerStepException {

        konfigurationKomponente = new KonfigurationKomponente();
        teileKomponente = new TeileKomponente();
        IKonfiguration konfiguration = KonfigurationSession.getKonfigurationFromSession();

        List<Mantel> mantelUngefiltert = teileKomponente.getMaentelList();
        List<Mantel> mantelGefiltert = konfigurationKomponente.filterMantelByKonfiguration(konfiguration, mantelUngefiltert);

        List<EinzelteilDTO> mantelListe = new ArrayList(mantelGefiltert.size());
        for(Mantel einMantel : mantelGefiltert){

            mantelListe.add(teileKomponente.toEinzelteilDTO(einMantel));
        }

        return mantelListe;
    }

    // setStep06
    public static Result setStep06(){

        DynamicForm form = Form.form().bindFromRequest();

        String mantelIdString = form.get("Mantel");
        int mantelId = Integer.parseInt(mantelIdString);

        IKonfiguration konfiguration = KonfigurationSession.getKonfigurationFromSession();

        try {
            konfiguration.setStep6(mantelId,EinzelTeileTyp.MANTEL);
            KonfigurationSession.setKonfigurationToSession(konfiguration);
        } catch (KonfigurationException|UngueltigerStepException e) {
            return Verlinkung.step06();
        }

        return Verlinkung.step07();
    }

    // setStep07
    public static Result setStep07(){

        DynamicForm form = Form.form().bindFromRequest();

        String vorbauIdString = form.get("Vorbau");
        int vorbauId = Integer.parseInt(vorbauIdString);

        IKonfiguration konfiguration = KonfigurationSession.getKonfigurationFromSession();

        try {
            konfiguration.setStep7(vorbauId, EinzelTeileTyp.VORBAU);
            KonfigurationSession.setKonfigurationToSession(konfiguration);
        } catch (KonfigurationException|UngueltigerStepException e) {
            return Verlinkung.step07();
        }

        return Verlinkung.step08();
    }

    // setStep08
    public static Result setStep08(){

        DynamicForm form = Form.form().bindFromRequest();

        String sattelIdString = form.get("Sattel");
        int sattelId = Integer.parseInt(sattelIdString);

        IKonfiguration konfiguration = KonfigurationSession.getKonfigurationFromSession();

        try {
            konfiguration.setStep8(sattelId, EinzelTeileTyp.SATTEL);
            KonfigurationSession.setKonfigurationToSession(konfiguration);
        } catch (KonfigurationException|UngueltigerStepException e) {
            return Verlinkung.step08();
        }

        return Verlinkung.step09();
    }

    // setStep09
    public static Result setStep09(){

        DynamicForm form = Form.form().bindFromRequest();

        String isSteckLichtString = form.get("Stecklicht");
        String isFestLichtString = form.get("Festlicht");

        boolean isSteckLicht = (isSteckLichtString != null ? true : false);
        boolean isFestLicht = (isFestLichtString != null ? true : false);

        IKonfiguration konfiguration = KonfigurationSession.getKonfigurationFromSession();

        try {
            konfiguration.setStep9(true, isSteckLicht, isFestLicht);
            KonfigurationSession.setKonfigurationToSession(konfiguration);

        } catch (UngueltigerStepException e) {
            return Verlinkung.step09();
        }
        return Verlinkung.step10();
    }

    // getStep07
    public static List<EinzelteilDTO> getVorbauList() throws UngueltigerStepException {

        konfigurationKomponente = new KonfigurationKomponente();
        teileKomponente = new TeileKomponente();
        IKonfiguration konfiguration = KonfigurationSession.getKonfigurationFromSession();

        List<Vorbau> vorbauUngefiltert = teileKomponente.getVorbauList();
        List<Vorbau> vorbauGefiltert = konfigurationKomponente.filterVorbauByKonfiguration(konfiguration, vorbauUngefiltert);

        List<EinzelteilDTO> vorbauListe = new ArrayList(vorbauGefiltert.size());
        for(Vorbau einVorbau: vorbauGefiltert){

            vorbauListe.add(teileKomponente.toEinzelteilDTO(einVorbau));
        }

        return vorbauListe;
    }

    // getStep08
    public static List<EinzelteilDTO> getSattelList() throws UngueltigerStepException {

        konfigurationKomponente = new KonfigurationKomponente();
        teileKomponente = new TeileKomponente();
        IKonfiguration konfiguration = KonfigurationSession.getKonfigurationFromSession();

        List<Sattel> sattelUngefiltert = teileKomponente.getSattelList();
        List<Sattel> sattelGefiltert = konfigurationKomponente.filterSattelByKonfiguration(konfiguration, sattelUngefiltert);

        List<EinzelteilDTO> sattelListe = new ArrayList(sattelGefiltert.size());
        for(Sattel einSattel : sattelGefiltert){

            sattelListe.add(teileKomponente.toEinzelteilDTO(einSattel));
        }

        return sattelListe;
    }

    public static boolean getBeleuchtung() throws UngueltigerStepException {

        konfigurationKomponente = new KonfigurationKomponente();
        IKonfiguration konfiguration = KonfigurationSession.getKonfigurationFromSession();

        boolean isFestlicht = konfigurationKomponente.filterFestlicht(konfiguration);
        return isFestlicht;
    }

    public static List<EinzelteilDTO> getZubehoerList() throws UngueltigerStepException {

        konfigurationKomponente = new KonfigurationKomponente();
        teileKomponente = new TeileKomponente();
        IKonfiguration konfiguration = KonfigurationSession.getKonfigurationFromSession();

        List<Zubehoer> zubehoerUngefiltert = teileKomponente.getZubehoerList();
        List<Zubehoer> zubehoerGefiltert = konfigurationKomponente.filterZubehoerByKonfiguration(konfiguration, zubehoerUngefiltert);

        List<EinzelteilDTO> zubehoerList = new ArrayList(zubehoerGefiltert.size());
        for(Zubehoer einZubehoer : zubehoerGefiltert){

            zubehoerList.add(teileKomponente.toEinzelteilDTO(einZubehoer));
        }

        return zubehoerList;
    }

    // setStep10
    public static Result setStep10(){

        DynamicForm form = Form.form().bindFromRequest();

        Map<String,String> formData = form.data();
        List<Integer> zubehoerList = new ArrayList(formData.size());

        for(String stringID : formData.keySet()){

            try{
                int id = Integer.parseInt(stringID);
                zubehoerList.add(id);
            }catch (NumberFormatException ex){
                continue;
            }
        }

        IKonfiguration konfiguration = KonfigurationSession.getKonfigurationFromSession();

        try {
            konfiguration.setStep10(EinzelTeileTyp.ZUBEHOER,zubehoerList);
            KonfigurationSession.setKonfigurationToSession(konfiguration);
        } catch (KonfigurationException|UngueltigerStepException e) {
            return Verlinkung.step10();
        }

        IWarenkorb warenkorb = WarenkorbSession.getWarenkorbFromSession();
        IKonfiguration eineKonfiguration = KonfigurationSession.getKonfigurationFromSession();
        warenkorb.addKonfiguration(eineKonfiguration);
        WarenkorbSession.setWarenkorbToSession(warenkorb);

        KonfigurationSession.removeKonfiguration();

        return Verlinkung.warenkorb();
    }
}
