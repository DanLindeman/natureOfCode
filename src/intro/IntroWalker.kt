package intro

import javafx.animation.TranslateTransition
import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import javafx.stage.Stage
import javafx.util.Duration
import java.util.*

class Walker(val pane: Pane) {

    var x = pane.width / 2
    var y = pane.height / 2
    val circle = Circle(x, y, 5.0, Color.GREEN)

    fun display() {
        pane.children.addAll(circle)
    }

    fun step() {
        val choice = Random().nextInt(4)
        val translation = TranslateTransition(Duration.millis(1000.0), circle)
        when (choice) {
            0 -> {
                println("Moving Left")
                translation.byX = -10.0
                circle.centerX -= 10.0
            }
            1 -> {
                println("Moving Right")
                translation.byX = 10.0
                circle.centerX += 10.0
            }
            2 -> {
                println("Moving Up")
                translation.byY = -10.0
                circle.centerY -= 10.0
            }
            3 -> {
                println("Moving Down")
                translation.byY = 10.0
                circle.centerY += 10.0
            }
        }
        translation.cycleCount = 1
        translation.play()
    }

    fun step2() {
        circle.translateX = 10.0
        println("Moving Right")
        println(circle.centerX)
    }

}

class WalkerScreen : Application() {
    override fun start(stage: Stage) {
        val pane = Pane()
        val scene = Scene(pane, 200.0, 200.0)
        val w = Walker(pane)
        w.display()
        for (i in 1..5) {
            w.step2()
        }
        stage.scene = scene
        stage.show()

    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(WalkerScreen::class.java)
        }
    }

}