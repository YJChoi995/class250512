import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Todo from './Components/Todo';
import {Paper, List, Container} from '@mui/material';
import AddTodo from './Components/AddTodo';

function App() {
  const [items, setItems] = useState([]);

  // item 상태를 업테이트 하는 함수
  const addItems=(item)=>{
    item.id="ID-" + Date.now(); // key를 위한 id
    item.done=false; // done 상태는 false로 초기화

    const newItems = [...items, item];
    setItems(newItems); 
    console.log('newItems: ', newItems);
  }

  // 아이템 삭제 함수
  const deleteItem=(item)=>{
    // 삭제 전 확인 알림창 표시
    const confirmDelete = window.confirm("삭제하시겠습니까?");

    if(confirmDelete){
      //삭제할 아이템
      const newItems = items.filter((e) => e.id !== item.id); 

      const updateItems = [...newItems]; 
      setItems(updateItems); // 상태 업데이트
      console.log("updateItems : ", updateItems);
    }
  }

  let todoItems = items.length > 0 &&
  <Paper style={{margin:16, boxShadow: '0 5px 8px rgba(0,0,0,0.5)'}}>
    <List>
      {items.map((item)=>(
        <Todo item = {item} key = {item.id} deleteItem={deleteItem}/> 
      ))}
    </List>
  </Paper>
   
  return (
    // <div className="App">{todoItems}</div>
    <div className="App">
      <Container maxWidth="md">
        <AddTodo addItems={addItems}/>
        <div>{todoItems}</div>
      </Container>
    </div>
  );
}

export default App;
