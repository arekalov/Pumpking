package com.arekalov.pumpking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.arekalov.commonui.ui.theme.PumpkingTheme
import kotlin.random.Random

@Suppress("detekt:all")
private fun randomExerciseSet(): ExerciseSetState {
    val weight = Random.nextInt(5, 100).toString()
    val quantity = Random.nextInt(1, 20).toString()
    return ExerciseSetState(weight, quantity)
}

@Suppress("detekt:all")
class MainActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val listEls: List<ExerciseState> = List(15) { index ->
                ExerciseState(
                    category = ExerciseCategory.entries.toTypedArray().random(),
                    title = "Exercise ${index + 1}",
                    sets = List(Random.nextInt(1, 5)) { randomExerciseSet() }
                )
            }

            PumpkingTheme {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier
                        .background(color = MaterialTheme.colorScheme.surface)
                        .padding(8.dp)
                ) {
                    items(listEls, key = {it.title}) {
                        ExerciseCardView(
                            exerciseState = it
                        )
                    }
                }
            }
        }
    }
}
