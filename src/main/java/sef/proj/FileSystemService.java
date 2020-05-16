package sef.proj;

import org.w3c.dom.ls.LSOutput;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemService {
 /*name of the created folder */  private static final String APPLICATION_FOLDER = ".schedule";
 /* whew u find the folder  */   private static final String USER_FOLDER = System.getProperty("user.home");
    public static final Path APPLICATION_HOME_PATH = Paths.get(USER_FOLDER, APPLICATION_FOLDER);

    public static Path getPathToFile(String... path) {
        return APPLICATION_HOME_PATH.resolve(Paths.get(".", path));
    }
}