const { Sequelize, DataTypes } = require("sequelize");

const dataSource = new Sequelize('test', 'root', '', {
    host: 'localhost',
    dialect: 'sqlite',
    storage: './data/db.sqlite'
})

const personSchema = dataSource.define('Person', {
    id: { type: DataTypes.INTEGER, autoIncrement: true, primaryKey: true },
    name: { type: DataTypes.STRING },
    job: { type: DataTypes.STRING }
}, { 
    modelName: 'Person',
    tableName: 'Person'
})

module.exports = { dataSource, personSchema }