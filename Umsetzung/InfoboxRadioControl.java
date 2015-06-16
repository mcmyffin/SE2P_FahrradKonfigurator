package se2;
//package models.KonfigurationKomponente;
import java.util.ArrayList;
import se2.InfoboxRadioException;
//import models.Exception.InfoboxRadioException;

/**
 * @author Henning Kahl
 */

public class InfoboxRadioControl {
    
    private ArrayList<String> componentstrings;
    private ArrayList<String> outstrings;
   
    
    public InfoboxRadioControl(ArrayList<String> instrings){
        componentstrings = new ArrayList<>();
        componentstrings = instrings;
        outstrings = new ArrayList();
    }
    
    //Beachten!!!
    //Der NEXT-Button muss folgenderweise angepasst werden:
    //<div id="next"><a href="index.php?section=stepNÄCHSTER"><input style="background: url('@routes.Assets.at("images/next.png")'); cursor: pointer !important; type="submit" /></a></div>
    
    public ArrayList<String> getInfoboxRadioControl() throws InfoboxRadioException{
        if (componentstrings.isEmpty()){
            throw new InfoboxRadioException("Leider können zur Zeit keine Elemente ausgewählt werden.");
        } else {
            this.outstrings.add("<form action=\"index.php?section=infoboxradiocontrol#form\">");
            this.outstrings.add("<table style=\"border-spacing: 0px;\">");
            this.outstrings.add("<tr>");
            this.outstrings.add("<td align=\"left\" height=\"20px\" width=\"40px\"><input checked=\"checked\" id=\"0\" name=\"infoboxradio\" type=\"radio\" value=\""+this.componentstrings.get(0)+"\" /></td>");
            this.outstrings.add("<td align=\"center\" height=\"20px\" width=\"200px\"><label for=\"0\">"+this.componentstrings.get(0)+"</td>");
            this.outstrings.add("</tr>");
            for(int i = 1; i < componentstrings.size(); i++){
                this.outstrings.add("<tr>");
                this.outstrings.add("<td align=\"left\" height=\"20px\" width=\"40px\"><input id=\""+i+"\" name=\"infoboxradio\" type=\"radio\" value=\""+this.componentstrings.get(i)+"\" /></td>");
                this.outstrings.add("<td align=\"center\" height=\"20px\" width=\"200px\"><label for=\""+i+"\">"+this.componentstrings.get(i)+"</label></td>");
                this.outstrings.add("</tr>");
            }
            this.outstrings.add("</table><br />");
            this.outstrings.add("</form>");
            return this.outstrings;
        }
    }
}