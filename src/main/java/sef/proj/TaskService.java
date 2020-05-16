package sef.proj;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class TaskService extends UserService {

    private static List<Task> tasks;
    private  static final Path TASK_PATH = FileSystemService.getPathToFile("toDo","tasks.json");

    public static void loadTaskFromFile() throws IOException {

        if (!Files.exists(TASK_PATH)) {
            FileUtils.copyURLToFile(UserService.class.getClassLoader().getResource("tasks.json"), TASK_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        tasks = objectMapper.readValue(TASK_PATH.toFile(), new TypeReference<List<Task>>() {
        });
    }

    public static void addTask(String username, String title, String Content,String time) throws UsernameAlreadyExistException, TaskExistAlreadyException {
        if ( checkUser(username) ) {
            checkTaskExistence(Content);
            tasks.add(new Task(username, title, Content, time));
            persistTask();
        }
    }

    public static boolean checkUser (String username){

        for (User usr : getUsers()) {

            if (Objects.equals(username, usr.getUserName())) {
                return  true;
            }
        }
        return  false;
    }

    private static void checkTaskExistence(String Content) throws TaskExistAlreadyException {
        for (Task tsk : tasks) {
            if (Objects.equals(Content, tsk.getContent()))
                throw new TaskExistAlreadyException(Content);
        }
    }

    private static void persistTask() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(TASK_PATH.toFile(), tasks);
        } catch (IOException e) {
            throw new CouldNotWriteTaskException();
        }
    }

}