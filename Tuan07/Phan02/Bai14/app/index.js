const express = require('express');
const { createClient } = require('redis');

const app = express();
const port = 3000;

const client = createClient({
  url: 'redis://redis:6379' // ← Tên service trong Docker Compose
});

client.connect();

app.get('/', async (req, res) => {
  await client.set('message', 'Xin chào từ Node tới Redis!');
  const msg = await client.get('message');
  res.send(msg);
});

app.listen(port, () => {
  console.log(`App đang chạy tại http://localhost:${port}`);
});
