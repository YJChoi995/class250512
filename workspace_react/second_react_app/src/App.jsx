import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Todo from './Components/Todo';
import {Paper, List, Container} from '@mui/material';
import AddTodo from './Components/AddTodo';

function App() {
  const [items, setItems] = useState([{
    id: "0",
    title: "Sample Todo1",
    done: true // 할 일 완료된 상태
  },
  {
    id: "1",
    title: "Sample Todo2",
    done: false
  },
  {
    id: "2",
    title: "Sample Todo3",
    done: false
  }

]);

  const addItems=(item) => {
    item.id="ID-" + items.length; // key를 위한 id
    item.done=false; // done 상태는 false로 초기화
    setItems([...items, item]); // 기존 items에 새 item 추가
    console.log('items: ', items);
  }

  let todoItems = items.length > 0 &&
  <Paper style={{margin:16, boxShadow: '0 5px 8px rgba(0,0,0,0.5)'}}>
    <List>
      {items.map((item)=>(<Todo item = {item} key = {item.id}/>))}
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
