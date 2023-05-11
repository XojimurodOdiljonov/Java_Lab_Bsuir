import Model.Doctor;
import Model.Laboratories;
import Model.Medicines;
import Model.Patients;

import java.io.*;
import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Doctor> existingDoctors = new ArrayList<>();
    private static List<Patients> existingPatients = new ArrayList<>();
    private static List<Medicines> existingMedicines = new ArrayList<>();
    private static List<Laboratories> existingLaboratories = new ArrayList<>();
    private static List assignDoctorToPatients = new ArrayList<>();
    private static List assignMedicinesToPatients = new ArrayList<>();
    private static List assignMedicinesToLaboratories = new ArrayList();
    private static final String FILE_PATH1 = "ExistedDoctors.data";
    private static final String FILE_PATH2 = "ExistedPatients.data";
    private static final String FILE_PATH3 = "ExistedMedicines.data";
    private static final String FILE_PATH4 = "ExistedLaboratories.data";

    public static void main(String[] args) throws MyException {
        while (true){
            System.out.println("Меню: \n" +
                    "1. Доктор\n" +
                    "2. Пациент\n" +
                    "3. Медикаменты\n" +
                    "4. Лаборатория\n" +
                    "5. Назначение\n" +
                    "6. Выписка пациента\n" +
                    "7. Весь список назначений\n" +
                    "8. Сохранить\n" +
                    "9. Загрузить");

            switch (scanner.nextInt()){
                case 1:Doctor();break;
                case 2:Patients();break;
                case 3:Medicines();break;
                case 4:Laboratories();break;
                case 5:Appointment();break;
                case 6:Extract();break;
                case 7:ShowListAllAppointment();
                case 8:Save();break;
                case 9:Load();break;
                }
            }
        }

    private static void Doctor() {
        System.out.println("--------------------\n" +
                "1. Добавить нового специалиста\n" +
                "2. Показать существующих докторов\n");

        int choosingMenu = scanner.nextInt();
        if (choosingMenu == 1){
            System.out.println("Введите Id: ");
            int newIdDoctor = scanner.nextInt();
            System.out.println("Введите ФИО: ");
            String FIODoctor = scanner.next();
            System.out.println("Введите специальность: ");
            String specialistDoctor = scanner.next();
            System.out.println("Время работы: ");
            String timeWorkDoctor = scanner.next();
            System.out.println("Введите номер кабинета для Доктора: ");
            String roomDoctor = scanner.next();

            Doctor newDoctor = new Doctor(newIdDoctor, FIODoctor, specialistDoctor, timeWorkDoctor, roomDoctor);
            existingDoctors.add(newDoctor);
        }else if (choosingMenu == 2){
            existingDoctors.add(new Doctor(0, "Никитин Владимир Константинович", "Психолог", "5-11AM", "10"));
            existingDoctors.add(new Doctor(1, "Фадеев Максим Артёмович", "Стомотолог", "10-3AM", "15"));
            existingDoctors.add(new Doctor(2, "Андреев Ярослав Иванович", "Окулист", "8-2AM", "8"));
            System.out.println(existingDoctors);
        }
    }

    private static void Patients() throws MyException {
        System.out.println("--------------------\n" +
                "1. Добавить нового пациента\n" +
                "2. Показать существующих пациентов");

        int choosingMenu = scanner.nextInt();
        if (choosingMenu == 1){
            System.out.println("Введите Id: ");
            int newIdPatients = scanner.nextInt();
            System.out.println("Введите ФИО: ");
            String FIOPatients = scanner.next();
            System.out.println("Введите пол - (М или Ж): ");
            String genderPatients = scanner.next();
            System.out.println("Введите возвраст: ");
            int agePatients = scanner.nextInt();
            if (agePatients > 100){
                throw new MyException("Введите меньше 100 лет!");
            }else {
                Patients createNewPatients = new Patients(newIdPatients, FIOPatients, genderPatients, agePatients);
                existingPatients.add(createNewPatients);
            }
        }else if (choosingMenu == 2){
            existingPatients.add(new Patients(0, "Трофимова Амина Семёновна", "Ж", 25));
            existingPatients.add(new Patients(1, "Федоров Дмитрий Арсентьевич", "М", 32));
            existingPatients.add(new Patients(2, "Копылов Илья Артёмович", "М", 20));
            System.out.println(existingPatients);
        }
    }

    private static void Medicines() {
        System.out.println("--------------------\n" +
                "1. Добавить новый медикомент\n" +
                "2. Показать медикоментов\n");

        int choosingMenu = scanner.nextInt();
        if (choosingMenu == 1){
            System.out.println("Введите Id: ");
            int idMedicines = scanner.nextInt();
            System.out.println("Введите название препарата: ");
            String nameMedicines = scanner.next();
            System.out.println("Введите производитель: ");
            String nameCompanyMedicines = scanner.next();
            System.out.println("Введите дату выхода препарата: ");
            String dataMedicines = scanner.next();
            System.out.println("Введите цену: ");
            int priceMedicines = scanner.nextInt();

            Medicines createMedicines = new Medicines(idMedicines, nameMedicines, nameCompanyMedicines, dataMedicines, priceMedicines);
            existingMedicines.add(createMedicines);
        }else if (choosingMenu == 2){
            existingMedicines.add(new Medicines(0,"Тримол", "Uzbekistan", "2023-03-25", 10));
            existingMedicines.add(new Medicines(1,"Артра", "Eagle Nutritionals, Inc США", "2023-01-15", 30));
            existingMedicines.add(new Medicines(2,"Аквалор", "Нижфарм - Россия", "2023-04-10", 20));
            System.out.println(existingMedicines);
        }
    }

    private static void Laboratories() {
        System.out.println("--------------------\n" +
                "1. Добавить новую лабароторию\n" +
                "2. Показать сушествующих лабароторий");

        int choosingMenu = scanner.nextInt();
        if (choosingMenu == 1){
            System.out.println("Введите Id: ");
            int idLaboratories = scanner.nextInt();
            System.out.println("Введите вид лабораторий: ");
            String addFacilities = scanner.next();
            System.out.println("Введите цену: ");
            int priceLaboratories = scanner.nextInt();

            Laboratories createLaboratories = new Laboratories(idLaboratories, addFacilities, priceLaboratories);
            existingLaboratories.add(createLaboratories);
        }else if (choosingMenu == 2){
            existingLaboratories.add(new Laboratories(0,"CT Scan", 1200));
            existingLaboratories.add(new Laboratories(1,"OR Scan", 500));
            existingLaboratories.add(new Laboratories(2,"X-ray", 800));
            System.out.println(existingLaboratories);
        }
    }

    private static void Extract() {
        System.out.println("--------------------\n" +
                "1. Показать пациентов назначенных к доктору\n" +
                "2. Назад");

        int choosingMenu = scanner.nextInt();
        if (choosingMenu == 1){
            for (int i = 0; i < assignDoctorToPatients.size(); i++){
                System.out.println(i + ") " + assignDoctorToPatients.get(i));
            }
            System.out.println("Выбрать пациента чтобы его выписать из больницы");
            int choosingPatient = scanner.nextInt();
            if (choosingPatient <= assignDoctorToPatients.size()) {
                assignDoctorToPatients.remove(choosingPatient);
            }
        }else if (choosingMenu == 2){
            Extract();
        }
    }

    private static void Appointment() {
        System.out.println("--------------------\n" +
                "1. Назначить пациенту доктор\n" +
                "2. Назначить медикомент к пациету\n" +
                "3. Назначить медикоменты на лабораторию\n");

        switch (scanner.nextInt()){
            case 1:AssignDoctorPatient();break;
            case 2:AssignMedicinesToPatients();break;
            case 3:AssignMedicinesToLaboratories();break;
        }
    }

    private static void AssignDoctorPatient() {
        System.out.println("Выберите Доктора: ");
        for(int i = 0; i < existingDoctors.size(); i++){
            System.out.println(i + ") " + existingDoctors.get(i));
        }
        int choosingDoctor = scanner.nextInt();
        assignDoctorToPatients.add(existingDoctors.get(choosingDoctor));
        System.out.println("Выберите Пациента: ");
        for (int i = 0; i < existingPatients.size(); i++){
            System.out.println(i + ") " + existingPatients.get(i));
        }
        int choosingPatients = scanner.nextInt();
        assignDoctorToPatients.add(existingPatients.get(choosingPatients));
    }

    private static void AssignMedicinesToPatients() {
        System.out.println("Выберите Пациента: ");
        for (int i = 0; i < existingPatients.size(); i++){
            System.out.println(i + ") " + existingPatients.get(i));
        }
        int choosingPatients = scanner.nextInt();
        assignMedicinesToPatients.add(existingPatients.get(choosingPatients));
        System.out.println("Выберите Препарат: ");
        for (int i = 0; i < existingMedicines.size(); i++){
            System.out.println(i + ") " + existingMedicines.get(i));
        }
        int choosingMedicines = scanner.nextInt();
        assignMedicinesToPatients.add(existingMedicines.get(choosingMedicines));
    }

    private static void AssignMedicinesToLaboratories() {
        System.out.println("Выберите медикоменты для лаборатории: ");
        for (int i = 0; i < existingMedicines.size(); i++){
            System.out.println(i + ") " + existingMedicines.get(i));
        }
        int choosingMedicines = scanner.nextInt();
        assignMedicinesToLaboratories.add(existingMedicines.get(choosingMedicines));
        System.out.println("Выберите лабораторию: ");
        for (int i = 0; i < existingLaboratories.size(); i++){
            System.out.println(i + ") " + existingLaboratories.get(i));
        }
        int choosingLaboratories = scanner.nextInt();
        assignMedicinesToLaboratories.add(existingLaboratories.get(choosingLaboratories));
    }

    private static void ShowListAllAppointment() {
        System.out.println("--------------------\n" +
                "1. Показать назначеного пациента и доктор\n" +
                "2. Показать назначеного препарата к пациенту\n" +
                "3. Показать назначеного медикоменты на лабораторию");

        switch (scanner.nextInt()){
            case 1:
                System.out.println("Назначенный пациент к врачу: ");
                for (int i = 0; i < assignDoctorToPatients.size(); i++)
                    System.out.println(i + ") " + assignDoctorToPatients.get(i));
                break;
            case 2:
                System.out.println("Назначенный препарат к пациенту: ");
                for (int i = 0; i < assignMedicinesToPatients.size(); i++)
                    System.out.println(i + ") " + assignMedicinesToPatients.get(i));
                break;
            case 3:
                System.out.println("Назначенный медикомент на лабораторию: ");
                for (int i = 0; i < assignMedicinesToLaboratories.size(); i++)
                    System.out.println(i + ") " + assignMedicinesToLaboratories.get(i));
                break;
        }
    }

    private static void Save() {
        try {
            FileOutputStream fos= new FileOutputStream(FILE_PATH1);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(existingDoctors);

            FileOutputStream fos2= new FileOutputStream(FILE_PATH2);
            ObjectOutputStream oos2=new ObjectOutputStream(fos2);
            oos2.writeObject(existingPatients);
            oos.close();

            FileOutputStream fos3= new FileOutputStream(FILE_PATH3);
            ObjectOutputStream oos3=new ObjectOutputStream(fos3);
            oos3.writeObject(existingMedicines);
            oos.close();

            FileOutputStream fos4= new FileOutputStream(FILE_PATH4);
            ObjectOutputStream oos4=new ObjectOutputStream(fos4);
            oos4.writeObject(existingLaboratories);
            oos.close();

            System.out.println("\nсохранена!\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void Load() {
        System.out.println("\nЗАГРУЗКА ФАЙЛА:");
        try {
            FileInputStream fis1 = new FileInputStream(FILE_PATH1);
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            existingDoctors = (List<Doctor>) ois1.readObject();

            FileInputStream fis2 = new FileInputStream(FILE_PATH2);
            ObjectInputStream ois2 = new ObjectInputStream(fis2);
            existingPatients = (List<Patients>) ois2.readObject();

            FileInputStream fis3 = new FileInputStream(FILE_PATH3);
            ObjectInputStream ois3 = new ObjectInputStream(fis3);
            existingMedicines = (List<Medicines>) ois3.readObject();

            FileInputStream fis4 = new FileInputStream(FILE_PATH4);
            ObjectInputStream ois4 = new ObjectInputStream(fis4);
            existingLaboratories = (List<Laboratories>) ois4.readObject();

            System.out.println("\nзагружена!\n");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}