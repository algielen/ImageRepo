package be.algielen.imagerepo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.nio.file.Paths

@SpringBootApplication
class ImageRepoApplication

fun main(args: Array<String>) {
	runApplication<ImageRepoApplication>(*args) {
		val directoryScanner = DirectoryScanner()
		val folder = Paths.get(".")
		directoryScanner.walkDirectory(folder)

		println("Directories : ${directoryScanner.directories}")
	}
}
