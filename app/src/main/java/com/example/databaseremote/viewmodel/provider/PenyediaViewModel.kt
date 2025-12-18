package com.example.databaseremote.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.databaseremote.repositori.AplikasiDataSiswa
import com.example.databaseremote.viewmodel.EntryViewModel

fun CreationExtras.asplikasiDataSiswa(): AplikasiDataSiswa = (
        this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiDataSiswa
        )
object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer { HomeViewModel(asplikasiDataSiswa().container.repositoryDataSiswa) }
        initializer { EntryViewModel(asplikasiDataSiswa().container.repositoryDataSiswa) }
    }
}