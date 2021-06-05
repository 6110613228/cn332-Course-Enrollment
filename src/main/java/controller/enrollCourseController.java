package controller;
import model.CourseModel;
import model.UserModel;
import java.util.List;

import javax.management.ConstructorParameters;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;
/**
 * enrollCourseController
 */
class enrollCourseController implements Controller {
    CourseModel course = new CourseModel();
    UserModel user = new UserModel();
    @Override
    public void execute() {
        // TODO Auto-generated method stub
        
    }
    //input is cID ,only student can use this method
    @Override
    public void execute(Object a) {
       
    }

    @Override
    // admin can use this method
    //a = username ,b = cID
    public void execute(Object a, Object b) {
        // TODO Auto-generated method stub
        
        // TODO Auto-generated method stub
        String cID  = ""+b;
        CourseModel addCourse = new CourseModel();
        List<List<Object>> userCourse = user.getUsers(""+a); 
        List<String> enrollCourse = course.getCourse(cID);
        int quota =  Integer.parseInt(enrollCourse.get(4));
        String name ="";
        String surname = "";
        String password = "";
        String address = "";
        String phone = "";
        String email = "";
        
        for (List row : userCourse) {
            if (row.get(8).equals(cID)) {
                name = row.get(0)+"";
                surname = row.get(1)+"";
                password = row.get(2)+"";
                address = row.get(3)+"";
                phone = row.get(4)+"";
                email = row.get(5)+"";
                
                System.out.println(a+" have already enroll this course.");

                return;
            }
        }

        if(quota == 0){
            System.out.println("this course have no quota.");
        }
        else{
            quota = quota -1 ;
            enrollCourse.set(4,""+quota);
            int row = course.findRow();
            addCourse.addCourse(row, enrollCourse);
           
            user.addUser(name, surname, password, address, phone, email, cID);
            
            System.out.println("enroll Successful");
        }


        
    }
}