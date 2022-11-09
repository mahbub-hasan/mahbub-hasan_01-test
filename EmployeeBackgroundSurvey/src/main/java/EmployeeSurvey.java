import Entity.Employee;
import Entity.EmployeeRoot;
import Entity.LivingPlace;
import Entity.ProgrammingSkill;
import com.google.gson.Gson;
import com.nimbusds.jose.util.StandardCharset;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeSurvey {

    private static final String HDFS_PATH = "/user/mahbubhasan/IntermediateExam/";
    private static final String JSON_FILE_NAME = "employee_survey.json";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //List<Employee> employees = new ArrayList<>();
        Employee employee = null;
        String quit;

        do{
            employee = new Employee();

            System.out.println("Enter employee name: ");
            employee.setName(scanner.next());

            System.out.println("Enter employee surname: ");
            employee.setSurname(scanner.next());

            System.out.println("Enter employee age: ");
            employee.setAge(scanner.nextInt());

            LivingPlace livingPlace = new LivingPlace();

            System.out.println("Enter employee city name: ");
            livingPlace.setCityName(scanner.next());

            System.out.println("Enter employee province name: ");
            livingPlace.setProvince(scanner.next());

            employee.setLivingPlace(livingPlace);

            List<ProgrammingSkill> programmingSkills = new ArrayList<>();

            do{
                ProgrammingSkill programmingSkill = new ProgrammingSkill();

                System.out.println("Enter employee programming skill name: ");
                programmingSkill.setName(scanner.next());

                System.out.println("Enter employee programming skill desc: ");
                programmingSkill.setDescription(scanner.next());

                programmingSkills.add(programmingSkill);

                System.out.println("Add more programming skill? [Y/n]: ");
                quit = scanner.next();
            }while (!quit.equals("n"));

            employee.setProgrammingSkill(programmingSkills);

            //employees.add(employee);

            System.out.println("Add more survey info? [Y/n]: ");
            quit = scanner.next();
        }while (!quit.equals("n"));

        //System.out.println(employees.size());

        covertToJson(employee);
    }

    private static void covertToJson(Employee employees) {
        Gson gson = new Gson();
        String s = gson.toJson(employees);
        System.out.println(s);
        saveIntoHDFS(s);

    }

    private static void saveIntoHDFS(String toString) {
        FileSystem hadoopFileSystem = null;
        FSDataOutputStream outputStream = null;
        BufferedWriter bufferedWriter = null;
        try{
            Configuration configuration = new Configuration();
            hadoopFileSystem = FileSystem.get(new URI("hdfs://master:9000"), configuration);

            Path directory = new Path(HDFS_PATH);
            if (hadoopFileSystem.exists(directory)) {
                hadoopFileSystem.delete(directory, true);
            }
            hadoopFileSystem.mkdirs(directory);

            Path jsonFilePath = new Path(HDFS_PATH+JSON_FILE_NAME);
            outputStream = hadoopFileSystem.create(jsonFilePath, true);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharset.UTF_8));
            bufferedWriter.write(toString);
            bufferedWriter.newLine();

            bufferedWriter.close();
            outputStream.close();
            hadoopFileSystem.close();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
