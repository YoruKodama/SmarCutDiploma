package com.example.smartcutapp.ui.screen.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ListScreen(
    viewModel: ListViewModel = viewModel()
) {
    val state by viewModel.uiState.collectAsState()

    when (val currentState = state) {
        is ListState.Error -> ListErrorState(currentState, onRefresh ={viewModel.getData()})

        is ListState.Loading -> ListLoadingState()

        is ListState.Content -> ListContentState(currentState)


    }
}


@Composable
private fun ListLoadingState(
){
    Box(Modifier.fillMaxSize()){
      CircularProgressIndicator(
          modifier = Modifier.size(48.dp)
      )
    }
}

@Composable
private fun ListErrorState(
    state: ListState.Error,
    onRefresh: () -> Unit
){
    Box(Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(state.reason)
            Button(
                onClick = onRefresh
            ){
                Text("Refresh")
            }
        }
        CircularProgressIndicator(
            modifier = Modifier.size(48.dp)

        )
    }
}

@Composable
private fun ListContentState(
    state: ListState.Content,
){
    Box(Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        state.users.forEach { users ->
            Row{
                //Image
                Column {
                    Text("")//name
                    Text("")//email
                }
            }

    Column{

            }
        }
        CircularProgressIndicator(
            modifier = Modifier.size(48.dp)

        )
    }
}

