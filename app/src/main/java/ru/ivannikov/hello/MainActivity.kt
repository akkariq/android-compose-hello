package ru.ivannikov.hello

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Главная Activity приложения, инициализирующая Compose-интерфейс[cite: 1].
 *
 * @author Иванников Сергей Сергеевич
 * @version 1.0
 * @since 2026-09-03[cite: 1]
 */
class MainActivity : ComponentActivity() {

    /**
     * Точка входа в жизненный цикл Activity[cite: 1].
     *
     * @param savedInstanceState Сохраненное состояние экрана[cite: 1].
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingCard(
                        studentName = "Иванников Сергей Сергеевич",
                        group = "ПИН-б-о-24-1 (2)",
                        teacher = "Щеголев Алексей Алексеевич"
                    )
                }
            }
        }
    }
}

/**
 * Composable-компонент карточки студента с оформлением через Modifier[cite: 1].
 *
 * @param studentName ФИО обучающегося.
 * @param group Академическая группа.
 * @param teacher ФИО преподавателя дисциплины.
 * @param modifier Модификатор внешнего вида и расположения контейнера[cite: 1].
 */
@Composable
fun GreetingCard(
    studentName: String,
    group: String,
    teacher: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .border(2.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(16.dp)),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Hello, Jetpack Compose!",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Студент: $studentName",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Группа: $group",
                    fontSize = 15.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Преподаватель: $teacher",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.outline
                )
            }
        }
    }
}

/**
 * Предпросмотр карточки в среде Android Studio[cite: 1].
 */
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MaterialTheme {
        GreetingCard(
            studentName = "Иванников Сергей Сергеевич",
            group = "ПИН-б-о-24-1 (2)",
            teacher = "Щеголев Алексей Алексеевич"
        )
    }
}