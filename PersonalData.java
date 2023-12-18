import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class PersonalData {
    String firstname;
    String lastname;
    String middleName;
    Date birthdate;
    long phoneNumber;
    char gender;

    public PersonalData(String[] inputDetails, String[] detailRotation) throws Exception {
        if (inputDetails.length != detailRotation.length)
            throw new Exception("Не верное количество введенных данных");
        for (int i = 0; i < inputDetails.length; i++) {
//            "Фамилия", "Имя", "Отчество", "Дата рождения", "Номер телефона", "Пол"
            switch (detailRotation[i]) {
                case "Фамилия" -> lastname = inputDetails[i];
                case "Имя" -> firstname = inputDetails[i];
                case "Отчество" -> middleName = inputDetails[i];
                case "Дата рождения" -> setBirthdate(inputDetails[i]);
                case "Номер телефона" -> setPhoneNumber(inputDetails[i]);
                case "Пол" -> setGender(inputDetails[i]);
                default -> throw new Exception("Что то пошло не так");
            }
        }
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getBirthdate() {
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        return formatter.format(this.birthdate);
    }

    private void setBirthdate(String birthdate) throws Exception {
        String pattern = "dd.MM.yyyy";
        try {
            this.birthdate = new SimpleDateFormat(pattern).parse(birthdate);
        } catch (Exception e) {
            throw new Exception("Дата рождения " + birthdate + " не является форматом " + pattern);
        }
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    private void setPhoneNumber(String phoneNumber) throws Exception {
        try {
            this.phoneNumber = Long.parseLong(phoneNumber);
        } catch (Exception e) {
            throw new Exception("Телефонный номер " + phoneNumber + " не является числом");
        }
    }

    public char getGender() {
        return gender;
    }

    private void setGender(String gender) throws Exception {
        if (gender.length() != 1 || (!gender.equals("m") && !gender.equals("f")))
            throw new Exception("Пол должен быть равен m или f");

        this.gender = gender.charAt(0);
    }
}
