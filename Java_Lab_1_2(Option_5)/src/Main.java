import Model.Composition;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Composition> compositions = new ArrayList<Composition>();
    private static ArrayList<Composition> record = new ArrayList<Composition>();
    private static final String FILE_PATH1 = "ExistedMusic.data";
    public static void main(String[] args) throws MyException {
        while (true){
            System.out.println("\nГлавный меню: \n" +
                    "1. Создать альбом\n" +
                    "2. Запись на диск сборку\n" +
                    "3. Список альбомов\n" +
                    "4. Общая время продолжительности альбомов\n" +
                    "5. Перестановка\n" +
                    "6. Поиск\n" +
                    "7. Сохранить\n" +
                    "8. Загрузить\n" +
                    "9. Показать сериализованных объектов\n" +
                    "0. Выход");

            switch (scanner.nextInt()){
                case 1: ChoiceAlbum();break;
                case 2: RecordMusic();break;
                case 3: ListAlbum();break;
                case 4: AllTimeAlbum();break;
                case 5: Permutation();break;
                case 6: SearchAlbum();break;
                case 7: Save();break;
                case 8: Load();break;
                case 9: ShowList();break;
                case 0: System.exit(0);break;
            }
        }
    }

    private static void ChoiceAlbum() throws MyException {
        System.out.println("Ведите название альбома: ");
        Composition music = new Composition();
        music.setNameAlbum(scanner.next());

        System.out.println("Укажите продолжительность: ");
        int timeMusic = scanner.nextInt();
        if (timeMusic >= 120){
            throw new MyException("Введите меньше 120 минут");
        }else {
            music.setTimeMusic(timeMusic);
            compositions.add(music);
        }
    }

    private static void RecordMusic() throws MyException {
        System.out.println("Ведите продолжительность: ");
        int timeRecord = scanner.nextInt();

        while (true) {
            System.out.println("Выберите композицию: ");
            for (int i = 0; i < compositions.size(); i++) {
                System.out.println(i + " " + compositions.get(i));
            }
            int choosingMusic = scanner.nextInt();
            record.add(compositions.get(choosingMusic));
            timeRecord -= record.get(choosingMusic).getTimeMusic();

            System.out.println("У вас осталось столько продолжительности: \n" +
                    timeRecord);
        }
    }

    private static void ListAlbum() throws MyException {
        for (int i = 0; i < compositions.size(); i++) {
            System.out.println(i + " " + compositions.get(i));
        }
    }

    private static void AllTimeAlbum() throws MyException {
        int sumTime = compositions.stream().mapToInt(Composition::getTimeMusic).sum();
        System.out.println("Общая время продолжительности: " + sumTime);
    }

    private static void Permutation() throws MyException {
        System.out.println("Список альбомов:--------------------- ");
        for (int i = 0; i < compositions.size(); i++) {
            System.out.println(i + " " + compositions.get(i));
        }
        System.out.println("\nВыберите альбом для перестановки: ");
        int choiceAlbum = scanner.nextInt();
        System.out.println("Ниже выбранный альбом:");
        System.out.println(compositions.get(choiceAlbum));
    }

    private static void SearchAlbum() throws MyException {
        System.out.println("Поис по продолжительности - \n" +
                "Ведите минимальную время:");
        int minimumTime = scanner.nextInt();
        System.out.println("Ведите максимальную время:");
        int maximumTme = scanner.nextInt();

        List<Composition> filtered = compositions
                .stream()
                .filter(t -> t.getTimeMusic() <= maximumTme && t.getTimeMusic() >= minimumTime)
                .collect(Collectors.toList());
        System.out.println(filtered);
    }

    private static void Save() {
        try {
            FileOutputStream fos= new FileOutputStream(FILE_PATH1);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(compositions);
            oos.close();

            System.out.println("\nСохранена!\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void Load() {
        System.out.println("\nЗАГРУЗКА ФАЙЛА:");
        try {
            FileInputStream fis1 = new FileInputStream(FILE_PATH1);
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            compositions = (List<Composition>) ois1.readObject();


            System.out.println("\nЗагружена!\n");
        }  catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void ShowList() {
        for (int i = 0; i < compositions.size(); i++)
            System.out.println(i + ") " + compositions.get(i));
    }
}