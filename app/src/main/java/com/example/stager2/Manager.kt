package com.example.stager2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stager2.Data.Fruitsdata
import com.example.stager2.model.Fruits
import com.example.stager2.ui.theme.Stager2Theme

class Manager : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Stager2Theme {

                    (
                        Groceryscreen()

                    )
                }
            }
        }
    }


@Composable
fun HomeNav(modifier : Modifier = Modifier) {
    val context = LocalContext.current
    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surfaceVariant
    ) {
        NavigationBarItem(
            selected = false, onClick = {
                context.startActivity(Intent(context, Manager::class.java))
            },
            label = {
                Text(text = "Home")
            },
            icon = {
                Icon(imageVector = Icons.Default.Menu, contentDescription = null)
            })
        NavigationBarItem(selected = false,
            onClick = {
                context.startActivity(Intent(context, Manager::class.java))
            },
            label = {
                Text(text = "cerials")
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = null
                )
            })
        NavigationBarItem(
            selected = true,
            onClick = {
                context.startActivity(Intent(context, Manager::class.java))
            },
            label = {
                Text(text = "Fruits")
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = null
                )
            })
        NavigationBarItem(
            selected = true,
            onClick = {
                context.startActivity(Intent(context, Manager::class.java))
            },
            label = {
                Text(text = "vegetables")
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = null
                )
            })
    }
}
@Composable
fun GroceryHome(listme: Fruitsdata, modifier: Modifier,
               onLikeClick: (Int) -> Unit = {}) {
    val localContext = LocalContext.current
    var like by remember { mutableStateOf(false) }
    Column(modifier = modifier.padding(20.dp)) {
        Box {
            Column {
                Image(
                    painter = painterResource(listme.drawableResourceId),
                    contentDescription = stringResource(listme.stringResourceId),
                    modifier = Modifier
                        .clickable {
                            localContext.startActivity(
                                Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse("https://www.google.com/imgres?q=groceries&imgurl=https%3A%2F%2Fcdn-0.value.co.ke%2Fwp-content%2Fuploads%2F2023%2F06%2Fd6tu_l3chle.jpg&imgrefurl=https%3A%2F%2Fvalue.co.ke%2Fis-grocery-business-profitable-in-kenya%2F&docid=_TNcGfRkyKac6M&tbnid=s-H23w5BbeAnnM&vet=12ahUKEwjBkerf6ZuGAxXAUkEAHW3ZDcEQM3oECBUQAA..i&w=1600&h=1200&hcb=2&ved=2ahUKEwjBkerf6ZuGAxXAUkEAHW3ZDcEQM3oECBUQAA")
                                )
                            )
                        }
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop)
                Text(text = LocalContext.current.getString(listme.stringResourceId))
                Row {
                    IconButton(onClick = {
                        like = !like
                    }) {
                        Icon(
                            imageVector = if (like) {Icons.Filled.Favorite} else {Icons.Default.FavoriteBorder},
                            contentDescription = "Like"
                        )
                    }
                    Spacer(modifier = Modifier.padding(10.dp))
                    IconButton(onClick = {
                        val shareIntent = Intent(Intent.ACTION_SEND)
                        shareIntent.type = "text/plain"
                        shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this is a cool content")
                        localContext.startActivity(Intent.createChooser(shareIntent, "Share"))

                    }) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "share"

                        )
                    }
                    Spacer(modifier = modifier.padding(25.dp))
                    Button(onClick = {
                        localContext.startActivity(
                            Intent(
                                Intent.ACTION_VIEW, Uri.parse(
                                    "https://www.google.com/imgres?q=groceries&imgurl=https%3A%2F%2Fcdn-0.value.co.ke%2Fwp-content%2Fuploads%2F2023%2F06%2Fd6tu_l3chle.jpg&imgrefurl=https%3A%2F%2Fvalue.co.ke%2Fis-grocery-business-profitable-in-kenya%2F&docid=_TNcGfRkyKac6M&tbnid=s-H23w5BbeAnnM&vet=12ahUKEwjBkerf6ZuGAxXAUkEAHW3ZDcEQM3oECBUQAA..i&w=1600&h=1200&hcb=2&ved=2ahUKEwjBkerf6ZuGAxXAUkEAHW3ZDcEQM3oECBUQAA"
                                )
                            )
                        )
                    }) {
                        Text(text = "Buy")
                    }
                }
            }
        }
    }

}
@Composable
fun Grocerylist(items: List<Fruitsdata>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(items) { listme ->
            GroceryHome(
                listme = listme,
                modifier = Modifier.padding(8.dp)

            )
        }
    }
}

@Composable
fun Groceryscreen(modifier: Modifier = Modifier) {
    Column(modifier) {
        Spacer(Modifier.padding(horizontal = 20.dp))
        HomeNav(modifier.fillMaxWidth())
        Grocerylist(
            items = Fruits().loadmygroceries()
        )
    }
}



        @Preview(showBackground = true)
        @Composable
        fun GreetingPreview() {
            Stager2Theme {
                Groceryscreen()
            }
        }

