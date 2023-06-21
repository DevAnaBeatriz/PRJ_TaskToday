package com.example.tasktodayappsab.model.Tarefa

import java.util.Date

class Tarefa(val nome: String, val detalhes: String, val createdDate: Date, val pzoFinal: Date, status: Double) {

      var status = "pendente"
          get() {return field}
          set(value) {
              field = value
          }

}
