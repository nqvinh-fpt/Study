import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static List<Batch[]> batchList =new ArrayList<>();
    public static void main(String[] args) {
        BatchManagement batchManagement =new BatchManagement();
        batchList.add(batchManagement.createBatch());
        batchManagement.display(batchList);
        }

}