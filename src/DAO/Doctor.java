package DAO;

public class Doctor {
    private int doctorID;
    private String first_Name;
    private String last_Name;
    private String gender;
    private String contact_number;
    private int age;
    private int entry_charge;
    private String qualification;
    private String doctor_type;
    private String email_id;
    
    public Doctor(int doctorID, String first_Name, String last_Name, String gender, String contact_number, int age, int entry_charge, String qualification, String doctor_type, String email_id) {
        setDoctorId(doctorID);
        setFirstName(first_Name);
        setLastName(last_Name);
        setGender(gender);
        setContactNumber(contact_number);
        setAge(age);
        setEntry(entry_charge);
        setQualification(qualification);
        setDoctorType(doctor_type);
        setEmailId(email_id);
    }
    public Doctor(int doctorID, String first_Name, String last_Name, int age, String doctor_Type,String qualification, String email_id, String contact_number){
        setContactNumber(contact_number);
        setDoctorId(doctorID);
        setEmailId(email_id);
        setDoctorType(doctor_Type);
        setFirstName(first_Name);
        setLastName(last_Name);
        setAge(age);
        setQualification(qualification);
        
    }
    public Doctor(String first_Name,int age,String doctor_type,String qualification){
        setFirstName(first_Name);
        setAge(age);
        setDoctorType(doctor_type);
        setQualification(qualification);
    }
    public Doctor(String First_Name){
        setFirstName(First_Name);
    }
    public Doctor(String doctor_type,String first_Name){
        setDoctorType(doctor_type);
    }
    public Doctor(int doctor_id,String first_Name,int entry_charge,String emailid,String qualification){
        setDoctorId(doctor_id);
        setFirstName(first_Name);
        setEntry(doctor_id);
        setEmailId(emailid);
        setQualification(qualification);
    }
    public void setDoctorId(int doctorID) {
        this.doctorID = doctorID;
    }

    public int getDoctorId() {
        return doctorID;
    }

    public void setFirstName(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getFirstName() {
        return first_Name;
    }

    public void setLastName(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getLastName() {
        return last_Name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setContactNumber(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getContactNumber() {
        return contact_number;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setEntry(int entry_charge) {
        this.entry_charge = entry_charge;
    }

    public int getEntry() {
        return entry_charge;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getQualification() {
        return qualification;
    }

    public void setDoctorType(String doctor_type) {
        this.doctor_type = doctor_type;
    }

    public String getDoctorType() {
        return doctor_type;
    }

    public void setEmailId(String email_id) {
        this.email_id = email_id;
    }

    public String getEmailId() {
        return email_id;
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
    
        if (doctorID != 0) {
            result.append("Doctor ID: ").append(doctorID).append("| ");
        }
        if (first_Name != null) {
            result.append("First Name: ").append(first_Name).append("| ");
        }
        if (last_Name != null) {
            result.append("Last Name: ").append(last_Name).append("| ");
        }
        if (gender != null) {
            result.append("Gender: ").append(gender).append("| ");
        }
        if (contact_number != null) {
            result.append("Contact Number: ").append(contact_number).append("| ");
        }
        if (age != 0) {
            result.append("Age: ").append(age).append("| ");
        }
        if (entry_charge != 0) {
            result.append("Entry Fee: ").append(entry_charge).append("| ");
        }
        if (qualification != null) {
            result.append("Qualification: ").append(qualification).append("| ");
        }
        if (doctor_type != null) {
            result.append("Doctor Type: ").append(doctor_type).append("| ");
        }
        if (email_id != null) {
            result.append("Email: ").append(email_id);
        }
    
        return result.toString();
    }
    
}
