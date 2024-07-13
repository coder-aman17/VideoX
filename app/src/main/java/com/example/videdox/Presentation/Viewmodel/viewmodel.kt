package com.example.videdox.Presentation.Viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class viewmodel @Inject constructor() : ViewModel() {
    val ShowUi =
        MutableStateFlow(false)

}