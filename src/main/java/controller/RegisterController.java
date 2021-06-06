package controller;

import model.UserModel;

/**
 * RegisterController
 */
class RegisterController implements Controller {

    UserModel model = new UserModel();

    String name;
    String surname;
    String password;
    String address;
    String phone;
    String email;

    public void set(String name, String surname, String password, String address, String phone, String email) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public void execute() {
        Subject observeSubject = new Subject();
        model.addUser(name, surname, password, address, phone, email);
        observeSubject.update(name, "register", "susscess");
        
    }
    @Override
    public void execute(Object a) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void execute(Object a, Object b) {
        // TODO Auto-generated method stub
        
    }
}