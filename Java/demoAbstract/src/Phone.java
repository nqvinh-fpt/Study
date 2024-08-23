import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

abstract class PhoneManagementSystem {
    ArrayList<PhoneNumber> phoneBook;

    public PhoneManagementSystem() {
        phoneBook = new ArrayList<>();
    }

    abstract void insertPhone(String name, String phone);

    abstract void removePhone(String name);
    abstract void updatePhone(String name, String newPhone);

    abstract void searchPhone(String name);
    abstract void sort();
    class PhoneNumber {
        String name;
        String phone;

        public PhoneNumber(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }
    }
}

class ConcretePhoneManagementSystem extends PhoneManagementSystem {

    @Override
    void insertPhone(String name, String phone) {
        phoneBook.add(new PhoneNumber(name, phone));
    }

    @Override
    void removePhone(String name) {
        phoneBook.removeIf(entry -> entry.getName().equals(name));
    }

    @Override
    void updatePhone(String name, String newPhone) {
        for (PhoneNumber entry : phoneBook) {
            if (entry.getName().equals(name)) {
                entry.phone = newPhone;
                break;
            }
        }
    }

    @Override
    void searchPhone(String name) {
        for (PhoneNumber entry : phoneBook) {
            if (entry.getName().equals(name)) {
                System.out.println("Name: " + entry.getName() + ", Phone: " + entry.getPhone());
            }
        }
    }

    @Override
    void sort() {
        Collections.sort(phoneBook, Comparator.comparing(PhoneNumber::getName));
    }
}


