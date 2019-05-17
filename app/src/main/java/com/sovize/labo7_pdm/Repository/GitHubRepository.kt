package com.sovize.labo7_pdm.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.sovize.labo7_pdm.Database.GithubDAO
import com.sovize.labo7_pdm.Database.GithubRepo

class GitHubRepository(private val repoDao: GithubDAO){

    @WorkerThread
    suspend fun insert(repo: GithubRepo){
        repoDao.insert(repo)
    }

    fun getAll(): LiveData<List<GithubRepo>> = repoDao.getAllRepos()

    fun nuke() = repoDao.nukeTable()
}