import { Component, OnInit } from '@angular/core';
import { Todo } from '../todo';


@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.scss']
})
export class TodoListComponent implements OnInit {

arrayTodo:Todo[]=[]
// arrayCompletati:Todo[]=[]

  constructor() { }

  ngOnInit(): void {
    fetch("http://jsonplaceholder.typicode.com/todos")
    .then(res=>res.json())
    .then((res:{todo: Todo[]}) =>{
      this.arrayTodo = res.todo
      // this.arrayCompletati=this.arrayTodo.filter((e)=>{
      //   return e.completed;
      // })
    })
  }

getTodo(completed:boolean = false):Todo[]{
return this.arrayTodo.filter(e=>e.completed == completed)
}

}
