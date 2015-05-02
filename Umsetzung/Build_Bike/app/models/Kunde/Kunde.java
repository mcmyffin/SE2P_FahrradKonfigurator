package models.Kunde;

import models.DatenBank.DataC;
import models.DatenBank.IDatenBank;

/**
 * Created by tin on 01.05.15.
 */
public class Kunde implements IKunde{
    IDatenBank _db;

    public Kunde(){
        this._db = new DataC();
    }

    @Override
    public boolean login(String email, String pw) {

        if(_db.isKundeExistByMail(email)){
            return (_db.getKundeIDByLogin(email,pw) == 0 ? false : true);
        }
        return false;
    }
}
