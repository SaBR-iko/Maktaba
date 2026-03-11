package com.ElOuedUniv.maktaba.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ElOuedUniv.maktaba.data.model.Category
import com.ElOuedUniv.maktaba.presentation.viewmodel.CategoryViewModel

@Composable
fun CategoryListScreen(
    viewModel: CategoryViewModel,
    onBackClick: () -> Unit
) {
    val categories by viewModel.categories.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(onClick = onBackClick) { Text("Back") }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(categories) { category ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = category.name, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                        Text(text = category.description, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}