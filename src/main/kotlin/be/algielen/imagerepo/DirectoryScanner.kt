package be.algielen.imagerepo

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.nio.file.Files
import java.nio.file.Path
import java.time.Duration
import java.time.Instant

class DirectoryScanner(val directories: ArrayList<Path> = ArrayList(),
                       val files: ArrayList<Path> = ArrayList(),
                       val errors: ArrayList<Path> = ArrayList()
) {
    private var logger: Logger = LoggerFactory.getLogger("DirectoryScanner")

    fun walkDirectory(path: Path) {
        logger.info("Starting the scan of $path")
        val start = Instant.now()
        val walker = Files.walk(path)
        walker.use {
            walker.forEach {
                if (Files.isDirectory(it)) {
                    directories.add(it)
                } else if (Files.isRegularFile(it)) {
                    files.add(it)
                } else {
                    errors.add(it)
                    logger.error("Failed to detect type of {}", it)
                }
            }
        }
        val end = Instant.now()
        val duration = Duration.between(start, end)
        logger.info("Scan complete, it took ${duration.toSeconds()}.${duration.toMillisPart()}s")
        logger.info("Number of directories : ${directories.size}")
        logger.info("Number of files : ${files.size}")
        logger.info("Number of errors : ${errors.size}")
    }
}