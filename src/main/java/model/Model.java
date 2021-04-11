package model;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import model.Model;
import java.util.List;
import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * UserModel
 */
public abstract class Model {

    public final String spreadsheetId = "1DxtOiUtrHAg91Ui-A4xYYjMNkj8TMjLKcVKenF2yKIU";

    private DB db = new DB();
    public Sheets connection;

    public Model() throws IOException, GeneralSecurityException {
        this.connection = db.getInstance();
    }
}