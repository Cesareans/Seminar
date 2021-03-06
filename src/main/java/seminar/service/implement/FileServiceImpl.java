package seminar.service.implement;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import seminar.service.FileService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author Cesare
 */
@Service
public class FileServiceImpl implements FileService {
    //private static String UPLOADED_FOLDER = "/home/uploaded";

    private static final String UPLOADED_FOLDER = "F:\\Temp\\";

    @Override
    public Path store(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();

            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            return path;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }

    @Override
    public Path load(String filename) {
        return Paths.get(UPLOADED_FOLDER + filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public String getFileType(MultipartFile file) {
        String fileName = Objects.requireNonNull(file.getOriginalFilename());
        int typeIdx = fileName.lastIndexOf('.') + 1;
        if (typeIdx <= 0) {
            //TODO:Exception handling here
            throw new RuntimeException();
        }
        return fileName.substring(typeIdx).toLowerCase();
    }
}
