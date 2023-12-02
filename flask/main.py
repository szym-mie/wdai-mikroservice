from flask import Flask, jsonify
from flask_marshmallow import Marshmallow
from person_model import Person

app = Flask(__name__)
ma = Marshmallow(app)

app.config["SQLALCHEMY_DATABASE_URI"] = "sqlite:///demo.sqlite"
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = True


class PersonSchema(ma.SQLAlchemySchema):
    class Meta:
        model = Person


@app.route('/<name>', methods=['GET'])
def index(name):
    return f'<h1>Hello {name}</h1>'


if __name__ == '__main__':
    with app.app_context():
        app.run()
