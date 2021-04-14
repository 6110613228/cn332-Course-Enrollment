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
        // TODO Auto-generated method stub
    
        String cID = ""+a;
        List<String> enrollCourse = course.getCourse(cID);
        List<List<Object>> userCourse = user.getUsers("username"); 
        int quota =  Integer.parseInt(enrollCourse.get(4));

        for (List row : userCourse) {
            if (row.get(8).equals(""+cID)) {
                System.out.println("You have already enroll this course.");
                return;
            }
        }

        if(quota == 0){
            System.out.println("this course have no quota.");
        }
        else{
            quota = quota -1 ;
            enrollCourse.set(4,""+quota);
            System.out.println("enroll Successful");
        }
    }

    @Override
    // admin can use this method
    //a = username ,b = cID
    public void execute(Object a, Object b) {
        // TODO Auto-generated method stub
        String cID  = ""+b;
        List<List<Object>> userCourse = user.getUsers(""+a); 
        List<String> enrollCourse = course.getCourse(cID);
        int quota =  Integer.parseInt(enrollCourse.get(4));

        for (List row : userCourse) {
            if (row.get(8).equals(cID)) {
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
            System.out.println("enroll Successful");
        }

        
    }
}