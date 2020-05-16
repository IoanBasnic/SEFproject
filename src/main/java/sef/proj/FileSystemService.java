package sef.proj;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemService {
   private static final String APPLICATION_FOLDER = ".Schedule";

    public static final Path APPLICATION_HOME_PATH = Paths.get(USER_FOLDER, APPLICATION_FOLDER);

    public static Path getPathToFile(String... path) {
        return APPLICATION_HOME_PATH.resolve(Paths.get(".", path));
    }
}