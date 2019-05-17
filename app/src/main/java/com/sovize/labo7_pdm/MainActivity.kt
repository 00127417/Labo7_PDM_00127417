package com.sovize.labo7_pdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sovize.labo7_pdm.Database.GithubRepo
import com.sovize.labo7_pdm.ViewModels.GitHubRepoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(GitHubRepoViewModel::class.java)

        button.setOnClickListener {
            val name = editText.text.toString()
            if (name.isNotEmpty() && name.isNotBlank()){
                viewModel.insert(GithubRepo(name))
            }
        }

        viewModel.getAll().observe(this, Observer {
            repos ->
            Log.d("LISTA DE REPOS ", "_____________________________________________________________________")

            for (repo in repos){
            Log.d("LISTA DE REPOS ", repo.name)
        }
        })
    }
}
