package com.example.databaseremote.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.databaseremote.repositori.AplikasiDataSiswa
import com.example.databaseremote.viewmodel.DetailViewModel
import com.example.databaseremote.viewmodel.EditViewModel
import com.example.databaseremote.viewmodel.EntryViewModel
import com.example.databaseremote.viewmodel.HomeViewModel

fun CreationExtras.asplikasiDataSiswa(): AplikasiDataSiswa = (
        this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiDataSiswa
        )
object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer { HomeViewModel(asplikasiDataSiswa().container.repositoryDataSiswa) }
        initializer { EntryViewModel(asplikasiDataSiswa().container.repositoryDataSiswa) }
        initializer {
            DetailViewModel(
                this.createSavedStateHandle(),
                asplikasiDataSiswa().container.repositoryDataSiswa
            )
        }
        initializer {
            EditViewModel(
                this.createSavedStateHandle(),
                asplikasiDataSiswa().container.repositoryDataSiswa
            )
        }
    }
}