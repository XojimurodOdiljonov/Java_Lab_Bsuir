import Models.Bureau;
import Models.PersonBureau;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Bureau> listCustomer = new ArrayList<>();
    private static List<PersonBureau> bureauPersonList = new ArrayList<>();
    private static final String FILE_PATH1 = "ExistedTZ.data";
    private static final String FILE_PATH2 = "ExistedPerson.data";
    public static void main(String[] args) throws MyException {
        MainMenu();
    }

    private static void MainMenu() throws MyException {
        System.out.println("\nГлавный Меню: \n" +
                "1. Создать техническое задание проектирование многоэтажного Дома\n" +
                "2. Показать ТЗ заказчика\n" +
                "3. Создать бригаду для Проекта\n" +
                "4. Показать бригаду\n" +
                "5. Сериализация ТЗ\n" +
                "6. Сериализация бригаду\n" +
                "7. Десериализация ТЗ\n" +
                "8. Десериализация бригаду\n");

        switch (scanner.nextInt()){
            case 1:CreateTechnicalSpecification();break;
            case 2:ShowListCustomer();break;
            case 3:CreateBureau();break;
            case 4:ShowBureau();break;
            case 5:SaveTZ();break;
            case 6:SavePerson();break;
            case 7:LoadTZ();break;
            case 8:LoadPerson();break;
        }
    }

    private static void CreateTechnicalSpecification() throws MyException {
        System.out.println("Выберите Заказчика-застройщика\n" +
                "1. «АСТОДЕВЕЛОПМЕНТ»\n" +
                "2. «Айрон»\n" +
                "3. «Аркуб-сервис»\n" +
                "4. «БелАТЭП»");

        Bureau createBureau = new Bureau();

        switch (scanner.nextInt()){
            case 1:createBureau.setCustomerDeveloper("«АСТОДЕВЕЛОПМЕНТ»");SourceOfFunding(createBureau);break;
            case 2:createBureau.setCustomerDeveloper("«Айрон»");SourceOfFunding(createBureau);break;
            case 3:createBureau.setCustomerDeveloper("«Аркуб-сервис»");SourceOfFunding(createBureau);break;
            case 4:createBureau.setCustomerDeveloper("«БелАТЭП»");SourceOfFunding(createBureau);break;
        }
    }

    private static void SourceOfFunding(Bureau createBureau) throws MyException {
        System.out.println("Выберите источник финансирования: \n" +
                "1. Заемные средства финансовых организаций\n" +
                "2. Собственные средства компаний\n" +
                "3. Государственные заказ\n");

        switch (scanner.nextInt()){
            case 1:createBureau.setSourceOfFunding("Заемные средства финансовых организаций");TypeOfConstruction(createBureau);break;
            case 2:createBureau.setSourceOfFunding("Собственные средства компаний");TypeOfConstruction(createBureau);break;
            case 3:createBureau.setSourceOfFunding("Государственные заказ");TypeOfConstruction(createBureau);break;
        }
    }

    private static void TypeOfConstruction(Bureau createBureau) throws MyException {
        System.out.println("Вид строительство: \n" +
                "1. Проектирование многоэтажного Дома\n" +
                "2. Реконструкция жилого дома");

        switch (scanner.nextInt()){
            case 1:createBureau.setTypeOfConstruction("Проектирование многоэтажного Дома");Location(createBureau);break;
            case 2:createBureau.setTypeOfConstruction("Реконструкция жилого дома");Location(createBureau);break;
        }
    }

    private static void Location(Bureau createBureau) throws MyException {
        System.out.println("Введите локацию строительство: ");
        createBureau.setLocation(scanner.next());

        System.out.println("Введите площадь стоительство: ");
        createBureau.setTotalArea(scanner.nextInt());
        System.out.println("Введите стоимость: ");
        createBureau.setPrice(scanner.nextInt());
        listCustomer.add(createBureau);

        System.out.println("ТЗ Создан!");
        MainMenu();
    }

    private static void ShowListCustomer() throws MyException {
        for (int i = 0; i < listCustomer.size(); i++){
            System.out.println(i + " " + listCustomer.get(i));
        }

        MainMenu();
    }

    private static void CreateBureau() throws MyException {
        System.out.println("Введите имя: ");
        PersonBureau person = new PersonBureau();
        person.setName(scanner.next());
        System.out.println("Введите возвраст: ");
        int addAge = scanner.nextInt();
        if (addAge >= 100){
            throw new MyException("Введите правильный возвраст");
        }else {
            person.setAge(addAge);
            System.out.println("Введите вид деятельности: ");
            person.setTypeOfActivity(scanner.next());
            bureauPersonList.add(person);

            MainMenu();
        }
    }

    private static void ShowBureau() throws MyException {
        for (int i = 0; i < bureauPersonList.size(); i++){
            System.out.println(i + " " + bureauPersonList.get(i));
        }

        MainMenu();
    }

    private static void SaveTZ() {
        try {
            FileOutputStream fos= new FileOutputStream(FILE_PATH1);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(listCustomer);
            oos.close();

            System.out.println("\nTZ сохранена!\n");
            MainMenu();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
    }

    private static void SavePerson() {
        try {
            FileOutputStream fos= new FileOutputStream(FILE_PATH2);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(bureauPersonList);
            oos.close();

            System.out.println("\nСохранена!\n");
            MainMenu();
        } catch (IOException | MyException e) {
            e.printStackTrace();
        }
    }

    private static void LoadTZ() {
        System.out.println("\nЗАГРУЗКА ФАЙЛА:");
        try {
            FileInputStream fis1 = new FileInputStream(FILE_PATH1);
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            listCustomer = (List<Bureau>) ois1.readObject();


            System.out.println("\nTZ загружена!\n");
            MainMenu();
        } catch (IOException | ClassNotFoundException | MyException e) {
            e.printStackTrace();
        }
    }

    private static void LoadPerson() {
        System.out.println("\nЗАГРУЗКА ФАЙЛА:");
        try {
            FileInputStream fis1 = new FileInputStream(FILE_PATH2);
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            bureauPersonList = (List<PersonBureau>) ois1.readObject();


            System.out.println("\nЗагружена!\n");
            MainMenu();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
    }
}