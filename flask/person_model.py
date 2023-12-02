from flask_sqlalchemy.model import Model
from sqlalchemy import Integer, String
from sqlalchemy.orm import DeclarativeBase, Mapped, mapped_column


class Base(DeclarativeBase):
    pass


class Person(Model):
    id: Mapped[int] = mapped_column(Integer, primary_key=True)
    name: Mapped[str] = mapped_column(String, unique=True, nullable=True)
    job: Mapped[str] = mapped_column(String)
