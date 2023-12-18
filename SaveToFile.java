import java.io.FileWriter;
import java.io.IOException;

public abstract class SaveToFile {
    public static boolean save(PersonalData personalData) {
        try (FileWriter fileWriter = new FileWriter(personalData.getLastname(), true)) {
            fileWriter.write("\n" +
                    personalData.getLastname() + " " +
                    personalData.getFirstname() + " " +
                    personalData.getMiddleName() + " " +
                    personalData.getBirthdate() + " " +
                    personalData.getPhoneNumber() + " " +
                    personalData.getGender());
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
