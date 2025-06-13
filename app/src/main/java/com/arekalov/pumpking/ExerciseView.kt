package com.arekalov.pumpking

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arekalov.commonui.ui.theme.LocalPaletteColors
import com.arekalov.commonui.ui.theme.PumpkingTheme

@Composable
internal fun ExerciseImageView(
    exerciseCategory: ExerciseCategory = ExerciseCategory.OTHER,
    @DrawableRes image: Int? = null,
) {
    val borderColor = when (exerciseCategory) {
        ExerciseCategory.ARMS -> LocalPaletteColors.current.accentRed
        ExerciseCategory.SHOULDERS -> LocalPaletteColors.current.accentLightBlue
        ExerciseCategory.FULLBODY -> LocalPaletteColors.current.accentOrange
        ExerciseCategory.LEGS -> LocalPaletteColors.current.accentYellow
        ExerciseCategory.CHEST -> LocalPaletteColors.current.accentGreen
        ExerciseCategory.CORE -> LocalPaletteColors.current.accentPurple
        ExerciseCategory.CARDIO -> LocalPaletteColors.current.accentCyan
        ExerciseCategory.OTHER -> LocalPaletteColors.current.accentGrey
        ExerciseCategory.BACK -> LocalPaletteColors.current.accentBlue
    }
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .border(width = 2.dp, shape = CircleShape, color = borderColor)
            .size(40.dp)
    ) {
        if (image != null) {
            androidx.compose.foundation.Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier.clip(CircleShape),
            )
        } else {
            Box(modifier = Modifier
                .background(MaterialTheme.colorScheme.onSecondaryContainer)
                .size(40.dp))
        }
    }
}

@Suppress("detekt:LongMethod")
@Composable
internal fun ExerciseCardView(
    modifier: Modifier = Modifier,
    onAddSetClicked: () -> Unit,
    exerciseState: ExerciseState,
) {
    Column(
        modifier = modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.onSecondaryContainer)
                    .border(width = 2.dp, shape = CircleShape, color = MaterialTheme.colorScheme.primary)
                    .size(40.dp),
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp),
            ) {
                Text(
                    modifier = Modifier.padding(top = 3.dp),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontWeight = FontWeight.Bold,
                    text = exerciseState.title,
                )

                LazyRow(
                    modifier = Modifier.padding(top = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    items(
                        items = exerciseState.sets,
                    ) {
                        ExerciseSetView(
                            exerciseSetState = it,
                        )
                    }
                }
            }

            IconButton(
                onClick = onAddSetClicked,
                modifier = Modifier.size(24.dp),
            ) {
                Icon(
                    modifier = Modifier.size(14.dp),
                    painter = painterResource(R.drawable.plus_icon),
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    contentDescription = "",
                )
            }
        }
    }
}

@Composable
private fun ExerciseSetView(
    exerciseSetState: ExerciseSetState,
    backGroundColor: Color = Color.Transparent,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .background(backGroundColor)
            .conditional(backGroundColor == Color.Transparent) {
                border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.2f),
                    shape = RoundedCornerShape(10.dp)
                )
            }
            .padding(4.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                text = exerciseSetState.weight
            )
            Text(
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.5f),
                text = "кг"
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                text = exerciseSetState.quantity
            )
            Text(
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.5f),
                text = "пвт"
            )
        }
    }
}


@Composable
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
private fun ExerciseCounterPreview() {
    PumpkingTheme {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ExerciseSetView(
                backGroundColor = LocalPaletteColors.current.accentGreenVariant,
                exerciseSetState = ExerciseSetState("10", "7")
            )

            ExerciseSetView(
                exerciseSetState = ExerciseSetState("9999999", "7")
            )

            ExerciseSetView(
                backGroundColor = LocalPaletteColors.current.accentRedVariant,
                exerciseSetState = ExerciseSetState("10", "9999999")
            )
        }
    }
}

@Composable
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
private fun ExerciseCardViewPreview() {
    PumpkingTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ExerciseCardView(
                onAddSetClicked = {},
                exerciseState = ExerciseState(
                    category = ExerciseCategory.ARMS,
                    title = "Жим штанги ляжа",
                    sets = listOf(
                        ExerciseSetState("10", "7"),
                        ExerciseSetState("12", "20"),
                        ExerciseSetState("10", "7"),
                        ExerciseSetState("12", "20"),
                        ExerciseSetState("10", "7"),
                        ExerciseSetState("12", "20"),
                    ),
                )
            )
            ExerciseCardView(
                onAddSetClicked = {},
                exerciseState = ExerciseState(
                    category = ExerciseCategory.LEGS,
                    title = "Разгибание рук на блоке из-за головы стоя на коленях, держа в руках гантель неимоверно" +
                            " большого размера",
                    sets = listOf(
                        ExerciseSetState("109000", "7"),
                        ExerciseSetState("12", "20"),
                        ExerciseSetState("10", "7"),
                        ExerciseSetState("12", "29990"),
                        ExerciseSetState("10", "7"),
                        ExerciseSetState("12", "20"),
                    )
                )
            )

            ExerciseCardView(
                onAddSetClicked = {},
                exerciseState = ExerciseState(
                    category = ExerciseCategory.LEGS,
                    title = "Кранчи",
                    sets = listOf(
                        ExerciseSetState("12", "20"),
                    )
                )
            )
        }
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun ExerciseCategoryPreview() {
    PumpkingTheme {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ExerciseImageView(
                exerciseCategory = ExerciseCategory.SHOULDERS
            )
            ExerciseImageView(
                exerciseCategory = ExerciseCategory.CORE
            )

            ExerciseImageView(
                exerciseCategory = ExerciseCategory.SHOULDERS,
                image = R.drawable.ic_launcher_foreground
            )
        }
    }
}
