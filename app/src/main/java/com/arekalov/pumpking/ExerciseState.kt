package com.arekalov.pumpking

internal data class ExerciseState(
    val category: ExerciseCategory,
    val title: String,
    val sets: List<ExerciseSetState>,
)

internal data class ExerciseSetState(
    val weight: String,
    val quantity: String,
)

internal enum class ExerciseCategory {
    FULLBODY,
    SHOULDERS,
    CHEST,
    LEGS,
    ARMS,
    CORE,
    CARDIO,
    OTHER,
}
