package controller;
import model.CourseModel;
import model.UserModel;

import java.util.ArrayList;
import java.util.List;

import javax.management.ConstructorParameters;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;
/**
 * dropCourseController
 */
class dropCourseController implements Controller {
    CourseModel course = new CourseModel();
    UserModel user = new UserModel();
    @Override
    public void execute() {
        // TODO Auto-generated method stub
        
    }

    @Override
        //input is cID student can use this method
    public void execute(Object a) {
        // TODO Auto-generated method stub
        
        
    }

    @Override
    public void execute(Object a, Object b) {
        // TODO Auto-generated method stub
        CourseModel addCourse = new CourseModel();
        String cID  = ""+b;
        List<List<Object>> userCourse = user.getUsers(""+a);
        ArrayList<Integer> Queue = user.getQueue(); 
        List<String> enrollCourse = course.getCourse(cID);
        int quota =  Integer.parseInt(enrollCourse.get(4));

        for (List row : userCourse) {
            
            if (row.get(8).equals(cID)) {
                int rowNum = Queue.get(0);
                quota = quota -1 ;
                enrollCourse.set(4,""+quota);
                
                addCourse.addCourse(rowNum, enrollCourse);

                System.out.println("drop Successful");
                return;
            }
            Queue.remove(0);
        }
        
            
        System.out.println(a+" have no enroll this course.");
            
        

        
        
    }
}