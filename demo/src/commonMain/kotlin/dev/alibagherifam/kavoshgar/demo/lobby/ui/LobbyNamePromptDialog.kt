package dev.alibagherifam.kavoshgar.demo.lobby.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.alibagherifam.kavoshgar.demo.lobby.model.isValidLobbyName
import dev.alibagherifam.kavoshgar.demo.theme.AppTheme
import kavoshgar_project.demo.generated.resources.Res
import kavoshgar_project.demo.generated.resources.label_create_lobby
import kavoshgar_project.demo.generated.resources.label_dismiss
import kavoshgar_project.demo.generated.resources.message_lobby_name_selection
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun LobbyNamePromptDialog(
    onCreateButtonClick: (String) -> Unit,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    var inputValue by remember { mutableStateOf("") }
    AlertDialog(
        modifier = modifier,
        onDismissRequest = onDismissRequest,
        text = {
            Column(
                modifier = Modifier.widthIn(min = 280.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(Res.string.message_lobby_name_selection),
                    modifier = Modifier.align(Alignment.End),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(Modifier.size(16.dp))
                OutlinedTextField(
                    value = inputValue,
                    onValueChange = { inputValue = it }
                )
            }
        },
        confirmButton = {
            TextButton(
                modifier = Modifier.widthIn(min = 100.dp),
                onClick = {
                    if (isValidLobbyName(inputValue)) {
                        onCreateButtonClick(inputValue)
                    }
                }
            ) {
                Text(text = stringResource(Res.string.label_create_lobby))
            }
        },
        dismissButton = {
            TextButton(
                modifier = Modifier.width(100.dp),
                onClick = onDismissRequest
            ) {
                Text(text = stringResource(Res.string.label_dismiss))
            }
        }
    )
}

@Preview
@Composable
private fun LobbyNamePromptDialogPreview() {
    AppTheme {
        LobbyNamePromptDialog(
            onCreateButtonClick = {},
            onDismissRequest = {}
        )
    }
}
