import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import BusinessCard from './components/BusinessCard';
import Book from './components/Book';
import Counter from './components/Counter';

function App() {

  return(

    // <div>
    //   <h2>나의 동료들!</h2>
    //   <BusinessCard name="최연지" position="학생1" email="duswl4759@naver.com" />
    //   <BusinessCard name="홍길동" position="학생2" email="hongkd9@naver.com" />
    //   <BusinessCard name="김철수" position="학생3" email="cskim@naver.com" />
    // </div>

    // <div>
    //   <Book title="혼모노" author="성해나" price="16,200" imgSrc="https://image.aladin.co.kr/product/36101/66/cover200/893643974x_2.jpg" />
    //   <Book title="가공범 " author="히가시노 게이고" price="19,800" imgSrc="https://image.aladin.co.kr/product/36786/80/cover200/k472030698_2.jpg" />
    //   <Book title="징계를 마칩니다" author="박은정" price="20,700" imgSrc="https://image.aladin.co.kr/product/36801/4/cover200/k552030804_1.jpg" />
    // </div>

    <div>
      <Counter/>
    </div>
  )

}

export default App;
