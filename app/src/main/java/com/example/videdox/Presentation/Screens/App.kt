package com.example.videdox.Presentation.Screens

import android.Manifest
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.videdox.Presentation.Navigation.AppNavigation
import com.example.videdox.Presentation.Viewmodel.viewmodel

import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun App(modifier: Modifier , viewModel: viewmodel = hiltViewModel()){
    val mediaPermission = rememberPermissionState(permission = Manifest.permission.READ_MEDIA_VIDEO)


    val mediaPermissionLauncher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()){
        if(it){
            viewModel.ShowUi.value = true

        }else{
            viewModel.ShowUi.value = false
        }
    }
    LaunchedEffect(key1 = true) {
        if(!mediaPermission.status.isGranted){
            mediaPermissionLauncher.launch(Manifest.permission.READ_MEDIA_VIDEO)
        }
        else {
            viewModel.ShowUi.value = true
                }
        }

    val state = viewModel.ShowUi.collectAsState()
    if(state.value){
        AppNavigation()
    }
    else{
        Box(modifier = modifier.fillMaxSize() , contentAlignment = Alignment.Center)
        {
            Text(text = "Permission Not Granted")
        }
    }        
    }

