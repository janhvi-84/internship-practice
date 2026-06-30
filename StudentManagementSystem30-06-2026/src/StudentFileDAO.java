import java.io.*;

public class StudentFileDAO {

    public void addStudent(Student student) {

        try {

            FileWriter writer = new FileWriter("students.txt", true);

            writer.write(student.getId() + "," +
                    student.getName() + "," +
                    student.getAge() + "," +
                    student.getCourse() + "\n");

            writer.close();

            System.out.println("Student Added Successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewStudents() {

        try {

            BufferedReader reader = new BufferedReader(new FileReader("students.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                System.out.println("ID : " + data[0]);
                System.out.println("Name : " + data[1]);
                System.out.println("Age : " + data[2]);
                System.out.println("Course : " + data[3]);
                System.out.println("--------------------");
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchStudent(int searchId) {

    try {

        BufferedReader reader = new BufferedReader(new FileReader("students.txt"));

        String line;
        boolean found = false;

        while ((line = reader.readLine()) != null) {

            String[] data = line.split(",");

            int id = Integer.parseInt(data[0]);

            if (id == searchId) {

                System.out.println("\n===== Student Found =====");
                System.out.println("ID : " + data[0]);
                System.out.println("Name : " + data[1]);
                System.out.println("Age : " + data[2]);
                System.out.println("Course : " + data[3]);

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student Not Found.");
        }

        reader.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}

 public void updateStudent(int updateId, String newName, int newAge, String newCourse) {

    try {

        File inputFile = new File("students.txt");
        File tempFile = new File("temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        PrintWriter writer = new PrintWriter(new FileWriter(tempFile));

        String line;
        boolean found = false;

        while ((line = reader.readLine()) != null) {

            String[] data = line.split(",");

            int id = Integer.parseInt(data[0]);

            if (id == updateId) {

                writer.println(updateId + "," + newName + "," + newAge + "," + newCourse);
                found = true;

            } else {

                writer.println(line);

            }
        }

        reader.close();
        writer.close();

        inputFile.delete();
        tempFile.renameTo(inputFile);

        if (found) {
            System.out.println("Student Updated Successfully.");
        } else {
            System.out.println("Student Not Found.");
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
}

public void deleteStudent(int deleteId) {

    try {

        File inputFile = new File("students.txt");
        File tempFile = new File("temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        PrintWriter writer = new PrintWriter(new FileWriter(tempFile));

        String line;
        boolean found = false;

        while ((line = reader.readLine()) != null) {

            String[] data = line.split(",");

            int id = Integer.parseInt(data[0]);

            if (id == deleteId) {

                found = true;

            } else {

                writer.println(line);

            }
        }

        reader.close();
        writer.close();

        inputFile.delete();
        tempFile.renameTo(inputFile);

        if (found) {
            System.out.println("Student Deleted Successfully.");
        } else {
            System.out.println("Student Not Found.");
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
}
}