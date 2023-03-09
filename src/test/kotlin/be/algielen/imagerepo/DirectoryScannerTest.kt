package be.algielen.imagerepo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.nio.file.Path
import kotlin.io.path.createDirectory
import kotlin.io.path.createFile

class DirectoryScannerTest {
    @Test
    fun readsCorrectNumberOfFiles(@TempDir tempDir: Path) {
        val newDir = tempDir.resolve("newDir")
        newDir.createDirectory()
        for (i in 1..10) {
            val newFile = newDir.resolve("${i}.temp")
            newFile.createFile()
        }

        for (i in 1..10) {
            val newFile = tempDir.resolve("${i}.temp")
            newFile.createFile()
        }

        val directoryScanner = DirectoryScanner()
        directoryScanner.walkDirectory(tempDir)

        //println("Directories : ${directoryScanner.directories}")
        assertThat(directoryScanner.files.size).isEqualTo(20)
        assertThat(directoryScanner.directories.size).isEqualTo(2)
    }
}