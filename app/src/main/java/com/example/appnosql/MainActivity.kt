package com.example.appnosql

import DBHandler
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appnosql.ui.theme.AppNoSqlTheme
import com.example.appnosql.ui.theme.PurpleGrey40


class MainActivity : ComponentActivity() {


    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @RequiresApi(Build.VERSION_CODES.M)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNoSqlTheme {
                // on below line we are specifying background color for our application
                Surface(
                    // on below line we are specifying modifier and color for our app
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {

                    // on the below line we are specifying the theme as the scaffold.
                    Scaffold(

                        // in scaffold we are specifying the top bar.
                        topBar = {

                            // inside top bar we are specifying background color.
                            TopAppBar(colors = TopAppBarDefaults.centerAlignedTopAppBarColors(),

                                // along with that we are specifying title for our top bar.
                                title = {

                                    // in the top bar we are specifying tile as a text
                                    Text(
                                        // on below line we are specifying
                                        // text to display in top app bar.
                                        text = "GFG",

                                        // on below line we are specifying
                                        // modifier to fill max width.
                                        modifier = Modifier.fillMaxWidth(),

                                        // on below line we are specifying
                                        // text alignment.
                                        textAlign = TextAlign.Center,

                                        // on below line we are specifying
                                        // color for our text.
                                        color = Color.White
                                    )
                                })
                        }) {
                        // on below line we are calling our method to display UI
                        addDataToDatabase(LocalContext.current)
                    }
                }
            }
        }
    }
}

// on below line we are creating battery status function.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun addDataToDatabase(
    context: Context
) {

    val activity = context as Activity
    // on below line creating a variable for battery status
    val courseName = remember {
        mutableStateOf(TextFieldValue())
    }
    val courseDuration = remember {
        mutableStateOf(TextFieldValue())
    }
    val courseTracks = remember {
        mutableStateOf(TextFieldValue())
    }
    val courseDescription = remember {
        mutableStateOf(TextFieldValue())
    }


    // on below line we are creating a column,
    Column(
        // on below line we are adding a modifier to it,
        modifier = Modifier
            .fillMaxSize()
            // on below line we are adding a padding.
            .padding(all = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        var dbHandler: DBHandler = DBHandler(context)

        // on below line we are adding a text for heading.
        Text(
            // on below line we are specifying text
            text = "SQlite Database in Android",
            // on below line we are specifying text color, font size and font weight
            color = PurpleGrey40, fontSize = 20.sp, fontWeight = FontWeight.Bold
        )

        // on below line adding a spacer.
        Spacer(modifier = Modifier.height(20.dp))

        // on below line we are creating a text field.
        TextField(
            // on below line we are specifying value for our email text field.
            value = courseName.value,
            // on below line we are adding on value change for text field.
            onValueChange = { courseName.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Enter your course name") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .fillMaxWidth()
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we are adding single line to it.
            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(20.dp))

        // on below line we are creating a text field.
        TextField(
            // on below line we are specifying value for our email text field.
            value = courseDuration.value,
            // on below line we are adding on value change for text field.
            onValueChange = { courseDuration.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Enter your course duration") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we are adding single line to it.
            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(20.dp))


        // on below line we are creating a text field.
        TextField(
            // on below line we are specifying value for our email text field.
            value = courseTracks.value,
            // on below line we are adding on value change for text field.
            onValueChange = { courseTracks.value = it },
            // on below line we are adding place holder as text
            placeholder = { Text(text = "Enter your course tracks") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we are adding single line to it.
            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(20.dp))

        // on below line we are creating a text field.
        TextField(
            // on below line we are specifying value for our email text field.
            value = courseDescription.value,
            // on below line we are adding on value change for text field.
            onValueChange = { courseDescription.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Enter your course description") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we are adding single line to it.
            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(15.dp))

        // on below line creating a button to check battery charging status
        Button(onClick = {
            dbHandler.addNewCourse(
                courseName.value.text,
                courseDuration.value.text,
                courseDescription.value.text,
                courseTracks.value.text
            )
            Toast.makeText(context, "Course Added to Database", Toast.LENGTH_SHORT).show()
        }) {
            // on below line adding a text for our button.
            Text(text = "Add Course to Database", color = Color.White)
        }

        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(15.dp))

        // on below line creating a button to open view course activity
        Button(onClick = {
            val i = Intent(context, ViewCourses::class.java)
            context.startActivity(i)
        }) {
            // on below line adding a text for our button.
            Text(text = "Read Courses to Database", color = Color.White)
        }
    }
}
