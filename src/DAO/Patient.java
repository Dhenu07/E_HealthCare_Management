package DAO;

public class Patient {
    private int patientID;
    private String first_Name;
    private String last_Name;
    private String gender;
    private String contact_number;
    private int age;
    private String blood_group;
    private String address;
    private String email_id;

    public Patient(int patientID, String first_Name, String last_Name, String gender, String contact_number, int age,
            String blood_group, String address, String email_id) {
        setPatientID(patientID);
        setFirst_Name(first_Name);
        setLast_Name(last_Name);
        setGender(gender);
        setContact_Number(contact_number);
        setAge(age);
        setBlood_Group(blood_group);
        setAddress(address);
        setEmail_Id(email_id);
    }
    public Patient(int patientID){
        setPatientID(patientID);
    }
    public Patient(String First_Name){
      setFirst_Name(First_Name);
    }
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setContact_Number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getContact_Number() {
        return contact_number;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setBlood_Group(String blood_group) {
        this.blood_group = blood_group;
    }

    public String getBlood_Group() {
        return blood_group;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setEmail_Id(String email_id) {
        this.email_id = email_id;
    }

    public String getEmail_Id() {
        return email_id;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientID + "| " +
               "First Name: " + first_Name + "| " +
               "Last Name: " + last_Name + "| " +
               "Gender : " + gender + "| " +
               "Contact Number: " + contact_number + "| " +
               "Age: " + age + "| " +
               "Blood Group: " + blood_group + "| " +
               "Address : " + address + "| " +
               "Email : " + email_id;
    }

}
