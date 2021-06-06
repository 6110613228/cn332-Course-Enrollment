package controller;
import java.util.List;
import model.CourseModel;
import model.UserModel;
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
        List<String> cIDList = null;
        // TODO Auto-generated method stub
        for(List<Object> row :user.getUsers((String)a))
        {
            String cID = row.get(8).toString();
           if(!cID.endsWith(")") && !cID.equals("0")){
               cIDList.add(cID);

           }
           

           
        }
        for (String row : cIDList){
            System.out.println(course.getCourse(row));
        }
    }

    @Override
    public void execute(Object a, Object b) {
        // TODO Auto-generated method stub
        
    }
}