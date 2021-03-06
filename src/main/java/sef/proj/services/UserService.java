package sef.proj.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import sef.proj.exceptions.CouldNotWriteUsersException;
import sef.proj.exceptions.UsernameAlreadyExistException;
import sef.proj.model.User;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

public class UserService {

    private static List<User> users;
    private static final Path USERS_PATH = FileSystemService.getPathToFile("users.json");
    private static String getName;

    public static void loadUsersFromFile() throws IOException {

        if (!Files.exists(USERS_PATH)) {
            FileUtils.copyURLToFile(UserService.class.getClassLoader().getResource("users.json"), USERS_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        users = objectMapper.readValue(USERS_PATH.toFile(), new TypeReference<List<User>>() {
        });
    }

    public static List<User> getUsers(){
        return  users;
    }

    public static boolean addUser(String username, String password, String email,String tag,String phone_number,String role) throws UsernameAlreadyExistException {

        if ( username.matches("^[A-Za-z]+.[A-Za-z]+$") && tag.matches("[a-zA-Z0-9]+")) {
            checkUserDoesNotAlreadyExist(username);
            users.add(new User(username, encodePassword(username, password), email, tag, phone_number, role));
            persistUsers();
            return true;
        }
        return false;
    }

    private static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistException {
        for (User user : users) {
            if (Objects.equals(username, user.getUserName()))
                throw new UsernameAlreadyExistException(username);
        }
    }

    public static String CheckUser(String username, String password)  {
        for (User user : users) {
            if (Objects.equals(username, user.getUserName()) ) {
                getName = username;
                if(user.getRole().equals("Manager"))
                    return "ItsManager";
                else
                    return "ItsEmployee";
            }

        }
        return "nothing";
    }

    public static String getGetName() {
        return getName;
    }

    public static void ChangePassword(String username, String old_password, String new_password)  {
        for (User user : users) {
            if (Objects.equals(username, user.getUserName()) ) {
                user.setPassword(new_password);
            }

        }

    }

    private static void persistUsers() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(USERS_PATH.toFile(), users);
        } catch (IOException e) {
            throw new CouldNotWriteUsersException();
        }
    }

    public static String getName (int position){
        if(TaskService.getSize() == 0)
            return " ";
        int count = 0;
        for (User usr : users) {
            if( count == position) {
                return usr.getUserName();
            }
            count++;
        }
        return null;
    }

    public static String getEmail (int position){

        if(TaskService.getSize() == 0)
            return " ";
        int count = 0;
        for (User usr : users) {
            if( count == position) {
                return usr.getEmail();
            }
            count++;
        }
        return null;
    }

    public static String getTag (int position){

        if(TaskService.getSize() == 0)
            return " ";

        int count = 0;
        for (User usr : users) {
            if( count == position) {
                return usr.getTag();
            }
            count++;
        }
        return null;
    }

    public static int getSize() {
        if(users == null)
            return 0;

        return users.size();
    }
    private static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }



}