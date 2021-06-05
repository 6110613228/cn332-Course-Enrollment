package model;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.IOException;

/**
 * UserModel
 */
public class UserModel extends Model {
    ArrayList<Integer>  Queue = new ArrayList<Integer>();
    public UserModel() {
        super();
    }

    public List<List<Object>> getUsers() {
 
        List<List<Object>> query = null;
        try {
            ValueRange data = connection.spreadsheets().values().get(spreadsheetId, "Users!A2:J").execute();
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
    public ArrayList<Integer> getQueue(){
        return Queue;
    }
    public List<List<Object>> getUsers(String username) { 
        int rowNum = 2;
        List<List<Object>> users = getUsers();
        List<List<Object>> foundUsers = new ArrayList<>();
        for (List row : users) {
            if (row.get(1).equals(username)) {
                foundUsers.add(row);
                Queue.add(rowNum);
            }
            rowNum +=1;
        }

        if (foundUsers.size() == 0) {
            return null;
        }
        return foundUsers;
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

    /**
     * @param none
     * @return Maximum id from usermodel, if error occur return -1
     */
    public int getLastId() {
        List<List<Object>> query;
        ArrayList<Integer> result = new ArrayList<Integer>();
        try {
            ValueRange data = connection.spreadsheets().values().get(spreadsheetId, "Users!A2:A").execute();
            query = data.getValues();
            for (List row : query) {
                result.add(Integer.parseInt((String)row.get(0)));
            }
            return Collections.max(result);
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

    
    public boolean addUser(String name, String surname, String password, String address, String phone, String email) {

        Object data[] = {Integer.toString(getLastId()+1), name, surname, password, address, phone, email, "student"};

        List<List<Object>> values = Arrays.asList(Arrays.asList(data));

        ValueRange body = new ValueRange().setValues(values);
        try {
            String range = String.format("Users!A%s:H%s", getLastId()+2, getLastId()+2);
            UpdateValuesResponse result = connection.spreadsheets().values().update(spreadsheetId, range, body)
                                            .setValueInputOption("USER_ENTERED")
                                            .execute();
            return true;
        } catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public boolean addUser(String name, String surname, String password, String address, String phone, String email,String cid) {

        Object data[] = {Integer.toString(getLastId()+1), name, surname, password, address, phone, email, "student",cid};

        List<List<Object>> values = Arrays.asList(Arrays.asList(data));

        ValueRange body = new ValueRange().setValues(values);
        try {
            String range = String.format("Users!A%s:H%s", getLastId()+2, getLastId()+2);
            UpdateValuesResponse result = connection.spreadsheets().values().update(spreadsheetId, range, body)
                                            .setValueInputOption("USER_ENTERED")
                                            .execute();
            return true;
        } catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }
}