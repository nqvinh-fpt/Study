package fa.training.management;

import fa.training.entities.Multimedia;

import java.util.ArrayList;
import java.util.List;

public class MultimediaManagement {
    private List<Multimedia> listOfMultimedia;

    public MultimediaManagement() {
        listOfMultimedia = new ArrayList<>();
    }

    public void addMultimedia(Multimedia multimedia) {
        listOfMultimedia.add(multimedia);
    }

    public void displayMultimedia() {
        System.out.println("---------LIST OF MULTIMEDIA------");
        for (Multimedia media : listOfMultimedia) {
            System.out.println(media);
        }
    }
}
