const express = require('express')
const router = express.Router()
const { personSchema } = require('./dataModel')
const bodyParser = require('body-parser')

const jsonParser = bodyParser.json()

router.get('/person', async (req, res, next) => {
    const persons = await personSchema.findAll()
    res.status(200).json(persons).send()
})

router.get('/person/:id', async (req, res, next) => {
    const id = req.params.id
    const person = await personSchema.findByPk(id)
    res.status(200).json(person).send()
})

router.post('/create', jsonParser, async (req, res, next) => {
    const { name, job } = req.body
    if (name === undefined || job === undefined) {
        res.status(400).send()
    } else {
        await personSchema.create({ name, job })
        res.status(200).send()
    }
})

module.exports = router