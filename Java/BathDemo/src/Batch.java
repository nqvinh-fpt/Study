public class Batch {

    private String batchName;
    private String batchDate;
    private Interviewer interviewer;

    private Cadidate[] cadidate;

    public Batch(String batchName, String batchDate) {
        this.batchName = batchName;
        this.batchDate = batchDate;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getBatchDate() {
        return batchDate;
    }

    public void setBatchDate(String batchDate) {
        this.batchDate = batchDate;
    }

    public Interviewer getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(Interviewer interviewer) {
        this.interviewer = interviewer;
    }

    public Cadidate[] getCadidate() {
        return cadidate;
    }

    public void setCadidate(Cadidate[] cadidate) {
        this.cadidate = cadidate;
    }
}
