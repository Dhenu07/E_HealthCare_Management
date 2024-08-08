package DAO;

import java.sql.Timestamp;

public class Appointment {
    private int appointmentID;
    private String problem;
    private int patientId;
    private int doctorID;
    private String paymentStatus;
    private String appointmentStatus;
    private String doctorName;
    private String qualification;
    private String doctorType;
    private int entryCharge;
    private Timestamp appointmentTime;

    // public Appointment(int appointmentID, String problem, int patientId, int doctorID,String doctorname,  String qualification,int entry_charge,String doctortype,String paymentStatus, String appointmentStatus ) {
    //     setAppointmentID(appointmentID);
    //     setProblem(problem);
    //     setPatientId(patientId);
    //     setDoctorID(doctorID);
    //     setPaymentStatus(paymentStatus);
    //     setAppointmentStatus(appointmentStatus);
    //     setDoctorName(doctorname);
    //     setQualification(qualification);
    //     setDoctorType(doctortype);
    //     setEntryCharge(entry_charge);
    // }
    public Appointment(int appointmentID, String problem, int patientId, int doctorID, String doctorName, String qualification, int entryCharge, String doctorType, String paymentStatus, String appointmentStatus, Timestamp appointmentTime) {
        setAppointmentID(appointmentID);
        setProblem(problem);
        setPatientId(patientId);
        setDoctorID(doctorID);
        setPaymentStatus(paymentStatus);
        setAppointmentStatus(appointmentStatus);
        setDoctorName(doctorName);
        setQualification(qualification);
        setDoctorType(doctorType);
        setEntryCharge(entryCharge);
        setAppointmentTime(appointmentTime);
    }
    public Appointment(int doctorID){
        setDoctorID(doctorID);
    }
    public Appointment(int appointmentID, String problem, int patientID, int doctor_id,String paymentStatus, String appointmentStatus){
        setAppointmentID(appointmentID);
        setAppointmentStatus(appointmentStatus);
        setDoctorID(doctor_id);
        setPatientId(patientID);
        setPaymentStatus(paymentStatus);
        setProblem(problem);
    }
    public Appointment(int appointmentID,int patientID, int doctor_id,String problem){
        setAppointmentID(appointmentID);
        setDoctorID(doctor_id);
        setPatientId(patientID);
        setProblem(problem);
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
    public Appointment(int patientID,String appointmentStatus){
        setAppointmentStatus(appointmentStatus);
        setPatientId(patientID);
    }

    public Timestamp getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Timestamp appointmentTime) {
        this.appointmentTime = appointmentTime;
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
        this.doctorName = doctorName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getQualification() {
        return qualification;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public void setEntryCharge(int entryCharge) {
        this.entryCharge = entryCharge;
    }

    public int getEntryCharge() {
        return entryCharge;
    }
    @Override
    public String toString() {
        // Add appointmentTime to the toString method
        StringBuilder result = new StringBuilder();

        if (appointmentID != 0) {
            result.append("Appointment ID: ").append(appointmentID).append("| ");
        }
        if (problem != null) {
            result.append("Problem: ").append(problem).append("| ");
        }
        if (patientId != 0) {
            result.append("Patient ID: ").append(patientId).append("| ");
        }
        if (doctorID != 0) {
            result.append("Doctor ID: ").append(doctorID).append("| ");
        }
        if (doctorName != null) {
            result.append("Doctor Name: ").append(doctorName).append("| ");
        }
        if (qualification != null) {
            result.append("Qualification: ").append(qualification).append("| ");
        }
        if (doctorType != null) {
            result.append("Doctor Type: ").append(doctorType).append("| ");
        }
        if (paymentStatus != null) {
            result.append("Payment Status: ").append(paymentStatus).append("| ");
        }
        if (appointmentStatus != null) {
            result.append("Appointment Status: ").append(appointmentStatus).append("| ");
        }
        if (entryCharge != 0) {
            result.append("Entry Charge: ").append(entryCharge).append("| ");
        }
        if (appointmentTime != null) {
            result.append("Appointment Time: ").append(appointmentTime).append("| ");
        }
        if (result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }
    
}
