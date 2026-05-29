
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Finance : Screen("finance", "Finance", Icons.Default.Payments)
    object Schedule : Screen("schedule", "Schedule", Icons.Default.CalendarMonth)
    object Attendance : Screen("attendance", "Attendance", Icons.Default.AssignmentInd)
}