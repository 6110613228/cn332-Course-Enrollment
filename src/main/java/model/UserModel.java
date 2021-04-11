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

    public UserModel() {
        super();
    }

    public List<List<Object>> getUsers() {

        List<List<Object>> query = null;
        try {
            ValueRange data = connection.spreadsheets().values().get(spreadsheetId, "Users!A2:G").execute();
            query = data.getValues();
        } catch (IOException e) {
            System.out.println(e);
            System.exit(0);
        }
        return query;
    }

    public List getUser(int Id) {

        // Assume that Id is unique
        List<List<Object>> users = getUsers();

        for (List row : users) {
            if (row.get(0).equals("" + Id)) {
                return row;
            }
        }
        return null;
    }

    public List getUser(String username, String password) {

        List<List<Object>> users = getUsers();

        for (List row : users) {
            if (row.get(1).equals(username) && row.get(3).equals(password)) {
                return row;
            }
        }
        return null;
    }
}