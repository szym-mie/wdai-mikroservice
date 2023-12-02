const express = require('express')
const personRouter = require('./personRouter')
const app = express()
const port = 3000

const model = require('./dataModel')

model.dataSource.sync()
    .then(() => {
        console.log('connect to data source')
        model.personSchema.create({ 'name': 'John', 'job': 'IT' })
    })
    .catch(err => {
        console.error(err)
    })

app.get('/', (req, res) => {
    res.send('Hello world!')
})

app.use('/', personRouter)

app.listen(port, () => {
    console.log('listening on port ' + port)
})