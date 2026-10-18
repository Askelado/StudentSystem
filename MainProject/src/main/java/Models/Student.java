package Models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Student {

    public static int idCounter = 100;
    private int id;
    private String name;
    private String major;
    private Double gradeNum;
    private String gradeLetter;

   static HashMap<Integer,Student> hash = new HashMap<>();

    public Student(String name, String major,Double gradeNum, String gradeLetter) {
        this.id = idCounter;
        idCounter++;
        this.name = name;
        this.major=major;
        this.gradeNum = gradeNum;
        this.gradeLetter = gradeLetter;
        hash.put(id,this);
    }

    public static double getAverageGrade(){
      Double result = hash.values().stream().filter(s->s.getGradeNum()>0).collect(Collectors.averagingDouble(i -> i.getGradeNum()));
      return result;
    }

    public int getId() {
        return id;
    }

    static {
        Path path = Path.of("src/main/java/ControllerPakage/final_project/Students.txt");
        boolean file;

        try {
            file = Boolean.parseBoolean(String.valueOf(Files.readString(path).isBlank()).trim());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (file){

        }
        else {
            try {
                HelperClass.saveDataInHash();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGradeNum() {
        return gradeNum;
    }

    public void setGradeNum(Double gradeNum) {
        this.gradeNum = gradeNum;
        setGradeLetter();
    }

    public String getGradeLetter() {
        return gradeLetter;
    }

    public void setGradeLetter() {

        switch (gradeNum.intValue()) {
            case 60, 61, 62, 63, 64 -> gradeLetter = "D";
            case 65, 66, 67, 68, 69 -> gradeLetter = "D+";
            case 70, 71, 72, 73, 74 -> gradeLetter = "C";
            case 75, 76, 77, 78, 79 -> gradeLetter = "C+";
            case 80, 81, 82, 83, 84 -> gradeLetter = "B";
            case 85, 86, 87, 88, 89 -> gradeLetter = "B+";
            case 90, 91, 92, 93, 94 -> gradeLetter = "A";
            case 95, 96, 97, 98, 99 -> gradeLetter = "A+";
            case 100 -> gradeLetter = "SUPER!";
            default -> gradeLetter = "F";
        }
        this.gradeLetter = gradeLetter;
    }

    public static HashMap<Integer, Student> getHash() {
        return hash;
    }

    public void setHash(HashMap<Integer, Student> hash) {
        Student.hash = hash;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public static void removeFromHash(int Key){
        if (hash.containsKey(Key))
        {
            hash.remove(Key);
        };


    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", gradeNum=" + gradeNum +
                ", gradeLetter='" + gradeLetter + '\'' +
                '}';
    }
}
