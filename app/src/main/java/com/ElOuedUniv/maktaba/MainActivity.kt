package com.ElOuedUniv.maktaba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.* // مهم جداً لإضافة remember و mutableStateOf
import com.ElOuedUniv.maktaba.data.repository.BookRepository
import com.ElOuedUniv.maktaba.data.repository.CategoryRepositoryImpl
import com.ElOuedUniv.maktaba.domain.usecase.GetBooksUseCase
import com.ElOuedUniv.maktaba.domain.usecase.GetCategoriesUseCase
import com.ElOuedUniv.maktaba.presentation.screens.BookListScreen
import com.ElOuedUniv.maktaba.presentation.screens.CategoryListScreen
import com.ElOuedUniv.maktaba.presentation.theme.MaktabaTheme
import com.ElOuedUniv.maktaba.presentation.viewmodel.BookViewModel
import com.ElOuedUniv.maktaba.presentation.viewmodel.CategoryViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // إعدادات الـ Books (TP1)
        val bookRepository = BookRepository()
        val getBooksUseCase = GetBooksUseCase(bookRepository)
        val bookViewModel = BookViewModel(getBooksUseCase)

        // إعدادات الـ Categories (TP2)
        val categoryRepository = CategoryRepositoryImpl()
        val getCategoriesUseCase = GetCategoriesUseCase(categoryRepository)
        val categoryViewModel = CategoryViewModel(getCategoriesUseCase)

        setContent {
            MaktabaTheme {
                // حالة التبديل بين الشاشات
                var showCategories by remember { mutableStateOf(false) }

                if (showCategories) {
                    CategoryListScreen(
                        viewModel = categoryViewModel,
                        onBackClick = { showCategories = false }
                    )
                } else {
                    BookListScreen(
                        viewModel = bookViewModel,
                        onCategoriesClick = { showCategories = true }
                    )
                }
            }
        }
    }
}