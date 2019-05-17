package com.sovize.labo7_pdm.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.sovize.labo7_pdm.Database.GithubRepo
import com.sovize.labo7_pdm.Database.RoomDB
import com.sovize.labo7_pdm.Repository.GitHubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GitHubRepoViewModel(app: Application): AndroidViewModel(app) {
    private val repository: GitHubRepository

    init{
        val repoDao = RoomDB.getInstance(app).repoDao()
        repository = GitHubRepository(repoDao)
    }

    fun insert(repo: GithubRepo) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(repo)
    }

    fun getAll(): LiveData<List<GithubRepo>> = repository.getAll()

    fun nukeAll() = repository.nuke()
}