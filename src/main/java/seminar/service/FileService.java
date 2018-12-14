package seminar.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * The service must appoint a path in file system as the work directory of the service.
 *
 * @author Cesare
 */
public interface FileService {
    /**
     * Save a multipart file into the directory
     *
     * @param file the multipart file
     * @return the stored file
     * @author Cesare
     */
    Path store(MultipartFile file);

    /**
     * Get all files stored in the directory.
     *
     * @return all files as stream of paths
     * @author Cesare
     */
    Stream<Path> loadAll();

    /**
     * Load a file as path in the directory with given filename
     *
     * @param filename the given filename
     * @return the corresponding path
     * @author Cesare
     */
    Path load(String filename);

    /**
     * Load a file as resource with given filename
     *
     * @param filename the given filename
     * @return the corresponding resource
     * @author Cesare
     */
    Resource loadAsResource(String filename);

    /**
     * Delete all files in the directory.
     *
     * @author Cesare
     */
    void deleteAll();
}
