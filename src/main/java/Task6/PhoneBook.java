package Task6;

import java.util.*;

public class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        PhoneBook myPhoneBook = new PhoneBook();
        phoneBook.put("Sasha", new ArrayList<Integer>(Arrays.asList(65, 45, 85)));
        phoneBook.put("Koliy", new ArrayList<Integer>(Arrays.asList(6)));
        phoneBook.put("Masha", new ArrayList<Integer>(Arrays.asList(5, 8, 95, 9, 11)));
        phoneBook.put("Oleg", new ArrayList<Integer>(Arrays.asList(58, 100)));
        phoneBook.put("Olga", new ArrayList<Integer>(Arrays.asList(4569, 500, 9687)));

        System.out.println("Для управления используйте сл. команды:");
        System.out.println("+ чтобы добавить контакт/телефон");
        System.out.println("- чтобы удалить номер");
        System.out.println("d чтобы удалить контакт");
        System.out.println("p чтобы вывести телефонную книгу");
        System.out.println("q для выхода из режима ввода");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            char command = scanner.next().charAt(0);
            System.out.println(command);
            if (command == '+') {
                myPhoneBook.addNumber();
            } else if (command == '-') {
                System.out.println("Введите номер для удаления");
                Integer delNum = scanner.nextInt();
                myPhoneBook.deleteNumber(delNum);
            } else if (command == 'd') {
                System.out.println("Введите имя для удаления контакта");
                String delName = scanner.next().toString();
                System.out.println(delName);
                myPhoneBook.deleteContact(delName);
            } else if (command == 'p') {
                myPhoneBook.printAll();
            } else if (command == 'q') {
                break;
            } else {
                System.out.println("некорректная команда, введи еще раз:");
            }
        }
    }

    /**
     * @return Contact or number has been added to the phonebook
     * @apiNote Метод предназначен для добавления контактов/номеров в телефонную книгу
     */
    public void addNumber() {
        ArrayList<Integer> num = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите номер телефона: ");
        int phoneNum = scanner.nextInt();
        if (!phoneBook.containsKey(name)) {
            num.add(phoneNum);
            phoneBook.put(name, num);
        } else {
            num = phoneBook.get(name);
            num.add(phoneNum);
            phoneBook.put(name, num);
        }
    }

    /**
     * @param delNum Number of the contact being deleted
     * @return Deletes a phonenumber from the phonebook
     * @apiNote Метод предназначен для удаления номера телефона из телефонной книги
     */
    public void deleteNumber(Integer delNum) {
        for (Map.Entry<String, ArrayList<Integer>> elem : phoneBook.entrySet()) {
            List<Integer> number = new ArrayList<>(elem.getValue());
            Iterator itr =number.iterator();
            while (itr.hasNext()) {
                if ((Integer) itr.next() == delNum) {
                    phoneBook.get(elem.getKey()).remove(delNum);
                }
            }
        }
    }

        /**
         * @apiNote Метод предназначен для удаления контакта из телефонной книги
         * @param name The name of the contact being deleted
         * @return Deletes a contact from the phonebook
         */
    public void deleteContact(String name){
        phoneBook.remove(name);
    }

    /**
     * @apiNote Метод предназначен для выведения в консоль всей телефонной книги отсортированной
     * по убыванию числа телефонов.
     * @return Sorted the phonebook
     */
    public void printAll() {
        Map<Integer, ArrayList<String>> unSortPhoneBook = new HashMap<>();
        for (String s : phoneBook.keySet()) {
            ArrayList<String> num = new ArrayList<>();
            if (!unSortPhoneBook.containsKey(phoneBook.get(s).size())) {
                num.add(s);
                unSortPhoneBook.put(phoneBook.get(s).size(), num);
            } else {
                num = unSortPhoneBook.get(phoneBook.get(s).size());
                num.add(s);
                unSortPhoneBook.put(phoneBook.get(s).size(), num);
            }
        }

        Integer [] keys = unSortPhoneBook.keySet().toArray(new Integer[0]);
        Arrays.sort(keys,Collections.reverseOrder());
        Map<Integer, ArrayList<String>> sortPB = new LinkedHashMap<>();
        for (Integer key: keys) {
            sortPB.put(key, unSortPhoneBook.get(key));
        }
        for (Integer s : sortPB.keySet()) {
            for (String names : sortPB.get(s)){
                System.out.println(names + " " + phoneBook.get(names));
            }
        }
    }
}