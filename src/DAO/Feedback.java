package DAO;

public class Feedback {
    private int patientID;
    private int points;
    private String docNature;
    private String location;
    private String patientComment;
    
    public Feedback(int patientID, int points, String docNature, String location, String patientComment) {
        setDocNature(docNature);
        setLocation(location);
        setPatientComment(patientComment);
        setPatientID(patientID);
        setPoints(points);
    }
    
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setDocNature(String docNature) {
        this.docNature = docNature;
    }

    public String getDocNature() {
        return docNature;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setPatientComment(String patientComment) {
        this.patientComment = patientComment;
    }

    public String getPatientComment() {
        return patientComment;
    }

    @Override
    public String toString() {
        return "Patient Id: " + patientID + "| " +
               "Points: " + points + "| " +
               "Doctor Nature: " + docNature + "| " +
               "Location : " + location + "| " +
               "Patient Comment: " + patientComment;
    }
}
