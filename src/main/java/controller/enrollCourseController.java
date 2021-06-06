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
    Subject ObserveObject = new Subject();
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
        String uID = "";
        String name ="";
        String surname = "";
        String password = "";
        String address = "";
        String phone = "";
        String email = "";
       
        for (List row : userCourse) {
            if (row.get(8).equals(cID)) {
                name = "";
                surname = "";
                password ="";
                address = "";
                phone = "";
                email ="";
                
                ObserveObject.update((String) a, "Enroll Course : "+cID, "have already enroll this course.");
                System.out.println(a+" have already enroll this course.");

                return;
            }
            else{
            uID= row.get(0)+"";
            name = row.get(1)+"";
            surname = row.get(2)+"";
            password = row.get(3)+"";
            address = row.get(4)+"";
            phone = row.get(5)+"";
            email = row.get(6)+"";
            System.out.println(name+":"+surname+" " + password + " "+ address + " " +phone + " "+ email);}
        }
    

        if(quota == 0){
            System.out.println("this course have no quota.");
            ObserveObject.update((String) a, "Enroll Course : "+cID, "have no quato");
        }
        else{
            quota = quota -1 ;
            enrollCourse.set(4,""+quota);
            int row = course.findRow();
            System.out.println(row);
            addCourse.addCourse(row, enrollCourse.get(0),enrollCourse.get(1),enrollCourse.get(2),enrollCourse.get(3),enrollCourse.get(4));
            System.out.println("--------------------------------");
            System.out.println(uID+ " "+name+":"+surname+" " + password + " "+ address + " " +phone + " "+ email);
            user.addUser(uID,name, surname, password, address, phone, email, cID);
            ObserveObject.update((String) a, "Enroll Course : "+cID, "Success");
            System.out.println("enroll Successful");
        }


        
    }
}