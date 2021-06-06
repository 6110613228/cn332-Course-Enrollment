package controller;
import java.util.List;
import model.CourseModel;
import model.UserModel;
import java.util.ArrayList;
/**
 * showEnrollmentRatingController
 */
class showEnrollmentRatingController implements Controller {
    UserModel user = new UserModel();
    CourseModel course = new CourseModel();
    @Override
    public void execute() {
        // TODO Auto-generated method stub
       
    }

    @Override
    public void execute(Object a) {
        ArrayList<String>  cIDList = new ArrayList<String>();
        // TODO Auto-generated method stub
        for(List<Object> row :user.getUsers((String)a))
        {
            String cID = row.get(8).toString();
           if(!cID.endsWith(")") && !cID.equals("0")){
               cIDList.add(cID);

           }
           

           
        }
        System.out.println("CID            cName          date           seat           quota");
        for (String num : cIDList){
            for(List<Object> row :course.getCourseBycID(num)){
                String table = String.format("%-15s%-15s%-15s%-15s%-15s", row.get(0),row.get(1),row.get(2),row.get(3),row.get(4));
                System.out.println(table);
            }
        }

        
        
    }

    @Override
    public void execute(Object a, Object b) {
        // TODO Auto-generated method stub
        
    }
}