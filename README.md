일정 관리 앱 만들기

필수 구현

Lv 0 : API 명세 및 ERD 작성

Lv 1 : 일정 생성 및 조회

Lv 2 : 일정 수정 및 삭제

도전 구현

Lv 3 : 연관 관계 설정

Lv 4 : 페이지 네이션

Lv 5 : 예외 발생 처리

Lv 6 : null 체크 및 특정 패턴에 대한 검증 수행

일정 API 설계

<details>
<summary>일정 생성 API</summary>

- Method: POST
- URL: `/api`
- Request Body
```json5
{
    "title": "일정",
    "contents": "오늘의 할일 1",
    "author": "작성자 이름",
    "password" : "1234"
}
```
- Response (201 Created)

```json
{
    "id": 1,
    "title": "일정",
    "contents": "오늘의 할일 1",
    "author": "작성자 이름",
    "createtime": "2025-05-13 17:22:58"
}
```
</details>

<details>
<summary>일정 목록 조회 API</summary>

- Method: GET
- URL: `/api`
- Request Body
```json5
{
    
}
```
- Response (200 OK)

```json
{
        "id": 1,
        "title": "일정",
        "contents": "오늘의 할일 1",
        "author": "작성자 이름",
        "createtime": "2025-05-13 17:37:59",
        "updatetime": "2025-05-13 17:37:59"
    }
```
</details>

<details>
<summary>일정 선택 조회 API</summary>

- Method: GET
- URL: `/api/1`
- Request Body
```json5
{
    
}
```
- Response (200 OK)

```json
{
    "id": 1,
    "title": "일정",
    "contents": "오늘의 할일 1",
    "author": "작성자 이름",
    "createtime": "2025-05-13 17:37:59",
    "updatetime": "2025-05-13 17:37:59"
}
```
</details>

<details>
<summary>일정 수정 API</summary>

- Method: PUT
- URL: `/api/1`
- Request Body
```json5
{
    "title" : "제목만 수정1",
    "contents" : "내용 수정1" ,
    "author" : "작성자 수정1",
    "password" : "1234"
}
```
- Response (200 OK)

```json
{
    "id": 1,
    "title": "제목만 수정1",
    "contents": "내용 수정1",
    "author": "작성자 수정1",
    "createtime": "2025-05-13 17:37:59",
    "updatetime": "2025-05-13 17:40:37"
}
```
</details>

<details>
<summary>일정 삭제 API</summary>

- Method: DEL
- URL: `/api/1`
- Request Body
```json5
{
    "password" : "1234"
}
```
- Response (200 OK)

```json
{

}
```
</details>






| 기능       | 메서드  | URL    | response | 상태코드        |
|----------|------|--------|----------|-------------|
| 일정 등록    | post | /api   | 등록 정보    | 201 created |
| 일정 목록 조회 | GET  | /api   | 전체 목록 조회 | 200 OK      |
| 일정 선택 조회 | GET  | /api{/id} | 선택 목록 조회 | 200 OK      |
| 일정 수정    | PUT  | /api{/id}   | 선택 목록 수정 | 200 OK      |
| 일정 삭제    | DEL  | /api{/id}   | 일정 삭제    | 200 OK      |


ERD 작성

![img.png](img.png)
