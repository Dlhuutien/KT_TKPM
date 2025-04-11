const express = require('express');
const { Pool } = require('pg');
const app = express();
const port = 80;

const pool = new Pool({
  user: 'postgres',
  host: 'db',
  database: 'votes',
  password: 'password',
  port: 5432
});

app.get('/', async (req, res) => {
  const cat = await pool.query("SELECT COUNT(*) FROM votes WHERE vote = 'cat'");
  const dog = await pool.query("SELECT COUNT(*) FROM votes WHERE vote = 'dog'");
  res.send(`
    <h1>Kết quả bình chọn:</h1>
    <p>🐱 Cat: ${cat.rows[0].count}</p>
    <p>🐶 Dog: ${dog.rows[0].count}</p>
  `);
});

app.listen(port, () => {
  console.log(`Kết quả hiển thị tại http://localhost:${port}`);
});
