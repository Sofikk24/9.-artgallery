package com.example.artgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.artgallery.ui.theme.ArtgalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtgalleryTheme {
                NavigationApp()
            }
        }
    }
}

@Composable
fun NavigationApp() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopNavigationBar(navController)
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {
            composable("home") { HomePage() }
            composable("artworks") { ArtworksPage() }
            composable("contacts") { ContactsPage() }
        }
    }
}

@Composable
fun TopNavigationBar(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Button(
            onClick = { navController.navigate("home") },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
        ) {
            Text(text = "Главная", color = Color.White)
        }
        Button(
            onClick = { navController.navigate("artworks") },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
        ) {
            Text(text = "Произведения", color = Color.White)
        }
        Button(
            onClick = { navController.navigate("contacts") },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
        ) {
            Text(text = "Контакты", color = Color.White)
        }
    }
}

@Composable
fun HomePage() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.main),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "«Современное искусство такое непонятное» — фраза, которую мы не раз слышали от своих знакомых. Но давно прошли те времена, когда про картины рассказывали заумными словами нудным голосом. Поход в арт-галерею Екатеринбурга теперь развлечение, ничуть не уступающее выходным в развлекательном центре, а в некотором смысле даже круче! Именно здесь вы можете узнать интересные факты, о которых не написано в учебнике, встретиться с художниками, попасть на концерт и, возможно, даже сами поучаствуете в перформансе.",
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Sinara ArtGallery",
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.main2),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Галерея Екатеринбурга, где нередко встретишь известных блогеров. И это не случайно! Здесь можно запланировать ламповый вечер с подругой, после которого память будет забита фотографиями, как в Pinterest. Сначала познакомьтесь с работами современных художников и дизайнеров. В фонде галереи более 1 500 работ российских и уральских мастеров, так что каждый найдет то самое творение, которое западет в душу. Особенно советуем сделать это в формате авторской экскурсии, которую нередко можно встретить в афише.\n" +
                        "\n" +
                        "После этого рекомендуем прогуляться по территории комплекса «Синара Центр» и сделать вечерние фотки под гирляндой. А куда же дальше? Время заглянуть в ресторан DOLCE, попробовать метровую пиццу и обсудить современных художников.",
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Сколько стоит",
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Билеты — от 100 руб.",
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun ArtworksPage() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.pro1),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.pro2),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.pro3),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ContactsPage() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = "Россия, г. Екатеринбург,\n" +
                        "Верх-Исетский бульвар, 15/4, Синара Центр",
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Электронная почта: center@sinara-center.com\nПриемная генерального директора: +7 (343) 350-22-00\n" +
                        "Кассы «Синара Центра»: +7 (343) 358-99-96",
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    ArtgalleryTheme {
        NavigationApp()
    }
}
