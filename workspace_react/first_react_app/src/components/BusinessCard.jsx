function BusinessCard( {name, position, email} ){

  //  // 여기에 javascript 변수
  // const name = "최연지";
  // const year = 2025;
  // const position = "Student";
  // const email = "duswl4759@naver.com";

  return(
    // 1. 하나의 부모 요소로 감싸기
    // <div>
    //   <h1>안녕하세요, {name}님! </h1>
    //   <h2>react와 함께하는 {year}년! </h2>
    //   <p>이것은 첫번째 react 컴포넌트입니다.</p>
    // </div>

  <div className="business-card">
  {/* <h1>{props.name}</h1>
    <p>직책: {props.position}</p>
    <p>이메일: {props.email}</p> */}
    <h1>{name}</h1>
    <p>직책: {position}</p>
    <p>이메일: {email}</p>
  </div>
  )

}

export default BusinessCard; // 이 명함을 수출함!