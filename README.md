# 📕UnivLMS
Using Java in 2019   
📌: Learning MVC Pattern  

[![License](https://img.shields.io/github/license/221b0825/UnivLMS)](LICENSE)  
[![Last Commit](https://img.shields.io/github/last-commit/221b0825/UnivLMS)](https://github.com/221b0825/UnivLMS/commits/main)

## 📚 Introduction

| 항목   | 내용 |
|--------|--------------------------------|
| **과목명** | 절차적 사고와 프로그래밍 |
| **교수명** | 최성운 교수님 |
| **학기** | 2019년 1학기 |
| **과목코드** | 5842 |
| **학년** | 1학년 |
| **시간** | 월/수 09:00 ~ 10:15 |
| **장소** | S1350 |

---

## 📸 Preview  
<div align="center"> <img src="https://github.com/user-attachments/assets/75136c3b-e201-41fa-a543-41d13dd4cb9a" alt="Project Preview" height="500px"> <p><em>로그인 화면</em></p> </div>

---

## ✨ Features
- 📂 **Text 파일에서 강의 목록 읽기**  
  텍스트 파일을 통해 강의 목록 데이터를 불러와 UI에 표시합니다. 파일 형식은 간단한 텍스트 기반으로 구성되며, 강의 이름과 관련 정보를 파싱하여 보여줍니다.  

- 🖱️ **강의 선택 시 하위 강의 변경**  
  스크롤 리스트에서 강의를 클릭하면 상위 범위와 연결된 하위 범위 목록이 동적으로 변경됩니다. AWT 이벤트 처리를 활용하여 클릭 이벤트를 처리하고, UI를 업데이트합니다.  

- 🛒 **강의 담기 (장바구니 기능)**  
  강의를 클릭한 후 **"담기"** 버튼을 누르면, 해당 강의가 사용자의 `basket/basket+userID` 파일에 저장됩니다.  
  저장된 강의 목록은 장바구니 화면에서 확인할 수 있습니다.  

- ✅ **강의 신청**  
  장바구니에서 강의를 선택한 후 **"신청"** 버튼을 누르면, 해당 강의가 `sincheong/sincheong+userID` 파일에 저장됩니다.  
  신청된 강의 목록은 별도의 신청 내역 화면에서 확인할 수 있습니다.  

---

## 📂 Folder Structure
```plaintext
└─UnivLMS
    ├─.settings
    ├─basket
    ├─bin
    │  ├─control
    │  ├─dao
    │  ├─entity
    │  ├─main
    │  └─ui
    ├─data
    ├─image
    ├─login
    ├─sincheong
    └─src
        ├─control
        ├─dao
        ├─entity
        ├─main
        └─ui
```
---

## 🛠️ Built With
- **Programming Language**: Java  
- **UI Library**: AWT (Abstract Window Toolkit)  

---

## 📧 Contact
- **이름**: Eunseo Yu  
- **이메일**: eunseoyu0825@gmail.com  
- **GitHub**: [221b0825](https://github.com/221b0825)  

