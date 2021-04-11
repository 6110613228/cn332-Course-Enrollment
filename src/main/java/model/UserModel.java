package model;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.util.List;
import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * UserModel
 */
public class UserModel extends Model {

    public UserModel() throws IOException, GeneralSecurityException {
        super();
    }

    public List<List<Object>> getUsers() throws IOException {

        ValueRange data = connection.spreadsheets().values().get(spreadsheetId, "Sheet1!A2:F").execute();
        List<List<Object>> query = data.getValues();

        return query;
    }
}