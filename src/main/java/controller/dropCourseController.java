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
    Subject ObserveObject = new Subject();
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
                quota = quota +1 ;
                enrollCourse.set(4,""+quota);
                user.dropUser(rowNum, row.get(0)+"", row.get(1)+"", row.get(2)+"", row.get(3)+"", row.get(4)+"",row.get(5)+"", row.get(6)+"", row.get(8)+"");
                
                int cRow = course.findRow();
                addCourse.addCourse(cRow, enrollCourse.get(0),enrollCourse.get(1),enrollCourse.get(2),enrollCourse.get(3),enrollCourse.get(4));
                course.resetRow();
                ObserveObject.update((String) a, "Drop Course : "+cID, "Success");
                System.out.println("drop Successful");
                return;
            }
            Queue.remove(0);
        }
        
        ObserveObject.update((String) a, "Drop Course : "+cID, "have no enroll this course");
        System.out.println(a+" have no enroll this course.");
            
        

        
        
    }
}