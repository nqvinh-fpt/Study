package fa.training.management;

import fa.training.entities.Multimedia;

import java.util.List;

public class MultimediaManagement {
    public List<Multimedia> listOfMultimedia;

    public MultimediaManagement(List<Multimedia> listOfMultimedia) {
        this.listOfMultimedia = listOfMultimedia;
    }

    public void addMultimedia(Multimedia multimedia) {
        listOfMultimedia.add(multimedia);
    }

    public void displayMultimedia() {
        if (listOfMultimedia.isEmpty()) {
            System.out.println("The list of multimedia is empty.");
        } else {
            for (Multimedia multimedia : listOfMultimedia) {
                System.out.println(multimedia.toString());
            }
        }
    }
}
