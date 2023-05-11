import Models.Company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    static List<Company> companies = new ArrayList<>();
    private static final String FILE_PATH1 = "ExistedCompany.data";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Company user = new Company();
        while (true){
            System.out.println("Главный меню: \n" +
                    "1. Добавить абонимент\n" +
                    "2. Изменить номер\n" +
                    "3. Показать user\n" +
                    "4. Отключить минуты\n" +
                    "5. Добавить мтнуты\n" +
                    "6. Сохранить\n" +
                    "7. Загрузить\n" +
                    "0. Выход");

            switch (scanner.nextInt()){
                case 1: AddUser(user);break;
                case 2: ChangeNumber();break;
                case 3: ViewUser();break;
                case 4: OffTimeUser();break;
                case 5: AddTimeUser(user);break;
                case 6: Save();break;
                case 7: Load();break;
                case 0: System.exit(0);break;
            }
        }
    }

    private static void AddUser(Company user) {
        System.out.println("Введите имя: ");
        user.setName(scanner.next());
        System.out.println("Введите номер: ");
        user.setNumber(scanner.nextInt());
        companies.add(user);
    }

    private static void ChangeNumber() {
        for(int i = 0; i < companies.size(); i++){
            System.out.println(i + ") " + companies.get(i));
        }
        System.out.println("Выберите номер User для изменения: ");
        int choiceChangeNumber = scanner.nextInt();
        System.out.println("Введите номер: ");
        companies.get(choiceChangeNumber).setNumber(scanner.nextInt());

        for(int i = 0; i < companies.size(); i++){
            System.out.println(i + " " + companies.get(i));
        }
    }

    private static void ViewUser() {
        for(int i = 0; i < companies.size(); i++){
            System.out.println(i + " " + companies.get(i));
        }
    }

    private static void OffTimeUser() {
        for(int i = 0; i < companies.size(); i++){
            if(companies.get(i).getTime() != 0){
                System.out.println(i + " " + companies.get(i));
            }
        }
        System.out.println("Выбрать пользователя что-бы отключить минуты: ");
        int choiceTime = scanner.nextInt();
        companies.get(choiceTime).setTime(0);
    }

    private static void AddTimeUser(Company user) {
        for(int i = 0; i < companies.size(); i++){
            System.out.println(i + " " + companies.get(i));
        }
        System.out.println("Выберите абонимент: ");
        int choiceUser = scanner.nextInt();
        System.out.println(companies.get(choiceUser));
        System.out.println("Добавить минуты: ");
        user.setTime(scanner.nextInt());
    }

    private static void Save() throws IOException {
        FileOutputStream fos= new FileOutputStream(FILE_PATH1);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(companies);
        oos.close();

        System.out.println("\nсохранена!\n");
    }

    private static void Load() throws IOException, ClassNotFoundException {
        System.out.println("\nЗАГРУЗКА ФАЙЛА:");

        FileInputStream fis1 = new FileInputStream(FILE_PATH1);
        ObjectInputStream ois1 = new ObjectInputStream(fis1);
        companies = (List<Company>) ois1.readObject();

        System.out.println("\nзагружена!\n");
    }
}