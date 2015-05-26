package models.TeileKomponente;

import models.TeileKomponente.DTO.EinzelteilDTO;
import models.TeileKomponente.Einzelteile.*;

import java.util.List;

/**
 * Created by dima on 19.05.15.
 */
public interface ITeileKomponente {


    /**
     * To Einzelteil DTO
     * Wandelt den DatenTyp Felge zu einem DTO DatenTyp um.
     * @param felge
     * @return EinzelteilDTO
     */
    public EinzelteilDTO toEinzelteilDTO(Felge felge);

    /**
     * To Einzelteil DTO
     * Wandelt den DatenTyp Gabel zu einem DTO DatenTyp um.
     * @param gabel
     * @return EinzelteilDTO
     */
    public EinzelteilDTO toEinzelteilDTO(Gabel gabel);

    /**
     * To Einzelteil DTO
     * Wandelt den DatenTyp Mantel zu einem DTO DatenTyp um.
     * @param mantel
     * @return EinzelteilDTO
     */
    public EinzelteilDTO toEinzelteilDTO(Mantel mantel);

    /**
     * To Einzelteil DTO
     * Wandelt den DatenTyp Rahmen zu einem DTO DatenTyp um.
     * @param rahmen
     * @return EinzelteilDTO
     */
    public EinzelteilDTO toEinzelteilDTO(Rahmen rahmen);

    /**
     * To Eintelteil DTO
     * @param sattel
     * @return
     */
    public EinzelteilDTO toEinzelteilDTO(Sattel sattel);

    /**
     * To Einzelteil DTO
     * Wandelt den DatenTyp Vorbau zu einem DTO DatenTyp um.
     * @param vorbau
     * @return EinzelteilDTO
     */
    public EinzelteilDTO toEinzelteilDTO(Vorbau vorbau);

    /**
     * To Einzelteil DTO
     * Wandelt den DatenTyp Zubehoer zu einem DTO DatenTyp um.
     * @param zubehoer
     * @return EinzelteilDTO
     */
    public EinzelteilDTO toEinzelteilDTO(Zubehoer zubehoer);

    /**
     * Get Felge List
     * Gibt alle verfuegbaren Felgen als Liste zurueck.
     * @return Felgenliste
     *
     * Bei Persistenzproblemen wird null zurueck geliefert
     */
    public List<Felge> getFelgeList();

    /**
     * Get Gabel List
     * Gibt alle verfuegbaren Gabeln als Liste zurueck.
     * @return Gabelliste
     *
     * Bei Persistenzproblemen wird null zurueck geliefert
     */
    public List<Gabel> getGabelList();

    /**
     * Get Mantel List
     * Gibt alle verfuegbaren Maentel als Liste zurueck.
     * @return Mantelliste
     *
     * Bei Persistenzproblemen wird null zurueck geliefert
     */
    public List<Mantel> getMaentelList();

    /**
     * Get Rahmen List
     * Gibt alle verfuegbaren Rahmen als Liste zurueck.
     * @return Rahmenliste
     *
     * Bei Persistenzproblemen wird null zurueck geliefert
     */
    public List<Rahmen> getRahmenList();

    /**
     * Get Sattel List
     * Gibt alle verfuegbaren Sattel als Liste zurueck.
     * @return Sattelliste
     *
     * Bei Persistenzproblemen wird null zurueck geliefert
     */
    public List<Sattel> getSattelList();

    /**
     * Get Vorbau List
     * Gibt alle verfuegbaren Vorbau-Arten als Liste zurueck.
     * @return Vorbauliste
     *
     * Bei Persistenzproblemen wird null zurueck geliefert
     */
    public List<Vorbau> getVorbauList();

    /**
     * Get Zubehoer List
     * Gibt alle verfuegbaren Zubehoer-Arten zurueck.
     * @return ZubehoerListe
     *
     * Bei Persistenzproblemen wird null zurueck geliefert
     */
    public List<Zubehoer> getZubehoerList();



    public Felge getFelgeByID(int id);

    public Gabel getGabelByID(int id);

    public Mantel getMantelByID(int id);

    public Rahmen getRahmenByID(int id);

    public Sattel getSattelByID(int id);

    public Vorbau getVorbauByID(int id);

    public Zubehoer getZubehoerByID(int id);
}
