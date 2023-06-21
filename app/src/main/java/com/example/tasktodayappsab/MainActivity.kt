package com.example.tasktodayappsab
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasktodayappsab.model.Tarefa.Tarefa
import kotlinx.coroutines.launch
import java.util.Date
import java.util.Locale




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           MainScreenContent(DrawerState(initialValue = DrawerValue.Closed))
        }
    }
}


@Composable
fun MainScreenContent(drawerState: DrawerState) {

    val scaffoldState = rememberScaffoldState( drawerState = drawerState)
    val scope = rememberCoroutineScope()
  Scaffold(
      scaffoldState = scaffoldState,

      topBar = {

          TopAppBar(
              title = { Text(text = "Daily Tasks :)", color = Color.White)},
              backgroundColor = Color(0xFFF845BE),
              navigationIcon = {
                  IconButton(onClick = {
                     scope.launch{
                      scaffoldState.drawerState.open()}
                  }){
                  Icon(
                      imageVector = Icons.Default.Menu,
                      tint = Color.White,
                      contentDescription = "Drawer Menu",

                  )
                  }
              }
          )
      },
      drawerBackgroundColor = Color(0xFFFAC1E5),
      drawerGesturesEnabled = drawerState.isOpen,
      drawerContent = {
          Row(modifier = Modifier.padding(all = 12.dp)){
              Column(horizontalAlignment = Alignment.CenterHorizontally,
                  verticalArrangement = Arrangement.Center,
                  modifier = Modifier
                      .padding(12.dp)

              ){
                  Icon(
                      imageVector = Icons.Default.Home,
                      tint = Color(0xFFF845BE),
                      contentDescription = "Icons of a pendent task",
                  )
              }
              Spacer(modifier = Modifier.width(5.dp))
              Column(
                  modifier = Modifier
                      .border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(size = 12.dp))
                      .background(Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 12.dp))
                      .padding(10.dp)
                      .width(320.dp)
              ){
                  Text(
                      text = "Minha Conta",
                      fontSize = 20.sp,
                      color = Color(0xFFF845BE),
                      fontWeight = FontWeight.Bold,
                      fontStyle = FontStyle.Italic,
                  )
                  Text(
                      text = "Acesse a sua conta com mais detalhes!",
                      fontSize = 12.sp,
                      color = Color.Black,
                      fontWeight = FontWeight.Bold,
                      fontStyle = FontStyle.Italic,
                  )
              }
              Spacer(modifier = Modifier.height(16.dp))
              }





              Row(modifier = Modifier.padding(all = 12.dp)){
          Column(horizontalAlignment = Alignment.CenterHorizontally,
              verticalArrangement = Arrangement.Center,
              modifier = Modifier
                  .padding(12.dp)

          ){
              Icon(
                  imageVector = Icons.Default.Edit,
                  tint = Color(0xFFF845BE),
                  contentDescription = "Icons of a pendent task",
              )
          }
          Spacer(modifier = Modifier.width(5.dp))
          Column(
              modifier = Modifier
                  .border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(size = 12.dp))
                  .background(Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 12.dp))
                  .padding(10.dp)
                  .width(320.dp)
          ){
              Text(
                  text = "Editar Tarefas",
                  fontSize = 20.sp,
                  color = Color(0xFFF845BE),
                  fontWeight = FontWeight.Bold,
                  fontStyle = FontStyle.Italic,
              )
              Text(
                  text = "Edite suas tarefas aqui!",
                  fontSize = 12.sp,
                  color = Color.Black,
                  fontWeight = FontWeight.Bold,
                  fontStyle = FontStyle.Italic,
              )
          }
          Spacer(modifier = Modifier.height(16.dp))
      }


          Row(modifier = Modifier.padding(all = 12.dp)){
              Column(horizontalAlignment = Alignment.CenterHorizontally,
                  verticalArrangement = Arrangement.Center,
                  modifier = Modifier
                      .padding(12.dp)

              ){
                  Icon(
                      imageVector = Icons.Default.Info,
                      tint = Color(0xFFF845BE),
                      contentDescription = "Icons of a pendent task",
                  )
              }
              Spacer(modifier = Modifier.width(5.dp))
              Column(
                  modifier = Modifier
                      .border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(size = 12.dp))
                      .background(Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 12.dp))
                      .padding(10.dp)
                      .width(320.dp)
              ){
                  Text(
                      text = "Visualizar Tarefas",
                      fontSize = 20.sp,
                      color = Color(0xFFF845BE),
                      fontWeight = FontWeight.Bold,
                      fontStyle = FontStyle.Italic,
                  )
                  Text(
                      text = "Veja suas tarefas com mais detalhes!",
                      fontSize = 12.sp,
                      color = Color.Black,
                      fontWeight = FontWeight.Bold,
                      fontStyle = FontStyle.Italic,
                  )
              }
              Spacer(modifier = Modifier.height(16.dp))
          }


          Row(modifier = Modifier.padding(all = 12.dp)){
              Column(horizontalAlignment = Alignment.CenterHorizontally,
                  verticalArrangement = Arrangement.Center,
                  modifier = Modifier
                      .padding(12.dp)

              ){
                  Icon(
                      imageVector = Icons.Default.Share,
                      tint = Color(0xFFF845BE),
                      contentDescription = "Icons of a pendent task",
                  )
              }
              Spacer(modifier = Modifier.width(5.dp))
              Column(
                  modifier = Modifier
                      .border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(size = 12.dp))
                      .background(Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 12.dp))
                      .padding(10.dp)
                      .width(320.dp)
              ){
                  Text(
                      text = "Compartilhar Tarefas",
                      fontSize = 20.sp,
                      color = Color(0xFFF845BE),
                      fontWeight = FontWeight.Bold,
                      fontStyle = FontStyle.Italic,
                  )
                  Text(
                      text = "Compartilhe suas tarefas aqui!",
                      fontSize = 12.sp,
                      color = Color.Black,
                      fontWeight = FontWeight.Bold,
                      fontStyle = FontStyle.Italic,
                  )
              }
              Spacer(modifier = Modifier.height(16.dp))
          }

          Row(modifier = Modifier.padding(all = 12.dp)){
              Column(horizontalAlignment = Alignment.CenterHorizontally,
                  verticalArrangement = Arrangement.Center,
                  modifier = Modifier
                      .padding(12.dp)

              ){
                  Icon(
                      imageVector = Icons.Default.AddCircle,
                      tint = Color(0xFFF845BE),
                      contentDescription = "Icons of a pendent task",
                  )
              }
              Spacer(modifier = Modifier.width(5.dp))
              Column(
                  modifier = Modifier
                      .border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(size = 12.dp))
                      .background(Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 12.dp))
                      .padding(10.dp)
                      .width(320.dp)
              ){
                  Text(
                      text = "Adicionar Tarefas",
                      fontSize = 20.sp,
                      color = Color(0xFFF845BE),
                      fontWeight = FontWeight.Bold,
                      fontStyle = FontStyle.Italic,
                  )
                  Text(
                      text = "Adicione uma tarefa aqui!",
                      fontSize = 12.sp,
                      color = Color.Black,
                      fontWeight = FontWeight.Bold,
                      fontStyle = FontStyle.Italic,
                  )
              }
              Spacer(modifier = Modifier.height(16.dp))
          }


          Row(modifier = Modifier.padding(all = 12.dp)){
              Column(horizontalAlignment = Alignment.CenterHorizontally,
                  verticalArrangement = Arrangement.Center,
                  modifier = Modifier
                      .padding(12.dp)

              ){
                  Icon(
                      imageVector = Icons.Default.Delete,
                      tint = Color(0xFFF845BE),
                      contentDescription = "Icons of a pendent task",
                  )
              }
              Spacer(modifier = Modifier.width(5.dp))
              Column(
                  modifier = Modifier
                      .border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(size = 12.dp))
                      .background(Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 12.dp))
                      .padding(10.dp)
                      .width(320.dp)
              ){
                  Text(
                      text = "Excluir Tarefas",
                      fontSize = 20.sp,
                      color = Color(0xFFF845BE),
                      fontWeight = FontWeight.Bold,
                      fontStyle = FontStyle.Italic,
                  )
                  Text(
                      text = "Exclua uma tarefa aqui!",
                      fontSize = 12.sp,
                      color = Color.Black,
                      fontWeight = FontWeight.Bold,
                      fontStyle = FontStyle.Italic,
                  )
              }
              Spacer(modifier = Modifier.height(16.dp))
          }




      }




      ,
      content = { paddingValues -> Log.i("paddingValues", "$paddingValues")
          Column(
              modifier = Modifier
                  .background(Color(0xFFFAC1E5))
                  .fillMaxSize()
          ) {
              MySearchField(modificador = Modifier.fillMaxWidth())

              val tProvadeCalculo = Tarefa(
                  "Prova de Cálculo",
                  "Estudar Capítulo 1 do livro Maths",
                  Date(),
                  Date(),
                  status = 0.0
              )

              val tProvadeKotlin = Tarefa(
                  "Prova de Kotlin",
                  "Estudar Capítulo 1 do livro Kotlin Origem",
                  Date(),
                  Date(),
                  status = 0.0
              )

              val tApstIngles = Tarefa(
                  "Apresentação de Inglês" ,
                  "Gravar as falas com a Bia" ,
                  Date(123, 5,24),
                  Date(),
                  status = 0.0
              )

              val tTrabQTS = Tarefa(
                  "Trabalho de QTS" ,
                  "Realizar o teste de software" ,
                  Date(123, 5,25),
                  Date(),
                  status = 0.0
              )

              val tTrabIngles = Tarefa(
                  "Apresentação de Inglês" ,
                  "Terminar os slides" ,
                  Date(123, 5,23),
                  Date(),
                  status = 0.0
              )

              var minhaListadeTarefas = listOf<Tarefa>(tProvadeCalculo, tProvadeKotlin, tApstIngles, tTrabQTS, tTrabIngles)

              MyTasksWidgetList(minhaListadeTarefas)
              //criando um card para cada tarefa

              }

      },
      bottomBar = {
          BottomAppBar(
              backgroundColor = Color(0xFFF845BE),
              content = {
                  Text(text ="Desenvolvido por Ana Beatriz Martins Batista | RA 22284",
                  textAlign = TextAlign.Center, color = Color.White)
              }
          )

          },
        isFloatingActionButtonDocked = false,
        floatingActionButton = { ExtendedFloatingActionButton(
            icon = {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "Add Task",
                    tint = Color.White,
                )
                    },
            backgroundColor = Color(0xFFF845BE),
            text = { Text(text = "ADD", color = Color.White)},
            onClick = { /*TODO*/ })}

  )//Scaffold
      }

@Composable
fun MyTasksWidgetList(listaDeTarefas: List<Tarefa>) {
    listaDeTarefas.forEach(
        action = { MyTaskWidget(modificador =  Modifier.fillMaxWidth(), tarefaASerMostrada = it) }
    )
}

@Composable
fun MySearchField(modificador: Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        modifier = modificador,
        placeholder = { Text(text= "Pesquisar Tarefa", color = Color.White)},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                tint = Color(0xFFF845BE),
                contentDescription = "Icons of a Search"
            )
        }
    )


}


@Composable
fun MyTaskWidget(
        modificador: Modifier,
        tarefaASerMostrada: Tarefa
        ){
        val dateFormatter = SimpleDateFormat("dd/MMM/yyyy", Locale.getDefault())
        Row(modifier = modificador.padding(all = 12.dp)){
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .background(Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 12.dp))
                    .padding(12.dp)

            ){
            Icon(
                imageVector = Icons.Default.Notifications,
                tint = Color(0xFFF845BE),
                contentDescription = "Icons of a pendent task",
            )
                Text(
                    text = dateFormatter.format(tarefaASerMostrada.pzoFinal),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                )
            }
        Spacer(modifier = Modifier.width(5.dp))
        Column(
            modifier = modificador
                .border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(size = 12.dp))
                .background(Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 12.dp))
                .padding(10.dp)




        ){
            Text(
                text = tarefaASerMostrada.nome,
                fontSize = 20.sp,
                color = Color(0xFFF845BE),
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
            )
            Text(
                text = tarefaASerMostrada.detalhes,
                fontSize = 12.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
            )
        }
            Spacer(modifier = Modifier.height(16.dp))
        }
}










@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreenContent(DrawerState(initialValue = DrawerValue.Closed))
}


