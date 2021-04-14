package model;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
/**
 * CourseModel
 */
public class CourseModel extends Model {
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
    public List getCourse(int cId) {

        // Assume that Id is unique
        List<List<Object>> course = getCourse();

        for (List row : course) {
            if (row.get(0).equals(String(cId))) {
                return row;
            }
        }
        return null;
    }

}