package fa.training.entities;

public abstract class Multimedia {
    private String name;
    private double duration;

    public Multimedia() {
        this("", 0.0);
    }

    public Multimedia(String name, double duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public abstract void createMultimedia();


}
