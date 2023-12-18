import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            PersonalData personalData = null;
            String[] details =
                    {"Фамилия", "Имя", "Отчество", "Дата рождения", "Номер телефона", "Пол"};
            details = shuffle(details);
//            System.out.println("Введите " + Arrays.toString(details) + " через пробел");
            System.out.print("Введите");
            for (String t : details) {
                System.out.print(" <" + t + ">");
            }
            System.out.println(" через пробел");
            String personalDetails = scanner.nextLine();
            if (personalDetails.equals("exit"))
                isRunning = false;
            else {
                try {
                    personalData = new PersonalData(personalDetails.split(" "), details);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                System.out.println(personalData.getFirstname() + " " +
                        personalData.getMiddleName() + " " +
                        personalData.getLastname() + " " +
                        personalData.getBirthdate() + " " +
                        personalData.getPhoneNumber() + " " +
                        personalData.getGender());

                System.out.println(SaveToFile.save(personalData) ? "Файл сохранен" : "Файл не сохранен");
            }
        }
    }

    public static String[] shuffle(String[] shuffleArray) {
        List<String> strList = Arrays.asList(shuffleArray);
        Collections.shuffle(strList);
        return strList.toArray(shuffleArray);
    }
}