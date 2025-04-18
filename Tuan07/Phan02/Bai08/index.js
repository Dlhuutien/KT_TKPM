const express = require('express');
const mysql = require('mysql2');

const app = express();
const port = 3000;

const db = mysql.createConnection({
  host: 'mysql',        
  user: 'user',
  password: 'password',
  database: 'mydb'
});

db.connect(err => {
  if (err) {
    console.error('Không thể kết nối MySQL:', err);
    return;
  }
  console.log('Đã kết nối MySQL!');
});

app.get('/', (req, res) => {
  db.query('SELECT NOW() AS current_time', (err, result) => {
    if (err) return res.status(500).send('Lỗi truy vấn');
    res.send(`Thời gian hiện tại từ DB: ${result[0].current_time}`);
  });
});

app.listen(port, () => {
  console.log(`App đang chạy tại http://localhost:${port}`);
});


//docker compose up -d --build
