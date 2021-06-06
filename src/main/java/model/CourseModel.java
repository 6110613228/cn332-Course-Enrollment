package model;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import java.io.IOException;
/**
 * CourseModel
 */
public class CourseModel extends Model {

    private static int  Numrow = 1;

    public CourseModel() {
        super();
    }

    public List<List<Object>> getCourse() {

        List<List<Object>> query = null;
        try {
            ValueRange data = connection.spreadsheets().values().get(spreadsheetId, "Courses!A2:E").execute();
            query = data.getValues();
        } catch (IOException e) {
            System.out.println(e);
            System.exit(0);
        }
        return query;
    }
    public List<List<Object>> getCourseByName(String cName) { 
        
        List<List<Object>> c = getCourse();
        List<List<Object>> foundcName= new ArrayList<>();
        for (List row : c) {
            if (row.get(1).equals(cName)) {
                foundcName.add(row);
               
            }
           
        }

        if (foundcName.size() == 0) {
            return null;
        }
        return foundcName;
    }

    public List<List<Object>> getCourseBycID(String cID) { 
        
        List<List<Object>> c = getCourse();
        List<List<Object>> foundcName= new ArrayList<>();
        for (List row : c) {
            if (row.get(0).equals(cID)) {
                foundcName.add(row);
               
            }
           
        }

        if (foundcName.size() == 0) {
            return null;
        }
        return foundcName;
    }
    


    public List<List<Object>> getTable() {

        List<List<Object>> query = null;
        try {
            ValueRange data = connection.spreadsheets().values().get(spreadsheetId, "Courses!A1:E").execute();
            query = data.getValues();
        } catch (IOException e) {
            System.out.println(e);
            System.exit(0);
        }
        return query;
    }

    public void travelRow(){
        Numrow +=1;
    }

    public int findRow(){
        return Numrow;
    }

    public List getCourse(String cId) {
        
        // Assume that Id is unique
        List<List<Object>> course = getCourse();
        Numrow = 1;
        for (List row : course) {
            travelRow();
            if (row.get(0).equals(cId)) {
                System.out.println(row);
                return row;
            }
        }
        return null;
    }

    public void resetRow(){
        Numrow = 1;
    }

    public boolean addCourse(int row ,String CID,String cName,String date,String seat,String quota) {

        Object data[] = {CID,cName,date,seat,quota};

        List<List<Object>> values = Arrays.asList(Arrays.asList(data));

        ValueRange body = new ValueRange().setValues(values);
        try {
            String range = String.format("Courses!A%s:E%s", row+"", row+"");
            UpdateValuesResponse result = connection.spreadsheets().values().update(spreadsheetId, range, body).setValueInputOption("USER_ENTERED").execute();
            return true;
        } catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }

}