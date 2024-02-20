package DAO;

public class Reports {
    private int reportId;
    private int appointmentID;
    private int patientId;
    private int doctorId;
    private String medicinePre;
    private String docComment;
    private String pname;

    public Reports(int reportId, int appointment, int patient, int doctor, String medicationPre, String docComment) {
        setAppointmentID(appointment);
        setDocComment(docComment);
        setDoctorId(doctor);
        setMedicinePre(docComment);
        setPatientId(patient);
        setReportId(reportId);
    }

    public Reports(int reportId) {
        setReportId(reportId);
    }

    public Reports(String dname, String pname, String medicationPre, String docComment) {
        setDocComment(docComment);
        setMedicinePre(docComment);
        setDname(dname);
        setPname(pname);
    }

    public Reports(int patientId, String medicationPre) {
        setPatientId(patientId);
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getReportId() {
        return reportId;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setMedicinePre(String medicinePre) {
        this.medicinePre = medicinePre;
    }

    public String getMedicinePre() {
        return medicinePre;
    }

    public void setDocComment(String docComment) {
        this.docComment = docComment;
    }

    public String getDocComment() {
        return docComment;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    private String dname;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        if (reportId != 0) {
            result.append("Report ID: ").append(reportId).append("| ");
        }
        if (appointmentID != 0) {
            result.append("Appointment ID: ").append(appointmentID).append("| ");
        }
        if (patientId != 0) {
            result.append("Patient ID: ").append(patientId).append("| ");
        }
        if (doctorId != 0) {
            result.append("Doctor ID: ").append(doctorId).append("| ");
        }
        if (medicinePre != null) {
            result.append("Medicine Prescribed: ").append(medicinePre).append("| ");
        }
        if (docComment != null) {
            result.append("Doctor Comment: ").append(docComment);
        }

        return result.toString();
    }

}
