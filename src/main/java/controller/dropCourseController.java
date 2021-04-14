package controller;
import model.CourseModel;
import model.UserModel;
import java.util.List;

import javax.management.ConstructorParameters;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;
/**
 * dropCourseController
 */
class dropCourseController implements Controller {

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        
    }

    @Override
        //input is cID student can use this method
    public void execute(Object a) {
        // TODO Auto-generated method stub
        int cID = a;
        List<String> userCourse = user.getUser(this.username); 
        List<String> enrollCourse = course.getCourse(cID);
        int quota =  Integer.parseInt(enrollCourse.get(4));

        for (List row : userCourse) {
            if (row.get(8).equals(String(cID))) {
                quota = quota+1;
                enrollCourse.set(4,String(quota));
                System.out.println("drop Successful.");
                return;
            }

        }
        System.out.println("You have no enroll this course");
        
        
    }

    @Override
    public void execute(Object a, Object b) {
        // TODO Auto-generated method stub
        int cID = b;
        List<String> userCourse = user.getUser(String(a)); 
        List<String> enrollCourse = course.getCourse(cID);
        int quota =  Integer.parseInt(enrollCourse.get(4));

        for (List row : userCourse) {
            if (row.get(8).equals(String(cID))) {
                quota = quota+1;
                enrollCourse.set(4,String(quota));
                System.out.println("drop Successful.");
                return;
            }
        }

        System.out.println(String(a)+" have no enroll this course.");
        
    }
}