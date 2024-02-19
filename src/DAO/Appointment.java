package DAO;

public class Appointment {
    private int appointmentID;
    private String problem;
    private int patientId;
    private int doctorID;
    private String paymentStatus;
    private String appointmentStatus;
    private String doctorname;
    private String qualification;
    private String doctortype;
    private int entry_charge;

    public Appointment(int appointmentID, String problem, int patientId, int doctorID,String doctorname,  String qualification,int entry_charge,String doctortype,String paymentStatus, String appointmentStatus ) {
        setAppointmentID(appointmentID);
        setProblem(problem);
        setPatientId(patientId);
        setDoctorID(doctorID);
        setPaymentStatus(paymentStatus);
        setAppointmentStatus(appointmentStatus);
        setDoctorName(doctorname);
        setQualification(qualification);
        setDoctorType(doctortype);
        setEntryCharge(entry_charge);
    }

    public Appointment(int doctorID){
        setDoctorID(doctorID);
    }

    public Appointment(int appointmentID,int patientID){
        setPatientId(patientID);
        setAppointmentID(appointmentID);
    }

    public Appointment(int appointmentID, String problem,int patientID, int DoctorFees, String paymentStatus){
        setAppointmentID(appointmentID);
        setAppointmentStatus(paymentStatus);
        setEntryCharge(DoctorFees);
        setPatientId(patientID);
        setProblem(problem);
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getProblem() {
        return problem;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setDoctorName(String doctorName) {
        this.doctorname = doctorName;
    }

    public String getDoctorName() {
        return doctorname;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getQualification() {
        return qualification;
    }

    public void setDoctorType(String doctorType) {
        this.doctortype = doctorType;
    }

    public String getDoctorType() {
        return doctortype;
    }

    public void setEntryCharge(int entryCharge) {
        this.entry_charge = entryCharge;
    }

    public int getEntryCharge() {
        return entry_charge;
    }
    @Override
    public String toString() {
        return "Appointment ID: " + appointmentID + "| " +
               "Problem: " + problem + "| " +
               "Patient ID: " + patientId + "| " +
               "Doctor ID: " + doctorID + "| " +
               "Doctor Name: " + doctorname + "| " +
               "Qualification: " + qualification + "| " +
               "Doctor Type: " + doctortype + "| " +
               "Payment Status: " + paymentStatus + "| " +
               "Appointment Status: " + appointmentStatus + "| " +
               "Entry Charge: " + entry_charge;
    }
    
    
    

}
