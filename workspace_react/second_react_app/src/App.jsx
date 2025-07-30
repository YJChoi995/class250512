import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Todo from './Components/Todo';
import {Paper, List, Container, Box, Button } from '@mui/material';
import AddTodo from './Components/AddTodo';
import TrashPage from '../Pages/TrashPage';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';

function App() {
  const [items, setItems] = useState([]);
  const [deletedItems, setDeletedItems] = useState([]);

  // item 상태를 업테이트 하는 함수
  const addItems = (item) => {
    item.id="ID-" + Date.now(); // key를 위한 id
    item.done=false; // done 상태는 false로 초기화

    const newItems = [...items, item];
    setItems(newItems); 
    console.log('newItems: ', newItems);
  }

  // 아이템 삭제 함수
  const deleteItem = (item) => {
    // 삭제 전 확인 알림창 표시
    const confirmDelete = window.confirm("삭제하시겠습니까?");

    if(confirmDelete){
      //삭제할 아이템
      const newItems = items.filter((e) => e.id !== item.id); 

      const updateItems = [...newItems]; 
      setItems(updateItems); // 상태 업데이트
      setDeletedItems([...deletedItems, item]); // 삭제된 아이템 저장
      alert('삭제되었습니다');
      console.log("updateItems : ", updateItems);
    }
  }

  // 아이템 복원 함수
  const restoreItem = (item) => {
    // 삭제된 항목 목록에서 제거
    const newDeletedItems = deletedItems.filter((e) => e.id !== item.id);
    setDeletedItems(newDeletedItems);

    // 원래 항복에 다시 추가
    setItems([...items, item]);
    alert('복원되었습니다');
  }

  const editItem = () => {
    setItems([...items]) // 변경된 내용을 리렌더링
    // 새 배열을 만들어서 React에게 상태가 바뀌었다고 알리는 역할
  }

  let todoItems = items.length > 0 && (
  <Paper style={{margin:16, boxShadow: '0 5px 8px rgba(0,0,0,0.5)'}}>
    <List>
      {items.map((item)=>(
        <Todo item = {item} key = {item.id} editItem={editItem} deleteItem={deleteItem}/> 
      ))}
    </List>
  </Paper>
  )
   
  return (
    <BrowserRouter>
      <div className="App">
        <Container maxWidth="md">
          <Box sx={{display: 'flex', justifyContent: 'center', gap:2, mb:2, mt: 2}}>
            <Button variant = "contained" component={Link} to="/">할 일 목록</Button>
            <Button variant = "contained" component={Link} to="/trash">휴지통 {deletedItems.length}</Button>
          </Box>
          <Routes>
            <Route
              path="/" element={
                <>
                  <AddTodo addItems={addItems} />
                  <div>{todoItems}</div>
                </>
              }
            />
            <Route
              path="/trash" element={
                <TrashPage deletedItems={deletedItems} restoreItem={restoreItem} />
              }
            />
          </Routes>
         
        </Container>
      </div>
    </BrowserRouter>
  );
}

export default App;
