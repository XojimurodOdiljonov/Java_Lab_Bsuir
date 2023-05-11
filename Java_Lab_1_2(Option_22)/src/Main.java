import Models.FKP;
import Models.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> listStudent = new ArrayList<>();
    private static List<FKP> listFKP = new ArrayList<>();
    private static List studentsAdd = new ArrayList<>();
    private static List enrolledStudent = new ArrayList();
    private static final String FILE_PATH1 = "ExistedStudents.data";
    public static void main(String[] args) throws IOException, ClassNotFoundException, MyException {
        while (true){
            System.out.println("\nГлавный меню: \n" +
                    "1. Войти в систему как преподаватель\n" +
                    "2. Регистрация (для студентов)\n" +
                    "3. Сохранить\n" +
                    "4. Загрузить\n" +
                    "5. Показать\n" +
                    "0. Выход");

            switch (scanner.nextInt()){
                case 1:TeacherMenu();break;
                case 2:RegistryStudent();break;
                case 3:Save();break;
                case 4:Load();break;
                case 5:ShowList();break;
                case 0:System.exit(0);
            }
        }
    }

    private static void TeacherMenu() {
        System.out.println("\nВведите ID учителя чтобы войти: ");
        int IDTeacher = scanner.nextInt();
        if (IDTeacher == 1111){
            System.out.println("------------------\n" +
                    "1. Показать поступающих студентов\n" +
                    "2. Показать зачисленных студентов");

            int choosingMenu = scanner.nextInt();
            switch (choosingMenu){
                case 1:
                    System.out.println("Студенты: ");
                    for (int i = 0; i < studentsAdd.size(); i++)
                        System.out.println(i + ") " + studentsAdd.get(i));
                    System.out.println("\nВыберите студента чтобы оценить: ");
                    int choosingStudent = scanner.nextInt();
                    System.out.println("Если студент правильно ответил на все вопросы то ставим - 10 балл\n" +
                            "Если не правильно ответил ставим = 1 балл. И не зачисляем в университет");
                    int estimation = scanner.nextInt();
                    if (estimation == 10){
                        enrolledStudent.add(studentsAdd.get(choosingStudent));
                        System.out.println("Студент зачислен !!!");

                        TeacherMenu();
                    }else if (estimation == 1){
                        System.out.println("Студент не зачислен !!!");
                    }
                    break;
                case 2:
                    System.out.println("Зачисленные студенты: \n");
                    for (int i = 0; i < enrolledStudent.size(); i++)
                        System.out.println(i + ") " + enrolledStudent.get(i));
                    break;
            }
        }else {
            System.out.println("Неправильный ID\n" +
                    "Повторите попытку !");
        }
    }

    private static void RegistryStudent() throws MyException {
        System.out.println("Введите Имя: ");
        String nameStudent = scanner.next();
        System.out.println("Введите возвраст: ");
        int ageStudent = scanner.nextInt();
        if (ageStudent > 50){
            throw new MyException("Универстит принимает студентов до 50 лет");
        }else {
            Student addStudent = new Student(nameStudent, ageStudent);
            listStudent.add(addStudent);

            System.out.println("Приступим к сдаче экзаменов на факультет FKP\n" +
                    "Экзамен по предмету Математика\n" +
                    "Задание: 5 + 5 = \n");
            String questionFirst = scanner.next();

            System.out.println("Экзамен по предмету Физике\n" +
                    "Температура, при которой закипает вода = ");
            String questionSecond = scanner.next();

            FKP createQuestion = new FKP(questionFirst, questionSecond);
            listFKP.add(createQuestion);

            studentsAdd.add(listStudent);
            studentsAdd.add(listFKP);
        }
    }

    private static void Save() throws IOException {
        FileOutputStream fos= new FileOutputStream(FILE_PATH1);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(listStudent);

        System.out.println("\nсохранена!\n");
    }

    private static void Load() throws IOException, ClassNotFoundException {
        System.out.println("\nЗАГРУЗКА ФАЙЛА:");
        FileInputStream fis1 = new FileInputStream(FILE_PATH1);
        ObjectInputStream ois1 = new ObjectInputStream(fis1);
        listStudent = (List<Student>) ois1.readObject();

        System.out.println("\nзагружена!\n");
    }

    private static void ShowList() {
        System.out.println("Сериализованные объекты: ");
        for (int i = 0; i < listStudent.size(); i++)
        System.out.println(i + ") " + listStudent.get(i));
    }
}