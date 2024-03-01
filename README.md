## 🚀 개발환경
<img src="https://img.shields.io/badge/SpringBoot-2.7.17-%2361DAFB" /> <img src="https://img.shields.io/badge/Javascript-ES6-%238D6748" /> 
<img src="https://img.shields.io/badge/Jquery-3.6.0-%23646CFF" /> <img src="https://img.shields.io/badge/Java-11.0.21-%23FF4154" /> 
<img src="https://img.shields.io/badge/Mybatis-2.2.0-%23764ABC" /> <img src="https://img.shields.io/badge/MariaDB-2.7.4-%23CC6699" /> 
<img src="https://img.shields.io/badge/Httpclient-4.5.13-%238D6748" /> <img src="https://img.shields.io/badge/Lombok-1.18.30-%2361DAFB" /> 

## 🎊 문제 확인 가이드
- 원하는 위치에 `git clone https://github.com/richcollector/brique-kimtaewan.git`로 프로젝트를 다운받아 IDE(InteliJ)로 실행시켜줍니다.
- `gradle build`를 하여 실행가능한 상태로 만들어줍니다.
- README.md에 적혀있는 가이드에 따라 TEST해줍니다.

### 🤔 question 1
csv 파일을 읽어서 오류가 있는 항목들을 걸러내고, 필요한 내용이 있는 항목에 대해서는 계산 결과를 출력

- 각 라인별로 계산해야 하는 항목
  - 최소값
  - 최대값
  - 합계
  - 평균
  - 표준편차
  - 중간값

- **`ReadCsv 실행`**
![1번문제](https://github.com/richcollector/brique-kimtaewan/assets/104312779/25fc8d0f-9e7a-47cf-8696-5498d487e0a7)
- **`ReadCsv 실행 결과 확인`**
![1번답](https://github.com/richcollector/brique-kimtaewan/assets/104312779/e028c5ed-e73f-404a-9455-f2f7fb224a65)

### 🤔 question 2
클라이언트 프로그램이 서버 프로그램에 Ping 을 보내면 Pong 을 응답받는 프로그램 작성

- TCP, UDP 중 택일
  - 클라이언트에서 보낸 메시지가 Ping 일 경우에 Pong 응답을 한다.
  - 클라이언트에서 보낸 메시지가 Ping 이 아니면 클라이언트에서 보낸 메시지를 그대로 응답을 한다.
  - 비동기 요청/응답을 수행하도록 프로그램을 작성.
  - client는 요청을 보낸 후 server의 응답을 기다리지 않고 바로 다음 요청을 보낼 수 있다.
  - server는 client로부터 요청을 받은 후, 3초간 기다렸다가 응답을 보낸다.

- **`Server 실행`**
  - Client를 실행하기 전에 Server를 실행시켜주세요.
  - Client의 실행 결과를 확인 하기 전까지 Server를 종료하지마세요.
![문제2 서버](https://github.com/richcollector/brique-kimtaewan/assets/104312779/7f180801-b930-4fee-860c-7d130df398d4)
- **`Server 실행 결과 확인`**
![서버 실행](https://github.com/richcollector/brique-kimtaewan/assets/104312779/4025a574-0b99-4361-b812-ca61ca80a0e0)

- **`Client Meassage 세팅`**
  - 전달하고 싶은 Message를 `String[] messageList = {"ping", "ping", "111"};`안에 배열로 넣어 주세요.
  -  Message 수에 따라 `for (int i = 0; i < 3; i++)`의 숫자를 변경해 주세요.
![클라이언트 메세지 변경](https://github.com/richcollector/brique-kimtaewan/assets/104312779/d000c648-a859-4f46-b749-b8fbc119e849)
- **`Client 실행`**
  - 선 조건으로 Server가 실행되어 있어야합니다.
![클라이언트 실행](https://github.com/richcollector/brique-kimtaewan/assets/104312779/17ae7e7f-769e-43e6-b588-eed80e65921f)
- **`Client 실행 결과 확인`**
![클라이언트 전달](https://github.com/richcollector/brique-kimtaewan/assets/104312779/5af1f79a-8207-4dbe-8c24-41ab51203cf2)

### 🤔 question 3
다음 조건에 맞는 결과를 출력

- 제약조건
  - 출력 열은 총 8개이다.
  - 종업원 번호 (emp_no)
  - 이름 (first_name)
  - 성 (last_name)
  - 성별 (gender)
  - 고용일자 (hire_date)
  - 부서 이름 (dept_name)
  - 직급 (title)
  - 최대 급여 (max_salary)
  - 2000년 이후 고용된 종업원들을 대상으로 한다
  - 최대 급여는 각 종업원들이 받았던 급여 중 가장 높은 값을 의미한다.
  - 문제풀이의 결과는 SQL query 만이 아닌 프로그램이다.


- **`CodingtestApplication 실행`**
![코테 어플리케이션 실행](https://github.com/richcollector/brique-kimtaewan/assets/104312779/c2f528de-be38-4a20-8815-a01a29df3d25)
- **`employee 실행 결과 확인`**
  - `http://localhost:8080/employee/api/list` 접속
![employee 연결](https://github.com/richcollector/brique-kimtaewan/assets/104312779/2c16a5dd-8707-4fbd-82c8-13d5ff4eccff)

### 🤔 question 4
기온과 습도를 입력 받을 수 있도록 입력 테이블을 만들고, 그 입력 값에 대해 아래 그래프와 같은 형태의 선꺽은선 그래프를 구현

- 입력은 계속 변경 될 수 있으며 그래프에 바로 반영 되어야 한다.
- 입력 테이블 아래에 ＂random＂ 버튼을 만들고, ＂random＂ 버튼 클릭 시 자동으로 입력 테이블의＂기온＂, ＂습도＂ 항목에 임의의 값이 입력된다.
- 입력이 변경되면 자동으로 chart에 변경된 값이 반영 된다.

- **`CodingtestApplication 실행`**
![차트 연결](https://github.com/richcollector/brique-kimtaewan/assets/104312779/769b2cb9-f2f6-40b6-b298-3e1aabc49fd9)
- **`chart 실행 결과 확인`**
  - `http://localhost:8080/chart/api/list` 접속
  - 입력 정보를 개별로 입력하여 chart를 바꿀 수 있습니다.
  - random을 누르면 차트와 테이블의 값이 random으로 변합니다.
  - 확인 후 server를 종료해주세요.
![차트 페이지](https://github.com/richcollector/brique-kimtaewan/assets/104312779/6e6de9c5-ec8c-46ac-958c-d0463f5e1ba4)

### 🤔 question 5
서버를 100번 호출하여 각각의 결과 값들이 몇 번 반복 되었는지 계산한다.

- 마지막에 각 횟수들의 총 합을 출력한다.
- 가장 많은 횟수가 나온 값부터 출력한다

- **`Response 실행`**
![응답저장](https://github.com/richcollector/brique-kimtaewan/assets/104312779/87a1833a-1fb9-4359-b14e-524537193511)
- **`Response 실행 결과 확인`**
![응답 화면](https://github.com/richcollector/brique-kimtaewan/assets/104312779/18361337-0227-41e8-9714-53dec0e58100)

### 🤔 question final
괄호가 알맞게 짝지어진 가장 긴 부분의 길이를 구하시오. 

- ‘(‘와 ‘)’로만 이루어진 문자열에서, 괄호가 알맞게 짝지어진 가장 긴 부분의 길이를 구한다. 
- “(()”의 경우 가장 긴 유효한 부분은 “()” 이므로 길이는 2 이다. 
- “)()())”의 경우는, 가장 긴 유효한 부분은 “()()” 이므로 길이는 4 이다.

- **`question 세팅`**
    - `String question = "(())))()()()";`안에 원하는 문제를 넣어주세요.
![문제 넣기](https://github.com/richcollector/brique-kimtaewan/assets/104312779/59bd06d2-b03c-4cdf-be8a-79ac921b95ea)
- **`VaildCheck 실행`**
![마지막 문제](https://github.com/richcollector/brique-kimtaewan/assets/104312779/95cf1910-69f2-48bb-bcae-15e79c76ade3)
- **`VaildCheck 실행 결과 확인`**
![마지막 문제 결과](https://github.com/richcollector/brique-kimtaewan/assets/104312779/fcaf294f-ae9e-46d3-9002-1cdbdee7ae67)
