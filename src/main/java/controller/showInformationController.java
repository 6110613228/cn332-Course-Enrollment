package controller;
import java.util.List;

import model.CourseModel;
/**
 * showInformationController
 */
class showInformationController implements Controller {
CourseModel course = new CourseModel();
    @Override
    public void execute() {
        // TODO Auto-generated method stub
        for(List<Object> row :course.getTable()){
            String table = String.format("%-15s%-15s%-15s%-15s%-15s", row.get(0),row.get(1),row.get(2),row.get(3),row.get(4));
            System.out.println(table);
        }
    }

    @Override
    public void execute(Object a) {
        // TODO Auto-generated method stub
        System.out.println("CID            cName          date           seat           quota");
        for(List<Object> row :course.getCourseByName((String)a)){
            String table = String.format("%-15s%-15s%-15s%-15s%-15s", row.get(0),row.get(1),row.get(2),row.get(3),row.get(4));
            System.out.println(table);
        }
    }

    @Override
    public void execute(Object a, Object b) {
        // TODO Auto-generated method stub
        
    }
}