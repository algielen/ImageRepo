package be.algielen.ImageRepo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ImageRepoApplication

fun main(args: Array<String>) {
	runApplication<ImageRepoApplication>(*args)
}
