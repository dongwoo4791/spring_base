import React, { useEffect } from 'react';
import './App.css';

function App() {

  useEffect(() => {

    let person = {
      username: "test1",
      password: "1234"
    }

    fetch("http://localhost:8000/loginProc", {
      method: "POST",
      body: JSON.stringify(person),
      headers: {
        'Content-Type': "application/json; charset=utf-8"

      }
    }).then(res => {
      console.log(1, res);
      for (let header of res.headers.entries()) {
        if(header[0]==="authorization"){
          localStorage.setItem("Authorization",header[1]);
        }
      }
      //로그인 하면 토크이 헤더의 Authorization에 담김
      //인증이 필요한 페이지에 접근하면 헤더에 Authorization적어서 확인
      //로그아웃하면 Authorization를 지워줌
      return res.text();
    }).then(res => {
      console.log(3, res);
    })

    // localStorage.setItem("jwt","sdfsdfdsf");
    //let jwtToken = localStorage.getItem("jwt");
    //console.log(jwtToken)
  }, []);

  return (
    <div>1</div>
  );
}

export default App;
