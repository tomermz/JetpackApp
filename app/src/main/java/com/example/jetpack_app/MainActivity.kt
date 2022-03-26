package com.example.jetpack_app

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.unit.dp
import com.example.jetpack_app.repository.PersonRepository
import com.example.jetpack_app.ui.theme.CustomItem
import org.w3c.dom.Text
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
//import java.lang.reflect.Modifier
import kotlin.text.Typography.section
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import com.example.jetpack_app.ui.theme.LazyColumAppJekPackTheme
import androidx.compose.foundation.lazy.itemsIndexed
import com.example.jetpack_app.ExpandableCard
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpack_app.ui.theme.LazyColumAppJekPackTheme


class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            LazyColumAppJekPackTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ExpandableCard(title = "effi profus",
                        description = "this is my first time card animation , " +
                                " i hope you love it" +
                                "hit is the best place to be  " +
                                "yea its fine jdkjkdjdkjskjsdkdjksdkjskdskjdksjdkjskdj" +
                                "kjdkjdkjdkjsdksjdksjkdjskjdkkdjkdjksdjdksjdkjskdjskj" +
                                "skjsdkjskjsakjskjasjwqijqienwinwneweinwieniwdm")
                }
            }

            LazyColumAppJekPackTheme {
                // We initialize the repository
                val sections = listOf("A", "B", "C", "D", "E", "F", "G") // List of multiple strings
                val personRepository =
                    PersonRepository() // The variable that represent the repository
                val getAllData =
                    personRepository.getAllData() // represent all the values in the data

                LazyColumn(
                    verticalArrangement = Arrangement.spaceBy(12.dp) // The space in each shown item is 12.dp
                ) {
                    sections.forEach { section ->
                        stickyHeader {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.LightGray)
                                    .padding(12.dp),
                                text = "Section $section"
                            )
                        }
                        // We load this Sticky Headers items from the list
                        // For each item in the section list, we specify all those items
                        items(10) {
                            Text(
                                modifier = Modifier.padding(12.dp),
                                text = "Item $it from the section $section")
                        }
                    }
                    /**itemsIndexed(
                    items = getAllData,
                    key = { index, person -> person.id
                    }
                    ) { index, person ->
                    Log.d("MainActivity", index.toString())
                    CustomItem(person = person)
                    }*/
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
        LazyColumAppJekPackTheme {
            Greeting("Android")
        }
    }
}


