import java.util.ArrayList;
import java.util.List;

public class BatchManagement {

    static List<Batch> batchList =new ArrayList<>();
    public Batch createBatch(){
        Person person =new Person(1,"Vinh","Men","11/02/2002","vinh1122k2@gmail.com");
        Interviewer interviewer =new Interviewer(1,"Vinh","Men","11/02/2002","vinh1122k2@gmail.com",1);
        Batch batch =new Batch("Hang1","10/10/2023");
        Cadidate cadidate =new Cadidate(1,"Vinh","Men","11/02/2002","vinh1122k2@gmail.com",10);
        return batch;
    };
    public void display(List<Batch[]> batch){
        System.out.println("Tên lô hàng      Ngày tạo");
        for (int i=0;i< batch.size();i++){
            System.out.printf("%-20s ", batch.get(i));
        }
    };



}
