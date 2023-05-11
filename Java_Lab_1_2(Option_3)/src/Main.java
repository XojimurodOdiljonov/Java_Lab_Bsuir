import Model.Electrical;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Electrical> elec = new ArrayList<Electrical>();
    private static ArrayList<Electrical> powerOnDevice = new ArrayList<>();
    private static final String FILE_PATH1 = "ExistedDevice.data";
    public static void main(String[] args) {
        while (true){
            System.out.println("\nГлавный Меню: \n" +
                    "1. Создать электроприбор\n" +
                    "2. Подключить приборы\n" +
                    "3. Сумма мощности электроприборов\n" +
                    "4. Сортировка электроприборов\n" +
                    "5. Поиск\n" +
                    "6. Сохранить\n" +
                    "7. Загрузить\n" +
                    "8. Список электроприборов\n" +
                    "0. Выход из программы");

            switch (scanner.nextInt()){
                case 1: CreateElectricalDevice();break;
                case 2: PowerOnDeviceElectrical();break;
                case 3: SumPowerElectricalDevice();break;
                case 4: SortElectricalDevice();break;
                case 5: SearchElectricalDevice();break;
                case 6: SaveDevice();break;
                case 7: LoadDevice();break;
                case 8: ShowListDevice();break;
                case 0: System.exit(0);break;
            }
        }
    }

    private static void CreateElectricalDevice() {
        System.out.println("Выберите электроприбор: \n" +
                "1. Пылесос\n" +
                "2. Стиральныя машина\n" +
                "3. Электрочайник\n");

        Electrical deviceType = new Electrical(true);
        switch (scanner.nextInt()){
            case 1: deviceType.setName("Пылесос");PriceDevice(deviceType);break;
            case 2: deviceType.setName("Стиральныя машина");PriceDevice(deviceType);break;
            case 3: deviceType.setName("Электрочайник");PriceDevice(deviceType);break;
        }
    }

    private static void PriceDevice(Electrical deviceType) {
        System.out.println("Укажите цену: \n");
        deviceType.setPrice(scanner.nextInt());
        System.out.println("Укажите мощность: \n");
        deviceType.setPower(scanner.nextInt());

        elec.add(deviceType);
    }

    private static void PowerOnDeviceElectrical() {
        for (int i = 0; i < elec.size(); i++){
            System.out.println(i + " " + elec.get(i));
        }

        System.out.println("Выберите прибор: ");
        int choiceDevicePowerOn = scanner.nextInt();
        powerOnDevice.add(elec.get(choiceDevicePowerOn));
    }

    private static void SumPowerElectricalDevice() {
        int sum = powerOnDevice.stream().mapToInt(Electrical::getPower).sum();
        System.out.println("Сумма мощностей электроприборов: " + sum);
    }

    private static void SortElectricalDevice() {
            System.out.println("1. По убыванию мощностей\n" +
                    "2. По возврастанию мощностей\n");

            ArrayList<Electrical> copy = new ArrayList<>(elec);

            int selectSort = scanner.nextInt();
            switch (selectSort) {
                case 1:
                    Collections.sort(copy);
                    Collections.reverse(copy);
                    System.out.println(copy);
                    break;
                case 2:
                    Collections.sort(copy);
                    System.out.println(copy);
                    break;
            }
    }

    private static void SearchElectricalDevice() {
            System.out.println("Поис по цене - \n" +
                    "Ведите минимальную цену:");
            int minimumPrice = scanner.nextInt();
            System.out.println("Ведите максимальную цену:");
            int maximumPrice = scanner.nextInt();

            List<Electrical> filtered = elec
                    .stream()
                    .filter(t -> t.getPrice() <= maximumPrice && t.getPrice() >= minimumPrice)
                    .collect(Collectors.toList());
            System.out.println(filtered);
    }

    private static void SaveDevice() {
        try {
            FileOutputStream fos= new FileOutputStream(FILE_PATH1);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(elec);
            oos.close();

            System.out.println("\nСохранена!\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void LoadDevice() {
        System.out.println("\nЗАГРУЗКА ФАЙЛА:");
        try {
            FileInputStream fis1 = new FileInputStream(FILE_PATH1);
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            elec = (List<Electrical>) ois1.readObject();

            System.out.println("\nЗагружена!\n");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void ShowListDevice() {
        for (int i = 0; i < elec.size(); i++){
            System.out.println(i + " " + elec.get(i));
        }
    }
}