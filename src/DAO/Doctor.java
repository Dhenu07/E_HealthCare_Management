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
    public Doctor(String First_Name){
        setFirstName(First_Name);
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
        return "Doctor ID: " + doctorID + "| " +
               "First Name: " + first_Name + "| " +
               "Last Name: " + last_Name + "| " +
               "Gender : " + gender + "| " +
               "Contact Number: " + contact_number + "| " +
               "Age: " + age + "| " +
               "Entry Fee: " + entry_charge + "| " +
               " Qualification : " + qualification + "| " +
               "Doctor Type: " + doctor_type + "| " +
               "Email : " + email_id;
    }
}
