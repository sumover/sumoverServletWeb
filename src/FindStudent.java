import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

class Student {
    //姓名、出生日期、所属学院、专业、年级、班号
    private String name, colldge, major, Number;
    private Date birth;
    private Integer Classes, grade;

    public Student() {
    }

    public Student(String name, String colldge, String major, String Number, Date birth, Integer classes, Integer grade) {
        this.name = name;
        this.colldge = colldge;
        this.major = major;
        this.birth = birth;
        Classes = classes;
        this.grade = grade;
        this.Number = Number;
    }

    @Override
    public String toString() {
        return "Student[" +
                "name='" + name + '\'' +
                ", colldge='" + colldge + '\'' +
                ", major='" + major + '\'' +
                ", Number='" + Number + '\'' +
                ", birth=" + birth +
                ", Classes=" + Classes +
                ", grade=" + grade +
                ']';
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColldge() {
        return colldge;
    }

    public void setColldge(String colldge) {
        this.colldge = colldge;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getClasses() {
        return Classes;
    }

    public void setClasses(Integer classes) {
        Classes = classes;
    }
}

class NotFindStudent extends Exception {
    @Override
    public void printStackTrace() {
    }
}

public class FindStudent {
    private static int getInt(String string) {
        int t = 0;
        for (int i = 0, len = string.length(); i < len; ++i)
            t = t * 10 + string.charAt(i) - '0';
        return t;
    }

    public static Student getStudentByNumber(String number) throws NotFindStudent {
        Student student = null;
        try {
            System.setIn(new FileInputStream(new File("D:\\Java\\ServletWebApp\\src\\main\\webapp\\students.txt")));
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                student = format(scanner.nextLine());
                if (student.getNumber().equals(number)) {
                    scanner.close();
                    return student;
                }
            }
            scanner.close();
            throw new NotFindStudent();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return student;
    }

    private static Student format(String line) {
        Student student = new Student();
        String st = "";
        char c;
        int index = 0, length = line.length();
        do {///name
            c = line.charAt(index++);
            if (c == ' ') {
                student.setNumber(st);
                st = "";
                break;
            } else {
                st += c;
            }
        } while (index < length);
        do {///name
            c = line.charAt(index++);
            if (c == ' ') {
                student.setName(st);
                st = "";
                break;
            } else {
                st += c;
            }
        } while (index < length);
        int year = 0, mouth = 0, day = 0;
        do {///
            c = line.charAt(index++);
            if (c == ' ') {
                year = getInt(st);
                st = "";
                break;
            } else {
                st += c;
            }
        } while (index < length);
        do {///name
            c = line.charAt(index++);
            if (c == ' ') {
                mouth = (getInt(st));
                st = "";
                break;
            } else {
                st += c;
            }
        } while (index < length);

        do {
            c = line.charAt(index++);
            if (c == ' ') {
                day = getInt(st);
                student.setBirth(new Date(year, mouth, day));
                st = "";
                break;
            } else {
                st += c;
            }
        } while (index < length);
        do {///name
            c = line.charAt(index++);
            if (c == ' ') {
                student.setColldge(st);
                st = "";
                break;
            } else {
                st += c;
            }
        } while (index < length);
        do {///name
            c = line.charAt(index++);
            if (c == ' ') {
                student.setMajor(st);
                st = "";
                break;
            } else {
                st += c;
            }
        } while (index < length);
        do {///name
            c = line.charAt(index++);
            if (c == ' ') {
                student.setGrade(getInt(st));
                st = "";
                break;
            } else {
                st += c;
            }
        } while (index < length);
        do {///name
            c = line.charAt(index++);
            if (c == ' ') {
                break;
            } else {
                st += c;
            }
        } while (index < length);
        student.setClasses(getInt(st));
        return student;
    }
}
