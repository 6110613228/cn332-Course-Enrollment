package model;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.IOException;

public class logtoSheet extends Model{
  

    public logtoSheet() {
       super();
    }
    public int getLastId() {
        List<List<Object>> query;
        
        try {
            ValueRange data = connection.spreadsheets().values().get(spreadsheetId, "Log!D2:D").execute();
            query = data.getValues();
            return query.size();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }


    public boolean addInfo(String Date, String Info, String results, String user) {

        Object data[] = {Date, Info, results, user};

        List<List<Object>> values = Arrays.asList(Arrays.asList(data));

        ValueRange body = new ValueRange().setValues(values);
        try {
            String range = String.format("Log!A%s:H%s", getLastId()+2, getLastId()+2);
            UpdateValuesResponse result = connection.spreadsheets().values().update(spreadsheetId, range, body).execute();
            return true;
        } catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }
}

    

    
