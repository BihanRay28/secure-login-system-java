# 🔐 Secure Login System (Java)

> A simple yet secure authentication system built in Java using hashing, salting, file handling, and exception handling.

---

## 🚀 Features

* 📝 User Registration & Login
* 📧 Email Validation using Regex
* 🔑 Password Validation (length + digit check)
* 🧂 Password Salting
* 🔒 SHA-256 Password Hashing
* 📁 File-based User Storage
* ⚠️ Logging of Failed Login Attempts
* 🧠 Custom Exception Handling

---

## 🛠️ Tech Stack

* ☕ Java
* 📂 File Handling
* ⚠️ Exception Handling
* 🔍 Regular Expressions (Regex)
* 🔐 Cryptography (SHA-256 Hashing)

---

## 🧠 How It Works

### 📝 Registration Flow

1. User enters email & password
2. Email & password are validated
3. A random **salt** is generated
4. Password + salt → **hashed using SHA-256**
5. Email, hash, and salt are stored in `users.txt`

---

### 🔐 Login Flow

1. User enters credentials
2. Stored salt is retrieved
3. Input password is hashed again using same salt
4. Hash is compared with stored hash
5. ✔ Match → Login Success
6. ❌ Mismatch → Login Failed (logged in `logs.txt`)

---

## 📂 Project Structure

```
SecureLoginSystem/
│
├── Main.java                  # Entry point (CLI interface)
├── AuthService.java          # Handles registration & login logic
├── HashUtil.java             # SHA-256 hashing + salting logic
├── Validator.java            # Email & password validation
├── FileHandler.java          # Read/write user data
├── LoggerUtil.java           # Logs failed login attempts
├── CustomException.java      # User-defined exceptions
│
├── users.txt                 # Stores user credentials
├── logs.txt                  # Stores failed login attempts
│
└── README.md                 # Project documentation
```

---

## 🔐 Security Design

> Designed to follow basic real-world authentication practices.

* ❌ Passwords are **never stored in plain text**
* ✅ Each password is **salted**
* ✅ Uses **SHA-256 hashing**
* ✅ Same password ≠ same hash (due to salt)
* ✅ Failed attempts are logged for tracking

---

## ⚙️ Sample Data (users.txt)

```
user@example.com,5e884898da28047151d0e56f8dc629...,a1b2c3d4
```

> Format: `email, hashed_password, salt`

---

## ⚠️ Sample Log (logs.txt)

```
[2026-03-30 22:14:05] Failed login attempt for: user@example.com
```

---

## ▶️ How to Run

### 1️⃣ Compile

```
javac Main.java
```

### 2️⃣ Run

```
java Main
```

---

## 🧠 Concepts Demonstrated

* Object-Oriented Programming (OOP)
* File Handling in Java
* Exception Handling (Custom + Built-in)
* Basic Cryptography
* Input Validation using Regex
* Modular Code Design

---

## 🚧 Future Improvements

* 🔐 JWT Authentication
* 📱 GUI Interface (JavaFX / Swing)
* 🗄️ Database Integration (MySQL / SQLite)
* 🔑 Password Reset System
* 🚫 Account Lock after multiple failed attempts
* 🔒 AES Encryption for stored files

---

## 💡 Why This Project Matters

This project demonstrates:

* Understanding of **secure authentication basics**
* Ability to build **modular Java systems**
* Practical implementation of **hashing + salting**
* Awareness of **real-world security concerns**

---
## 🖥️ GUI Interface

The system includes a Java Swing-based graphical interface that allows users to:

- Register with email and password  
- Login securely with hidden password input  
- Toggle password visibility  
- Receive real-time success/failure feedback  


## 👨‍💻 Author

**Bihan Ray**
CSE (AIML) Student @ IEM
