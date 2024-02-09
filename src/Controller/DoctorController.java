package Controller;
import java.util.List;
import Model.DoctorModel;

public class DoctorController{
    private DoctorModel doctorModel;
    
    public DoctorController() {
        this.doctorModel = new DoctorModel();
    }
    
    public  boolean checkDoctor(int id, String password) {
        return doctorModel.checkDoctor(id, password);
    }

    public void addDoctor(int docid,String fn,String ln,String G,String cn,int age,int ec,String Q,String dt,String ed){
        doctorModel.doctor_Registration(docid,fn,ln,G,cn,age,ec,Q,dt,ed);
    }
   public List<String> getProfile(int id){
       return doctorModel.getProfile(id);
   }
   public List<String> getAppo(int id){
       return doctorModel.getAppoint(id);
   }
}

