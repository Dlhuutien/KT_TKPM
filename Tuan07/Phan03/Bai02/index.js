const express = require('express');
const mongoose = require('mongoose');

const app = express();
app.use(express.json());

mongoose.connect('mongodb://mongo:27017/mydb', {
  useNewUrlParser: true,
  useUnifiedTopology: true
}).then(() => console.log('Kết nối MongoDB thành công'))
  .catch(err => console.error('Lỗi kết nối MongoDB:', err));

const userSchema = new mongoose.Schema({ name: String });
const User = mongoose.model('User', userSchema);

app.get('/', async (req, res) => {
  const users = await User.find();
  res.json(users);
});

app.post('/add', async (req, res) => {
  const user = new User({ name: req.body.name });
  await user.save();
  res.send('Đã thêm user');
});

app.listen(3000, () => {
  console.log('🚀 Server chạy tại http://localhost:3000');
});
