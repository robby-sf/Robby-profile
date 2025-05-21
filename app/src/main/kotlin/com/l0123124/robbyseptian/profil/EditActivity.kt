package com.l0123124.robbyseptian.profil

import android.content.Intent
import android.graphics.drawable.shapes.Shape
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract.Profile
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.l0123124.robbyseptian.profil.ui.theme.ProfilTheme

val timesNewRoman = FontFamily(
    Font(R.font.times_new_roman)
)


class EditActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfilTheme {
                Scaffold(
                    bottomBar = { Menubawah() }
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                            .verticalScroll(rememberScrollState()),
                    ) {
                        ProfilePic()
                        ProfileImage()
                        UserProfile()
                    }
                }

            }
        }
    }
}

@Composable
fun ProfilePic() {
    val context = LocalContext.current
    val notification = rememberSaveable { mutableStateOf("") }
    if (notification.value.isNotEmpty()){
        Toast.makeText(LocalContext.current, notification.value, Toast.LENGTH_LONG).show()
        notification.value = ""
    }


    Column(modifier = Modifier.padding(10.dp)){

        Row(
            modifier = Modifier.fillMaxWidth().padding(10.dp)
            ,horizontalArrangement = Arrangement.SpaceBetween){
            Button(onClick = {
                Toast.makeText(context, "Profile Updated",
                    Toast.LENGTH_LONG).show()}){
                Text("Save")
            }
            Button(onClick = {
                val intent = Intent(context, MainActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                Toast.makeText(context, "Profile Updated",
                Toast.LENGTH_LONG).show()
                context.startActivity(intent)
            }) {Text("Cancel")}
        }
    }
}

@Composable
fun ProfileImage(){
    val imageUri = rememberSaveable{ mutableStateOf("") }
    val painter = rememberAsyncImagePainter(
        if (imageUri.value.isEmpty())
            R.drawable.ic_userbase
        else
            imageUri.value
    )

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent())
    { uri: Uri? ->
        imageUri.value = uri?.toString() ?: ""
    }


    Column(modifier = Modifier.fillMaxWidth().padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Card(shape = CircleShape
            ,modifier = Modifier.padding(10.dp).size(100.dp)){
            Image(painter = painter,
                contentDescription = null,
                modifier = Modifier.wrapContentSize().clickable { launcher.launch("Image/*") },
                contentScale = ContentScale.Crop)
        }
        Text(text = "Change Picture")
    }
}

@Composable
fun UserProfile(){
    Column(modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
        horizontalAlignment = Alignment.Start) {

        Text("Nama : Robby Septian Fajar"
            ,fontFamily = timesNewRoman
            ,fontSize = 20.sp)
        Text("NIM  : L0123124"
            ,fontFamily = timesNewRoman
            ,fontSize = 20.sp)
        Text("Kelas: D"
            ,fontFamily = timesNewRoman
            ,fontSize = 20.sp)
        Text("Prodi: Informatika"
            ,fontFamily = timesNewRoman
            ,fontSize = 20.sp)


    }

}
