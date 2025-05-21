package com.l0123124.robbyseptian.profil

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.l0123124.robbyseptian.profil.ui.theme.ProfilTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    ProfilTheme {
        Scaffold(
            bottomBar = { Menubawah() }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(top = 10.dp, start = 10.dp, end = 10.dp)
            ) {
                AccountName()
                AccountProfile()
                AccountAlias()
                Social()
                EditAndShare()
                Menuatas()
                Griddisimpan()
            }

        }
    }
}

@Composable
fun AccountName(){
    val nama: String = " Robby Septian Fajar"
    val notification = rememberSaveable { mutableStateOf(" $") }
    if (notification.value.isNotEmpty()){
        Toast.makeText(LocalContext.current, notification.value, Toast.LENGTH_LONG).show()
        notification.value = ""
    }
    Column(modifier = Modifier.fillMaxWidth().padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) { Text(text= nama, modifier = Modifier.clickable{notification.value = "Halo $nama"}) }

}

@Composable
fun AccountProfile(){
    Column(modifier = Modifier.fillMaxWidth().padding(top = 20.dp, bottom = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(R.drawable.ic_userbase),
                contentDescription = " Profile Picture",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape),
                contentScale = ContentScale.Crop

        )
    }
}

@Composable
fun AccountAlias(){
    val alias: String = "robbysf123"
    Column(modifier = Modifier.fillMaxWidth().padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) { Text(text = "@$alias") }

}

@Composable
fun Social(){
    var url: String = "https://www.instagram.com/robby.sf_?igsh=MW5wYjU5bnZ1NHE0Zg=="
    var igname: String = "Robby.sf_"
    val context = LocalContext.current


    Row(modifier = Modifier.fillMaxWidth().padding(5.dp).
    clickable{
        val intent = Intent(Intent.ACTION_VIEW,
            Uri.parse(url))
        context.startActivity(intent)},
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = rememberAsyncImagePainter(R.drawable.logo_ig),
            contentDescription = " Profile Picture",
            modifier = Modifier
                .size(20.dp)

        )
        Text(text = igname)
    }
}

@Composable
fun EditAndShare(){
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxWidth().padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Row (modifier = Modifier.fillMaxWidth().padding(10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly) {

            Button(onClick = {
                val intent = Intent(context, EditActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                context.startActivity(intent)
            }) {Text("Edit Profile")}

            Button(onClick = {
                Toast.makeText(context, "Fitur masih dalam pengembangan",
                    Toast.LENGTH_LONG).show()}){
                Text("Share Profile")
            }
        }


    }
}

@Composable
fun Menuatas(){
    Column(modifier = Modifier.fillMaxWidth().padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Image(
            painter = rememberAsyncImagePainter(R.drawable.menu_atas),
            contentDescription = " Profile Picture",
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                ,contentScale = ContentScale.Crop

        )
    }

}

data class GridItem(val name: String, val imageRes: Int)


@Composable
fun Griddisimpan() {
    val listGambar = listOf(
        GridItem("Pura", R.drawable.pura),
        GridItem("Raja Ampat", R.drawable.raja_ampat),
        GridItem("Bali", R.drawable.bali),
        GridItem("Girisubo", R.drawable.girisubo_jogja),
        GridItem("Candi Baratan", R.drawable.candi_baratan),
        GridItem("Pura", R.drawable.pura),
        GridItem("Raja Ampat", R.drawable.raja_ampat),
        GridItem("Bali", R.drawable.bali),
        GridItem("Girisubo", R.drawable.girisubo_jogja),
        GridItem("Candi Baratan", R.drawable.candi_baratan),
        GridItem("Pura", R.drawable.pura),
        GridItem("Raja Ampat", R.drawable.raja_ampat),
        GridItem("Bali", R.drawable.bali),
        GridItem("Girisubo", R.drawable.girisubo_jogja),
        GridItem("Candi Baratan", R.drawable.candi_baratan),

    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(listGambar) { item ->
            Box(
                modifier = Modifier
                    .background(Color.LightGray)
                    .aspectRatio(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = item.imageRes),
                    contentDescription = item.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}


@Composable
fun Menubawah(){
    Column(modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom){
        Image(
            painter = rememberAsyncImagePainter(R.drawable.menu_bawah),
            contentDescription = " Profile Picture",
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                ,contentScale = ContentScale.Crop


        )
    }

}



@Preview (showBackground = true)
@Composable
fun DefaultPreview(){
        MainScreen()

}


