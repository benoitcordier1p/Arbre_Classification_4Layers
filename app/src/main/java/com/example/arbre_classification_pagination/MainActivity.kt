package com.example.arbre_classification_pagination

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.arbre_classification_pagination.ui.theme.Arbre_Classification_PaginationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Arbre_Classification_PaginationTheme {

                val viewModel : TreesListViewModel = hiltViewModel()
                val treeList = viewModel.state.collectAsLazyPagingItems()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LazyColumn(content = {
                        items(treeList){
                            Card(
                                Modifier.padding(10.dp),
                                shape = RoundedCornerShape(16.dp),
                                elevation = 8.dp
                            ){
                                Column(Modifier.fillMaxSize()) {
                                    Text(text = it?.id.orEmpty())
                                    Text(text = it?.espece.orEmpty())
                                    Text(text = it?.adresse.orEmpty())
                                }
                            }
                        }
                        when (treeList.loadState.append) {
                            is LoadState.NotLoading -> item { Text(text = "NOT LOADING") }
                            is LoadState.Loading -> item { Text(text = "LOADING") }
                            is LoadState.Error -> item { Text(text = "ERROR") }
                            else -> { }
                        }
                    })
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Arbre_Classification_PaginationTheme {
        Greeting("Android")
    }
}