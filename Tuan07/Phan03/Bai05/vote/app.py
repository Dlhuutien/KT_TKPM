from flask import Flask, render_template_string, request
import redis
import socket

app = Flask(__name__)
r = redis.Redis(host='redis', port=6379)

template = """
<h1>Bạn thích con nào hơn?</h1>
<form method="POST">
  <button type="submit" name="vote" value="cat">Cat</button>
  <button type="submit" name="vote" value="dog">Dog</button>
</form>
<p>Hostname: {{hostname}}</p>
"""

@app.route('/', methods=['GET', 'POST'])
def main():
    if request.method == 'POST':
        vote = request.form['vote']
        r.rpush('votes', vote)
    return render_template_string(template, hostname=socket.gethostname())

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=80)
